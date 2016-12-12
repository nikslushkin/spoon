package com.squareup.spoon.retrievers;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.squareup.spoon.ScreenshotGrabber;

public class ScrollViewScreenshotGrabber implements ScreenshotGrabber {

    private final ViewGroup scrollView;

    public ScrollViewScreenshotGrabber(ViewGroup scrollView) {
        this.scrollView = scrollView;
    }

    @Override
    public Bitmap take() {
        if (scrollView.getChildCount() > 0) {
            return new ViewScreenshotGrabber(scrollView.getChildAt(0))
                    .take();
        }
        return null;
    }
}
