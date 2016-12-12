package com.squareup.spoon.retrievers;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

import com.squareup.spoon.ScreenshotGrabber;

public class ViewScreenshotGrabber implements ScreenshotGrabber {

  private final View view;

  public ViewScreenshotGrabber(View view) {
    this.view = view;
  }

  @Override
  public Bitmap take() {
    Bitmap bitmap = Bitmap.createBitmap(
        view.getWidth(),
        view.getHeight(),
        Bitmap.Config.ARGB_8888);
    Canvas c = new Canvas(bitmap);
    view.draw(c);
    return bitmap;
  }
}