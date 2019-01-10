package io.github.ovso.ktest.ui.main.search;

import io.github.ovso.ktest.data.network.ImageRequest;
import io.github.ovso.ktest.data.network.VclipRequest;
import io.github.ovso.ktest.data.network.model.image.Document;
import io.github.ovso.ktest.data.network.model.image.Search;
import io.github.ovso.ktest.ui.base.rx.Schedulers;
import io.github.ovso.ktest.ui.main.MainPresenterImpl;
import io.github.ovso.ktest.ui.main.search.vo.SearchFragmentArgs;
import io.github.ovso.ktest.utils.RxBus;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SearchFragmentPresenterImpl implements SearchFragmentPresenter {

  private List<Document> documents = new ArrayList<>();
  private final View view;
  private final RxBus rxBus;
  private final ImageRequest imageRequest;
  private final VclipRequest vclipRequest;
  private final Schedulers schedulers;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();

  public SearchFragmentPresenterImpl(SearchFragmentArgs args) {
    view = args.getView();
    rxBus = args.getRxBus();
    imageRequest = args.getImageRequest();
    vclipRequest = args.getVclipRequest();
    schedulers = args.getSchedulers();
  }

  @Override public void onStart() {
    view.setupRecyclerView();
    rxBusObservable();
  }

  private void rxBusObservable() {
    Disposable disposable = rxBus.toObservable().subscribe(this::observer);
    compositeDisposable.add(disposable);
  }

  private void observer(Object o) {
    if (o instanceof MainPresenterImpl.RxBusEvent) {
      reqSearch(((MainPresenterImpl.RxBusEvent) o).getNewText());
    }
  }

  private void reqSearch(String query) {
    clearData();
    Observable<List<Document>> iMap = imageRequest.images(query).map(Search::getDocuments);
    Observable<List<Document>> vMap = vclipRequest.vclip(query).map(Search::getDocuments);
    Observable.zip(iMap, vMap, (documents, documents2) -> {
      documents.addAll(documents2);
      return documents;
    }).sorted(new Comparator<List<Document>>() {
      @Override public int compare(List<Document> o1, List<Document> o2) {
        return 0;
      }
    })
        .subscribeOn(schedulers.io())
        .observeOn(schedulers.ui())
        .subscribe(new Observer<List<Document>>() {
          @Override public void onSubscribe(Disposable d) {

          }

          @Override public void onNext(List<Document> documents) {

          }

          @Override public void onError(Throwable e) {

          }

          @Override public void onComplete() {

          }
        });
  }

  private int toSortedLists(List<Document> documents, List<Document> documents1) {
    return 0;
  }

  private List<Observable<Search>> getReqs(String query) {
    List<Observable<Search>> reqs = new ArrayList<>();
    reqs.add(imageRequest.images("설현"));
    reqs.add(vclipRequest.vclip("전효성"));
    return reqs;
  }

  @Override public void onDestroy() {
    compositeDisposable.clear();
  }

  private void clearData() {
    documents.clear();
    compositeDisposable.clear();
  }
}