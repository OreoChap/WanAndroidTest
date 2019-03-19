package com.example.oreooo.wanandroidtest.network;


import com.example.oreooo.wanandroidtest.BannerService;

/**
 * @author Oreo https://github.com/OreoChap
 * @date 2018/12/18
 */
public class ApiService {
    public static BannerService createBannerService() {
        return Network.getInstance().retrofit().create(BannerService.class);
    }
}
