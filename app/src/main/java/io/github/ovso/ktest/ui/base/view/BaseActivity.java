package io.github.ovso.ktest.ui.base.view;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatActivity;
import io.github.ovso.ktest.R;

public abstract class BaseActivity extends DaggerAppCompatActivity {
  protected @BindView(R.id.toolbar) Toolbar toolbar;

  private Unbinder bind;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutResId());
    bind = ButterKnife.bind(this);
    setupSupportActionBar();
  }

  private void setupSupportActionBar() {
    setSupportActionBar(toolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayShowTitleEnabled(isTitle());
    }
  }

  protected abstract int getLayoutResId();

  @Override protected void onDestroy() {
    super.onDestroy();
    if (bind != null) {
      bind.unbind();
    }
  }

  public boolean isTitle() {
    return false;
  }
}