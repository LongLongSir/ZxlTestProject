package com.differ.zxl.server;

import com.differ.zxl.request.RequestMessage;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class ConfigOperation implements InitializingBean {

    private ThreadPoolExecutor executor;

    private NettyServerProperties properties;

//    @Autowired
//    private Service  service;

    public ConfigOperation(NettyServerProperties properties){
        this.properties=properties;
    }

    //处理同步数据
    public void processSyncData(RequestMessage message){

    }

    //处理推送结果
    public void processPushResult(RequestMessage message){

    }

    public void setExecutor(ThreadPoolExecutor executor){
        this.executor=executor;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        executor=new ThreadPoolExecutor(properties.getCorePoolSize(), properties.getMaxPoolSize(), 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"configService-"+r.hashCode());
            }
        });
    }
}
