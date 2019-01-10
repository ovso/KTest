package io.github.ovso.ktest.data.network;

import io.github.ovso.ktest.data.network.model.image.ImageData;
import io.reactivex.Single;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ImageService {
  @GET("/v2/search/image")
  Single<ImageData> images(@QueryMap Map<String, Object> queryMap);
}
