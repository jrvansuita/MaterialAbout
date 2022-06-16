package com.vansuita.materialabout.sample.helper;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.sample.R;
import com.vansuita.materialabout.views.AboutView;

/**
 * Created by jrvansuita on 17/02/17.
 */
public class SampleHelper implements View.OnClickListener {

    private Activity activity;
    public static int theme = R.style.AppThemeDark;

    private SampleHelper(@NonNull Activity activity) {
        this.activity = activity;
    }

    @NonNull
    public static SampleHelper with(@NonNull Activity activity) {
        return new SampleHelper(activity);
    }

    @NonNull
    public SampleHelper init() {

        activity.findViewById(R.id.dark).setOnClickListener(this);
        activity.findViewById(R.id.light).setOnClickListener(this);
        activity.findViewById(R.id.custom).setOnClickListener(this);

        return this;
    }

    public void loadAbout() {
        final FrameLayout flHolder = activity.findViewById(R.id.about);

        AboutBuilder builder = AboutBuilder.with(activity)
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .setPhoto(R.mipmap.profile_picture)
                .setCover(R.mipmap.profile_cover)
                .setLinksAnimated(true)
                .setDividerDashGap(13)
                .setName("Your Full Name")
                .setSubTitle("Mobile Developer")
                .setLinksColumnsCount(4)
                .setBrief("I'm warmed of mobile technologies. Ideas maker, curious and nature lover.")
                .addGooglePlayStoreLink("8002078663318221363")
                .addGitHubLink("jrvansuita")
                .addBitbucketLink("jrvansuita")
                .addFacebookLink("user")
                .addTwitterLink("user")
                .addInstagramLink("jnrvans")
                .addYoutubeChannelLink("CaseyNeistat")
                .addDribbbleLink("user")
                .addEmailLink("vansuita.jr@gmail.com")
                .addWhatsAppDirectChat( "554799650629")
                //.addWhatsappLink("Jr", "+554799650629")
                .addSkypeLink("user")
                .addGoogleLink("user")
                .addAndroidLink("user")
                .addWebsiteLink("site")
                .addFiveStarsAction()
                .addMoreFromMeAction("Vansuita")
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .addUpdateAction()
                .setActionsColumnsCount(2)
                .addFeedbackAction("vansuita.jr@gmail.com")
                .addPrivacyPolicyAction("http://www.docracy.com/2d0kis6uc2")
                .addIntroduceAction((Intent) null)
                .addHelpAction((Intent) null)
                .addChangeLogAction((Intent) null)
                .addRemoveAdsAction((Intent) null)
                .addDonateAction((Intent) null)
                .setWrapScrollView(true)
                .setShowAsCard(true);

        AboutView view = builder.build();

        flHolder.addView(view);
    }


    @Override
    public void onClick(@NonNull View view) {
        if (view.getId() == R.id.dark && theme != R.style.AppThemeDark){
            theme = R.style.AppThemeDark;
            activity.recreate();
            return;
        }

        if (view.getId() == R.id.light && theme != R.style.AppThemeLight){
            theme = R.style.AppThemeLight;
            activity.recreate();
            return;
        }

        if (view.getId() == R.id.custom && theme != R.style.AppThemeCustom){
            theme = R.style.AppThemeCustom;
            activity.recreate();
        }

    }
}
