package com.example.oreooo.wanandroidtest.network;

import com.example.oreooo.wanandroidtest.Profile;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author Oreo https://github.com/OreoChap
 * @date 2018/12/20
 */
public class Network {
    private Retrofit mRetrofit;

    public static Network getInstance() {
        return NetworkHolder.instance;
    }

    private Network(){}

    private static class NetworkHolder {
        private static Network instance = new Network();
    }

    public Retrofit retrofit() {
        if (null == mRetrofit) {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Profile.API_BASE)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        }
        return mRetrofit;
    }
}
