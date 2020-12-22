package com.differ.zxl.response;

import com.differ.zxl.enums.RequestTypeEnum;
import io.netty.util.internal.StringUtil;

import java.io.Serializable;
import java.util.List;

public class ResponseMessage implements Serializable {

    private static final long serialVersionUID = 42L;

    //请求类型
    private String requestType;

    //需要同步的数据key
    private String configCode;

    //同步失败的结果key
    private List<String> syncErrorConfigCodes;

    //推送数据
    private String pushData;

    public ResponseMessage(RequestTypeEnum requestType){
        this.requestType=requestType.getMessage();
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode;
    }

    public List<String> getSyncErrorConfigCodes() {
        return syncErrorConfigCodes;
    }

    public void setSyncErrorConfigCodes(List<String> syncErrorConfigCodes) {
        this.syncErrorConfigCodes = syncErrorConfigCodes;
    }
}
