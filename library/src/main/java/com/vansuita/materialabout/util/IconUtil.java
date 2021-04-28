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

    @Nullable
    public static Bitmap getBitmap(@NonNull Context context, @DrawableRes int res) {
        return BitmapFactory.decodeResource(context.getResources(), res);
    }

    @Nullable
    public static Bitmap getBitmap(@Nullable BitmapDrawable drawable) {
        return drawable == null ? null : drawable.getBitmap();
    }

    @NonNull
    public static Drawable getDrawable(@NonNull Context context,@NonNull  Bitmap bitmap) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    @NonNull
    public static Drawable getDrawable(@NonNull Context context, @DrawableRes int res) {
        return ContextCompat.getDrawable(context, res);
    }
}
