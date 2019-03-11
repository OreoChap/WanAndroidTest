package com.example.oreooo.wanandroidtest.wanAndroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oreooo.wanandroidtest.GlideImageLoader;
import com.example.oreooo.wanandroidtest.R;
import com.example.oreooo.wanandroidtest.contract.WanAndroidContract;
import com.example.oreooo.wanandroidtest.pojo.BannerDetailData;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oreo https://github.com/OreoChap
 * @date 2018/12/13
 */

public class WanAndroidFragment extends Fragment implements WanAndroidContract.View{

    RecyclerView mRecyclerView;
    WanAndroidContract.Presenter mPresenter;
    Banner mBanner;

    public static WanAndroidFragment newInstance() {
        return new WanAndroidFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_wanandroid, container, false);
        initView(view);
        mPresenter.getBanner();
        mPresenter = new WanAndroidPresenter(this);
        return view;
    }

    public void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_wanAndroid);
        mBanner = view.findViewById(R.id.banner_wanAndroid);
    }

    public void initBanner(List<BannerDetailData> data) {
        List<String> bannerUrl = new ArrayList<>();
        for (BannerDetailData item : data) {
            bannerUrl.add(item.getImagePath());
        }
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                .setImageLoader(new GlideImageLoader())
                .setImages(bannerUrl)
                .setBannerAnimation(Transformer.DepthPage)
                .setDelayTime(1500)
                .start();
    }

    @Override
    public void subscribe(WanAndroidContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void unSubscribe() {
        this.mPresenter = null;
    }

    @Override
    public void showBanner(List<BannerDetailData> list) {
        initBanner(list);
    }
}
