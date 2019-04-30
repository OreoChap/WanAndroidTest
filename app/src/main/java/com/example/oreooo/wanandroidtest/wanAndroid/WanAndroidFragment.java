package com.example.oreooo.wanandroidtest.wanAndroid;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.example.oreooo.wanandroidtest.GlideImageLoader;
import com.example.oreooo.wanandroidtest.R;
import com.example.oreooo.wanandroidtest.pojo.Article;
import com.example.oreooo.wanandroidtest.pojo.ArticleDatas;
import com.example.oreooo.wanandroidtest.pojo.BannerDetailData;
import com.oreooo.library.ListBase.BaseRecyclerAdapter;
import com.oreooo.library.ListBase.BaseViewHolder;
import com.oreooo.library.MvpBase.BaseFragment;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Oreo https://github.com/OreoChap
 * @date 2018/12/13
 */

public class WanAndroidFragment extends BaseFragment implements WanAndroidContract.View{

    public static WanAndroidFragment wanAndroidFragment;
    RecyclerView mRecyclerView;
    WanAndroidContract.Presenter mPresenter;
    Banner mBanner;

    public static WanAndroidFragment getInstance() {
        if (wanAndroidFragment == null) {
            synchronized (WanAndroidFragment.class) {
                if (wanAndroidFragment == null) {
                    wanAndroidFragment = new WanAndroidFragment();
                }
            }
        }
        return wanAndroidFragment;
    }

    @Override
    public void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_wanAndroid);
        mBanner = view.findViewById(R.id.banner_wanAndroid);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void showArticle(Article data) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new BaseRecyclerAdapter<ArticleDatas>(getActivity(),
                data.getData().getDatas(), R.layout.list_item_article, null) {
            @Override
            public void bindHolder(BaseViewHolder holder, ArticleDatas item) {
                ((TextView)holder.getView(R.id.txt_article_name))
                        .setText((Html.fromHtml("《" + item.getTitle() +"》")));
                ((TextView)holder.getView(R.id.txt_article_super_chapter_name))
                        .setText(String.valueOf(item.getSuperChapterName().trim()));
                ((TextView)holder.getView(R.id.txt_article_author))
                        .setText(String.valueOf(item.getAuthor().trim()));
                ((TextView)holder.getView(R.id.txt_article_nice_date))
                        .setText(Html.fromHtml("<font color='#008577'>" + "发布时间：" +
                                "</font>" +
                                item.getNiceDate()));
            }
        });

    }

    //todo 添加点击事件
    @Override
    public void showBanner(final List<BannerDetailData> list) {
        List<String> bannerUrl = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (BannerDetailData item : list) {
            bannerUrl.add(item.getImagePath());
            titles.add(item.getTitle());
        }

        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                .setImageLoader(new GlideImageLoader())
                .setImages(bannerUrl)
                .setBannerTitles(titles)
                .setBannerAnimation(Transformer.DepthPage)
                .setDelayTime(1500)
                .start();
    }

    @Override
    public void onStart() {
        super.onStart();
        subscribe();
    }

    @Override
    public void onStop() {
        super.onStop();
        unsubscribe();
    }

    @Override
    public int setContentView() {
        return R.layout.fragment_wanandroid;
    }

    @Override
    public void subscribe() {
        this.mPresenter = WanAndroidPresenter.getInstance();
        mPresenter.setView(this);
        mPresenter.getBanner();
        mPresenter.getArticles("0");
    }

    @Override
    public void unsubscribe() {
        this.mPresenter = null;
    }

}
