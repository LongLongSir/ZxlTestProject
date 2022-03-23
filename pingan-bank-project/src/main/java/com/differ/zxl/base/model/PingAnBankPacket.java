package com.differ.zxl.base.model;

/**
 * @auth zhangxl
 * @date 2021/12/10
 */
public class PingAnBankPacket {

    private byte[] head;

    private byte[] body;

    private int bodyLength;

    public byte[] getHead() {
        return head;
    }

    public void setHead(byte[] head) {
        this.head = head;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public int getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(int bodyLength) {
        this.bodyLength = bodyLength;
    }
}
