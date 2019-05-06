package com.example.oreooo.wanandroidtest.wanAndroid;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Html;
import android.widget.TextView;
import com.example.oreooo.wanandroidtest.R;
import com.example.oreooo.wanandroidtest.pojo.ArticleDatas;
import com.oreooo.library.ListBase.BaseRecyclerAdapter;
import com.oreooo.library.ListBase.BaseViewHolder;
import java.util.List;

/**
 * @author Oreo https://github.com/OreoChap
 * @date 2019/5/4
 */
public class WanAndroidAdapter extends BaseRecyclerAdapter<ArticleDatas> {

    public WanAndroidAdapter(Context context, List<ArticleDatas> list, int layoutId, @Nullable OnViewHolderClickListener listener) {
        super(context, list, layoutId, listener);
    }

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
}
