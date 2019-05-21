package com.example.oreooo.wanandroidtest.test;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public abstract class TRecyclerViewAdapter<T> extends RecyclerView.Adapter<TRecyclerViewAdapter.ViewHolder>{

    private Context mContext;
    private List<T> mData;
    private int mLayoutId;
    private OnViewHolderClickListener mListener;

    // 头尾ViewHolder实例
    private View mHeaderView;
    private View mFooterView;
    protected static final int TYPE_HEADER = 0;  //说明是带有Header的
    protected static final int TYPE_FOOTER = 1;  //说明是带有Footer的
    protected static final int TYPE_NORMAL = 2;  //说明是不带有header和footer的

    public TRecyclerViewAdapter(Context context, List<T> list, @IdRes int layoutId,
                               @Nullable OnViewHolderClickListener listener){
        this.mData = list;
        this.mLayoutId = layoutId;
        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    public int getItemCount() {
        if(mHeaderView == null && mFooterView == null){
            return mData.size();
        }else if(mHeaderView == null || mFooterView == null){
            return mData.size() + 1;
        }else {
            return mData.size() + 2;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(mHeaderView != null && viewType == TYPE_HEADER) {
            return new ViewHolder(mHeaderView);
        }
        if(mFooterView != null && viewType == TYPE_FOOTER) {
            return new ViewHolder(mFooterView);
        }
        return ViewHolder.
                createViewHolder(mContext, parent, mLayoutId, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final int mPosition = position;
        if (getItemViewType(position) == TYPE_NORMAL && mHeaderView != null) {
            bindHolder(holder, mData.get(position - 1));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.onClick(mPosition);
                    }
                }
            });
        } else if (getItemViewType(position) == TYPE_NORMAL && mHeaderView == null){
            bindHolder(holder, mData.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.onClick(mPosition);
                    }
                }
            });
        } else if (getItemViewType(position) == TYPE_HEADER && mHeaderView != null) {
            bindHeaderHolder(holder);
        } else if (getItemViewType(position) == TYPE_FOOTER && mFooterView != null) {
            bindFooterHolder(holder);
        }
    }

    protected abstract void bindHolder(ViewHolder holder, T item);
    protected void bindHeaderHolder(ViewHolder holder){}
    protected void bindFooterHolder(ViewHolder holder){}

    @Override
    public int getItemViewType(int position) {
        if (mHeaderView == null && mFooterView == null){
            return TYPE_NORMAL;
        } else if (position == 0 && mHeaderView != null){
            return TYPE_HEADER;
        } else if (position == getItemCount() - 1 && mFooterView != null){
            return TYPE_FOOTER;
        }
        return TYPE_NORMAL;
    }

    public void setOnViewHolderClickListener(OnViewHolderClickListener listener) {
        this.mListener = listener;
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public void setFooterView(View footerView) {
        mFooterView = footerView;
        notifyItemInserted(getItemCount()-1);
    }

    public interface OnViewHolderClickListener {
        void onClick(int position);
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder{

        private SparseArray<View> mViews;
        private Context mContext;
        private View mView;
        private OnViewHolderClickListener mListener;

        private ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        private ViewHolder(Context context, View itemView,
                           @Nullable OnViewHolderClickListener listener){
            super(itemView);
            mViews = new SparseArray<>();
            this.mContext = context;
            this.mView = itemView;
            this.mListener = listener;
        }

        static ViewHolder createViewHolder(Context context, View itemView,
                                           @Nullable OnViewHolderClickListener listener) {
            return new ViewHolder(context, itemView, listener);
        }

        static ViewHolder createViewHolder
                (Context context, ViewGroup parent, int layoutId,
                 @Nullable OnViewHolderClickListener listener) {
            return new ViewHolder(context, LayoutInflater.from(context).inflate
                    (layoutId, parent, false), listener);
        }

        public <T extends View> T getView(int viewId) {
            View view = mViews.get(viewId);
            if (view == null) {
                view = mView.findViewById(viewId);
                mViews.put(viewId, view);
            }
            return (T)view;
        }
    }
}

