package com.example.oreooo.wanandroidtest.base;

/**
 * @author Oreo https://github.com/OreoChap
 * @date 2018/12/17
 */
public interface BaseView<T> {
    void subscribe(T presenter);
    void unSubscribe();
}
