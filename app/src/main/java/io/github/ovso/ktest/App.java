package io.github.ovso.ktest;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import io.github.ovso.ktest.di.DaggerAppComponent;
import io.github.ovso.ktest.ui.base.rx.RxBus;
import lombok.Getter;
import timber.log.Timber;

public class App extends DaggerApplication {

  @Getter private RxBus rxBus;

  @Override public void onCreate() {
    super.onCreate();
    setupTimber();
    setupRxBus();
  }

  private void setupRxBus() {
    rxBus = new RxBus();
  }

  private void setupTimber() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }

  @Override
  protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    return DaggerAppComponent.builder().application(this).build();
  }
}