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
 * 快付接口单笔转账请求类
 * @author zhuyuchao
 * @date 2020/11/11
 */
@XmlRootElement(name = "Result")
public class PayFastSingleTransferRequest {
    /**
     * 订单号C(20)
     */
    private String OrderNumber;
    /**
     * 企业签约帐号
     */
    private String AcctNo;

    /**
     * 费项代码 跨行快付固定为：00000
     */
    private String BusiType;
    /**
     * 单位代码
     */
    private String CorpId;
    /**
     * 币种 RMB
     */
    private String CcyCode;
    /**
     * 金额
     */
    private String TranAmount;
    /**
     * 收款卡号
     */
    private String InAcctNo;
    /**
     * 收款户名
     */
    private String InAcctName;
    /**
     * 收款方银行名称 收款方为存折、对公账户时建议输入
     */
    private String InAcctBankName;
    /**
     * 收款方联行号 收款方为存折、对公账户时建议输入
     */
    private String InAcctBankNode;
    /**
     * 收款方手机号
     */
    private String Mobile;
    /**
     * 用途/备注
     */
    private String Remark;
    /**
     * 收款方开户行省份 收款方为存折、对公账户时建议输入
     */
    private String InAcctProvinceName;
    /**
     * 收款方开户行城市 收款方为存折、对公账户时建议输入
     */
    private String InAcctCityName;
    /**
     * 智能收款子账户
     */
    private String SubAcctNo;

    /**
     *业务场景
     * 特别说明:签订多场景协议的该字段必传,单场景的该字段非必传
     * 99	其他（针对新签约客户）
     * 98	其他（存量客户）
     * 50	营销返现
     * 51	资金结算
     * 52	农林牧副渔收购
     * 53	投资赎回（含基金赎回）
     * 54	汇划ACS账户
     * 55	订单支付
     * 56	基金到期返回
     * 57	认/申购失败返还
     * 00	一般性付款
     * 04	商户资金结算
     * 05	农林牧副渔收购
     * 11	投资赎回
     * 01	境内转账
     * 12	政府服务
     * 18	保险理赔/分红
     * 19	薪资发放
     * 20	信贷发放
     */
    private String busPdtFlag;


    @XmlElement(name = "OrderNumber")
    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }

    @XmlElement(name = "AcctNo")
    public String getAcctNo() {
        return AcctNo;
    }

    public void setAcctNo(String acctNo) {
        AcctNo = acctNo;
    }

    @XmlElement(name = "BusiType")
    public String getBusiType() {
        return BusiType;
    }

    public void setBusiType(String busiType) {
        BusiType = busiType;
    }

    @XmlElement(name = "CorpId")
    public String getCorpId() {
        return CorpId;
    }

    public void setCorpId(String corpId) {
        CorpId = corpId;
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

    @XmlElement(name = "InAcctBankName")
    public String getInAcctBankName() {
        return InAcctBankName;
    }

    public void setInAcctBankName(String inAcctBankName) {
        InAcctBankName = inAcctBankName;
    }

    @XmlElement(name = "InAcctBankNode")
    public String getInAcctBankNode() {
        return InAcctBankNode;
    }

    public void setInAcctBankNode(String inAcctBankNode) {
        InAcctBankNode = inAcctBankNode;
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

    @XmlElement(name = "InAcctProvinceName")
    public String getInAcctProvinceName() {
        return InAcctProvinceName;
    }

    public void setInAcctProvinceName(String inAcctProvinceName) {
        InAcctProvinceName = inAcctProvinceName;
    }

    @XmlElement(name = "InAcctCityName")
    public String getInAcctCityName() {
        return InAcctCityName;
    }

    public void setInAcctCityName(String inAcctCityName) {
        InAcctCityName = inAcctCityName;
    }

    @XmlElement(name = "SubAcctNo")
    public String getSubAcctNo() {
        return SubAcctNo;
    }

    public void setSubAcctNo(String subAcctNo) {
        SubAcctNo = subAcctNo;
    }

    @XmlElement(name = "busPdtFlag")
    public String getBusPdtFlag() {
        return busPdtFlag;
    }

    public void setBusPdtFlag(String busPdtFlag) {
        this.busPdtFlag = busPdtFlag;
    }

    @Override
    public String toString() {
        try {
            JAXBContext context = JAXBContext.newInstance(PayFastSingleTransferRequest.class);
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
