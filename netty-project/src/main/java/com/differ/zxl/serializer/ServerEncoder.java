package com.differ.zxl.serializer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class ServerEncoder extends MessageToByteEncoder<Object> {

    private Serializer serializer;
    private Class<?> clazz;

    public ServerEncoder(Serializer serializer,Class<?> clazz){
        this.serializer=serializer;
        this.clazz=clazz;
    }
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object obj, ByteBuf byteBuf) throws Exception {
        if(clazz.isInstance(obj)){
            byte[] bytes = serializer.serialize(obj);
            byteBuf.writeInt(bytes.length);
            byteBuf.writeBytes(bytes);
        }
    }
}
