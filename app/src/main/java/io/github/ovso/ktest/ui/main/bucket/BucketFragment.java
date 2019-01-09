package io.github.ovso.ktest.ui.main.bucket;

import android.os.Bundle;
import io.github.ovso.ktest.R;
import io.github.ovso.ktest.ui.base.view.BaseFragment;

public class BucketFragment extends BaseFragment {

  @Override protected int getLayoutResId() {
    return R.layout.fragment_all;
  }

  public static BucketFragment newInstance(Bundle args) {
    BucketFragment f = new BucketFragment();
    f.setArguments(args);
    return f;
  }
}