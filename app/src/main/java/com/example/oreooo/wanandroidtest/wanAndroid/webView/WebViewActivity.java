package com.example.oreooo.wanandroidtest.wanAndroid.webView;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.oreooo.wanandroidtest.R;
import com.oreooo.library.MvpBase.BaseActivity;

public class WebViewActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.webview_container_fragment, WebViewFragment.getInstance())
                .commit();
    }
}
