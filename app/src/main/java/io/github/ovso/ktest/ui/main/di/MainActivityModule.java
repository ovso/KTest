package io.github.ovso.ktest.ui.main.di;

import androidx.lifecycle.Lifecycle;
import dagger.Module;
import dagger.Provides;
import io.github.ovso.ktest.App;
import io.github.ovso.ktest.ui.main.MainActivity;
import io.github.ovso.ktest.ui.main.MainPresenter;
import io.github.ovso.ktest.ui.main.MainPresenterImpl;
import io.github.ovso.ktest.utils.ResourceProvider;
import io.github.ovso.ktest.utils.RxBus;
import javax.inject.Singleton;

@Module public class MainActivityModule {

  @Singleton @Provides MainPresenter provideMainPresenter(MainPresenter.View view,
      ResourceProvider resourceProvider, Lifecycle lifecycle, RxBus rxBus) {
    MainPresenter presenter = new MainPresenterImpl(view, resourceProvider, rxBus);
    lifecycle.addObserver(presenter);
    return presenter;
  }

  @Provides Lifecycle provideLifecycle(MainActivity act) {
    return act.getLifecycle();
  }

  @Provides RxBus provideRxBus(MainActivity act) {
    return ((App) act.getApplication()).getRxBus();
  }
}