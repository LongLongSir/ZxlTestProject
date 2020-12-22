package com.differ.zxl.spring;

import com.differ.zxl.server.ConfigOperation;
import com.differ.zxl.server.NettyServerFactoryBean;
import com.differ.zxl.server.NettyServerProperties;
import com.differ.zxl.server.channelhandle.NettyServerHandler;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(NettyServerProperties.class)
public class ServerConfiguration {

    @Bean
    public NettyServerFactoryBean nettyServerFactoryBean(NettyServerProperties properties, SimpleChannelInboundHandler serverInboundHandler){
        return new NettyServerFactoryBean(properties,serverInboundHandler);
    }

    @Bean
    public NettyServerHandler nettyServerHandler(ConfigOperation operation){
        return new NettyServerHandler(operation);
    }



}
