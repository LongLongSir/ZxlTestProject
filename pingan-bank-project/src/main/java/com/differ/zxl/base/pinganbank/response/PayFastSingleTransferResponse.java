package com.differ.zxl.base.pinganbank.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 快付单笔转账银行回应包结构
 * @author zhuyuchao
 * @date 2020/11/11
 */
@XmlRootElement(name = "Result")
public class PayFastSingleTransferResponse {
    /**
     * 订单号
     */
    private String OrderNumber;
    /**
     * 银行业务流水号 银行受理成功，返回业务流水号
     */
    private String BussFlowNo;
    /**
     * 交易状态码
     */
    private String code;

    /**
     * 交易信息
     */
    private String message;

    @XmlElement(name = "OrderNumber")
    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }

    @XmlElement(name = "BussFlowNo")
    public String getBussFlowNo() {
        return BussFlowNo;
    }

    public void setBussFlowNo(String bussFlowNo) {
        BussFlowNo = bussFlowNo;
    }

    @XmlElement(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlElement(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
