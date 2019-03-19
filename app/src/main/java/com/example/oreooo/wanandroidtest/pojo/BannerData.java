package com.example.oreooo.wanandroidtest.pojo;

import java.util.ArrayList;

/**
 * @author Oreo https://github.com/OreoChap
 * @date 2018/12/19
 */
public class BannerData {
    private ArrayList<BannerDetailData> data;
    private int errorCode;
    private String errorMsg;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ArrayList<BannerDetailData> getData() {
        return data;
    }

    public void setData(ArrayList<BannerDetailData> data) {
        this.data = data;
    }
}
