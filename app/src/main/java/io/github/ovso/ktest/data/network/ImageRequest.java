package io.github.ovso.ktest.data.network;

import io.github.ovso.ktest.data.network.model.Search;
import io.reactivex.Observable;
import javax.inject.Inject;
import okhttp3.Headers;

public class ImageRequest extends BaseRequest<ImageService> {

  @Inject ImageRequest() {

  }

  @Override protected Class<ImageService> getApiClass() {
    return ImageService.class;
  }

  @Override protected Headers createHeaders() {
    return new Headers.Builder().add(Header.NAME, Header.VALUE).build();
  }

  @Override protected String getBaseUrl() {
    return BaseUrl.SEARCH;
  }

  public Observable<Search> images(String query) {
    return getApi().images(createParam(query));
  }
}