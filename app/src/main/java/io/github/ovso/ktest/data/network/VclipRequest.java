package io.github.ovso.ktest.data.network;

import io.github.ovso.ktest.data.network.model.Search;
import io.reactivex.Observable;
import javax.inject.Inject;
import okhttp3.Headers;

public class VclipRequest extends BaseRequest<VclipService> {

  @Inject VclipRequest() {

  }

  @Override protected Class<VclipService> getApiClass() {
    return VclipService.class;
  }

  @Override protected Headers createHeaders() {
    return new Headers.Builder().add(Header.NAME, Header.VALUE).build();
  }

  @Override protected String getBaseUrl() {
    return BaseUrl.SEARCH;
  }

  public Observable<Search> vclip(String query) {
    return getApi().vclip(createParam(query));
  }
}