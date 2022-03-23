package com.differ.zxl.base.pinganbank.request;

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
import java.util.List;

/**
 * 批量资金划转请求类
 * @author zhuyuchao
 * @date 2020/7/29
 */
@XmlRootElement(name = "Result")
public class BatchTransferRequest {
    /**
     * 批量转账凭证号(20位) 标示交易唯一性，同一客户上送的不可重复，建议格式：yyyymmddHHSS+8位系列。
     */
    private String ThirdVoucher;
    /**
     * 总记录数  批量转账的笔数，笔数不大于500笔；
     */
    private String totalCts;
    /**
     * 总金额 C(13,2)
     */
    private String totalAmt;
    /**
     * 批次摘要
     */
    private String BatchSummary;
    /**
     * 整批转账加急标志 Y：加急
     * N：不加急
     * S：特急（汇总扣款模式不支持）
     */
    private String BSysFlag;
    /**
     * 货币类型
     */
    private String CcyCode;
    /**
     * 付款人账户 扣款账户
     */
    private String OutAcctNo;
    /**
     * 付款人名称 付款账户户名
     */
    private String OutAcctName;
    /**
     * 付款人地址 建议填写付款账户的分行、网点名称
     */
    private String OutAcctAddr;
    /**
     * 扣款类型 默认为0
     * 0：单笔扣划
     * 1：汇总扣划
     * BizFlag1=1时只支持0单笔扣划
     */
    private String PayType;
    /**
     *业务标识1
     * 1：转信托网银落地划款
     * 0或其他为普通直连交易
     */
    private String BizFlag1;
    /**
     * 明细记录
     */
    private List<BatchTransferDetailRequest> batchTransferDetailRequestList;

    @XmlElement(name = "ThirdVoucher")
    public String getThirdVoucher() {
        return ThirdVoucher;
    }

    public void setThirdVoucher(String thirdVoucher) {
        ThirdVoucher = thirdVoucher;
    }
    @XmlElement(name = "totalCts")
    public String getTotalCts() {
        return totalCts;
    }

    public void setTotalCts(String totalCts) {
        this.totalCts = totalCts;
    }
    @XmlElement(name = "totalAmt")
    public String getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(String totalAmt) {
        this.totalAmt = totalAmt;
    }
    @XmlElement(name = "BatchSummary")
    public String getBatchSummary() {
        return BatchSummary;
    }

    public void setBatchSummary(String batchSummary) {
        BatchSummary = batchSummary;
    }
    @XmlElement(name = "BSysFlag")
    public String getBSysFlag() {
        return BSysFlag;
    }

    public void setBSysFlag(String BSysFlag) {
        this.BSysFlag = BSysFlag;
    }
    @XmlElement(name = "CcyCode")
    public String getCcyCode() {
        return CcyCode;
    }

    public void setCcyCode(String ccyCode) {
        CcyCode = ccyCode;
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
    @XmlElement(name = "OutAcctAddr")
    public String getOutAcctAddr() {
        return OutAcctAddr;
    }

    public void setOutAcctAddr(String outAcctAddr) {
        OutAcctAddr = outAcctAddr;
    }
    @XmlElement(name = "PayType")
    public String getPayType() {
        return PayType;
    }

    public void setPayType(String payType) {
        PayType = payType;
    }
    @XmlElement(name = "BizFlag1")
    public String getBizFlag1() {
        return BizFlag1;
    }

    public void setBizFlag1(String bizFlag1) {
        BizFlag1 = bizFlag1;
    }
    @XmlElement(name = "HOResultSet4018R")
    public List<BatchTransferDetailRequest> getBatchTransferDetailRequestList() {
        return batchTransferDetailRequestList;
    }

    public void setBatchTransferDetailRequestList(List<BatchTransferDetailRequest> batchTransferDetailRequestList) {
        this.batchTransferDetailRequestList = batchTransferDetailRequestList;
    }

    @Override
    public String toString() {
        try {
            JAXBContext context = JAXBContext.newInstance(BatchTransferRequest.class);
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
