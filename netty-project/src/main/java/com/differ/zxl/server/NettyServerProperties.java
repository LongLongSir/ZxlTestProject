package com.differ.zxl.server;


import org.springframework.boot.context.properties.ConfigurationProperties;

//@ConfigurationProperties(prefix = "jackyun.config.server")
public class NettyServerProperties {

    private int corePoolSize = 60;
    private int maxPoolSize = 300;

    //服务端启动端口
    private int port = 7080;

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
