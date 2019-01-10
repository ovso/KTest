package io.github.ovso.ktest.data.network;

import io.github.ovso.ktest.data.network.model.image.Search;
import io.reactivex.Observable;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface VclipService {
  @GET("/v2/search/vclip")
  Observable<Search> vclip(@QueryMap Map<String, Object> queryMap);
}
