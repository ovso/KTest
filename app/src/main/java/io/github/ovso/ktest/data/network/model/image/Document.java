package io.github.ovso.ktest.data.network.model.image;

import java.util.Date;
import lombok.Getter;
import lombok.ToString;

@Getter @ToString public class Document {
  private String collection;
  private String thumbnail_url;
  private String thumbnail;
  private String image_url;
  private int width;
  private int height;
  private String display_sitename;
  private String doc_url;
  private Date datetime;
}
