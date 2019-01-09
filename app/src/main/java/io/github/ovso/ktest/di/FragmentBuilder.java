package io.github.ovso.ktest.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import io.github.ovso.ktest.ui.main.bucket.BucketFragment;
import io.github.ovso.ktest.ui.main.bucket.di.BucketFragmentModule;
import io.github.ovso.ktest.ui.main.bucket.di.BucketFragmentViewModule;
import io.github.ovso.ktest.ui.main.search.SearchFragment;
import io.github.ovso.ktest.ui.main.search.di.SearchFragmentModule;
import io.github.ovso.ktest.ui.main.search.di.SearchFragmentViewModule;
import javax.inject.Singleton;

@Module(includes = { AndroidSupportInjectionModule.class })
public abstract class FragmentBuilder {
  @Singleton @ContributesAndroidInjector(modules = {
      SearchFragmentModule.class,
      SearchFragmentViewModule.class
  })
  abstract SearchFragment contributeSearchFragment();

  @Singleton @ContributesAndroidInjector(modules = {
      BucketFragmentModule.class,
      BucketFragmentViewModule.class
  })
  abstract BucketFragment contributeBucketFragment();
}
