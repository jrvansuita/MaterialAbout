package com.vansuita.materialabout.util;

import android.view.View;

/**
 * Created by jrvansuita on 20/02/17.
 */

public class VisibleUtil {

    public static void handle(View v, String s) {
        v.setVisibility(s == null || s.isEmpty() ? View.GONE : View.VISIBLE);
    }
}
