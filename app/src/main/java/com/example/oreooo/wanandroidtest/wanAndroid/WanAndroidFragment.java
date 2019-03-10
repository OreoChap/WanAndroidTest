package com.example.oreooo.wanandroidtest.wanAndroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oreooo.wanandroidtest.R;
import com.example.oreooo.wanandroidtest.contract.WanAndroidContract;

/**
 * @author Oreo https://github.com/OreoChap
 * @date 2018/12/13
 */

public class WanAndroidFragment extends Fragment implements WanAndroidContract.View{

    RecyclerView mRecyclerView;
    WanAndroidContract.Presenter mPresenter;

    public static WanAndroidFragment newInstance() {
        return new WanAndroidFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_wanandroid, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_wanAndroid);

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
    public void setContent() {

    }
}
