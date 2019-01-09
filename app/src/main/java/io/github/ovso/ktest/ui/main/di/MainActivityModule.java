package io.github.ovso.ktest.ui.main.di;

import androidx.lifecycle.Lifecycle;
import dagger.Module;
import dagger.Provides;
import io.github.ovso.ktest.ui.main.MainActivity;
import io.github.ovso.ktest.ui.main.MainPresenter;
import io.github.ovso.ktest.ui.main.MainPresenterImpl;
import io.github.ovso.ktest.utils.ResourceProvider;
import javax.inject.Singleton;

@Module public class MainActivityModule {

  @Singleton @Provides MainPresenter provideMainPresenter(MainPresenter.View view,
      ResourceProvider resourceProvider, Lifecycle lifecycle) {
    MainPresenter presenter = new MainPresenterImpl(view, resourceProvider);
    lifecycle.addObserver(presenter);
    return presenter;
  }

  @Provides Lifecycle provideLifecycle(MainActivity act) {
    return act.getLifecycle();
  }
}