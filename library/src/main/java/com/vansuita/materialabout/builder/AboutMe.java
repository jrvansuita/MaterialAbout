package com.vansuita.materialabout.builder;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;

import com.vansuita.materialabout.BuildConfig;
import com.vansuita.materialabout.R;
import com.vansuita.materialabout.util.ColorUtil;
import com.vansuita.materialabout.util.IconUtil;
import com.vansuita.materialabout.util.IntentUtil;
import com.vansuita.materialabout.views.AboutView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jrvansuita on 10/02/17.
 */

public class AboutMe {

    private Context context;
    private IntentUtil util;

    private String name;
    private String subTitle;
    private String brief;
    private String appName;
    private String appTitle;

    private Bitmap photo;
    private Bitmap cover;
    private Bitmap appIcon;

    private int nameColor;
    private int subTitleColor;
    private int briefColor;
    private int iconColor;
    private int backgroundColor;

    private boolean showDivider = true;
    private int dividerColor = 0;
    private int dividerHeight = 4;
    private int dividerDashWidth = 15;
    private int dividerDashGap = 15;

    private boolean linksAnimated = true;
    private int linksColumnsCount = 5;
    private int actionsColumnsCount = 2;

    private List<Item> links = new ArrayList();
    private List<Item> actions = new ArrayList();

    AboutMe(Context context) {
        this.context = context;
        this.util = new IntentUtil(context);
    }

    public static AboutMe with(Context context) {
        return new AboutMe(context);
    }

    public AboutMe setName(String text) {
        this.name = text;
        return this;
    }

    public AboutMe setName(int text) {
        return setName(context.getString(text));
    }


    public AboutMe setSubTitle(String text) {
        this.subTitle = text;
        return this;
    }

    public AboutMe setSubTitle(int text) {
        return setSubTitle(context.getString(text));
    }

    public AboutMe setBrief(String text) {
        this.brief = text;
        return this;
    }

    public AboutMe setBrief(int text) {
        return setBrief(context.getString(text));
    }

    public AboutMe setAppName(String text) {
        this.appName = text;
        return this;
    }

    public AboutMe setAppName(int text) {
        return setAppName(context.getString(text));
    }


    public AboutMe setAppTitle(String text) {
        this.appTitle = text;
        return this;
    }

    public AboutMe setAppTitle(int text) {
        return setAppTitle(context.getString(text));
    }

    public AboutMe setVersionAsAppTitle() {
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return setAppTitle(context.getString(R.string.version, pi.versionName));
        } catch (PackageManager.NameNotFoundException e) {
            return setAppTitle(R.string.error);
        }
    }

    public AboutMe setPhoto(Bitmap bitmap) {
        this.photo = bitmap;
        return this;
    }

    public AboutMe setPhoto(int res) {
        return setPhoto(IconUtil.getBitmap(context, res));
    }

    public AboutMe setPhoto(Drawable drawable) {
        return setPhoto(IconUtil.getBitmap(context, drawable));
    }

    public AboutMe setCover(Bitmap bitmap) {
        this.cover = bitmap;
        return this;
    }

    public AboutMe setCover(int res) {
        return setCover(IconUtil.getBitmap(context, res));
    }

    public AboutMe setCover(Drawable drawable) {
        return setCover(IconUtil.getBitmap(context, drawable));
    }

    public AboutMe setAppIcon(Bitmap bitmap) {
        this.appIcon = bitmap;
        return this;
    }

    public AboutMe setAppIcon(int res) {
        return setAppIcon(IconUtil.getBitmap(context, res));
    }

    public AboutMe setAppIcon(Drawable drawable) {
        return setAppIcon(IconUtil.getBitmap(context, drawable));
    }

    public AboutMe setNameColor(int color) {
        this.nameColor = ColorUtil.get(context, color);
        return this;
    }

    public AboutMe setSubTitleColor(int color) {
        this.subTitleColor = ColorUtil.get(context, color);
        return this;
    }

    public AboutMe setBriefColor(int color) {
        this.briefColor = ColorUtil.get(context, color);
        return this;
    }

    public AboutMe setDividerColor(int color) {
        this.dividerColor = ColorUtil.get(context, color);
        return this;
    }

    public AboutMe setIconColor(int color) {
        this.iconColor = ColorUtil.get(context, color);
        return this;
    }


    public AboutMe setBackgroundColor(int res) {
        this.backgroundColor = ColorUtil.get(context, res);
        return this;
    }

    public AboutMe setActionsColumnsCount(int count) {
        this.actionsColumnsCount = count;
        return this;
    }


    public AboutMe setLinksColumnsCount(int count) {
        this.linksColumnsCount = count;
        return this;
    }


    public AboutMe setLinksAnimated(boolean animate) {
        this.linksAnimated = animate;
        return this;
    }

    public AboutMe setDividerHeight(int dividerHeight) {
        this.dividerHeight = dividerHeight;
        return this;
    }

    public AboutMe setDividerDashWidth(int dividerDashWidth) {
        this.dividerDashWidth = dividerDashWidth;
        return this;
    }

    public AboutMe setDividerDashGap(int dividerDashGap) {
        this.dividerDashGap = dividerDashGap;
        return this;
    }

    public void setShowDivider(boolean showDivider) {
        this.showDivider = showDivider;
    }

    public AboutMe addLink(Bitmap icon, String label, View.OnClickListener onClickListener) {
        links.add(new Item(icon, label, onClickListener));
        return this;
    }

    public AboutMe addLink(Bitmap icon, String label, Intent intent) {
        return addLink(icon, label, util.clickIntent(intent));
    }

    public AboutMe addLink(Bitmap icon, String label, Uri uri) {
        return addLink(icon, label, util.clickUri(uri));
    }

    public AboutMe addLink(Bitmap icon, String label, String url) {
        return addLink(icon, label, Uri.parse(url));
    }

    public AboutMe addLink(Bitmap icon, int label, View.OnClickListener onClickListener) {
        return addLink(icon, context.getString(label), onClickListener);
    }

    public AboutMe addLink(Bitmap icon, int label, Intent intent) {
        return addLink(icon, label, util.clickIntent(intent));
    }

    public AboutMe addLink(Bitmap icon, int label, Uri uri) {
        return addLink(icon, label, util.clickUri(uri));
    }

    public AboutMe addLink(Bitmap icon, int label, String url) {
        return addLink(icon, label, Uri.parse(url));
    }

    public AboutMe addLink(int icon, int label, View.OnClickListener onClickListener) {
        return addLink(IconUtil.getBitmap(context, icon), context.getString(label), onClickListener);
    }

    public AboutMe addLink(int icon, int label, Intent intent) {
        return addLink(icon, label, util.clickIntent(intent));
    }

    public AboutMe addLink(int icon, int label, Uri uri) {
        return addLink(icon, label, util.clickUri(uri));
    }

    public AboutMe addLink(int icon, int label, String url) {
        return addLink(icon, label, Uri.parse(url));
    }

    public AboutMe addLink(int icon, String label, View.OnClickListener onClickListener) {
        return addLink(IconUtil.getBitmap(context, icon), label, onClickListener);
    }

    public AboutMe addLink(int icon, String label, Intent intent) {
        return addLink(icon, label, util.clickIntent(intent));
    }

    public AboutMe addLink(int icon, String label, Uri uri) {
        return addLink(icon, label, util.clickUri(uri));
    }

    public AboutMe addLink(int icon, String label, String url) {
        return addLink(icon, label, Uri.parse(url));
    }

    public AboutMe addLink(Drawable icon, int label, View.OnClickListener onClickListener) {
        return addLink(IconUtil.getBitmap(context, icon), context.getString(label), onClickListener);
    }

    public AboutMe addLink(Drawable icon, int label, Intent intent) {
        return addLink(icon, label, util.clickIntent(intent));
    }

    public AboutMe addLink(Drawable icon, int label, Uri uri) {
        return addLink(icon, label, util.clickUri(uri));
    }

    public AboutMe addLink(Drawable icon, int label, String url) {
        return addLink(icon, label, Uri.parse(url));
    }

    public AboutMe addLink(Drawable icon, String label, View.OnClickListener onClickListener) {
        return addLink(IconUtil.getBitmap(context, icon), label, onClickListener);
    }

    public AboutMe addLink(Drawable icon, String label, Intent intent) {
        return addLink(icon, label, util.clickIntent(intent));
    }

    public AboutMe addLink(Drawable icon, String label, Uri uri) {
        return addLink(icon, label, util.clickUri(uri));
    }

    public AboutMe addLink(Drawable icon, String label, String url) {
        return addLink(icon, label, Uri.parse(url));
    }


    public AboutMe addGitHubLink(String user) {
        return addLink(R.mipmap.github, R.string.github, util.uri(R.string.url_github, user));
    }

    public AboutMe addBitbucketLink(String user) {
        return addLink(R.mipmap.bitbucket, R.string.bitbucket, util.uri(R.string.url_bitbucket, user));
    }

    public AboutMe addFacebookLink(String user) {
        return addLink(R.mipmap.facebook, R.string.facebook, util.openFacebook(user));
    }

    public AboutMe addInstagramLink(String user) {
        return addLink(R.mipmap.instagram, R.string.instagram, util.openInstagram(user));
    }

    public AboutMe addTwitterLink(String user) {
        return addLink(R.mipmap.twitter, R.string.twitter, util.openTwitter(user));
    }

    public AboutMe addGoogleLink(String url) {
        return addLink(R.mipmap.google, R.string.google, url);
    }

    public AboutMe addGooglePlusLink(String user) {
        return addLink(R.mipmap.google_plus, R.string.google_plus, util.openGooglePlus(user));
    }

    public AboutMe addGooglePlayStoreLink(String user) {
        return addLink(R.mipmap.google_play_store, R.string.google_play_store, util.openGooglePlayDev(user));
    }

    public AboutMe addGoogleGamesLink(String url) {
        return addLink(R.mipmap.google_play_games, R.string.google_play_games, url);
    }

    public AboutMe addYoutubeChannelLink(String user) {
        return addLink(R.mipmap.youtube, R.string.youtube, util.openYoutubeChannel(user));
    }

    public AboutMe addLinkedinLink(String user) {
        return addLink(R.mipmap.linkedin, R.string.linkedin, util.openLinkedin(user));
    }

    public AboutMe addSkypeLink(String phone) {
        return addLink(R.mipmap.skype, R.string.skype, util.openSkype(phone));
    }

    public AboutMe addWhatsappLink(String name, String phone) {
        return addLink(R.mipmap.whatsapp, R.string.whastapp, util.openAddContact(name, phone));
    }

    public AboutMe addAndroidLink(String url) {
        return addLink(R.mipmap.android, R.string.android, url);
    }

    public AboutMe addDribbleLink(String url) {
        return addLink(R.mipmap.dribbble, R.string.dribbble, url);
    }

    public AboutMe addWebsiteLink(String url) {
        return addLink(R.mipmap.website, R.string.website, url);
    }

    public AboutMe addEmailLink(String email, String subject, String message) {
        return addLink(R.mipmap.email, R.string.email, util.sendEmail(email, subject, message));
    }

    public AboutMe addEmailLink(String email) {
        return addLink(R.mipmap.email, R.string.email, util.sendEmail(email, null, null));
    }


    public AboutMe addAction(Bitmap icon, String label, View.OnClickListener onClickListener) {
        actions.add(new Item(icon, label, onClickListener));
        return this;
    }

    public AboutMe addAction(Bitmap icon, String label, Intent intent) {
        return addAction(icon, label, util.clickIntent(intent));
    }

    public AboutMe addAction(Bitmap icon, String label, Uri uri) {
        return addAction(icon, label, util.clickUri(uri));
    }

    public AboutMe addAction(Bitmap icon, String label, String url) {
        return addAction(icon, label, Uri.parse(url));
    }

    public AboutMe addAction(Bitmap icon, int label, View.OnClickListener onClickListener) {
        return addAction(icon, context.getString(label), onClickListener);
    }

    public AboutMe addAction(Bitmap icon, int label, Intent intent) {
        return addAction(icon, label, util.clickIntent(intent));
    }

    public AboutMe addAction(Bitmap icon, int label, Uri uri) {
        return addAction(icon, label, util.clickUri(uri));
    }

    public AboutMe addAction(Bitmap icon, int label, String url) {
        return addAction(icon, label, Uri.parse(url));
    }

    public AboutMe addAction(int icon, int label, View.OnClickListener onClickListener) {
        return addAction(IconUtil.getBitmap(context, icon), context.getString(label), onClickListener);
    }

    public AboutMe addAction(int icon, int label, Intent intent) {
        return addAction(icon, label, util.clickIntent(intent));
    }

    public AboutMe addAction(int icon, int label, Uri uri) {
        return addAction(icon, label, util.clickUri(uri));
    }

    public AboutMe addAction(int icon, int label, String url) {
        return addAction(icon, label, Uri.parse(url));
    }

    public AboutMe addAction(int icon, String label, View.OnClickListener onClickListener) {
        return addAction(IconUtil.getBitmap(context, icon), label, onClickListener);
    }

    public AboutMe addAction(int icon, String label, Intent intent) {
        return addAction(icon, label, util.clickIntent(intent));
    }

    public AboutMe addAction(int icon, String label, Uri uri) {
        return addAction(icon, label, util.clickUri(uri));
    }

    public AboutMe addAction(int icon, String label, String url) {
        return addAction(icon, label, Uri.parse(url));
    }

    public AboutMe addAction(Drawable icon, int label, View.OnClickListener onClickListener) {
        return addAction(IconUtil.getBitmap(context, icon), context.getString(label), onClickListener);
    }

    public AboutMe addAction(Drawable icon, int label, Intent intent) {
        return addAction(icon, label, util.clickIntent(intent));
    }

    public AboutMe addAction(Drawable icon, int label, Uri uri) {
        return addAction(icon, label, util.clickUri(uri));
    }

    public AboutMe addAction(Drawable icon, int label, String url) {
        return addAction(icon, label, Uri.parse(url));
    }

    public AboutMe addAction(Drawable icon, String label, View.OnClickListener onClickListener) {
        return addAction(IconUtil.getBitmap(context, icon), label, onClickListener);
    }

    public AboutMe addAction(Drawable icon, String label, Intent intent) {
        return addAction(icon, label, util.clickIntent(intent));
    }

    public AboutMe addAction(Drawable icon, String label, Uri uri) {
        return addAction(icon, label, util.clickUri(uri));
    }

    public AboutMe addAction(Drawable icon, String label, String url) {
        return addAction(icon, label, Uri.parse(url));
    }

    public AboutMe addFiveStarsAction(String appId) {
        return addAction(R.mipmap.star, R.string.rate_five_stars, util.openPlayStoreAppPage(appId));
    }

    public AboutMe addFiveStarsAction() {
        return addFiveStarsAction(BuildConfig.APPLICATION_ID);
    }

    public AboutMe addUpdateAction(String appId) {
        return addAction(R.mipmap.update, R.string.update_app, util.openPlayStoreAppPage(appId));
    }

    public AboutMe addUpdateAction() {
        return addUpdateAction(BuildConfig.APPLICATION_ID);
    }

    public AboutMe addMoreFromMeAction(String userName) {
        return addAction(R.mipmap.google_play_store, R.string.more_apps, util.openPlayStoreAppsList(userName));
    }

    public AboutMe addShareAction(String subject, String message) {
        return addAction(R.mipmap.share, R.string.share_app, util.shareThisApp(subject, message));
    }

    public AboutMe addShareAction(String subject) {
        return addShareAction(subject, context.getString(R.string.uri_play_store_app_website, BuildConfig.APPLICATION_ID));
    }

    public AboutMe addShareAction(int subject) {
        return addShareAction(context.getString(subject));
    }

    public AboutMe addFeedbackAction(String email, String subject, String text) {
        return addAction(R.mipmap.feedback, R.string.feedback_app, util.sendEmail(email, subject, text));
    }

    public AboutMe addFeedbackAction(String email, String subject) {
        return addFeedbackAction(email, subject, null);
    }

    public AboutMe addFeedbackAction(String email) {
        return addFeedbackAction(email, null);
    }

    public AboutMe addIntroduceAction(View.OnClickListener onClickListener) {
        return addAction(R.mipmap.intrduce, R.string.introduce_app, onClickListener);
    }

    public AboutMe addIntroduceAction(Intent intent) {
        return addIntroduceAction(util.clickIntent(intent));
    }

    public AboutMe addHelpAction(View.OnClickListener onClickListener) {
        return addAction(R.mipmap.help, R.string.help, onClickListener);
    }

    public AboutMe addHelpAction(Intent intent) {
        return addHelpAction(util.clickIntent(intent));
    }

    public AboutMe addChangeLogAction(View.OnClickListener onClickListener) {
        return addAction(R.mipmap.changelog, R.string.changelog, onClickListener);
    }

    public AboutMe addChangeLogAction(Intent intent) {
        return addChangeLogAction(util.clickIntent(intent));
    }

    public AboutMe addRemoveAdsAction(View.OnClickListener onClickListener) {
        return addAction(R.mipmap.ads, R.string.remove_ads, onClickListener);
    }

    public AboutMe addRemoveAdsAction(Intent intent) {
        return addRemoveAdsAction(util.clickIntent(intent));
    }


    public AboutMe addDonateAction(View.OnClickListener onClickListener) {
        return addAction(R.mipmap.donate, R.string.donate, onClickListener);
    }

    public AboutMe addDonateAction(Intent intent) {
        return addDonateAction(util.clickIntent(intent));
    }

    public String getName() {
        return name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getBrief() {
        return brief;
    }

    public String getAppName() {
        return appName;
    }

    public String getAppTitle() {
        return appTitle;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public Bitmap getCover() {
        return cover;
    }

    public Bitmap getAppIcon() {
        return appIcon;
    }

    public int getNameColor() {
        return nameColor;
    }

    public int getSubTitleColor() {
        return subTitleColor;
    }

    public int getBriefColor() {
        return briefColor;
    }

    public int getDividerColor() {
        return dividerColor;
    }

    public int getIconColor() {
        return iconColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getLinksColumnsCount() {
        return linksColumnsCount;
    }

    public int getActionsColumnsCount() {
        return actionsColumnsCount;
    }

    public boolean isShowDivider() {
        return showDivider;
    }

    public int getDividerHeight() {
        return dividerHeight;
    }

    public int getDividerDashWidth() {
        return dividerDashWidth;
    }

    public int getDividerDashGap() {
        return dividerDashGap;
    }

    public boolean isLinksAnimated() {
        return linksAnimated;
    }

    public List<Item> getLinks() {
        return links;
    }

    public List<Item> getActions() {
        return actions;
    }

    public View build() {
        AboutView aboutView = new AboutView(context);
        aboutView.build(this);
        return aboutView;
    }

}
