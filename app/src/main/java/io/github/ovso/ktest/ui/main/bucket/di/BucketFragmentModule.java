package io.github.ovso.ktest.ui.main.bucket.di;

import androidx.lifecycle.Lifecycle;
import dagger.Module;
import dagger.Provides;
import io.github.ovso.ktest.App;
import io.github.ovso.ktest.data.network.model.Document;
import io.github.ovso.ktest.ui.base.adapter.BaseAdapterDataModel;
import io.github.ovso.ktest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.ktest.ui.base.rx.Schedulers;
import io.github.ovso.ktest.ui.main.bucket.BucketFragment;
import io.github.ovso.ktest.ui.main.bucket.BucketFragmentPresenter;
import io.github.ovso.ktest.ui.main.bucket.BucketFragmentPresenterImpl;
import io.github.ovso.ktest.ui.main.bucket.adapter.BucketAdapter;
import io.github.ovso.ktest.ui.main.bucket.vo.BucketFragmentArgs;

import io.github.ovso.ktest.ui.base.rx.RxBus;
import javax.inject.Singleton;

@Module public class BucketFragmentModule {

  @Singleton @Provides BucketFragmentPresenter provideBucketFragmentPresenter(
      BucketFragmentPresenter.View view, Lifecycle lifecycle, RxBus rxBus, Schedulers schedulers,
      BaseAdapterDataModel<Document> adapterDataModel) {

    BucketFragmentArgs args = new BucketFragmentArgs.Builder()
        .setView(view)
        .setRxBus(rxBus)
        .setSchedulers(schedulers)
        .setAdapterDataModel(adapterDataModel)
        .build();

    BucketFragmentPresenter presenter = new BucketFragmentPresenterImpl(args);
    lifecycle.addObserver(presenter);
    return presenter;
  }

  @Provides Lifecycle provideLifecuycle(BucketFragment f) {
    return f.getLifecycle();
  }

  @Singleton @Provides BucketAdapter provideBucketAdapter() {
    return new BucketAdapter.Builder().build();
  }

  @Provides BaseAdapterView provideAdapterView(BucketAdapter adapter) {
    return adapter;
  }

  @Provides BaseAdapterDataModel<Document> provideAdapterDataModel(BucketAdapter adapter) {
    return adapter;
  }

  @Provides RxBus provideRxBus(BucketFragment frag) {
    return ((App) frag.getActivity().getApplication()).getRxBus();
  }
}