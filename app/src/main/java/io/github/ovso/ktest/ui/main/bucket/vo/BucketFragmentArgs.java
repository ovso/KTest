package io.github.ovso.ktest.ui.main.bucket.vo;

import io.github.ovso.ktest.data.network.ImageRequest;
import io.github.ovso.ktest.data.network.VclipRequest;
import io.github.ovso.ktest.data.network.model.image.Document;
import io.github.ovso.ktest.ui.base.adapter.BaseAdapterDataModel;
import io.github.ovso.ktest.ui.base.interfaces.IBuilder;
import io.github.ovso.ktest.ui.base.rx.Schedulers;
import io.github.ovso.ktest.ui.main.bucket.BucketFragmentPresenter;
import io.github.ovso.ktest.utils.RxBus;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public final class BucketFragmentArgs {
  @Getter private BucketFragmentPresenter.View view;
  @Getter private RxBus rxBus;
  @Getter private Schedulers schedulers;
  @Getter private BaseAdapterDataModel<Document> adapterDataModel;

  private BucketFragmentArgs(Builder builder) {
    view = builder.view;
    rxBus = builder.rxBus;
    schedulers = builder.schedulers;
    adapterDataModel = builder.adapterDataModel;
  }

  public final static class Builder implements IBuilder<BucketFragmentArgs> {

    @Setter @Accessors(chain = true) private BucketFragmentPresenter.View view;
    @Setter @Accessors(chain = true) private RxBus rxBus;
    @Setter @Accessors(chain = true) private Schedulers schedulers;
    @Setter @Accessors(chain = true) private BaseAdapterDataModel<Document> adapterDataModel;

    @Override public BucketFragmentArgs build() {
      return new BucketFragmentArgs(this);
    }
  }
}
