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

/**
 * 单笔付款结果通知
 *
 * @author zhuyuchao
 * @date 2020/7/10
 */
@XmlRootElement(name = "Result")
public class PayFastSingleTransferOrderRequset {
    /**
     * 订单号
     */
    private String OrderNumber;

    /**
     * 银行业务流水号
     */
    private String BussFlowNo;
    /**
     * 银行交易流水号
     */
    private String TranFlowNo;
    /**
     * 清算日期
     */
    private String SettleDate;

    /**
     * 交易状态 20成功，30失败，其余处理中。
     */
    private String Status;

    /**
     * 付款帐号 企业签约帐号
     */
    private String AcctNo;
    /**
     * 收款卡号
     */
    private String InAcctNo;
    /**
     * 金额
     */
    private String TranAmount;
    /**
     * 返回码
     */
    private String RetCode;
    /**
     * 返回消息
     */
    private String RetMsg;

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

    @XmlElement(name = "SettleDate")
    public String getSettleDate() {
        return SettleDate;
    }

    public void setSettleDate(String settleDate) {
        SettleDate = settleDate;
    }

    @XmlElement(name = "Status")
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @XmlElement(name = "AcctNo")
    public String getAcctNo() {
        return AcctNo;
    }

    public void setAcctNo(String acctNo) {
        AcctNo = acctNo;
    }

    @XmlElement(name = "InAcctNo")
    public String getInAcctNo() {
        return InAcctNo;
    }

    public void setInAcctNo(String inAcctNo) {
        InAcctNo = inAcctNo;
    }

    @XmlElement(name = "TranAmount")
    public String getTranAmount() {
        return TranAmount;
    }

    public void setTranAmount(String tranAmount) {
        TranAmount = tranAmount;
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


    @Override
    public String toString() {
        try {
            JAXBContext context = JAXBContext.newInstance(PayFastSingleTransferOrderRequset.class);
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
