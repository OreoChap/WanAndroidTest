package com.example.oreooo.wanandroidtest.wanAndroid;

import android.util.Log;

import com.example.oreooo.wanandroidtest.network.Service.WanAndroidService;
import com.example.oreooo.wanandroidtest.network.Api;
import com.example.oreooo.wanandroidtest.pojo.Article;
import com.example.oreooo.wanandroidtest.pojo.BannerData;
import com.example.oreooo.wanandroidtest.pojo.BannerDetailData;
import com.oreooo.library.MvpBase.BaseContract;

import java.util.List;

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
    private WanAndroidContract.View mView;
    private List<BannerDetailData> mDate;

    public static WanAndroidPresenter getInstance() {
        return WanAndroidPresenterHolder.Instance;
    }

    private static class  WanAndroidPresenterHolder {
        private static WanAndroidPresenter Instance = new WanAndroidPresenter();
    }

    WanAndroidPresenter(){}

    @Override
    public void setView(BaseContract.BaseView view) {
        this.mView = (WanAndroidContract.View)view;
    }


    @Override
    public void getArticles(String curPage, final boolean isUpdate) {
        Api.createBannerService().getArticle(curPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Article>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(Article data) {
                        mView.showArticle(data, isUpdate);
                        Log.d(TAG, "onNext: " + mDate.toString());
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
    public void getBanner() {
        Api.createBannerService().getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerData>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "getBanner: 发起请求");
                    }

                    @Override
                    public void onNext(BannerData bannerData) {
                        mDate = bannerData.getData();
                        mView.showBanner(mDate);
                        Log.d(TAG, "getBanner: 请求回调");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "getBanner: 请求失败");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "getBanner: 请求完结");
                    }
                });
    }

}
