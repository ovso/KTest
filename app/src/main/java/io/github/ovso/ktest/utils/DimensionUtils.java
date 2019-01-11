package io.github.ovso.ktest.utils;

import android.content.Context;
import android.util.TypedValue;

public final class DimensionUtils {
  private DimensionUtils() {
  }

  public static int dpToPx(float dp, Context context) {
    return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
        context.getResources().getDisplayMetrics());
  }
}
