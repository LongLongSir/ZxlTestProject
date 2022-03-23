package com.differ.zxl.base.pinganbank;

/**
 * 报文内容
 * @author zhuyuchao
 * @date 2020/7/10
 */
public class Packets {
    byte[] head;
    byte[] body;

    int len;

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

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

}
