package com.vansuita.materialabout.views;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;

import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.vansuita.library.Icon;
import com.vansuita.materialabout.R;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.builder.Item;
import com.vansuita.materialabout.util.RippleUtil;
import com.vansuita.materialabout.util.VisibleUtil;

/**
 * Created by jrvansuita on 10/02/17.
 */

public final class AboutView extends FrameLayout {

    private LayoutInflater layoutInflater;

    private CardView cvHolder;
    private CircleImageView ivPhoto;
    private AppCompatImageView ivCover;
    private AppCompatTextView tvName;
    private AppCompatTextView tvSubTitle;
    private AppCompatTextView tvBrief;

    private AppCompatTextView tvAppName;
    private AppCompatTextView tvAppTitle;
    private AppCompatImageView ivAppIcon;

    private View appHolder;
    private AutoFitGridLayout vLinks;
    private AutoFitGridLayout vActions;

    private Boolean isDarker;
    private int iconColor = 0;
    private int animationDelay = 200;


    public AboutView(@NonNull Context context) {
        this(context, null);
    }

    public AboutView(@NonNull Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AboutView(@NonNull Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(@NonNull AboutBuilder bundle) {
        layoutInflater = LayoutInflater.from(getContext());

        ViewGroup holder = this;
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        if (bundle.isWrapScrollView()) {
            lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            ScrollView scrollView = new ScrollView(getContext());
            scrollView.setLayoutParams(lp);
            addView(scrollView);
            holder = new FrameLayout(getContext());
            holder.setLayoutParams(lp);
            scrollView.addView(holder);
        }

        setLayoutParams(lp);

        layoutInflater.inflate(R.layout.xab_about_layout_card, holder);
    }

    private void bind() {
        cvHolder = findViewById(R.id.card_holder);
        ivPhoto = findViewById(R.id.photo);
        ivCover = findViewById(R.id.cover);
        tvName = findViewById(R.id.name);
        tvSubTitle = findViewById(R.id.sub_title);
        tvBrief = findViewById(R.id.brief);
        tvAppName = findViewById(R.id.app_name);
        tvAppTitle = findViewById(R.id.app_title);
        ivAppIcon = findViewById(R.id.app_icon);

        vLinks = findViewById(R.id.links);
        vActions = findViewById(R.id.actions);
        appHolder = findViewById(R.id.app_holder);
    }

    public void build(@NonNull AboutBuilder bundle) {
        init(bundle);
        bind();

        setupCard(bundle);

        tvName.setText(bundle.getName());
        VisibleUtil.handle(tvName, bundle.getName());

        tvSubTitle.setText(bundle.getSubTitle());
        VisibleUtil.handle(tvSubTitle, bundle.getSubTitle());

        tvBrief.setText(bundle.getBrief());
        VisibleUtil.handle(tvBrief, bundle.getBrief());

        tvAppName.setText(bundle.getAppName());
        tvAppTitle.setText(bundle.getAppTitle());

        setupBitmaps(bundle);

        setupTextColors(bundle);

        this.iconColor = bundle.getIconColor();

        if (bundle.getBackgroundColor() != 0)
            cvHolder.setCardBackgroundColor(bundle.getBackgroundColor());

        VisibleUtil.handle(appHolder, bundle.getAppName());

        if (appHolder.getVisibility() == VISIBLE)
            setDivider(bundle, appHolder);

        setDivider(bundle, vLinks);

        if (bundle.getLinksColumnsCount() != 0)
            vLinks.setColumnCount(bundle.getLinksColumnsCount());

        if (bundle.getActionsColumnsCount() != 0)
            vActions.setColumnCount(bundle.getActionsColumnsCount());

        vLinks.setVisibility(bundle.getLinks().isEmpty() ? GONE : VISIBLE);
        vActions.setVisibility(bundle.getActions().isEmpty() ? GONE : VISIBLE);

        loadLinks(bundle);
        loadActions(bundle);
    }

    private void setupTextColors(@NonNull AboutBuilder bundle) {
        setTextColor(tvName, bundle.getNameColor());
        setTextColor(tvSubTitle, bundle.getSubTitleColor());
        setTextColor(tvBrief, bundle.getBriefColor());
    }

    private void setTextColor(@NonNull AppCompatTextView tv, @ColorInt int color) {
        if (color != 0)
            tv.setTextColor(color);
    }

    @SuppressWarnings("ResourceAsColor")
    private void setDivider(@NonNull AboutBuilder bundle, @NonNull View holder) {
        if (bundle.isShowDivider()) {

            int color = bundle.getDividerColor();

            if (color == 0)
                color = isDarker() ? Color.GRAY : getNameColor();

            GradientDrawable drawable = ((GradientDrawable) ((LayerDrawable) holder.getBackground()).findDrawableByLayerId(R.id.stroke));

            if (drawable != null) {
                drawable.setStroke(bundle.getDividerHeight(), color, bundle.getDividerDashWidth(), bundle.getDividerDashGap());
            }
        } else {
            RippleUtil.background(holder, (Drawable) null);
        }
    }

    private int getNameColor() {
        return tvName.getCurrentTextColor();
    }

    private boolean isDarker() {
        if (isDarker == null)
            isDarker = RippleUtil.isDark(getCardColor());

        return isDarker;
    }

    private int getCardColor() {
        return cvHolder.getCardBackgroundColor().getDefaultColor();
    }

    private int getIconColor() {
        if (iconColor == 0)
            iconColor = isDarker() ? Color.WHITE : getNameColor();

        return iconColor;
    }

    private void setupBitmaps(@NonNull AboutBuilder bundle) {
        setBitmap(ivCover, bundle.getCover());
        setBitmap(ivPhoto, bundle.getPhoto());
        setBitmap(ivAppIcon, bundle.getAppIcon());
    }

    private void setBitmap(@NonNull AppCompatImageView iv, @Nullable Bitmap bitmap) {
        if (bitmap == null) {
            iv.setVisibility(GONE);
        } else {
            iv.setImageBitmap(bitmap);
        }
    }

    private void loadLinks(@NonNull AboutBuilder bundle) {
        for (Item item : bundle.getLinks()) {
            View v = addItem(vLinks, R.layout.xab_each_link, item);

            if (bundle.isLinksAnimated())
                animate(v);
        }
    }

    private void animate(@NonNull final View v) {
        v.setVisibility(INVISIBLE);

        animationDelay += 20;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setVisibility(VISIBLE);
                v.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.expand_in));
            }
        }, animationDelay);
    }

    private void loadActions(@NonNull AboutBuilder bundle) {
        for (Item item : bundle.getActions()) {
            addItem(vActions, R.layout.xab_each_action, item);
        }
    }

    @NonNull
    private View addItem(@NonNull ViewGroup holder, @LayoutRes int layout, @NonNull Item item) {
        View view = layoutInflater.inflate(layout, null);
        view.setId(item.getId());

        AppCompatTextView tvLabel = view.findViewById(R.id.label);
        AppCompatImageView ivIcon = view.findViewById(R.id.icon);

        Icon.on(ivIcon).bitmap(item.getIcon()).color(getIconColor()).put();

        tvLabel.setText(item.getLabel());
        view.setOnClickListener(item.getOnClick());

        RippleUtil.backgroundRipple(view, getCardColor());

        holder.addView(view);
        return view;
    }

    private void setupCard(@NonNull AboutBuilder bundle) {
        if (!bundle.isShowAsCard()) {
            cvHolder.setCardElevation(0);
            cvHolder.setRadius(0);
            cvHolder.setUseCompatPadding(false);
            cvHolder.setMaxCardElevation(0);
            cvHolder.setPreventCornerOverlap(false);

            ( (LayoutParams)cvHolder.getLayoutParams()).setMargins(0, 0, 0, 0);
        }
    }

    @NonNull
    public CardView getHolder() {
        return cvHolder;
    }

    @NonNull
    public View findItem(@IdRes int id) {
        return cvHolder.findViewById(id);
    }

    @NonNull
    public View findItem(@NonNull Item item) {
        return findItem(item.getId());
    }

}
