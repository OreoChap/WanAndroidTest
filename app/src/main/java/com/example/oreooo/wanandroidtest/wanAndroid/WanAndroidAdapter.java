package com.example.oreooo.wanandroidtest.wanAndroid;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Html;
import android.widget.TextView;
import com.example.oreooo.wanandroidtest.R;
import com.example.oreooo.wanandroidtest.pojo.ArticleData;
import com.example.oreooo.wanandroidtest.pojo.ArticleDatas;
import com.example.oreooo.wanandroidtest.test.TRecyclerViewAdapter;
import com.oreooo.library.ListBase.BaseRecyclerAdapter;
import com.oreooo.library.ListBase.BaseViewHolder;
import java.util.List;

/**
 * @author Oreo https://github.com/OreoChap
 * @date 2019/5/4
 */
public class WanAndroidAdapter extends TRecyclerViewAdapter<ArticleDatas> {

    private List<ArticleDatas> mData;

    public WanAndroidAdapter(Context context, List<ArticleDatas> list,
                             int layoutId, @Nullable OnViewHolderClickListener listener) {
        super(context, list, layoutId, listener);
        mData = list;
    }

    @Override
    protected void bindHolder(TRecyclerViewAdapter.ViewHolder holder, ArticleDatas item) {
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

    public void addData(List<ArticleDatas> list) {
        mData.addAll(list);
    }
}
