package io.github.ovso.ktest.ui.main;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public interface MainPresenter extends LifecycleObserver {

  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  void onCreate();

  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  void onDestroy();

  boolean onQueryTextChange(String newText);

  interface View {

    void setupViewPager();

    void setupTabLayout();

    void navigateToSearchFragment();

    void hideKeyboard();
  }
}
