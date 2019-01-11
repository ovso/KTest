package io.github.ovso.ktest.data.network.model;

import androidx.annotation.NonNull;
import java.util.Date;
import lombok.Getter;

@SuppressWarnings("unused") @Getter public class Document implements Comparable<Document> {
  private String thumbnail_url;
  private String thumbnail;
  private Date datetime;

  @Override public int compareTo(@NonNull Document o) {
    return o.datetime.compareTo(this.getDatetime());
  }
}
