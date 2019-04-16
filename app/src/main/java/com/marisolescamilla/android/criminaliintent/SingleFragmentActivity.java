package com.marisolescamilla.android.criminaliintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public abstract class SingleFragmentActivity extends FragmentActivity {
    public abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fmm= getSupportFragmentManager();
        Fragment fragment= fmm.findFragmentById(R.id.fragment_container);
        if (fragment==null){
            fragment= createFragment();
            fmm.beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();
        }
    }
}
