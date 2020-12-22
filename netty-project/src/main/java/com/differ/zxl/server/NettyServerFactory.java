package com.differ.zxl.server;

import com.differ.zxl.serializer.HessianSerializer;
import com.differ.zxl.serializer.Serializer;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyServerFactory {

    private static NettyServer nettyServer;

    private NettyServerProperties properties;

    private ServerCallback startCallback;

    private ServerCallback stopCallback;

    //传输协议解析器
    private Serializer serializer;

    private Class<?> requestParamType;
    private Class<?> responseType;

    private SimpleChannelInboundHandler serverInboundHandler;

    private Object lockObj=new Object();

    private boolean startedFlag=false;

    public NettyServerFactory(NettyServerProperties properties,SimpleChannelInboundHandler serverInboundHandler){
        this.properties=properties;
        this.serverInboundHandler=serverInboundHandler;
        serializer=new HessianSerializer();
    }

    public void start(){
        synchronized (lockObj){
            if(!startedFlag){
                getServer().start();
                startedFlag=true;
            }
        }
    }

    public void close(){
        getServer().stop();
    }

    public NettyServer getServer(){
        if(nettyServer==null){
            synchronized (lockObj){
                if(nettyServer==null){
                    nettyServer=new NettyServer(this);
                }
            }
        }
        return nettyServer;
    }

    public Serializer getSerializer(){
        return serializer;
    }

    public int getPort(){
        return properties.getPort();
    }

    public ServerCallback getStartCallback() {
        return startCallback;
    }

    public void setStartCallback(ServerCallback startCallback) {
        this.startCallback = startCallback;
    }

    public ServerCallback getStopCallback() {
        return stopCallback;
    }

    public void setStopCallback(ServerCallback stopCallback) {
        this.stopCallback = stopCallback;
    }

    public int getCorePoolSize() {
        return properties.getCorePoolSize();
    }

    public int getMaxPoolSize() {
        return properties.getMaxPoolSize();
    }

    public Class<?> getRequestParamType() {
        return requestParamType;
    }

    public void setRequestParamType(Class<?> requestParamType) {
        this.requestParamType = requestParamType;
    }

    public Class<?> getResponseType() {
        return responseType;
    }

    public void setResponseType(Class<?> responseType) {
        this.responseType = responseType;
    }

    public SimpleChannelInboundHandler getServerInboundHandler() {
        return serverInboundHandler;
    }
}
