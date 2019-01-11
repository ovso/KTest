package io.github.ovso.ktest.data.network;

import io.github.ovso.ktest.data.network.model.Search;
import io.reactivex.Observable;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ImageService {
  @GET("/v2/search/image")
  Observable<Search> images(@QueryMap Map<String, Object> queryMap);
}
