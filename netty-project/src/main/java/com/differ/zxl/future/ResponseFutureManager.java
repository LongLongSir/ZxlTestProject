package com.differ.zxl.future;


import com.differ.jackyun.business.config.nettyserver.response.ResponseMessage;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @auth zhangxl
 * @date 2020/12/4
 */
public class ResponseFutureManager {

    private static ConcurrentHashMap<String ,NettyClientFutureResponse> futurePool=new ConcurrentHashMap<>();

    public static void setResponseFuture(String requestId,NettyClientFutureResponse futureResponse) {
        futurePool.put(requestId,futureResponse);
    }

    public static void removeResponseFuture(String requestId){
        futurePool.remove(requestId);
    }

    public static void notifyResponseFuture(ResponseMessage responseMessage){
        NettyClientFutureResponse futureResponse=futurePool.get(responseMessage.getRequestId());
        if(futureResponse==null){
            return;
        }
        futureResponse.setResponseMessage(responseMessage);
        removeResponseFuture(responseMessage.getRequestId());
    }


}
