package io.github.ovso.ktest.ui.main.search;

import android.os.Bundle;
import io.github.ovso.ktest.R;
import io.github.ovso.ktest.ui.base.view.BaseFragment;

public class SearchFragment extends BaseFragment {
  @Override protected int getLayoutResId() {
    return R.layout.fragment_all;
  }

  public static SearchFragment newInstance(Bundle args) {
    SearchFragment f = new SearchFragment();
    f.setArguments(args);
    return f;
  }
}