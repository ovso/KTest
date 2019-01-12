package io.github.ovso.ktest.ui.main.search;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.airbnb.lottie.LottieAnimationView;
import io.github.ovso.ktest.R;
import io.github.ovso.ktest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.ktest.ui.base.view.BaseFragment;
import io.github.ovso.ktest.ui.main.search.adapter.SearchAdapter;
import javax.inject.Inject;

public class SearchFragment extends BaseFragment implements SearchFragmentPresenter.View {
  @BindView(R.id.recyclerview_all) RecyclerView recyclerView;
  @BindView(R.id.lottie_fragment_loading) LottieAnimationView loadingView;
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

  @Override public void refresh() {
    adapterView.refresh();
  }

  @Override public void hideLoading() {
    loadingView.setVisibility(View.INVISIBLE);
  }

  @Override public void showLoading() {
    loadingView.setVisibility(View.VISIBLE);
  }
}