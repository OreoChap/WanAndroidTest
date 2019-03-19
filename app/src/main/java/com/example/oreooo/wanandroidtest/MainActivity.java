package com.example.oreooo.wanandroidtest;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.oreooo.wanandroidtest.wanAndroid.WanAndroidFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    String text;
    WanAndroidFragment mWanAndroidFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();
        initPresenter();
    }

    private void initFragment() {
        mWanAndroidFragment = WanAndroidFragment.newInstance();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.container_fragment, mWanAndroidFragment)
                .commit();

    }

    private void initPresenter() { }
}
