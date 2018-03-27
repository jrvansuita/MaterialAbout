package com.vansuita.materialabout.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.view.View;

import com.vansuita.materialabout.R;


/**
 * Created by jrvansuita on 10/02/17.
 */

public final class IntentUtil {

    private Context context;

    public IntentUtil(Context context) {
        this.context = context;
    }

    public Intent intent(String url) {
        return intent(uri(url));
    }

    public Uri uri(String url) {
        return Uri.parse(url);
    }

    public Intent intent(Uri uri) {
        return new Intent(Intent.ACTION_VIEW, uri);
    }

    public View.OnClickListener clickUri(Uri uri) {
        return clickIntent(intent(uri));
    }

    public View.OnClickListener clickIntent(final Intent intent) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open(intent);
            }
        };
    }

    public void open(Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void open(Uri uri) {
        open(intent(uri));
    }

    public Intent openFacebook(String user) {
        try {
            tryPackage(R.string.id_facebook_app);
            return intent(R.string.uri_facebook_app, user);
        } catch (Exception e) {
            return intent(R.string.url_facebook_website, user);
        }
    }

    public Intent intent(int res, String user) {
        return intent(uri(res, user));
    }

    public Uri uri(int res, String user) {
        return Uri.parse(context.getString(res, user));
    }

    private void tryPackage(int res) throws PackageManager.NameNotFoundException {
        context.getPackageManager().getPackageInfo(context.getString(res), 0);
    }

    public Intent openInstagram(String user) {
        try {
            tryPackage(R.string.id_instagram_app);
            return intent(R.string.uri_instagram_app, user);
        } catch (Exception e) {
            return intent(R.string.url_instagram_website, user);
        }
    }

    public Intent openTwitter(String user) {
        try {
            tryPackage(R.string.id_twitter_app);
            return intent(R.string.uri_twitter_app, user);
        } catch (Exception e) {
            return intent(R.string.url_twitter_website, user);
        }
    }

    public Intent openGooglePlus(String user) {
        try {
            tryPackage(R.string.id_google_plus_app);
            return intent(R.string.uri_google_plus_app, user);
        } catch (Exception e) {
            return intent(R.string.url_google_plus_website, user);
        }
    }

    public Intent openGooglePlayDev(String user) {
        try {
            return intent(R.string.url_google_play_store_developer_page, user);
        } catch (Exception e) {
            return intent(R.string.url_google_play_store_developer_page, user);
        }
    }

    public Intent openYoutubeChannel(String user) {
        try {
            return intent(R.string.url_youtube_channel_website, user);
        } catch (Exception e) {
            return intent(R.string.url_youtube_channel_website, user);
        }
    }

    public Intent openYoutubeUser(String user) {
        try {
            return intent(R.string.url_youtube_user_website, user);
        } catch (Exception e) {
            return intent(R.string.url_youtube_user_website, user);
        }
    }

    public Intent openLinkedIn(String user) {
        try {
            tryPackage(R.string.id_linkedin_app);
            return intent(R.string.uri_linkedin_app, user);
        } catch (Exception e) {
            return intent(R.string.url_linkedin_website, user);
        }
    }


    public Intent openSkype(String phone) {
        try {
            tryPackage(R.string.id_skype_app);
            return intent(R.string.uri_skype_app, phone);
        } catch (Exception e) {
            return intent(R.string.uri_skype_app, phone);
        }
    }

    @NonNull
    public Intent openAddContact(String name, String phone) {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);

        intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone);

        return intent;
    }

    @NonNull
    public Intent sendEmail(String email, String subject, String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        return intent;
    }

    @NonNull
    public Intent openPlayStoreAppPage(String app) {
        Intent intent = intent(R.string.uri_play_store_app, app);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return intent;
        } else {
            return intent(R.string.uri_play_store_app_website, app);
        }
    }

    @NonNull
    public Intent openPlayStoreAppsList(String app) {
        Intent intent = intent(R.string.uri_play_store_apps_list, app);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return intent;
        } else {
            return intent(R.string.uri_play_store_apps_list_website, app);
        }
    }

    @NonNull
    public Intent shareThisApp(String subject, String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        return intent;
    }

}
