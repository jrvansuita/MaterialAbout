package com.vansuita.materialabout.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.text.TextUtils;
import android.view.View;

/**
 * Created by jrvansuita on 20/02/17.
 */

public final class VisibleUtil {

    public static void handle(@NonNull View v, @Nullable String s) {
        v.setVisibility(TextUtils.isEmpty(s) ? View.GONE : View.VISIBLE);
    }
}
