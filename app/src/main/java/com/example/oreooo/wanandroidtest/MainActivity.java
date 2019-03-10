package com.example.oreooo.wanandroidtest;

import android.graphics.Paint;
import android.support.annotation.MainThread;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.oreooo.wanandroidtest.network.ApiService;
import com.example.oreooo.wanandroidtest.pojo.BannerData;
import com.example.oreooo.wanandroidtest.wanAndroid.WanAndroidFragment;
import com.youth.banner.Banner;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;


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

    private void initPresenter() {

    }
}
