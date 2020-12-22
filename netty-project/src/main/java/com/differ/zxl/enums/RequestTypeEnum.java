package com.differ.zxl.enums;

public enum RequestTypeEnum {
    //同步请求
    SYNC_REQ("sync_request"),
    //同步回应
    SYNC_RES("sync_result"),
    //同步请求
    PUSH_REQ("push_request"),
    //同步回应
    PUSH_RES("push_result"),
    //心跳
    BEAT("beat");

    private String message;

    private RequestTypeEnum(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}
