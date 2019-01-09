package io.github.ovso.ktest.ui.base.listener;

import androidx.appcompat.widget.SearchView;

public class SimpleOnQueryTextListener implements SearchView.OnQueryTextListener {
  @Override public boolean onQueryTextSubmit(String query) {
    return false;
  }

  @Override public boolean onQueryTextChange(String newText) {
    return false;
  }
}
