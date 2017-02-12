package com.vansuita.materialabout.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

/**
 * Created by jrvansuita on 10/02/17.
 */

public class IconUtil {

    public static Bitmap getBitmap(Context context, int res) {
        return BitmapFactory.decodeResource(context.getResources(), res);
    }

    public static Bitmap getBitmap(Context context, Drawable drawable) {
        return ((BitmapDrawable) drawable).getBitmap();
    }

    public static Drawable getDrawable(Context context, Bitmap bitmap) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static Drawable getDrawable(Context context, int res) {
        return ContextCompat.getDrawable(context, res);
    }
}
