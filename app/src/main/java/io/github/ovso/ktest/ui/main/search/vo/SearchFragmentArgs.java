package io.github.ovso.ktest.ui.main.search.vo;

import io.github.ovso.ktest.ui.base.interfaces.IBuilder;
import io.github.ovso.ktest.ui.main.search.SearchFragmentPresenter;
import io.github.ovso.ktest.utils.RxBus;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public final class SearchFragmentArgs {
  @Getter private SearchFragmentPresenter.View view;
  @Getter private RxBus rxBus;

  private SearchFragmentArgs(Builder builder) {
    view = builder.view;
    rxBus = builder.rxBus;
  }

  public final static class Builder implements IBuilder<SearchFragmentArgs> {

    @Setter @Accessors(chain = true) private SearchFragmentPresenter.View view;
    @Setter @Accessors(chain = true) private RxBus rxBus;

    @Override public SearchFragmentArgs build() {
      return new SearchFragmentArgs(this);
    }
  }
}
