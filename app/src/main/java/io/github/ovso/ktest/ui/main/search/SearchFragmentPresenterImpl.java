package io.github.ovso.ktest.ui.main.search;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import io.github.ovso.ktest.data.network.ImageRequest;
import io.github.ovso.ktest.data.network.VclipRequest;
import io.github.ovso.ktest.data.network.model.Document;
import io.github.ovso.ktest.data.network.model.Search;
import io.github.ovso.ktest.ui.base.adapter.BaseAdapterDataModel;
import io.github.ovso.ktest.ui.base.rx.Schedulers;
import io.github.ovso.ktest.ui.main.MainPresenterImpl;
import io.github.ovso.ktest.ui.main.search.vo.SearchFragmentArgs;
import io.github.ovso.ktest.ui.base.rx.RxBus;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import timber.log.Timber;

public class SearchFragmentPresenterImpl implements SearchFragmentPresenter {

  private final View view;
  private final RxBus rxBus;
  private final ImageRequest imageRequest;
  private final VclipRequest vclipRequest;
  private final Schedulers schedulers;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private BaseAdapterDataModel<Document> adapterDataModel;

  public SearchFragmentPresenterImpl(SearchFragmentArgs args) {
    view = args.getView();
    rxBus = args.getRxBus();
    imageRequest = args.getImageRequest();
    vclipRequest = args.getVclipRequest();
    schedulers = args.getSchedulers();
    adapterDataModel = args.getAdapterDataModel();
  }

  @Override public void onStart() {
    view.setupRecyclerView();
    rxBusObservable();
  }

  private void rxBusObservable() {
    Disposable disposable =
        rxBus.toObservable().observeOn(schedulers.ui()).subscribe(this::observer);
    compositeDisposable.add(disposable);
  }

  private void observer(Object o) {
    if (o instanceof MainPresenterImpl.RxBusEvent) {
      String query = ((MainPresenterImpl.RxBusEvent) o).getQuery();
      if (TextUtils.isEmpty(query)) {
        handleEmpty();
      } else {
        view.showLoading();
        reqSearch(query);
      }
    }
  }

  private void handleEmpty() {
    adapterDataModel.clear();
    view.refresh();
  }

  private void reqSearch(String query) {
    Observable<List<Document>> imageMap = imageRequest.images(query).map(Search::getDocuments);
    Observable<List<Document>> vclipMap = vclipRequest.vclip(query).map(Search::getDocuments);
    Observable.zip(imageMap, vclipMap, this::reqSearchBiFunction)
        .subscribeOn(schedulers.io())
        .observeOn(schedulers.ui())
        .subscribe(reqSearchObserver);
  }

  @WorkerThread
  private List<Document> reqSearchBiFunction(List<Document> documents, List<Document> documents2) {
    List<Document> newDocments = new ArrayList<>();
    newDocments.addAll(documents);
    newDocments.addAll(documents2);
    Collections.sort(newDocments);
    return newDocments;
  }

  private Observer<List<Document>> reqSearchObserver = new Observer<List<Document>>() {
    @Override public void onSubscribe(Disposable d) {
      compositeDisposable.add(d);
    }

    @Override public void onNext(List<Document> documents) {
      if (documents != null && !documents.isEmpty()) {
        adapterDataModel.clear();
        adapterDataModel.addAll(documents);
        view.refresh();
      } else {
        handleEmpty();
      }
    }

    @Override public void onError(Throwable e) {
      Timber.e(e);
      handleEmpty();
      view.hideLoading();
    }

    @Override public void onComplete() {
      view.hideLoading();
    }
  };

  @Override public void onDestroy() {
    compositeDisposable.clear();
  }
}