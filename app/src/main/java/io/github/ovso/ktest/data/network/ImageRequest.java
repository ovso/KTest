package io.github.ovso.ktest.data.network;

import io.github.ovso.ktest.data.network.model.image.ImageData;
import io.reactivex.Single;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import okhttp3.Headers;

public class ImageRequest extends BaseRequest<ImageService> {

  @Inject
  public ImageRequest() {

  }

  @Override protected Class getApiClass() {
    return ImageService.class;
  }

  @Override protected Headers createHeaders() {
    String name = "Authorization";
    String value = "KakaoAK 46f79ddb923621c9bf8d8b26c25aa7dc";
    return new Headers.Builder().add(name, value).build();
  }

  @Override protected String getBaseUrl() {
    return BaseUrl.SEARCH_IMAGE.getUrl();
  }

  public Single<ImageData> images(String query, int page) {
    Map<String, Object> param = new HashMap<>();
    param.put("query", query);
    //param.put("sort", "recency");
    param.put("page", page);
    param.put("size", 30);
    return getApi().images(param);
  }
}