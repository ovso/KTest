package io.github.ovso.ktest.ui.base.adapter;

import java.util.List;

public interface BaseAdapterDataModel<T> {
  void add(T item);

  void addAll(List<T> items);

  int getSize();

  void clear();

  void remove(T document);
}
