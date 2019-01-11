package io.github.ovso.ktest.data.network.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.annotations.Expose;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused") @Getter public class Document implements Comparable<Document> {
  private String thumbnail_url;
  private String thumbnail;
  private Date datetime;
  @Setter private boolean bucket;

  @Override public int compareTo(@NonNull Document o) {
    return o.datetime.compareTo(this.getDatetime());
  }

  @Override public boolean equals(@Nullable Object obj) {
    if (obj instanceof Document) {
      return datetime.getTime() == ((Document) obj).getDatetime().getTime();
    } else {
      return false;
    }
  }
}
