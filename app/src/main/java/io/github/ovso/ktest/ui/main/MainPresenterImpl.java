package io.github.ovso.ktest.ui.main;

import io.github.ovso.ktest.utils.ResourceProvider;
import io.reactivex.disposables.CompositeDisposable;

public class MainPresenterImpl implements MainPresenter {

  private MainPresenter.View view;
  private ResourceProvider resourceProvider;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();

  public MainPresenterImpl(MainPresenter.View $view, ResourceProvider $resourceProvider) {
    view = $view;
    resourceProvider = $resourceProvider;
  }

  @Override public void onCreate() {
    view.setupTabLayout();
    view.setupViewPager();
  }

  @Override public void onDestroy() {
    compositeDisposable.clear();
  }

  @Override public boolean onQueryTextChange(String newText) {
    return false;
  }
}