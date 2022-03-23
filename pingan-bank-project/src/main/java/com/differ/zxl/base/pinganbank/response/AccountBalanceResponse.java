package com.differ.zxl.base.pinganbank.response;


import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;

/**
 * 平安银行账户余额响应类
 * @author zhuyuchao
 * @date 2020/7/10
 */
@XmlRootElement(name = "Result")
public class AccountBalanceResponse {
    /**
     * 账号
     */
    private String Account;
    /**
     * 货币类型
     */
    private String  CcyCode;
    /**
     * 钞汇标志
     */
    private String CcyType ;
    /**
     * 账户户名
     */
    private String AccountName ;
    /**
     * 可用余额
     */
    private BigDecimal Balance;
    /**
     * 账面余额
     */
    private String  TotalAmount ;
    /**
     * 账户状态 若有多个状态， “|”分割，如：A| DGZH01
     * A：正常；
     * DGZH01: 法律冻结
     * DGZH02: 账户止付
     */
    private String AccountStatus ;
    /**
     * 冻结金额
     */
    private String HoldBalance ;
    /**
     * 止付金额
     */
    private String StopBalance ;
    /**
     * 昨日余额
     */
    private String LastBalance ;
    /**
     * 交易状态码
     */
    private String code;

    /**
     * 交易信息
     */
    private String message;


    @XmlElement(name = "Account")
    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    @XmlElement(name = "CcyCode")
    public String getCcyCode() {
        return CcyCode;
    }

    public void setCcyCode(String ccyCode) {
        CcyCode = ccyCode;
    }

    @XmlElement(name = "CcyType")
    public String getCcyType() {
        return CcyType;
    }

    public void setCcyType(String ccyType) {
        CcyType = ccyType;
    }

    @XmlElement(name = "AccountName")
    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    @XmlElement(name = "Balance")
    public BigDecimal getBalance() {
        return Balance;
    }

    public void setBalance(BigDecimal balance) {
        Balance = balance;
    }

    @XmlElement(name = "TotalAmount")
    public String getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        TotalAmount = totalAmount;
    }

    @XmlElement(name = "AccountStatus")
    public String getAccountStatus() {
        return AccountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        AccountStatus = accountStatus;
    }

    @XmlElement(name = "HoldBalance")
    public String getHoldBalance() {
        return HoldBalance;
    }

    public void setHoldBalance(String holdBalance) {
        HoldBalance = holdBalance;
    }

    @XmlElement(name = "StopBalance")
    public String getStopBalance() {
        return StopBalance;
    }

    public void setStopBalance(String stopBalance) {
        StopBalance = stopBalance;
    }

    @XmlElement(name = "LastBalance")
    public String getLastBalance() {
        return LastBalance;
    }

    public void setLastBalance(String lastBalance) {
        LastBalance = lastBalance;
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

    @Override
    public String toString() {
        try {
            JAXBContext context = JAXBContext.newInstance(AccountBalanceResponse.class);
            Marshaller marshaller = context.createMarshaller();
            // 编码格式
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
            // 是否省略xml头信息（<?xml version="1.0" encoding="gb2312" standalone="yes"?>）
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            StringWriter writer = new StringWriter();
            marshaller.marshal(this, writer);
            // 杭州银行失败返回<output></output>，这边直接返回格式会变成<output/>，需要进行格式处理
            OutputFormat format = new OutputFormat();
            format.setEncoding("GBK");
            //关闭自闭合标签
            format.setExpandEmptyElements(true);
            format.setSuppressDeclaration(true);
            StringWriter strWtr = new StringWriter();
            XMLWriter xmlWrt = new XMLWriter(strWtr, format);
            xmlWrt.write(DocumentHelper.parseText(writer.toString()));
            xmlWrt.flush();
            xmlWrt.close();
            //格式化，去掉换行
            return strWtr.toString().replaceAll("\r|\n", "");
        } catch (JAXBException | DocumentException | IOException e) {
            return "";
        }
    }
}
