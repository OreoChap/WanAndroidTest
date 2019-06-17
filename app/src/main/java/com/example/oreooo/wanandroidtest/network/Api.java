package com.example.oreooo.wanandroidtest.network;

import com.example.oreooo.wanandroidtest.network.Service.WanAndroidService;

/**
 * @author Oreo https://github.com/OreoChap
 * @date 2018/12/18
 */
public class Api {
    public static WanAndroidService createWanAndroidService() {
        return Network.getInstance().retrofit().create(WanAndroidService.class);
    }
}
