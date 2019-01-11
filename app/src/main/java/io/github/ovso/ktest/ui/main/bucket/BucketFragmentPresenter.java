package io.github.ovso.ktest.ui.main.bucket;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public interface BucketFragmentPresenter extends LifecycleObserver {
  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  void onStart();

  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  void onDestroy();

  interface View {

    void setupRecyclerView();

    void refresh();
  }
}
