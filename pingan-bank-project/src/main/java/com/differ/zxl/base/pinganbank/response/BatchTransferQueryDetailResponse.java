package com.differ.zxl.base.pinganbank.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 批量转账指令查询响应类明细
 * @author zhuyuchao
 * @date 2020/7/29
 */
@XmlRootElement(name = "list")
public class BatchTransferQueryDetailResponse {
    /**
     * 银行流水号
     */
    private String FrontLogNo;
    /**
     * 单笔转账凭证号(批次中的流水号)
     */
    private String SThirdVoucher;
    /**
     * 客户自定义凭证号
     */
    private String CstInnerFlowNo;
    /**
     * 货币类型
     */
    private String CcyCode;
    /**
     * 转出账户开户网点名
     */
    private String OutAcctBankName;
    /**
     * 转出账户
     */
    private String OutAcctNo;
    /**
     * 转入账户网点名称
     */
    private String InAcctBankName;
    /**
     * 转入账户
     */
    private String InAcctNo;
    /**
     * 转入账户户名
     */
    private String InAcctName;
    /**
     * 交易金额
     */
    private String TranAmount;
    /**
     * 行内跨行标志
     * 1：行内转账，0：跨行转账
     */
    private String UnionFlag;
    /**
     * 交易状态标志
     * 20：成功
     * 30：失败
     * 其他为银行受理成功处理中
     */
    private String Stt;
    /**
     * 转账退票标志
     * 0:未退票;
     * 1:退票;
     */
    private String IsBack;
    /**
     * 支付失败、退票原因
     */
    private String BackRem;
    /**
     * 银行处理结果
     * 格式为：“六位代码:中文描述”。冒号为半角。如： 000000：内部转账交易成功
     * MA0103: 没有满足条件纪录；
     */
    private String Yhcljg;
    /**
     * 转账加急标志
     * ‘1’—大额 ，等同Y
     * ‘2’—小额”等同N
     * Y：加急 N：不加急S：特急
     */
    private String SysFlag;
    /**
     * 银行手续费
     */
    private String Fee;
    /**
     * 转账代码类型
     * 4004：单笔转账；
     * 4014：单笔批量；
     * 4018：大批量转账
     * 4034：汇总批量
     */
    private String TransBsn;
    /**
     * 交易受理时间
     */
    private String submitTime;
    /**
     * 记账日期
     */
    private String AccountDate;
    /**
     * 主机记账流水号
     */
    private String hostFlowNo;
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
     * 错误码
     */
    private String hostErrorCode;

    @XmlElement(name = "FrontLogNo")
    public String getFrontLogNo() {
        return FrontLogNo;
    }

    public void setFrontLogNo(String frontLogNo) {
        FrontLogNo = frontLogNo;
    }

    @XmlElement(name = "SThirdVoucher")
    public String getSThirdVoucher() {
        return SThirdVoucher;
    }

    public void setSThirdVoucher(String SThirdVoucher) {
        this.SThirdVoucher = SThirdVoucher;
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
    @XmlElement(name = "OutAcctBankName")
    public String getOutAcctBankName() {
        return OutAcctBankName;
    }

    public void setOutAcctBankName(String outAcctBankName) {
        OutAcctBankName = outAcctBankName;
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
    @XmlElement(name = "Stt")
    public String getStt() {
        return Stt;
    }

    public void setStt(String stt) {
        Stt = stt;
    }
    @XmlElement(name = "IsBack")
    public String getIsBack() {
        return IsBack;
    }

    public void setIsBack(String isBack) {
        IsBack = isBack;
    }
    @XmlElement(name = "BackRem")
    public String getBackRem() {
        return BackRem;
    }

    public void setBackRem(String backRem) {
        BackRem = backRem;
    }
    @XmlElement(name = "Yhcljg")
    public String getYhcljg() {
        return Yhcljg;
    }

    public void setYhcljg(String yhcljg) {
        Yhcljg = yhcljg;
    }
    @XmlElement(name = "SysFlag")
    public String getSysFlag() {
        return SysFlag;
    }

    public void setSysFlag(String sysFlag) {
        SysFlag = sysFlag;
    }
    @XmlElement(name = "Fee")
    public String getFee() {
        return Fee;
    }

    public void setFee(String fee) {
        Fee = fee;
    }
    @XmlElement(name = "TransBsn")
    public String getTransBsn() {
        return TransBsn;
    }

    public void setTransBsn(String transBsn) {
        TransBsn = transBsn;
    }
    @XmlElement(name = "submitTime")
    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }
    @XmlElement(name = "AccountDate")
    public String getAccountDate() {
        return AccountDate;
    }

    public void setAccountDate(String accountDate) {
        AccountDate = accountDate;
    }
    @XmlElement(name = "hostFlowNo")
    public String getHostFlowNo() {
        return hostFlowNo;
    }

    public void setHostFlowNo(String hostFlowNo) {
        this.hostFlowNo = hostFlowNo;
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

    @XmlElement(name = "hostErrorCode")
    public String getHostErrorCode() {
        return hostErrorCode;
    }

    public void setHostErrorCode(String hostErrorCode) {
        this.hostErrorCode = hostErrorCode;
    }
}
