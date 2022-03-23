package com.differ.zxl.base.pinganbank.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 快付单笔转账指令查询响应类
 * @author zhuyuchao
 * @date 2020/11/11
 */
@XmlRootElement(name = "Result")
public class PayFastSingleTransferQueryResponse {
    /**
     * 订单号
     */
    private String OrderNumber;
    /**
     * 银行业务流水号 银行受理成功，返回业务流水号
     */
    private String BussFlowNo;
    /**
     * 银行交易流水号
     */
    private String TranFlowNo;
    /**
     * 交易状态 20成功，30失败，其余处理中。
     */
    private String Status;
    /**
     * 返回码
     */
    private String RetCode;
    /**
     * 返回消息
     */
    private String RetMsg;
    /**
     * 清算日期
     */
    private String SettleDate;
    /**
     * 收款卡号
     */
    private String InAcctNo;
    /**
     * 收款户名
     */
    private String InAcctName;
    /**
     * 币种
     */
    private String CcyCode;
    /**
     * 金额
     */
    private String TranAmount;
    /**
     * 手机号
     */
    private String Mobile;
    /**
     * 用途/备注
     */
    private String Remark;
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
    @XmlElement(name = "TranFlowNo")
    public String getTranFlowNo() {
        return TranFlowNo;
    }

    public void setTranFlowNo(String tranFlowNo) {
        TranFlowNo = tranFlowNo;
    }
    @XmlElement(name = "Status")
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
    @XmlElement(name = "RetCode")
    public String getRetCode() {
        return RetCode;
    }

    public void setRetCode(String retCode) {
        RetCode = retCode;
    }
    @XmlElement(name = "RetMsg")
    public String getRetMsg() {
        return RetMsg;
    }

    public void setRetMsg(String retMsg) {
        RetMsg = retMsg;
    }
    @XmlElement(name = "SettleDate")
    public String getSettleDate() {
        return SettleDate;
    }

    public void setSettleDate(String settleDate) {
        SettleDate = settleDate;
    }
    @XmlElement(name = "InAcctNo")
    public String getInAcctNo() {
        return InAcctNo;
    }

    public void setInAcctNo(String inAcctNo) {
        InAcctNo = inAcctNo;
    }
    @XmlElement(name = "InAcctName")
    public String getInAcctName() {
        return InAcctName;
    }

    public void setInAcctName(String inAcctName) {
        InAcctName = inAcctName;
    }
    @XmlElement(name = "CcyCode")
    public String getCcyCode() {
        return CcyCode;
    }

    public void setCcyCode(String ccyCode) {
        CcyCode = ccyCode;
    }
    @XmlElement(name = "TranAmount")
    public String getTranAmount() {
        return TranAmount;
    }

    public void setTranAmount(String tranAmount) {
        TranAmount = tranAmount;
    }
    @XmlElement(name = "Mobile")
    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }
    @XmlElement(name = "Remark")
    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
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
