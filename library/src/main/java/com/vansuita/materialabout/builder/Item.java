package com.vansuita.materialabout.builder;

import android.graphics.Bitmap;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.vansuita.materialabout.views.ViewIdGenerator;

/**
 * Created by jrvansuita on 11/02/17.
 */
public final class Item {

    private int id;
    private CharSequence label;
    private Bitmap icon;
    private View.OnClickListener onClick;

    @Nullable
    public CharSequence getLabel() {
        return label;
    }

    public void setLabel(@Nullable CharSequence label) {
        this.label = label;
    }

    @Nullable
    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(@Nullable Bitmap icon) {
        this.icon = icon;
    }

    @Nullable
    public View.OnClickListener getOnClick() {
        return onClick;
    }

    public void setOnClick(@Nullable View.OnClickListener onClick) {
        this.onClick = onClick;
    }

    public int getId() {
        return id;
    }

    public Item(@Nullable Bitmap icon, @Nullable CharSequence label, @Nullable View.OnClickListener onClick) {
        this.id = ViewIdGenerator.generateViewId();
        this.label = label;
        this.icon = icon;
        this.onClick = onClick;
    }
}
