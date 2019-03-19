package com.example.oreooo.wanandroidtest.contract;

import com.example.oreooo.wanandroidtest.base.BasePresenter;
import com.example.oreooo.wanandroidtest.base.BaseView;
import com.example.oreooo.wanandroidtest.pojo.BannerDetailData;

import java.util.List;

/**
 * @author Oreo https://github.com/OreoChap
 * @date 2018/12/26
 */
public interface WanAndroidContract {
    interface Presenter extends BasePresenter {
        void getBanner();
        void getArticles();
    }

    interface View extends BaseView<Presenter> {
        void showBanner(List<BannerDetailData> list);
    }
}
