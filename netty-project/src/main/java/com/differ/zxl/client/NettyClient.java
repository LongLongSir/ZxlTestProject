package com.differ.zxl.client;

import com.differ.jackyun.business.config.nettyserver.request.RequestMessage;
import com.differ.jackyun.framework.component.config.client.model.message.BaseMessage;
import com.differ.zxl.response.ResponseMessage;
import com.differ.zxl.serializer.HessianSerializer;
import com.differ.zxl.serializer.ServerDecoder;
import com.differ.zxl.serializer.ServerEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class NettyClient {

    private EventLoopGroup group;
    private Channel channel;
    private Bootstrap bootstrap;
    private int port=16666;

    public void init()throws Exception{
        group=new NioEventLoopGroup();
        bootstrap=new Bootstrap();

        bootstrap.group(group).channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(getChannelHandler());
                    }
                })
                .option(ChannelOption.SO_KEEPALIVE,true)
                .option(ChannelOption.TCP_NODELAY,true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS,10000);

        ChannelFuture future=bootstrap.connect("127.0.0.1",port).sync();
        channel =future.channel();
        if(channel==null || !channel.isActive()){
            close();
        }
    }

    public void restart(){
        bootstrap
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(getChannelHandler());
                    }
                });
        bootstrap.connect("127.0.0.1",port).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if(!future.isSuccess()){
                    System.out.println("尝试连接失败，准备重连...");
                    future.channel().eventLoop().schedule(()->restart(), 5, TimeUnit.SECONDS);
                }else{
                    System.out.println("连接成功...");
                    channel=future.channel();
                }
            }
        });
    }

    private ChannelHandler[] getChannelHandler() {
        return new ChannelHandler[]{
                new NettyClientReConnectHandler(bootstrap),
                new IdleStateHandler(0,10,0, TimeUnit.SECONDS),
                new ServerEncoder(new HessianSerializer(), BaseMessage.class),
                new ServerDecoder(new HessianSerializer(), BaseMessage.class),
                new NettyClientHandler()
        };
    }

    public void close(){
        if(channel!=null && channel.isActive()){
            channel.close();
        }

        if(group!=null && !group.isShutdown()){
            group.shutdownGracefully();
        }
        System.out.println("===netty client closed===");
    }

    public void send(RequestMessage request)throws  Exception{
        this.channel.writeAndFlush(request).sync();
    }

}
