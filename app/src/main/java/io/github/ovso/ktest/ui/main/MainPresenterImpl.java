package io.github.ovso.ktest.ui.main;

import io.github.ovso.ktest.utils.ResourceProvider;
import io.github.ovso.ktest.utils.RxBus;
import io.reactivex.disposables.CompositeDisposable;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class MainPresenterImpl implements MainPresenter {

  private final RxBus rxBus;
  private MainPresenter.View view;
  private ResourceProvider resourceProvider;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();

  public MainPresenterImpl(MainPresenter.View $view, ResourceProvider $resourceProvider,
      RxBus $rxBus) {
    view = $view;
    resourceProvider = $resourceProvider;
    rxBus = $rxBus;
  }

  @Override public void onCreate() {
    view.setupTabLayout();
    view.setupViewPager();
  }

  @Override public void onDestroy() {
    compositeDisposable.clear();
  }

  @Override public boolean onQueryTextChange(String newText) {
    rxBus.send(new RxBusEvent(newText));
    return true;
  }

  @Override public void onPageSelected(int position) {
    if (position == 0) {
      view.showSearchView();
    } else {
      view.hideSearchView();
    }
  }

  @AllArgsConstructor public final static class RxBusEvent {
    @Getter private String newText;
  }
}