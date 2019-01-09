package io.github.ovso.ktest.ui.main;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import io.github.ovso.ktest.ui.base.interfaces.IBuilder;
import java.util.ArrayList;
import java.util.List;
import lombok.Setter;
import lombok.experimental.Accessors;

public class MainFragmentPagerAdapter extends FragmentStatePagerAdapter {
  private List<Fragment> items = new ArrayList<>();
  private List<String> titles = new ArrayList<>();

  private MainFragmentPagerAdapter(Builder builder) {
    super(builder.fragmentManager);
    items.addAll(builder.items);
    titles.addAll(builder.titles);
  }

  @Override public Fragment getItem(int position) {
    return items.get(position);
  }

  @Override public int getCount() {
    return items.size();
  }

  @Nullable @Override public CharSequence getPageTitle(int position) {
    return titles.get(position);
  }

  public final static class Builder implements IBuilder<MainFragmentPagerAdapter> {
    @Setter @Accessors(chain = true) private FragmentManager fragmentManager;
    @Setter @Accessors(chain = true) private List<Fragment> items;
    @Setter @Accessors(chain = true) private List<String> titles;

    @Override public MainFragmentPagerAdapter build() {
      return new MainFragmentPagerAdapter(this);
    }
  }
}