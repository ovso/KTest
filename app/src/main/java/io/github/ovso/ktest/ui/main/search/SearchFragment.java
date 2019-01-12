package io.github.ovso.ktest.ui.main.search;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.airbnb.lottie.LottieAnimationView;
import io.github.ovso.ktest.R;
import io.github.ovso.ktest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.ktest.ui.base.listener.SearchSuccessListener;
import io.github.ovso.ktest.ui.base.view.BaseFragment;
import io.github.ovso.ktest.ui.main.search.adapter.SearchAdapter;
import javax.inject.Inject;
import timber.log.Timber;

public class SearchFragment extends BaseFragment implements SearchFragmentPresenter.View {
  @BindView(R.id.recyclerview_all) RecyclerView recyclerView;
  @BindView(R.id.lottie_fragment_loading) LottieAnimationView loadingView;
  @Inject SearchFragmentPresenter presenter;
  @Inject SearchAdapter adapter;
  @Inject BaseAdapterView adapterView;
  private SearchSuccessListener searchSuccessListener;

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    try {
      searchSuccessListener = (SearchSuccessListener) context;
    } catch (ClassCastException e) {
      Timber.e(e);
    }
  }

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
    if (searchSuccessListener != null) {
      searchSuccessListener.onSearchSuccess();
    }
  }

  @Override public void hideLoading() {
    loadingView.setVisibility(View.INVISIBLE);
  }

  @Override public void showLoading() {
    loadingView.setVisibility(View.VISIBLE);
  }
}