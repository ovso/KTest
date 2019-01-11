package io.github.ovso.ktest.ui.main.bucket;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import io.github.ovso.ktest.R;
import io.github.ovso.ktest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.ktest.ui.base.view.BaseFragment;
import io.github.ovso.ktest.ui.main.bucket.adapter.BucketAdapter;
import javax.inject.Inject;

public class BucketFragment extends BaseFragment implements BucketFragmentPresenter.View {
  @BindView(R.id.recyclerview_all) RecyclerView recyclerView;

  @Inject BucketFragmentPresenter presenter;
  @Inject BucketAdapter adapter;
  @Inject BaseAdapterView adapterView;

  @Override protected int getLayoutResId() {
    return R.layout.fragment_all;
  }

  public static BucketFragment newInstance() {
    return new BucketFragment();
  }

  @Override public void setupRecyclerView() {
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setAdapter(adapter);
  }

  @Override public void refresh() {
    adapterView.refresh();
  }
}