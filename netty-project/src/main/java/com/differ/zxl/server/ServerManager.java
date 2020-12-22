package com.differ.zxl.server;

import com.differ.zxl.response.ResponseMessage;
import io.netty.channel.Channel;
import io.netty.util.internal.StringUtil;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServerManager {

    //id -> duplicateId
    private static Map<String,String> channelMap=new ConcurrentHashMap<>();

    //duplicateId -> Channel
    private static Map<String, Channel> duplicateMap=new ConcurrentHashMap<>();

    //namespace ->
    //Map<String,Map<String,Channel>> serverConfigMap=new ConcurrentHashMap<>();

    public static void addChannel(String channelId,String duplicateId,Channel channel){
        if(!channelMap.containsKey(channelId)){
            channelMap.put(channelId,duplicateId);
            duplicateMap.put(duplicateId,channel);
        }
    }

    public static void removeChannel(String channelId){
        String duplicateId = channelMap.remove(channelId);
        if(!StringUtil.isNullOrEmpty(duplicateId)){
            duplicateMap.remove(duplicateId);
        }
    }

    //获取客户端ip
    public static String getRemoteIp(String remoteAddress){
        return remoteAddress.split("/")[1].split(":")[0];
    }

    public  static void sendSingleMessage(String duplicateId, ResponseMessage message){
        try {
            Channel channel=duplicateMap.get(duplicateId);
            if(channel!=null&&channel.isActive()){
                channel.writeAndFlush(message).sync();
            }else{
                System.out.println("副本id为"+duplicateId+"，连接已断开，无法发送消息");
            }
        } catch (InterruptedException e) {
            System.out.println("副本id为"+duplicateId+"，发送消息失败");
            e.printStackTrace();
        }
    }

    public static void sendMultiMessage(List<String> duplicateIds, ResponseMessage message){
        for(String duplicateId:duplicateIds){
            sendSingleMessage(duplicateId,message);
        }
    }
}
