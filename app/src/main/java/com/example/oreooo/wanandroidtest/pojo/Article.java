package com.example.oreooo.wanandroidtest.pojo;

/**
 * @author Oreo https://github.com/OreoChap
 * @date 2019/4/29
 */
public class Article {
    private ArticleData data;
    private String errorCode;
    private String errorMsg;

    public ArticleData getData() {
        return data;
    }

    public void setData(ArticleData data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
