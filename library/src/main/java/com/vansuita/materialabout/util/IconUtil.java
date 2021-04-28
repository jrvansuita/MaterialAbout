package com.vansuita.materialabout.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

/**
 * Static utilities.
 */
@SuppressWarnings("unused")
public final class IconUtil {

    public static Bitmap getBitmap(Context context, int res) {
        return BitmapFactory.decodeResource(context.getResources(), res);
    }

    public static Bitmap getBitmap(BitmapDrawable drawable) {
        return drawable.getBitmap();
    }

    public static Drawable getDrawable(Context context, Bitmap bitmap) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context context, @DrawableRes int res) {
        return ContextCompat.getDrawable(context, res);
    }
}
