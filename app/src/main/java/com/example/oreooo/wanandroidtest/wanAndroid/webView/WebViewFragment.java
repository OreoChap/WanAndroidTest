package com.example.oreooo.wanandroidtest.wanAndroid.webView;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.oreooo.wanandroidtest.R;
import com.oreooo.library.MvpBase.BaseFragment;

public class WebViewFragment extends BaseFragment {

    public static WebViewFragment getInstance() {
        return WebViewFragmentHolder.Instance;
    }

    private static class WebViewFragmentHolder {
        private static WebViewFragment Instance = new WebViewFragment();
    }

    @Override
    public void initView(View view) {
        if (getActivity() != null) {
            WebView mWebView = view.findViewById(R.id.wanAndroid_webView);
            mWebView.loadUrl(String.valueOf(getActivity().getIntent().getStringExtra("webUrl")));
            mWebView.setWebViewClient(new WebViewClient());
        }
    }

    @Override
    public void initListener() {

    }

    @Override
    public int setContentView() {
        return R.layout.fragment_webview;
    }
}
