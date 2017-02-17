package com.vansuita.materialabout.sample.act;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vansuita.materialabout.sample.R;
import com.vansuita.materialabout.sample.helper.SampleHelper;


public class ActivitySample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sample_view);

        SampleHelper.with(this).init().loadAbout();
    }
}
