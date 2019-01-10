package io.github.ovso.ktest.ui.main.bucket;

import io.github.ovso.ktest.R;
import io.github.ovso.ktest.ui.base.view.BaseFragment;

public class BucketFragment extends BaseFragment {

  @Override protected int getLayoutResId() {
    return R.layout.fragment_all;
  }

  public static BucketFragment newInstance() {
    return new BucketFragment();
  }
}