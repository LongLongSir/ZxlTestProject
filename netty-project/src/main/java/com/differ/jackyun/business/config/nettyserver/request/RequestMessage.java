package com.differ.jackyun.business.config.nettyserver.request;

import com.differ.zxl.enums.RequestTypeEnum;

import java.io.Serializable;


public class RequestMessage implements Serializable {

    private static final long serialVersionUID = 42L;

    private String requestId;

    //请求类型
    private String requestType;

    //服务名
    private String namespace;

    //副本id
    private String duplicateId;

    //请求的同步数据  List<SyncData>
    private String syncData;

    //推送结果
    private String pushResult;


    public RequestMessage(RequestTypeEnum requestType){
        this(requestType,"");
    }

    public RequestMessage(RequestTypeEnum requestType, String duplicateId){
        this.requestType=requestType.getMessage();
        this.duplicateId=duplicateId;
        //this.requestId=Long.toString(System.currentTimeMillis());
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType){
        this.requestType=requestType;
    }

    public String getDuplicateId() {
        return duplicateId;
    }

    public void setDuplicateId(String duplicateId) {
        this.duplicateId = duplicateId;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
