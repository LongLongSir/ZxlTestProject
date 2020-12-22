package com.differ.zxl;

import com.differ.zxl.request.RequestMessage;
import com.differ.zxl.response.ResponseMessage;
import com.differ.zxl.server.ConfigOperation;
import com.differ.zxl.server.NettyServerFactory;
import com.differ.zxl.server.NettyServerProperties;
import com.differ.zxl.server.channelhandle.NettyServerHandler;

public class NettyServerMain {

    public static void main(String[] args)throws Exception {
        NettyServerProperties nettyServerProperties = new NettyServerProperties();

        NettyServerFactory factory=new NettyServerFactory(nettyServerProperties,new NettyServerHandler(new ConfigOperation(nettyServerProperties)));

        factory.setStartCallback(()-> System.out.println("====服务启动了...====="));
        factory.setStopCallback(()-> System.out.println("=====服务停止了...======"));
        factory.setRequestParamType(RequestMessage.class);
        factory.setResponseType(ResponseMessage.class);

        factory.getServer().start();

        //Thread.sleep(4000);
        //ServerManager.sendSingleMessage("d-1234",new ResponseMessage(RequestTypeEnum.PUSH));

        //Thread.sleep(20000);
        //ServerManager.sendSingleMessage("d-1234",new ResponseMessage(RequestTypeEnum.SYNC_REQ));

        Thread.sleep(Integer.MAX_VALUE);

    }
}
