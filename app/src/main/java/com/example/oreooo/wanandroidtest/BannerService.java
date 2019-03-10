package com.example.oreooo.wanandroidtest;

import com.example.oreooo.wanandroidtest.network.Profile;
import com.example.oreooo.wanandroidtest.pojo.BannerData;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Oreo https://github.com/OreoChap
 * @date 2018/12/18
 */
public interface BannerService {
    @GET ("banner/json")
    Observable<BannerData> getBanner();
}
