package com.differ.zxl.server;

import com.differ.zxl.response.ResponseMessage;
import com.differ.zxl.server.channelhandle.NettyServerHandler;
import com.differ.zxl.serializer.ServerDecoder;
import com.differ.zxl.serializer.ServerEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.AttributeKey;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NettyServer {

   //protected static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

    private Thread thread;

    private NettyServerFactory factory;

    public NettyServer(NettyServerFactory factory){
        this.factory=factory;
    }

    public void start(){
        thread=new Thread(()->{
            EventLoopGroup bossGroup = new NioEventLoopGroup(1);
            EventLoopGroup workerGroup = new NioEventLoopGroup();

            //处理接收的业务数据
            ThreadPoolExecutor serverPoolExecutor=new ThreadPoolExecutor(factory.getCorePoolSize(), factory.getMaxPoolSize(), 60, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(1000), new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r,"configService-"+r.hashCode());
                }
            });
            try{
                // start server
                ServerBootstrap bootstrap = new ServerBootstrap();
                bootstrap.group(bossGroup, workerGroup)
                        .channel(NioServerSocketChannel.class)
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                                .addLast(new IdleStateHandler(0,0,10, TimeUnit.SECONDS))
                                .addLast(new ServerDecoder(factory.getSerializer(),factory.getRequestParamType()))
                                .addLast(new ServerEncoder(factory.getSerializer(),factory.getResponseType()))
                                .addLast(factory.getServerInboundHandler());
                    }
                })
                        .childOption(ChannelOption.TCP_NODELAY,true)
                        .childOption(ChannelOption.SO_KEEPALIVE,true);
                ChannelFuture future = bootstrap.bind(factory.getPort()).sync();
                //启动回调
                onStart();
                future.channel().closeFuture().sync();
            }catch (Exception e){
                System.out.println("netty server exception");
                e.printStackTrace();
            }finally {
                //stop
                try{
                    serverPoolExecutor.shutdown();
                    bossGroup.shutdownGracefully();
                    workerGroup.shutdownGracefully();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        thread.setDaemon(true);
        thread.start();
    }

    public void stop(){
        if(thread!=null && thread.isAlive()){
            thread.interrupt();
        }
        //回调onStop
        onStop();
    }

    private void onStart(){
        if (factory.getStartCallback() != null) {
            try {
                factory.getStartCallback().run();
            } catch (Exception e) {
                //logger.error("config service netty server, server startedCallback error.", e);
                e.printStackTrace();
            }
        }
    }
    private void onStop(){
        if(factory.getStopCallback()!=null){
            try {
                factory.getStopCallback().run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
