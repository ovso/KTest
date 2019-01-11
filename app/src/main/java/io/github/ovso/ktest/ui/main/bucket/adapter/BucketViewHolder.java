package io.github.ovso.ktest.ui.main.bucket.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import io.github.ovso.ktest.R;
import io.github.ovso.ktest.data.network.model.Document;
import io.github.ovso.ktest.ui.base.adapter.BaseViewHolder;

public class BucketViewHolder extends BaseViewHolder<Document> {
  @BindView(R.id.imageview_searchviewholder) ImageView thumbImageView;

  private BucketViewHolder(View itemView) {
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

  public static BucketViewHolder create(ViewGroup parent) {
    return new BucketViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bucket, parent, false));
  }
}