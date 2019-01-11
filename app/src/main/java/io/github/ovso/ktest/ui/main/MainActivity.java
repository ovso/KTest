package io.github.ovso.ktest.ui.main;

import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.google.android.material.tabs.TabLayout;
import io.github.ovso.ktest.R;
import io.github.ovso.ktest.ui.base.listener.SimpleOnQueryTextListener;
import io.github.ovso.ktest.ui.base.view.BaseActivity;
import io.github.ovso.ktest.ui.main.bucket.BucketFragment;
import io.github.ovso.ktest.ui.main.search.SearchFragment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainPresenter.View {
  @BindView(R.id.tablayout_main) TabLayout tabLayout;
  @BindView(R.id.viewpager_main) ViewPager viewPager;
  @Inject MainPresenter presenter;
  private Menu optionsMenu;

  @Override protected int getLayoutResId() {
    return R.layout.activity_main;
  }

  @Override public void setupTabLayout() {
    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    tabLayout.setTabMode(TabLayout.MODE_FIXED);
  }

  @Override public void showSearchView() {
    if (Objects.nonNull(optionsMenu)) {
      optionsMenu.findItem(R.id.action_search).setVisible(true);
    }
  }

  @Override public void hideSearchView() {
    if (Objects.nonNull(optionsMenu)) {
      optionsMenu.findItem(R.id.action_search).setVisible(false);
    }
  }

  @Override public void navigateToSearchFragment() {
    viewPager.setCurrentItem(0, true);
  }

  @Override public void setupViewPager() {
    MainFragmentPagerAdapter adapter = new MainFragmentPagerAdapter.Builder()
        .setFragmentManager(getSupportFragmentManager())
        .setItems(getFragments())
        .setTitles(Arrays.asList(getResources().getStringArray(R.array.page_title)))
        .build();
    viewPager.setAdapter(adapter);
    tabLayout.setupWithViewPager(viewPager);
  }

  private List<Fragment> getFragments() {
    List<Fragment> fragments = new ArrayList<>();
    fragments.add(SearchFragment.newInstance());
    fragments.add(BucketFragment.newInstance());
    return fragments;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.options_menu, menu);
    MenuItem searchMenu = menu.findItem(R.id.action_search);
    ((SearchView) searchMenu.getActionView()).setOnQueryTextListener(simpleOnQueryTextListener);
    optionsMenu = menu;
    return true;
  }

  private SimpleOnQueryTextListener simpleOnQueryTextListener = new SimpleOnQueryTextListener() {
    @Override public boolean onQueryTextChange(String newText) {
      return presenter.onQueryTextChange(newText);
    }
  };
}