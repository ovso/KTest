package io.github.ovso.ktest.ui.base.rx;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import javax.inject.Inject;

public class Schedulers {

  @Inject public Schedulers(){}

  /**
   * IO thread pool scheduler
   */
  public Scheduler io() {
    return io.reactivex.schedulers.Schedulers.io();
  }

  /**
   * Computation thread pool scheduler
   */
  public Scheduler computation() {
    return io.reactivex.schedulers.Schedulers.computation();
  }

  /**
   * Main Thread scheduler
   */
  public Scheduler ui() {
    return AndroidSchedulers.mainThread();
  }
}
