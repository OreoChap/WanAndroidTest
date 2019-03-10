package com.example.oreooo.wanandroidtest.wanAndroid;

import android.util.Log;

import com.example.oreooo.wanandroidtest.BannerService;
import com.example.oreooo.wanandroidtest.base.BaseView;
import com.example.oreooo.wanandroidtest.contract.WanAndroidContract;
import com.example.oreooo.wanandroidtest.network.ApiService;
import com.example.oreooo.wanandroidtest.pojo.BannerData;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Oreo https://github.com/OreoChap
 * @date 2018/12/17
 */
public class WanAndroidPresenter implements WanAndroidContract.Presenter{
    private static final String TAG = "WanAndroidPresenter";
    String text;
    BaseView view;


    public WanAndroidPresenter(BaseView view) {
        this.view = view;

    }

    @Override
    public void getArticles() {

    }

    @Override
    public void getBanner() {
        BannerService service = ApiService.createBannerService();
        service.getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerData bannerData) {
                        try {
                            text = bannerData.getData().get(0).getTitle();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: called");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: called");
                    }
                });

    }

    @Override
    public void setView() {

    }
}
