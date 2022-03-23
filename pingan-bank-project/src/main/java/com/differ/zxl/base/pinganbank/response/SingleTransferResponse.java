package com.differ.zxl.base.pinganbank.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 单笔转账响应类
 * @author zhuyuchao
 * @date 2020/7/10
 */
@XmlRootElement(name = "Result")
@XmlType(propOrder = {"thirdVoucher", "frontLogNo", "cstInnerFlowNo", "ccyCode", "outAcctName", "outAcctNo",
        "inAcctBankName", "inAcctNo", "inAcctName", "tranAmount", "unionFlag", "fee1",
        "fee2", "hostFlowNo", "hostTxDate", "stt", "code", "message"
})
public class SingleTransferResponse {
    /**
     * 转账凭证号
     */
    private String ThirdVoucher;
    /**
     * 银行流水号 银行业务流水号；可以用于对账
     */
    private String FrontLogNo;
    /**
     * 客户自定义凭证 于客户转账登记和内部识别，通过转账结果查询可以返回。银行不检查唯一性
     */
    private String CstInnerFlowNo;
    /**
     * 货币类型
     */
    private String CcyCode;
    /**
     * 付款人账户名称
     */
    private String OutAcctName;
    /**
     * 付款人账户
     */
    private String OutAcctNo;
    /**
     * 收款人开户行名称
     */
    private String InAcctBankName;
    /**
     * 收款人账户
     */
    private String InAcctNo;
    /**
     * 收款人账户户名
     */
    private String InAcctName;
    /**
     * 交易金额
     */
    private String TranAmount;
    /**
     * 行内跨行标志 1：行内转账，0：跨行转账
     */
    private String UnionFlag;
    /**
     * 手续费
     */
    private String Fee1;
    /**
     * 转账手续费预算，实际手续费用以实际扣取的为准。
     */
    private String Fee2;
    /**
     * 银行返回流水号 银行记账流水号；
     * 转账成功后，银行返回的流水号。
     */
    private String hostFlowNo;
    /**
     * 记账日期
     */
    private String hostTxDate;
    /**
     * 20：交易成功
     * 30：失败；
     * 其他为银行受理成功处理中，请使用“交易进度查询4005”接口获取最终状态
     */
    private String stt;

    /**
     * 交易状态码
     */
    private String code;

    /**
     * 交易信息
     */
    private String message;

    @XmlElement(name = "ThirdVoucher")
    public String getThirdVoucher() {
        return ThirdVoucher;
    }

    public void setThirdVoucher(String thirdVoucher) {
        ThirdVoucher = thirdVoucher;
    }
    @XmlElement(name = "FrontLogNo")
    public String getFrontLogNo() {
        return FrontLogNo;
    }

    public void setFrontLogNo(String frontLogNo) {
        FrontLogNo = frontLogNo;
    }
    @XmlElement(name = "CstInnerFlowNo")
    public String getCstInnerFlowNo() {
        return CstInnerFlowNo;
    }

    public void setCstInnerFlowNo(String cstInnerFlowNo) {
        CstInnerFlowNo = cstInnerFlowNo;
    }
    @XmlElement(name = "CcyCode")
    public String getCcyCode() {
        return CcyCode;
    }

    public void setCcyCode(String ccyCode) {
        CcyCode = ccyCode;
    }
    @XmlElement(name = "OutAcctName")
    public String getOutAcctName() {
        return OutAcctName;
    }

    public void setOutAcctName(String outAcctName) {
        OutAcctName = outAcctName;
    }
    @XmlElement(name = "OutAcctNo")
    public String getOutAcctNo() {
        return OutAcctNo;
    }

    public void setOutAcctNo(String outAcctNo) {
        OutAcctNo = outAcctNo;
    }
    @XmlElement(name = "InAcctBankName")
    public String getInAcctBankName() {
        return InAcctBankName;
    }

    public void setInAcctBankName(String inAcctBankName) {
        InAcctBankName = inAcctBankName;
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
    @XmlElement(name = "TranAmount")
    public String getTranAmount() {
        return TranAmount;
    }

    public void setTranAmount(String tranAmount) {
        TranAmount = tranAmount;
    }
    @XmlElement(name = "UnionFlag")
    public String getUnionFlag() {
        return UnionFlag;
    }

    public void setUnionFlag(String unionFlag) {
        UnionFlag = unionFlag;
    }
    @XmlElement(name = "Fee1")
    public String getFee1() {
        return Fee1;
    }

    public void setFee1(String fee1) {
        Fee1 = fee1;
    }
    @XmlElement(name = "Fee2")
    public String getFee2() {
        return Fee2;
    }

    public void setFee2(String fee2) {
        Fee2 = fee2;
    }
    @XmlElement(name = "hostFlowNo")
    public String getHostFlowNo() {
        return hostFlowNo;
    }

    public void setHostFlowNo(String hostFlowNo) {
        this.hostFlowNo = hostFlowNo;
    }
    @XmlElement(name = "hostTxDate")
    public String getHostTxDate() {
        return hostTxDate;
    }

    public void setHostTxDate(String hostTxDate) {
        this.hostTxDate = hostTxDate;
    }
    @XmlElement(name = "stt")
    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
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
