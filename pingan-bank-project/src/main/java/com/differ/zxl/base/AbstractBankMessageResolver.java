package com.differ.zxl.base;

import com.alibaba.fastjson.JSON;
import com.differ.zxl.base.model.BaseTransferResponse;
import com.differ.zxl.base.model.MessageBody;
import com.differ.zxl.base.model.MessageHeader;

/**
 * @auth zhangxl
 * @date 2021/12/9
 */
public abstract class AbstractBankMessageResolver<B extends MessageBody> implements BankMessageResolver<B>{

    @Override
    public String buildMessageHeaderString(MessageHeader messageHeader) {

        return null;
    }

    @Override
    public MessageHeader messageHeaderResolver(BaseTransferResponse response) {

        return null;
    }
}
