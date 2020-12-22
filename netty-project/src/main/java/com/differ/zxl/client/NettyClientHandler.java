package com.differ.zxl.client;

import com.differ.jackyun.business.config.nettyserver.request.RequestMessage;
import com.differ.jackyun.business.config.nettyserver.response.ResponseMessage;
import com.differ.jackyun.framework.component.config.client.model.message.BaseMessage;
import com.differ.jackyun.framework.component.config.client.model.message.response.SyncResponse;
import com.differ.zxl.enums.RequestTypeEnum;
import com.differ.zxl.future.ResponseFutureManager;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;

public class NettyClientHandler extends SimpleChannelInboundHandler<BaseMessage> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client channelActive");
        SyncResponse syncResponse = new SyncResponse();
        syncResponse.setMessageType(RequestTypeEnum.SYNC_RES.getMessage());
        syncResponse.setDuplicateId("1231331");
        syncResponse.setSyncData("{xxxxxxxxx}");
        ctx.channel().writeAndFlush(syncResponse).sync();
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client channelInactive====");
        super.channelInactive(ctx);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, BaseMessage responseMessage) throws Exception {
        System.out.println("=====client channelRead0:"+responseMessage.getMessageType());
        //Thread.sleep(6000);
        //ResponseFutureManager.notifyResponseFuture(responseMessage);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("=========exceptionCaught : "+cause.getMessage());
        //super.exceptionCaught(ctx, cause);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            System.out.println("===client 空闲超时====");
        }else {
            super.userEventTriggered(ctx, evt);
        }
    }
}
