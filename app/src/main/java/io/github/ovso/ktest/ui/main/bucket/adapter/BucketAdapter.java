package io.github.ovso.ktest.ui.main.bucket.adapter;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import io.github.ovso.ktest.data.network.model.image.Document;
import io.github.ovso.ktest.ui.base.adapter.BaseAdapterDataModel;
import io.github.ovso.ktest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.ktest.ui.base.adapter.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public class BucketAdapter extends RecyclerView.Adapter<BaseViewHolder> implements
    BaseAdapterDataModel<Document>, BaseAdapterView {

  private List<Document> items = new ArrayList<>();

  private BucketAdapter() {
  }

  @NonNull @Override
  public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return BucketViewHolder.create(parent);
  }

  @Override public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
    holder.bind(items.get(position));
  }

  @Override public int getItemCount() {
    return getSize();
  }

  @Override public void add(Document item) {
    items.add(item);
  }

  @Override public void addAll(List<Document> $items) {
    items.addAll($items);
  }

  @Override public int getSize() {
    return items.size();
  }

  @Override public void clear() {
    items.clear();
  }

  @Override public void refresh() {
    notifyDataSetChanged();
  }

  public static class Builder {
    public BucketAdapter build() {
      return new BucketAdapter();
    }
  }
}
