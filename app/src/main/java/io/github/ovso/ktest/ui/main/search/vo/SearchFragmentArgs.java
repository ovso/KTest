package io.github.ovso.ktest.ui.main.search.vo;

import io.github.ovso.ktest.data.network.ImageRequest;
import io.github.ovso.ktest.data.network.VclipRequest;
import io.github.ovso.ktest.data.network.model.Document;
import io.github.ovso.ktest.ui.base.adapter.BaseAdapterDataModel;
import io.github.ovso.ktest.ui.base.interfaces.IBuilder;
import io.github.ovso.ktest.ui.base.rx.Schedulers;
import io.github.ovso.ktest.ui.main.search.SearchFragmentPresenter;
import io.github.ovso.ktest.ui.base.rx.RxBus;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public final class SearchFragmentArgs {
  @Getter private SearchFragmentPresenter.View view;
  @Getter private RxBus rxBus;
  @Getter private ImageRequest imageRequest;
  @Getter private VclipRequest vclipRequest;
  @Getter private Schedulers schedulers;
  @Getter private BaseAdapterDataModel<Document> adapterDataModel;

  private SearchFragmentArgs(Builder builder) {
    view = builder.view;
    rxBus = builder.rxBus;
    imageRequest = builder.imageRequest;
    vclipRequest = builder.vclipRequest;
    schedulers = builder.schedulers;
    adapterDataModel = builder.adapterDataModel;
  }

  public final static class Builder implements IBuilder<SearchFragmentArgs> {

    @Setter @Accessors(chain = true) private SearchFragmentPresenter.View view;
    @Setter @Accessors(chain = true) private RxBus rxBus;
    @Setter @Accessors(chain = true) private ImageRequest imageRequest;
    @Setter @Accessors(chain = true) private VclipRequest vclipRequest;
    @Setter @Accessors(chain = true) private Schedulers schedulers;
    @Setter @Accessors(chain = true) private BaseAdapterDataModel<Document> adapterDataModel;

    @Override public SearchFragmentArgs build() {
      return new SearchFragmentArgs(this);
    }
  }
}