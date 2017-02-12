package com.vansuita.materialabout.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.vansuita.materialabout.builder.AboutMe;


public class Main extends AppCompatActivity implements View.OnClickListener {

    private static int theme = R.style.AppThemeDark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(theme);

        setContentView(LayoutInflater.from(this).inflate(R.layout.main, null));

        findViewById(R.id.dark).setOnClickListener(this);
        findViewById(R.id.light).setOnClickListener(this);
        findViewById(R.id.custom).setOnClickListener(this);

        loadAboutMe();
    }

    public void loadAboutMe() {
        final FrameLayout flHolder = (FrameLayout) findViewById(R.id.aboutme);

        flHolder.addView(
                AboutMe.with(this)
                        .setAppIcon(R.mipmap.ic_launcher)
                        .setAppName(R.string.app_name)
                        .setPhoto(R.mipmap.profile_picture)
                        .setCover(R.mipmap.profile_cover)
                        .setLinksAnimated(false)
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
                        .addGooglePlusLink("103588649850838411440")
                        .addYoutubeChannelLink("103588649850838411440")
                        .addDribbleLink("user")
                        .addLinkedinLink("arleu-cezar-vansuita-júnior-83769271")
                        .addEmailLink("vansuita.jr@gmail.com")
                        .addWhatsappLink("Jr", "+554799650629")
                        .addSkypeLink("user")
                        .addGoogleLink("user")
                        .addAndroidLink("user")
                        .addWebsiteLink("site")
                        .addFiveStarsAction()
                        .addMoreFromMeAction("Vansuita")
                        .setVersionAsAppTitle()
                        .addShareAction(R.string.app_name)
                        .addUpdateAction()
                        .setActionsColumnsCount(2)
                        .addFeedbackAction("vansuita.jr@gmail.com")
                        .addIntroduceAction((Intent) null)
                        .addHelpAction((Intent) null)
                        .addChangeLogAction((Intent) null)
                        .addRemoveAdsAction((Intent) null)
                        .addDonateAction((Intent) null)
                        .build());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dark:
                if (theme != R.style.AppThemeDark) {
                    theme = R.style.AppThemeDark;
                    recreate();
                }
                break;
            case R.id.light:
                if (theme != R.style.AppThemeLight) {
                    theme = R.style.AppThemeLight;
                    recreate();
                }
                break;

            case R.id.custom:
                if (theme != R.style.AppThemeCustom) {
                    theme = R.style.AppThemeCustom;
                    recreate();
                }
                break;
        }
    }

/*

    public static void save(View view) {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null)
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        else
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        // draw the view on the canvas
        view.draw(canvas);
        //return the bitmap


        try {
            String fileName = Environment.getExternalStorageDirectory() + "/test.png";
            OutputStream stream = new FileOutputStream(fileName);
            returnedBitmap.compress(Bitmap.CompressFormat.PNG, 80, stream);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
*/


/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = AboutMe.with(this)
                .setPhoto(R.mipmap.profile_picture)
                .setCover(R.mipmap.profile_cover)
                .setName("Your Full Name")
                .setSubTitle("Mobile Developer")
                .setBrief("I'm warmed of mobile technologies. Ideas maker, curious and nature lover.")
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .addGooglePlayStoreLink("8002078663318221363")
                .addGitHubLink("user")
                .addFacebookLink("user")
                .build();

        addContentView(view, layoutParams);
    }*/
}
