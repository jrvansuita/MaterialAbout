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

public class AboutBuilder {

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

    private boolean wrapScrollView = false;

    private List<Item> links = new ArrayList();
    private List<Item> actions = new ArrayList();

    AboutBuilder(Context context) {
        this.context = context;
        this.util = new IntentUtil(context);
    }

    public static AboutBuilder with(Context context) {
        return new AboutBuilder(context);
    }

    public AboutBuilder setName(String text) {
        this.name = text;
        return this;
    }

    public AboutBuilder setName(int text) {
        return setName(context.getString(text));
    }


    public AboutBuilder setSubTitle(String text) {
        this.subTitle = text;
        return this;
    }

    public AboutBuilder setSubTitle(int text) {
        return setSubTitle(context.getString(text));
    }

    public AboutBuilder setBrief(String text) {
        this.brief = text;
        return this;
    }

    public AboutBuilder setBrief(int text) {
        return setBrief(context.getString(text));
    }

    public AboutBuilder setAppName(String text) {
        this.appName = text;
        return this;
    }

    public AboutBuilder setAppName(int text) {
        return setAppName(context.getString(text));
    }


    public AboutBuilder setAppTitle(String text) {
        this.appTitle = text;
        return this;
    }

    public AboutBuilder setAppTitle(int text) {
        return setAppTitle(context.getString(text));
    }

    public AboutBuilder setVersionAsAppTitle() {
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return setAppTitle(context.getString(R.string.version, pi.versionName));
        } catch (PackageManager.NameNotFoundException e) {
            return setAppTitle(R.string.error);
        }
    }

    public AboutBuilder setPhoto(Bitmap bitmap) {
        this.photo = bitmap;
        return this;
    }

    public AboutBuilder setPhoto(int res) {
        return setPhoto(IconUtil.getBitmap(context, res));
    }

    public AboutBuilder setPhoto(Drawable drawable) {
        return setPhoto(IconUtil.getBitmap(context, drawable));
    }

    public AboutBuilder setCover(Bitmap bitmap) {
        this.cover = bitmap;
        return this;
    }

    public AboutBuilder setCover(int res) {
        return setCover(IconUtil.getBitmap(context, res));
    }

    public AboutBuilder setCover(Drawable drawable) {
        return setCover(IconUtil.getBitmap(context, drawable));
    }

    public AboutBuilder setAppIcon(Bitmap bitmap) {
        this.appIcon = bitmap;
        return this;
    }

    public AboutBuilder setAppIcon(int res) {
        return setAppIcon(IconUtil.getBitmap(context, res));
    }

    public AboutBuilder setAppIcon(Drawable drawable) {
        return setAppIcon(IconUtil.getBitmap(context, drawable));
    }

    public AboutBuilder setNameColor(int color) {
        this.nameColor = ColorUtil.get(context, color);
        return this;
    }

    public AboutBuilder setSubTitleColor(int color) {
        this.subTitleColor = ColorUtil.get(context, color);
        return this;
    }

    public AboutBuilder setBriefColor(int color) {
        this.briefColor = ColorUtil.get(context, color);
        return this;
    }

    public AboutBuilder setDividerColor(int color) {
        this.dividerColor = ColorUtil.get(context, color);
        return this;
    }

    public AboutBuilder setIconColor(int color) {
        this.iconColor = ColorUtil.get(context, color);
        return this;
    }


    public AboutBuilder setBackgroundColor(int res) {
        this.backgroundColor = ColorUtil.get(context, res);
        return this;
    }

    public AboutBuilder setActionsColumnsCount(int count) {
        this.actionsColumnsCount = count;
        return this;
    }


    public AboutBuilder setLinksColumnsCount(int count) {
        this.linksColumnsCount = count;
        return this;
    }


    public AboutBuilder setLinksAnimated(boolean animate) {
        this.linksAnimated = animate;
        return this;
    }

    public AboutBuilder setDividerHeight(int dividerHeight) {
        this.dividerHeight = dividerHeight;
        return this;
    }

    public AboutBuilder setDividerDashWidth(int dividerDashWidth) {
        this.dividerDashWidth = dividerDashWidth;
        return this;
    }

    public AboutBuilder setDividerDashGap(int dividerDashGap) {
        this.dividerDashGap = dividerDashGap;
        return this;
    }

    public AboutBuilder setShowDivider(boolean showDivider) {
        this.showDivider = showDivider;
        return this;
    }

    public AboutBuilder setWrapScrollView(boolean wrapScrollView) {
        this.wrapScrollView = wrapScrollView;
        return this;
    }

    public AboutBuilder addLink(Bitmap icon, String label, View.OnClickListener onClickListener) {
        links.add(new Item(icon, label, onClickListener));
        return this;
    }

    public AboutBuilder addLink(Bitmap icon, String label, Intent intent) {
        return addLink(icon, label, util.clickIntent(intent));
    }

    public AboutBuilder addLink(Bitmap icon, String label, Uri uri) {
        return addLink(icon, label, util.clickUri(uri));
    }

    public AboutBuilder addLink(Bitmap icon, String label, String url) {
        return addLink(icon, label, Uri.parse(url));
    }

    public AboutBuilder addLink(Bitmap icon, int label, View.OnClickListener onClickListener) {
        return addLink(icon, context.getString(label), onClickListener);
    }

    public AboutBuilder addLink(Bitmap icon, int label, Intent intent) {
        return addLink(icon, label, util.clickIntent(intent));
    }

    public AboutBuilder addLink(Bitmap icon, int label, Uri uri) {
        return addLink(icon, label, util.clickUri(uri));
    }

    public AboutBuilder addLink(Bitmap icon, int label, String url) {
        return addLink(icon, label, Uri.parse(url));
    }

    public AboutBuilder addLink(int icon, int label, View.OnClickListener onClickListener) {
        return addLink(IconUtil.getBitmap(context, icon), context.getString(label), onClickListener);
    }

    public AboutBuilder addLink(int icon, int label, Intent intent) {
        return addLink(icon, label, util.clickIntent(intent));
    }

    public AboutBuilder addLink(int icon, int label, Uri uri) {
        return addLink(icon, label, util.clickUri(uri));
    }

    public AboutBuilder addLink(int icon, int label, String url) {
        return addLink(icon, label, Uri.parse(url));
    }

    public AboutBuilder addLink(int icon, String label, View.OnClickListener onClickListener) {
        return addLink(IconUtil.getBitmap(context, icon), label, onClickListener);
    }

    public AboutBuilder addLink(int icon, String label, Intent intent) {
        return addLink(icon, label, util.clickIntent(intent));
    }

    public AboutBuilder addLink(int icon, String label, Uri uri) {
        return addLink(icon, label, util.clickUri(uri));
    }

    public AboutBuilder addLink(int icon, String label, String url) {
        return addLink(icon, label, Uri.parse(url));
    }

    public AboutBuilder addLink(Drawable icon, int label, View.OnClickListener onClickListener) {
        return addLink(IconUtil.getBitmap(context, icon), context.getString(label), onClickListener);
    }

    public AboutBuilder addLink(Drawable icon, int label, Intent intent) {
        return addLink(icon, label, util.clickIntent(intent));
    }

    public AboutBuilder addLink(Drawable icon, int label, Uri uri) {
        return addLink(icon, label, util.clickUri(uri));
    }

    public AboutBuilder addLink(Drawable icon, int label, String url) {
        return addLink(icon, label, Uri.parse(url));
    }

    public AboutBuilder addLink(Drawable icon, String label, View.OnClickListener onClickListener) {
        return addLink(IconUtil.getBitmap(context, icon), label, onClickListener);
    }

    public AboutBuilder addLink(Drawable icon, String label, Intent intent) {
        return addLink(icon, label, util.clickIntent(intent));
    }

    public AboutBuilder addLink(Drawable icon, String label, Uri uri) {
        return addLink(icon, label, util.clickUri(uri));
    }

    public AboutBuilder addLink(Drawable icon, String label, String url) {
        return addLink(icon, label, Uri.parse(url));
    }

    public AboutBuilder addGitHubLink(int user) {
        return addGitHubLink(context.getString(user));
    }

    public AboutBuilder addGitHubLink(String user) {
        return addLink(R.mipmap.github, R.string.github, util.uri(R.string.url_github, user));
    }

    public AboutBuilder addBitbucketLink(int user) {
        return addBitbucketLink(context.getString(user));
    }

    public AboutBuilder addBitbucketLink(String user) {
        return addLink(R.mipmap.bitbucket, R.string.bitbucket, util.uri(R.string.url_bitbucket, user));
    }

    public AboutBuilder addFacebookLink(int user) {
        return addFacebookLink(context.getString(user));
    }

    public AboutBuilder addFacebookLink(String user) {
        return addLink(R.mipmap.facebook, R.string.facebook, util.openFacebook(user));
    }

    public AboutBuilder addInstagramLink(int user) {
        return addInstagramLink(context.getString(user));
    }

    public AboutBuilder addInstagramLink(String user) {
        return addLink(R.mipmap.instagram, R.string.instagram, util.openInstagram(user));
    }

    public AboutBuilder addTwitterLink(int user) {
        return addTwitterLink(context.getString(user));
    }

    public AboutBuilder addTwitterLink(String user) {
        return addLink(R.mipmap.twitter, R.string.twitter, util.openTwitter(user));
    }

    public AboutBuilder addGoogleLink(int url) {
        return addGoogleLink(context.getString(url));
    }

    public AboutBuilder addGoogleLink(String url) {
        return addLink(R.mipmap.google, R.string.google, url);
    }

    public AboutBuilder addGooglePlusLink(int user) {
        return addGooglePlusLink(context.getString(user));
    }

    public AboutBuilder addGooglePlusLink(String user) {
        return addLink(R.mipmap.google_plus, R.string.google_plus, util.openGooglePlus(user));
    }

    public AboutBuilder addGooglePlayStoreLink(int user) {
        return addGooglePlayStoreLink(context.getString(user));
    }

    public AboutBuilder addGooglePlayStoreLink(String user) {
        return addLink(R.mipmap.google_play_store, R.string.google_play_store, util.openGooglePlayDev(user));
    }

    public AboutBuilder addGoogleGamesLink(int url) {
        return addGoogleGamesLink(context.getString(url));
    }

    public AboutBuilder addGoogleGamesLink(String url) {
        return addLink(R.mipmap.google_play_games, R.string.google_play_games, url);
    }

    public AboutBuilder addYoutubeChannelLink(int user) {
        return addYoutubeChannelLink(context.getString(user));
    }

    public AboutBuilder addYoutubeChannelLink(String user) {
        return addLink(R.mipmap.youtube, R.string.youtube, util.openYoutubeChannel(user));
    }

    public AboutBuilder addLinkedinLink(int user) {
        return addLinkedinLink(context.getString(user));
    }

    public AboutBuilder addLinkedinLink(String user) {
        return addLink(R.mipmap.linkedin, R.string.linkedin, util.openLinkedin(user));
    }

    public AboutBuilder addSkypeLink(int phone) {
        return addSkypeLink(context.getString(phone));
    }

    public AboutBuilder addSkypeLink(String phone) {
        return addLink(R.mipmap.skype, R.string.skype, util.openSkype(phone));
    }

    public AboutBuilder addWhatsappLink(int name, int phone) {
        return addWhatsappLink(context.getString(name), context.getString(phone));
    }

    public AboutBuilder addWhatsappLink(String name, String phone) {
        return addLink(R.mipmap.whatsapp, R.string.whastapp, util.openAddContact(name, phone));
    }

    public AboutBuilder addAndroidLink(int url) {
        return addAndroidLink(context.getString(url));
    }

    public AboutBuilder addAndroidLink(String url) {
        return addLink(R.mipmap.android, R.string.android, url);
    }

    public AboutBuilder addDribbleLink(int url) {
        return addDribbleLink(context.getString(url));
    }

    public AboutBuilder addDribbleLink(String url) {
        return addLink(R.mipmap.dribbble, R.string.dribbble, url);
    }

    public AboutBuilder addWebsiteLink(int url) {
        return addWebsiteLink(context.getString(url));
    }

    public AboutBuilder addWebsiteLink(String url) {
        return addLink(R.mipmap.website, R.string.website, url);
    }


    public AboutBuilder addEmailLink(int email, int subject, int message) {
        return addEmailLink(context.getString(email), context.getString(subject), context.getString(message));
    }

    public AboutBuilder addEmailLink(String email, String subject, String message) {
        return addLink(R.mipmap.email, R.string.email, util.sendEmail(email, subject, message));
    }

    public AboutBuilder addEmailLink(int email) {
        return addEmailLink(context.getString(email));
    }

    public AboutBuilder addEmailLink(String email) {
        return addLink(R.mipmap.email, R.string.email, util.sendEmail(email, null, null));
    }


    public AboutBuilder addAction(Bitmap icon, String label, View.OnClickListener onClickListener) {
        actions.add(new Item(icon, label, onClickListener));
        return this;
    }

    public AboutBuilder addAction(Bitmap icon, String label, Intent intent) {
        return addAction(icon, label, util.clickIntent(intent));
    }

    public AboutBuilder addAction(Bitmap icon, String label, Uri uri) {
        return addAction(icon, label, util.clickUri(uri));
    }

    public AboutBuilder addAction(Bitmap icon, String label, String url) {
        return addAction(icon, label, Uri.parse(url));
    }

    public AboutBuilder addAction(Bitmap icon, int label, View.OnClickListener onClickListener) {
        return addAction(icon, context.getString(label), onClickListener);
    }

    public AboutBuilder addAction(Bitmap icon, int label, Intent intent) {
        return addAction(icon, label, util.clickIntent(intent));
    }

    public AboutBuilder addAction(Bitmap icon, int label, Uri uri) {
        return addAction(icon, label, util.clickUri(uri));
    }

    public AboutBuilder addAction(Bitmap icon, int label, String url) {
        return addAction(icon, label, Uri.parse(url));
    }

    public AboutBuilder addAction(int icon, int label, View.OnClickListener onClickListener) {
        return addAction(IconUtil.getBitmap(context, icon), context.getString(label), onClickListener);
    }

    public AboutBuilder addAction(int icon, int label, Intent intent) {
        return addAction(icon, label, util.clickIntent(intent));
    }

    public AboutBuilder addAction(int icon, int label, Uri uri) {
        return addAction(icon, label, util.clickUri(uri));
    }

    public AboutBuilder addAction(int icon, int label, String url) {
        return addAction(icon, label, Uri.parse(url));
    }

    public AboutBuilder addAction(int icon, String label, View.OnClickListener onClickListener) {
        return addAction(IconUtil.getBitmap(context, icon), label, onClickListener);
    }

    public AboutBuilder addAction(int icon, String label, Intent intent) {
        return addAction(icon, label, util.clickIntent(intent));
    }

    public AboutBuilder addAction(int icon, String label, Uri uri) {
        return addAction(icon, label, util.clickUri(uri));
    }

    public AboutBuilder addAction(int icon, String label, String url) {
        return addAction(icon, label, Uri.parse(url));
    }

    public AboutBuilder addAction(Drawable icon, int label, View.OnClickListener onClickListener) {
        return addAction(IconUtil.getBitmap(context, icon), context.getString(label), onClickListener);
    }

    public AboutBuilder addAction(Drawable icon, int label, Intent intent) {
        return addAction(icon, label, util.clickIntent(intent));
    }

    public AboutBuilder addAction(Drawable icon, int label, Uri uri) {
        return addAction(icon, label, util.clickUri(uri));
    }

    public AboutBuilder addAction(Drawable icon, int label, String url) {
        return addAction(icon, label, Uri.parse(url));
    }

    public AboutBuilder addAction(Drawable icon, String label, View.OnClickListener onClickListener) {
        return addAction(IconUtil.getBitmap(context, icon), label, onClickListener);
    }

    public AboutBuilder addAction(Drawable icon, String label, Intent intent) {
        return addAction(icon, label, util.clickIntent(intent));
    }

    public AboutBuilder addAction(Drawable icon, String label, Uri uri) {
        return addAction(icon, label, util.clickUri(uri));
    }

    public AboutBuilder addAction(Drawable icon, String label, String url) {
        return addAction(icon, label, Uri.parse(url));
    }

    public AboutBuilder addFiveStarsAction(int appId) {
        return addFiveStarsAction(context.getString(appId));
    }

    public AboutBuilder addFiveStarsAction(String appId) {
        return addAction(R.mipmap.star, R.string.rate_five_stars, util.openPlayStoreAppPage(appId));
    }

    public AboutBuilder addFiveStarsAction() {
        return addFiveStarsAction(BuildConfig.APPLICATION_ID);
    }

    public AboutBuilder addUpdateAction(int appId) {
        return addUpdateAction(context.getString(appId));
    }


    public AboutBuilder addUpdateAction(String appId) {
        return addAction(R.mipmap.update, R.string.update_app, util.openPlayStoreAppPage(appId));
    }

    public AboutBuilder addUpdateAction() {
        return addUpdateAction(BuildConfig.APPLICATION_ID);
    }

    public AboutBuilder addMoreFromMeAction(int userName) {
        return addMoreFromMeAction(context.getString(userName));
    }

    public AboutBuilder addMoreFromMeAction(String userName) {
        return addAction(R.mipmap.google_play_store, R.string.more_apps, util.openPlayStoreAppsList(userName));
    }

    public AboutBuilder addShareAction(int subject, int message) {
        return addShareAction(context.getString(subject), context.getString(message));
    }

    public AboutBuilder addShareAction(String subject, String message) {
        return addAction(R.mipmap.share, R.string.share_app, util.shareThisApp(subject, message));
    }

    public AboutBuilder addShareAction(String subject) {
        return addShareAction(subject, context.getString(R.string.uri_play_store_app_website, BuildConfig.APPLICATION_ID));
    }

    public AboutBuilder addShareAction(int subject) {
        return addShareAction(context.getString(subject));
    }

    public AboutBuilder addFeedbackAction(int email, int subject, int text) {
        return addFeedbackAction(context.getString(email), context.getString(subject), context.getString(text));
    }

    public AboutBuilder addFeedbackAction(String email, String subject, String text) {
        return addAction(R.mipmap.feedback, R.string.feedback_app, util.sendEmail(email, subject, text));
    }

    public AboutBuilder addFeedbackAction(int email, int subject) {
        return addFeedbackAction(context.getString(email), context.getString(subject));
    }

    public AboutBuilder addFeedbackAction(String email, String subject) {
        return addFeedbackAction(email, subject, null);
    }

    public AboutBuilder addFeedbackAction(int email) {
        return addFeedbackAction(context.getString(email));
    }


    public AboutBuilder addFeedbackAction(String email) {
        return addFeedbackAction(email, null);
    }

    public AboutBuilder addIntroduceAction(View.OnClickListener onClickListener) {
        return addAction(R.mipmap.intrduce, R.string.introduce_app, onClickListener);
    }

    public AboutBuilder addIntroduceAction(Intent intent) {
        return addIntroduceAction(util.clickIntent(intent));
    }

    public AboutBuilder addHelpAction(View.OnClickListener onClickListener) {
        return addAction(R.mipmap.help, R.string.help, onClickListener);
    }

    public AboutBuilder addHelpAction(Intent intent) {
        return addHelpAction(util.clickIntent(intent));
    }

    public AboutBuilder addChangeLogAction(View.OnClickListener onClickListener) {
        return addAction(R.mipmap.changelog, R.string.changelog, onClickListener);
    }

    public AboutBuilder addChangeLogAction(Intent intent) {
        return addChangeLogAction(util.clickIntent(intent));
    }

    public AboutBuilder addRemoveAdsAction(View.OnClickListener onClickListener) {
        return addAction(R.mipmap.ads, R.string.remove_ads, onClickListener);
    }

    public AboutBuilder addRemoveAdsAction(Intent intent) {
        return addRemoveAdsAction(util.clickIntent(intent));
    }


    public AboutBuilder addDonateAction(View.OnClickListener onClickListener) {
        return addAction(R.mipmap.donate, R.string.donate, onClickListener);
    }

    public AboutBuilder addDonateAction(Intent intent) {
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

    public boolean isWrapScrollView() {
        return wrapScrollView;
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
