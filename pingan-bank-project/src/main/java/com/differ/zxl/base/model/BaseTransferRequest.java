package com.differ.zxl.base.model;

/**
 * @auth zhangxl
 * @date 2021/12/9
 */
public class BaseTransferRequest<B extends MessageBody> {

    private MessageHeader messageHeader;

    private B messageBody;

    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(MessageHeader messageHeader) {
        this.messageHeader = messageHeader;
    }

    public B getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(B messageBody) {
        this.messageBody = messageBody;
    }
}
