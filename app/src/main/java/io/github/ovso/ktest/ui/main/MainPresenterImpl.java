package io.github.ovso.ktest.ui.main;

import android.text.TextUtils;
import io.github.ovso.ktest.ui.base.rx.Schedulers;
import io.github.ovso.ktest.ui.base.rx.RxBus;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import timber.log.Timber;

public class MainPresenterImpl implements MainPresenter {

  private final RxBus rxBus;
  private MainPresenter.View view;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private Schedulers schedulers;

  public MainPresenterImpl(MainPresenter.View $view,
      RxBus $rxBus) {
    view = $view;
    rxBus = $rxBus;
    schedulers = new Schedulers();
  }

  @Override public void onCreate() {
    view.setupTabLayout();
    view.setupViewPager();
  }

  @Override public void onDestroy() {
    compositeDisposable.clear();
  }

  @Override public boolean onQueryTextChange(String query) {
    view.navigateToSearchFragment();
    compositeDisposable.clear();
    Single.just(query)
        .subscribeOn(schedulers.io())
        .delay(1, TimeUnit.SECONDS)
        .subscribe(onQueryTextChangeSingleObserver);
    return false;
  }

  private SingleObserver<String> onQueryTextChangeSingleObserver = new SingleObserver<String>() {
    @Override public void onSubscribe(Disposable d) {
      compositeDisposable.add(d);
    }

    @Override public void onSuccess(String q) {
      Timber.d("onSuccess = %s", q);
      rxBus.send(new RxBusEvent(q));
    }

    @Override public void onError(Throwable e) {
      Timber.e(e);
    }
  };

  @AllArgsConstructor public final static class RxBusEvent {
    @Getter private String newText;
  }
}