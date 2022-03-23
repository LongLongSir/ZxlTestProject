package com.differ.zxl.base.pinganbank.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 单笔转账指令查询响应类
 * @author zhuyuchao
 * @date 2020/7/10
 */
@XmlRootElement(name = "Result")
public class SingleTransferQueryResponse {
    /**
     * 转账凭证号
     */
    private String OrigThirdVoucher;
    /**
     * 银行流水号
     */
    private String FrontLogNo;
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
     * 账号
     */
    private String Account;
    /**
     * 行内跨行标志 1：行内转账，0：跨行转账
     */
    private String UnionFlag;
    /**
     * 交易状态标志 20：成功
     * 30：失败
     * 其他为银行受理成功处理中
     */
    private String Stt;
    /**
     * 0:未退票; 默认为0
     * 1:退票;
     */
    private String IsBack;
    /**
     * 支付失败或退票原因描述
     * 如果是超级网银则返回如下信息:
     * RJ01对方返回：账号不存在
     * RJ02对方返回：账号、户名不符
     * 大小额支付则返回失败描述
     */
    private String BackRem;
    /**
     * 银行处理结果
     * 格式为：“六位代码:中文描述”。冒号为半角。如：000000：转账成功
     * 处理中的返回(以如下返回开头)：
     * MA9111:交易正在受理中
     * 000000:交易受理成功待处理
     * 000000:交易处理中
     * 000000:交易受理成功处理中
     * 成功的返回：
     * 000000:转账交易成功
     * 其他的返回都为失败:
     * MA9112:转账失败
     */
    private String Yhcljg;
    /**
     * 转账加急标志 Y：加急 N：普通S：特急
     */
    private String SysFlag;
    /**
     * 转账手续费
     */
    private String Fee;
    /**
     * 转账代码类型
     * 4004：单笔转账；
     * 4014：单笔批量；
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
     * 错误码
     */
    private String hostErrorCode;
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

    @XmlElement(name = "OrigThirdVoucher")
    public String getOrigThirdVoucher() {
        return OrigThirdVoucher;
    }

    public void setOrigThirdVoucher(String origThirdVoucher) {
        OrigThirdVoucher = origThirdVoucher;
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
    @XmlElement(name = "Account")
    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
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
    @XmlElement(name = "transBsn")
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
    @XmlElement(name = "hostErrorCode")
    public String getHostErrorCode() {
        return hostErrorCode;
    }

    public void setHostErrorCode(String hostErrorCode) {
        this.hostErrorCode = hostErrorCode;
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

}
