package com.vansuita.materialabout.sample.act;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.vansuita.materialabout.sample.R;
import com.vansuita.materialabout.sample.helper.SampleHelper;

/**
 *
 */
public class ActivitySample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(SampleHelper.theme);
        setContentView(R.layout.sample_view);
        SampleHelper.with(this).init().loadAbout();
    }
}
