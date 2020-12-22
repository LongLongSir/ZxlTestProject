package com.differ.zxl.server;

import com.differ.zxl.request.RequestMessage;
import com.differ.zxl.response.ResponseMessage;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NettyServerFactoryBean extends NettyServerFactory implements InitializingBean, DisposableBean {

    public NettyServerFactoryBean(NettyServerProperties properties, SimpleChannelInboundHandler serverInboundHandler) {
        super(properties,serverInboundHandler);
    }

    @Override
    public void destroy() throws Exception {
        super.close();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRequestParamType(RequestMessage.class);
        setResponseType(ResponseMessage.class);
        setStartCallback(()-> System.out.println("netty服务启动成功"));
        setStopCallback(()-> System.out.println("netty服务已关闭"));
        //启动服务
        super.start();
    }
}
