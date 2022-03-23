package com.differ.zxl.base;

import com.differ.zxl.base.model.BaseTransferRequest;
import com.differ.zxl.base.model.BaseTransferResponse;
import com.differ.zxl.base.model.MessageBody;
import com.differ.zxl.base.model.MessageHeader;

/**
 * 银行接口调用消息解析器
 * @auth zhangxl
 * @date 2021/12/9
 */
public interface BankMessageResolver<B extends MessageBody> {

    String buildMessageHeaderString(MessageHeader messageHeader);

    MessageHeader messageHeaderResolver(BaseTransferResponse response);

    String buildMessageBody(B messageBody);

    B messageBodyResolver(String BodyStr,Class<B> bClass);

}
