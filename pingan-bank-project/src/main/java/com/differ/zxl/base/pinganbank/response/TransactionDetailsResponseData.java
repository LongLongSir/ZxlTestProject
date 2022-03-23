package com.differ.zxl.base.pinganbank.response;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.StringWriter;

/**
 * 平安交易明细查询返回结果实体类
 */
@XmlRootElement(name = "list")
public class TransactionDetailsResponseData {
    /**
     * 主机记账日期
     */
    private String AcctDate;
    /**
     * 交易时间
     */
    private String TxTime;
    /**
     * 主机流水号
     */
    private String HostTrace;
    /**
     * 业务流水号
     */
    private String BussSeqNo;
    /**
     * 明细序号
     * 明细序号，原来和核心水号一起区分交易唯一性
     */
    private String DetailSerialNo;
    /**
     * 付款方网点号
     */
    private String OutNode;
    /**
     * 付款方联行号
     */
    private String OutBankNo;
    /**
     * 付款行名称
     */
    private String OutBankName;
    /**
     * 付款方账号
     */
    private String OutAcctNo;

    /**
     * 付款方户名
     */
    private String OutAcctName;
    /**
     * 结算币种
     */
    private String CcyCode;
    /**
     * 交易金额
     */
    private String TranAmount;
    /**
     * 收款方网点号
     */
    private String InNode;
    /**
     * 收款方联行号
     */
    private String InBankNo;
    /**
     * 收款方行名
     */
    private String InBankName;
    /**
     * 收款方账号
     */
    private String InAcctNo;

    /**
     * 收款方户名
     */
    private String InAcctName;
    /**
     * 借贷标志
     */
    private String DcFlag;
    /**
     * 摘要
     */
    private String AbstractStr;
    /**
     * 手续费
     */
    private String TranFee;
    /**
     * 邮电费
     */
    private String PostFee;
    /**
     * 账户余额
     */
    private String AcctBalance;
    /**
     * 用途，附言
     */
    private String Purpose;
    /**
     * 中文摘要
     */
    private String AbstractStr_Desc;

    /**
     * 代理人户名
     */
    private String ProxyPayName;
    /**
     * 代理人账号
     */
    private String ProxyPayAcc;
    /**
     * 代理人银行名称
     */
    private String ProxyPayBankName;
    /**
     * 主机日期
     */
    private String HostDate;


    @XmlElement(name = "AcctDate")
    public String getAcctDate() {
        return AcctDate;
    }

    public void setAcctDate(String acctDate) {
        AcctDate = acctDate;
    }

    @XmlElement(name = "TxTime")
    public String getTxTime() {
        return TxTime;
    }

    public void setTxTime(String txTime) {
        TxTime = txTime;
    }

    @XmlElement(name = "HostTrace")
    public String getHostTrace() {
        return HostTrace;
    }

    public void setHostTrace(String hostTrace) {
        HostTrace = hostTrace;
    }

    @XmlElement(name = "BussSeqNo")
    public String getBussSeqNo() {
        return BussSeqNo;
    }

    public void setBussSeqNo(String bussSeqNo) {
        BussSeqNo = bussSeqNo;
    }

    @XmlElement(name = "DetailSerialNo")
    public String getDetailSerialNo() {
        return DetailSerialNo;
    }

    public void setDetailSerialNo(String detailSerialNo) {
        DetailSerialNo = detailSerialNo;
    }

    @XmlElement(name = "OutNode")
    public String getOutNode() {
        return OutNode;
    }

    public void setOutNode(String outNode) {
        OutNode = outNode;
    }

    @XmlElement(name = "OutBankNo")
    public String getOutBankNo() {
        return OutBankNo;
    }

    public void setOutBankNo(String outBankNo) {
        OutBankNo = outBankNo;
    }

    @XmlElement(name = "OutBankName")
    public String getOutBankName() {
        return OutBankName;
    }

    public void setOutBankName(String outBankName) {
        OutBankName = outBankName;
    }

    @XmlElement(name = "OutAcctNo")
    public String getOutAcctNo() {
        return OutAcctNo;
    }

    public void setOutAcctNo(String outAcctNo) {
        OutAcctNo = outAcctNo;
    }

    @XmlElement(name = "OutAcctName")
    public String getOutAcctName() {
        return OutAcctName;
    }

    public void setOutAcctName(String outAcctName) {
        OutAcctName = outAcctName;
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

    @XmlElement(name = "InNode")
    public String getInNode() {
        return InNode;
    }

    public void setInNode(String inNode) {
        InNode = inNode;
    }

    @XmlElement(name = "InBankNo")
    public String getInBankNo() {
        return InBankNo;
    }

    public void setInBankNo(String inBankNo) {
        InBankNo = inBankNo;
    }

    @XmlElement(name = "InBankName")
    public String getInBankName() {
        return InBankName;
    }

    public void setInBankName(String inBankName) {
        InBankName = inBankName;
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

    @XmlElement(name = "DcFlag")
    public String getDcFlag() {
        return DcFlag;
    }

    public void setDcFlag(String dcFlag) {
        DcFlag = dcFlag;
    }

    @XmlElement(name = "AbstractStr")
    public String getAbstractStr() {
        return AbstractStr;
    }

    public void setAbstractStr(String abstractStr) {
        AbstractStr = abstractStr;
    }

    @XmlElement(name = "TranFee")
    public String getTranFee() {
        return TranFee;
    }

    public void setTranFee(String tranFee) {
        TranFee = tranFee;
    }

    @XmlElement(name = "PostFee")
    public String getPostFee() {
        return PostFee;
    }

    public void setPostFee(String postFee) {
        PostFee = postFee;
    }

    @XmlElement(name = "AcctBalance")
    public String getAcctBalance() {
        return AcctBalance;
    }

    public void setAcctBalance(String acctBalance) {
        AcctBalance = acctBalance;
    }

    @XmlElement(name = "Purpose")
    public String getPurpose() {
        return Purpose;
    }

    public void setPurpose(String purpose) {
        Purpose = purpose;
    }

    @XmlElement(name = "AbstractStr_Desc")
    public String getAbstractStr_Desc() {
        return AbstractStr_Desc;
    }

    public void setAbstractStr_Desc(String abstractStr_Desc) {
        AbstractStr_Desc = abstractStr_Desc;
    }

    @XmlElement(name = "ProxyPayName")
    public String getProxyPayName() {
        return ProxyPayName;
    }

    public void setProxyPayName(String proxyPayName) {
        ProxyPayName = proxyPayName;
    }

    @XmlElement(name = "ProxyPayAcc")
    public String getProxyPayAcc() {
        return ProxyPayAcc;
    }

    public void setProxyPayAcc(String proxyPayAcc) {
        ProxyPayAcc = proxyPayAcc;
    }

    @XmlElement(name = "ProxyPayBankName")
    public String getProxyPayBankName() {
        return ProxyPayBankName;
    }

    public void setProxyPayBankName(String proxyPayBankName) {
        ProxyPayBankName = proxyPayBankName;
    }

    @XmlElement(name = "HostDate")
    public String getHostDate() {
        return HostDate;
    }

    public void setHostDate(String hostDate) {
        HostDate = hostDate;
    }

    @Override
    public String toString() {
        try {
            JAXBContext context = JAXBContext.newInstance(TransactionDetailsResponseData.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
            // 是否省略xml头信息（<?xml version="1.0" encoding="gb2312" standalone="yes"?>）
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            StringWriter writer = new StringWriter();
            marshaller.marshal(this, writer);
            return writer.toString();
        } catch (JAXBException e) {
            return "";
        }
    }
}
