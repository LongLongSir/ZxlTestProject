package com.differ;

import com.differ.jackyun.business.config.nettyserver.request.RequestMessage;
import com.differ.jackyun.business.config.nettyserver.response.ResponseMessage;
import com.differ.zxl.client.NettyClient;
import com.differ.zxl.enums.RequestTypeEnum;
import com.differ.zxl.future.NettyClientFutureResponse;

import java.util.concurrent.TimeUnit;

public class NettyClientMain {

    public static void main(String[] args)throws Exception {

        NettyClient client=new NettyClient();

        try {
            client.init();
        } catch (Exception e) {
            System.out.println("连接失败，开始重连...");
            client.restart();
        }


//        Thread.sleep(5000);
//        for (int i=0;i<5;i++){
//            client.send(new RequestMessage(RequestTypeEnum.BEAT,"d-1234"));
//            client.send(new RequestMessage(RequestTypeEnum.SYNC_REQ,"d-1234"));
//            client.send(new RequestMessage(RequestTypeEnum.PUSH,"d-1234"));
//            client.send(new RequestMessage(RequestTypeEnum.SYNC_RES,"d-1234"));
//        }
//        System.out.println("start request...");
//        RequestMessage requestMessage=new RequestMessage(RequestTypeEnum.PUSH_REQ,"d-1234");
//        requestMessage.setRequestId(Long.toString(System.currentTimeMillis()));
//
//        NettyClientFutureResponse response=new NettyClientFutureResponse(requestMessage);
//        client.send(requestMessage);
//        ResponseMessage responseMessage = response.get(5000, TimeUnit.MILLISECONDS);
//        System.out.println(responseMessage.getRequestId()+"====="+responseMessage.getRequestType());

        Thread.sleep(Integer.MAX_VALUE);
        client.close();

    }
}
