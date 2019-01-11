package io.github.ovso.ktest.ui.main.search.di;

import androidx.lifecycle.Lifecycle;
import dagger.Module;
import dagger.Provides;
import io.github.ovso.ktest.App;
import io.github.ovso.ktest.data.network.ImageRequest;
import io.github.ovso.ktest.data.network.VclipRequest;
import io.github.ovso.ktest.data.network.model.Document;
import io.github.ovso.ktest.ui.base.adapter.BaseAdapterDataModel;
import io.github.ovso.ktest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.ktest.ui.base.rx.Schedulers;
import io.github.ovso.ktest.ui.main.search.SearchFragment;
import io.github.ovso.ktest.ui.main.search.SearchFragmentPresenter;
import io.github.ovso.ktest.ui.main.search.SearchFragmentPresenterImpl;
import io.github.ovso.ktest.ui.main.search.adapter.SearchAdapter;
import io.github.ovso.ktest.ui.main.search.vo.SearchFragmentArgs;
import io.github.ovso.ktest.ui.base.rx.RxBus;
import javax.inject.Singleton;

@Module public class SearchFragmentModule {

  @Singleton @Provides SearchFragmentPresenter provideSearchFragmentPresenter(
      SearchFragmentPresenter.View view, Lifecycle lifecycle, RxBus rxBus,
      ImageRequest imageRequest, VclipRequest vclipRequest, Schedulers schedulers,
      BaseAdapterDataModel<Document> adapterDataModel) {

    SearchFragmentArgs args = new SearchFragmentArgs.Builder()
        .setView(view)
        .setRxBus(rxBus)
        .setImageRequest(imageRequest)
        .setVclipRequest(vclipRequest)
        .setSchedulers(schedulers)
        .setAdapterDataModel(adapterDataModel)
        .build();

    SearchFragmentPresenter presenter = new SearchFragmentPresenterImpl(args);
    lifecycle.addObserver(presenter);
    return presenter;
  }

  @Provides Lifecycle provideLifecuycle(SearchFragment f) {
    return f.getLifecycle();
  }

  @Singleton @Provides SearchAdapter provideSearchAdapter() {
    return new SearchAdapter.Builder().build();
  }

  @Provides BaseAdapterView provideAdapterView(SearchAdapter adapter) {
    return adapter;
  }

  @Provides BaseAdapterDataModel<Document> provideAdapterDataModel(SearchAdapter adapter) {
    return adapter;
  }

  @Provides RxBus provideRxBus(SearchFragment frag) {
    return ((App) frag.getActivity().getApplication()).getRxBus();
  }
}