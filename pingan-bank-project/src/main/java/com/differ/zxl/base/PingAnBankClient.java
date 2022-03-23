package com.differ.zxl.base;

import com.differ.zxl.base.model.BaseTransferRequest;
import com.differ.zxl.base.model.BaseTransferResponse;
import com.differ.zxl.base.model.MessageBody;

/**
 * @auth zhangxl
 * @date 2021/12/9
 */
public interface PingAnBankClient<B extends MessageBody> {

    /**
     * 转账接口
     * @param request
     * @return
     */
    B payTransfer(BaseTransferRequest<B> request);


    /**
     * 查询转账状态
     * @param request
     * @return
     */
    B queryTransferStatus(BaseTransferRequest<B> request);

}
