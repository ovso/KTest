package io.github.ovso.ktest.di;

import android.app.Application;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;
import io.github.ovso.ktest.App;

@Component(modules = {
    AndroidSupportInjectionModule.class, AppModule.class, ActivityBuilder.class,
    FragmentBuilder.class
}) public interface AppComponent extends AndroidInjector<DaggerApplication> {
  @Component.Builder interface Builder {
    @BindsInstance Builder application(Application application);

    AppComponent build();
  }

  void inject(App app);
}