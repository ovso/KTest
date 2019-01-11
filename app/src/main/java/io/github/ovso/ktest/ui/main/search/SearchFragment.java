package io.github.ovso.ktest.ui.main.search;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.fondesa.recyclerviewdivider.RecyclerViewDivider;
import io.github.ovso.ktest.R;
import io.github.ovso.ktest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.ktest.ui.base.view.BaseFragment;
import io.github.ovso.ktest.ui.main.search.adapter.SearchAdapter;
import io.github.ovso.ktest.utils.DimensionUtils;
import javax.inject.Inject;

public class SearchFragment extends BaseFragment implements SearchFragmentPresenter.View {
  @BindView(R.id.recyclerview_all) RecyclerView recyclerView;

  @Inject SearchFragmentPresenter presenter;
  @Inject SearchAdapter adapter;
  @Inject BaseAdapterView adapterView;

  @Override protected int getLayoutResId() {
    return R.layout.fragment_all;
  }

  public static SearchFragment newInstance() {
    return new SearchFragment();
  }

  @Override public void setupRecyclerView() {
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setAdapter(adapter);
  }

  @Override public void setupRecyclerViewDivider() {
    if (getContext() != null) {
      RecyclerViewDivider.with(getContext())
          .color(ContextCompat.getColor(getContext(), android.R.color.transparent))
          .size(DimensionUtils.dpToPx(10, getContext()))
          .build()
          .addTo(recyclerView);
    }
  }

  @Override public void refresh() {
    adapterView.refresh();
  }
}