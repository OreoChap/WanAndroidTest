package com.example.oreooo.wanandroidtest;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import com.example.oreooo.wanandroidtest.wanAndroid.WanAndroidFragment;
import com.oreooo.library.MvpBase.BaseActivity;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.container_fragment, WanAndroidFragment.getInstance())
                .commit();
    }
}
