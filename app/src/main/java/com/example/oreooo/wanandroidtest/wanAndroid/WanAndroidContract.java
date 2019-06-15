package com.example.oreooo.wanandroidtest.wanAndroid;

import com.example.oreooo.wanandroidtest.pojo.Article;
import com.example.oreooo.wanandroidtest.pojo.BannerDetailData;
import com.oreooo.library.MvpBase.BaseContract;
import java.util.List;

/**
 * @author Oreo https://github.com/OreoChap
 * @date 2018/12/26
 */
public interface WanAndroidContract {
    interface Presenter extends BaseContract.BasePresenter {
        void getBanner();
        void getArticles(String curPage, boolean isUpdate);
    }

    interface View extends BaseContract.BaseView {
        void showBanner(List<BannerDetailData> list);
        void showArticle(Article data, boolean isUpdate);
    }
}
