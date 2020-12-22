package com.differ.zxl.server.channelhandle;

import com.differ.zxl.enums.RequestTypeEnum;
import com.differ.zxl.request.RequestMessage;
import com.differ.zxl.server.ConfigOperation;
import com.differ.zxl.server.ServerManager;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;

import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;

public class NettyServerHandler extends SimpleChannelInboundHandler<RequestMessage> {

    private ConfigOperation operation;

    public NettyServerHandler(ConfigOperation operation){
        this.operation=operation;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress());

        //ctx.channel().writeAndFlush(new ResponseMessage(RequestTypeEnum.SYNC_REQ));
        //group.add(ctx.channel());
//        ChannelGroupFuture futures = group.writeAndFlush("czx");
//        futures.addListener(new GenericFutureListener<Future<? super Void>>() {
//            @Override
//            public void operationComplete(Future<? super Void> future) throws Exception {
//
//            }
//        });
        super.channelActive(ctx);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RequestMessage requestMessage) throws Exception {
        if(Objects.equals(requestMessage.getRequestType(),RequestTypeEnum.BEAT.getMessage())){
            return;
        }
        //缓存通道
        ServerManager.addChannel(ctx.channel().id().asLongText(),requestMessage.getDuplicateId(),ctx.channel());
        //根据请求类型，做相应的异步处理
        //交给线程池处理
        if(Objects.equals(requestMessage.getRequestType(), RequestTypeEnum.SYNC_REQ.getMessage())){
            operation.processSyncData(requestMessage);
        }else if(Objects.equals(requestMessage.getRequestType(), RequestTypeEnum.PUSH_REQ.getMessage())){
            operation.processPushResult(requestMessage);
        }
        System.out.println("channelRead0===:"+requestMessage.getRequestType());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //通道关闭
        ServerManager.removeChannel(ctx.channel().id().asLongText());
        //操作数据库，连接状态为异常（或者删除此实例的数据）

        super.channelInactive(ctx);
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        System.out.println(cause.getMessage());
        //cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            System.out.println("通道空闲已超时===");
            //ctx.close();
        }else{
            super.userEventTriggered(ctx, evt);
        }
    }

}
