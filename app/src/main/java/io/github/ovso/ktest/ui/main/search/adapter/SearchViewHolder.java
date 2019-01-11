package io.github.ovso.ktest.ui.main.search.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import io.github.ovso.ktest.App;
import io.github.ovso.ktest.R;
import io.github.ovso.ktest.data.network.model.Document;
import io.github.ovso.ktest.ui.base.adapter.BaseViewHolder;
import io.github.ovso.ktest.ui.base.rx.RxBus;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class SearchViewHolder extends BaseViewHolder<Document> {
  @BindView(R.id.imageview_searchviewholder) ImageView thumbImageView;
  @BindView(R.id.lottie_search_bucket) LottieAnimationView bucketLottie;

  private SearchViewHolder(View itemView) {
    super(itemView);
  }

  @Override public void bind(Document $data) {
    super.bind($data);
    Glide.with(itemView).load(getImageUrl()).into(thumbImageView);
  }

  private String getImageUrl() {
    if (data.getThumbnail() != null) {
      return data.getThumbnail();
    } else {
      return data.getThumbnail_url();
    }
  }

  @OnClick(R.id.lottie_search_bucket) void onClick() {
    bucketLottie.setProgress(getProgress());
    getRxBus().send(new RxBusEvent(data));
  }

  private float getProgress() {
    return bucketLottie.getProgress() == 0 ? 1 : 0;
  }

  private RxBus getRxBus() {
    return ((App) itemView.getContext().getApplicationContext()).getRxBus();
  }

  public static SearchViewHolder create(ViewGroup parent) {
    return new SearchViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false));
  }

  @AllArgsConstructor @Getter public final static class RxBusEvent {
    private Document document;
  }
}