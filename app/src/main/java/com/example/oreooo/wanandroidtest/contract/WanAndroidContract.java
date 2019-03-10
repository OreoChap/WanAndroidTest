package com.example.oreooo.wanandroidtest.contract;

import com.example.oreooo.wanandroidtest.base.BasePresenter;
import com.example.oreooo.wanandroidtest.base.BaseView;

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
        void setContent();
    }
}
