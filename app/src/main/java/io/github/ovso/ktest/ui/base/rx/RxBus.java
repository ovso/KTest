package io.github.ovso.ktest.ui.base.rx;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public final class RxBus {

  private PublishSubject<Object> bus = PublishSubject.create();

  public void send(Object o) {
    bus.onNext(o);
  }

  public Observable<Object> toObservable() {
    return bus;
  }
}