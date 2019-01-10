package io.github.ovso.ktest.data.network.model.image;

import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter @ToString public class ImageData {
  private Meta meta;
  private List<Document> documents;
}
