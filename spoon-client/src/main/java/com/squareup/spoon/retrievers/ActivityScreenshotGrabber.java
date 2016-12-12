package com.squareup.spoon.retrievers;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.squareup.spoon.ScreenshotGrabber;

import static android.graphics.Bitmap.Config.ARGB_8888;

public class ActivityScreenshotGrabber implements ScreenshotGrabber {

  private final Activity activity;

  public ActivityScreenshotGrabber(Activity activity) {
    this.activity = activity;
  }

  @Override
  public Bitmap take() {
    View view = activity.getWindow().getDecorView();
    final Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), ARGB_8888);
    drawDecorViewToBitmap(activity, bitmap);
    return bitmap;
  }

  private void drawDecorViewToBitmap(Activity activity, Bitmap bitmap) {
    Canvas canvas = new Canvas(bitmap);
    activity.getWindow().getDecorView().draw(canvas);
  }
}
