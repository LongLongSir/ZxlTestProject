package com.differ.zxl.client;

import com.differ.zxl.request.RequestMessage;
import com.differ.zxl.response.ResponseMessage;
import com.differ.zxl.serializer.HessianSerializer;
import com.differ.zxl.serializer.ServerDecoder;
import com.differ.zxl.serializer.ServerEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;
@ChannelHandler.Sharable
public class NettyClientReConnectHandler extends ChannelInboundHandlerAdapter implements Runnable {

    private Bootstrap bootstrap;

    public NettyClientReConnectHandler(Bootstrap bootstrap){
        this.bootstrap=bootstrap;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //连接断开触发
        ctx.executor().schedule(this,5, TimeUnit.SECONDS);
        super.channelInactive(ctx);
    }

    @Override
    public void run() {
        bootstrap.connect("127.0.0.1",16666).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if(!future.isSuccess()){
                    //重连
                    System.out.println("重连失败...");
                    future.channel().pipeline().fireChannelInactive();
                }else {
                    System.out.println("重连成功...");
                }
            }
        });


    }
}
