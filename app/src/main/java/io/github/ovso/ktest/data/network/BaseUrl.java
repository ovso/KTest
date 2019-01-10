package io.github.ovso.ktest.data.network;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor public enum BaseUrl {

  SEARCH_IMAGE("https://dapi.kakao.com");
  private String url;
}