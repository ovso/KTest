package io.github.ovso.ktest;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import io.github.ovso.ktest.di.DaggerAppComponent;
import timber.log.Timber;

public class App extends DaggerApplication {

  @Override public void onCreate() {
    super.onCreate();
    setupTimber();
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