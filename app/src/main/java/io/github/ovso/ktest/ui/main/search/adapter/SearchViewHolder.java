package io.github.ovso.ktest.ui.main.search.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.github.ovso.ktest.R;
import io.github.ovso.ktest.data.network.model.image.Document;
import io.github.ovso.ktest.ui.base.adapter.BaseViewHolder;

public class SearchViewHolder extends BaseViewHolder<Document> {

  private SearchViewHolder(View itemView) {
    super(itemView);
  }

  @Override public void bind(Document $data) {
    super.bind($data);
  }

  public static SearchViewHolder create(ViewGroup parent) {
    return new SearchViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false));
  }
}