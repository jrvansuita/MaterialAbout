package com.vansuita.materialabout.util;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;


/**
 * Created by jrvansuita on 10/02/17.
 */

public final class ColorUtil {

    public static int get(Context context, int res) {
        try {
            return ContextCompat.getColor(context, res);
        } catch (Resources.NotFoundException e) {
            return res;
        }
    }
}
