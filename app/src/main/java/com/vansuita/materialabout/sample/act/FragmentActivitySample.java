package com.vansuita.materialabout.sample.act;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.vansuita.materialabout.sample.R;
import com.vansuita.materialabout.sample.helper.SampleHelper;

/**
 * Created by jrvansuita on 17/02/17.
 */
public class FragmentActivitySample extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(SampleHelper.theme);
        setContentView(new LinearLayout(this));

        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new FragmentSample())
                .commit();
    }

    public static class FragmentSample extends Fragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.sample_view, container, false);
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            setRetainInstance(true);

            SampleHelper.with(getActivity()).init().loadAbout();
        }
    }

}
