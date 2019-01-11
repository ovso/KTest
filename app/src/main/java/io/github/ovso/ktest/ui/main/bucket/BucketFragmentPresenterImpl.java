package io.github.ovso.ktest.ui.main.bucket;

import io.github.ovso.ktest.data.network.model.Document;
import io.github.ovso.ktest.ui.base.adapter.BaseAdapterDataModel;
import io.github.ovso.ktest.ui.base.rx.RxBus;
import io.github.ovso.ktest.ui.base.rx.Schedulers;
import io.github.ovso.ktest.ui.main.bucket.vo.BucketFragmentArgs;
import io.github.ovso.ktest.ui.main.search.adapter.SearchViewHolder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BucketFragmentPresenterImpl implements BucketFragmentPresenter {

  private final View view;
  private final RxBus rxBus;
  private final Schedulers schedulers;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private BaseAdapterDataModel<Document> adapterDataModel;

  public BucketFragmentPresenterImpl(BucketFragmentArgs args) {
    view = args.getView();
    rxBus = args.getRxBus();
    schedulers = args.getSchedulers();
    adapterDataModel = args.getAdapterDataModel();
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
    if (o instanceof SearchViewHolder.RxBusEvent) {
      Document document = ((SearchViewHolder.RxBusEvent) o).getDocument();
      if (document.isBucket()) {
        adapterDataModel.add(document);
      } else {
        adapterDataModel.remove(document);
      }
      view.refresh();
    }
  }

  @Override public void onDestroy() {
    clear();
  }

  private void clear() {
    compositeDisposable.clear();
  }
}