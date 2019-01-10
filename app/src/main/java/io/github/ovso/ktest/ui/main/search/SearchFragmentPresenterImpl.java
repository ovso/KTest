package io.github.ovso.ktest.ui.main.search;

import io.github.ovso.ktest.ui.main.MainPresenterImpl;
import io.github.ovso.ktest.ui.main.search.vo.SearchFragmentArgs;
import io.github.ovso.ktest.utils.RxBus;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class SearchFragmentPresenterImpl implements SearchFragmentPresenter {

  private final View view;
  private final RxBus rxBus;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();

  public SearchFragmentPresenterImpl(SearchFragmentArgs args) {
    view = args.getView();
    rxBus = args.getRxBus();
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
      String newText = ((MainPresenterImpl.RxBusEvent) o).getNewText();
      Timber.d("newText = %s", newText);
    }
  }

  @Override public void onDestroy() {
    compositeDisposable.clear();
  }
}