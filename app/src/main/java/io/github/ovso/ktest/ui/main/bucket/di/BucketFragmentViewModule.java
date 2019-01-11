package io.github.ovso.ktest.ui.main.bucket.di;

import dagger.Binds;
import dagger.Module;
import io.github.ovso.ktest.ui.main.bucket.BucketFragment;
import io.github.ovso.ktest.ui.main.bucket.BucketFragmentPresenter;

@Module public abstract class BucketFragmentViewModule {

  @Binds abstract BucketFragmentPresenter.View bindBucketFragmentView(BucketFragment f);
}
