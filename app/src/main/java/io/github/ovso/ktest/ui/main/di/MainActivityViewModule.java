package io.github.ovso.ktest.ui.main.di;

import dagger.Binds;
import dagger.Module;
import io.github.ovso.ktest.ui.main.MainActivity;
import io.github.ovso.ktest.ui.main.MainPresenter;

@Module public abstract class MainActivityViewModule {
  @Binds abstract MainPresenter.View bindMainView(MainActivity act);
}
