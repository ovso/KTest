package io.github.ovso.ktest.ui.main.search.di;

import dagger.Binds;
import dagger.Module;
import io.github.ovso.ktest.ui.main.search.SearchFragment;
import io.github.ovso.ktest.ui.main.search.SearchFragmentPresenter;

@Module public abstract class SearchFragmentViewModule {

  @Binds abstract SearchFragmentPresenter.View bindSearchFragmentView(SearchFragment f);
}
