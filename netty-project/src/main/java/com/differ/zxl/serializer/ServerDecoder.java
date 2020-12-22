package com.differ.zxl.serializer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class ServerDecoder extends ByteToMessageDecoder {

    private Serializer serializer;
    private Class<?> clazz;

    public  ServerDecoder(Serializer serializer,Class<?> clazz){
        this.serializer=serializer;
        this.clazz=clazz;
    }
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() < 4) {
            return;
        }
        byteBuf.markReaderIndex();
        int dataLength = byteBuf.readInt();
        if (dataLength < 0) {
            channelHandlerContext.close();
        }
        if (byteBuf.readableBytes() < dataLength) {
            byteBuf.resetReaderIndex();
            return;	// fix 1024k buffer splice limix
        }
        byte[] data = new byte[dataLength];
        byteBuf.readBytes(data);

        Object obj = serializer.deserialize(data, clazz);
        list.add(obj);
    }

}
