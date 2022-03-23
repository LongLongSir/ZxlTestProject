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
 * 单笔转账请求类
 * @author zhuyuchao
 * @date 2020/7/10
 */
@XmlRootElement(name = "Result")
public class SingleTransferRequest {
    /**
     * 转账凭证号  C(20)，最少10位长度  标示交易唯一性，同一客户上送的不可重复，建议格式：yyyymmddHHSS+8位系列。
     * 要求6个月内唯一。
     */
    private String ThirdVoucher;
    /**
     * 客户自定义凭证号 C(20) 用于客户转账登记和内部识别，通过转账结果查询可以返回。银行不检查唯一性
     */
    private String CstInnerFlowNo;

    /**
     * 货币类型
     */
    private String CcyCode;
    /**
     * 付款人账户
     */
    private String OutAcctNo;
    /**
     * 付款人名称
     */
    private String OutAcctName;
    /**
     * 付款人地址
     */
    private String OutAcctAddr;
    /**
     * 收款人开户行行号
     */
    private String InAcctBankNode;
    /**
     * 接收行行号
     */
    private String InAcctRecCode;
    /**
     * 收款人账户
     */
    private String InAcctNo;
    /**
     * 收款人账户户名
     */
    private String InAcctName;
    /**
     * 收款人开户行名称
     */
    private String InAcctBankName;
    /**
     * 收款账户银行开户省代码或省名称
     */
    private String InAcctProvinceCode;
    /**
     * 收款账户开户市
     */
    private String InAcctCityName;
    /**
     * 转出金额
     */
    private String TranAmount;
    /**
     * 资金用途 100个汉字，对方能否看到此用途视收款方银行的支持。
     */
    private String UseEx;
    /**
     * 行内跨行标志 1：行内转账，0：跨行转账
     */
    private String UnionFlag;
    /**
     * 转账加急标志 N：普通（大小额自动选择），默认值；
     * Y：加急 （大额）；
     * S：特急(超级网银)；
     * T1：深圳同城普通；
     * T2：深圳同城实时；
     * 默认为N
     */
    private String SysFlag;
    /**
     * 同城/异地标志  “1”—同城   “2”—异地；若无法区分，可默认送1-同城。
     */
    private String AddrFlag;
    /**
     * 付款虚子账户
     */
    private String MainAcctNo;
    /**
     * 收款人证件类型
     */
    private String InIDType;
    /**
     * 收款人证件号码
     */
    private String InIDNo;

    @XmlElement(name = "ThirdVoucher")
    public String getThirdVoucher() {
        return ThirdVoucher;
    }

    public void setThirdVoucher(String thirdVoucher) {
        ThirdVoucher = thirdVoucher;
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

    @XmlElement(name = "InAcctBankNode")
    public String getInAcctBankNode() {
        return InAcctBankNode;
    }

    public void setInAcctBankNode(String inAcctBankNode) {
        InAcctBankNode = inAcctBankNode;
    }

    @XmlElement(name = "InAcctRecCode")
    public String getInAcctRecCode() {
        return InAcctRecCode;
    }

    public void setInAcctRecCode(String inAcctRecCode) {
        InAcctRecCode = inAcctRecCode;
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

    @XmlElement(name = "InAcctProvinceCode")
    public String getInAcctProvinceCode() {
        return InAcctProvinceCode;
    }

    public void setInAcctProvinceCode(String inAcctProvinceCode) {
        InAcctProvinceCode = inAcctProvinceCode;
    }

    @XmlElement(name = "InAcctCityName")
    public String getInAcctCityName() {
        return InAcctCityName;
    }

    public void setInAcctCityName(String inAcctCityName) {
        InAcctCityName = inAcctCityName;
    }

    @XmlElement(name = "TranAmount")
    public String getTranAmount() {
        return TranAmount;
    }

    public void setTranAmount(String tranAmount) {
        TranAmount = tranAmount;
    }

    @XmlElement(name = "UseEx")
    public String getUseEx() {
        return UseEx;
    }

    public void setUseEx(String useEx) {
        UseEx = useEx;
    }

    @XmlElement(name = "UnionFlag")
    public String getUnionFlag() {
        return UnionFlag;
    }

    public void setUnionFlag(String unionFlag) {
        UnionFlag = unionFlag;
    }

    @XmlElement(name = "SysFlag")
    public String getSysFlag() {
        return SysFlag;
    }

    public void setSysFlag(String sysFlag) {
        SysFlag = sysFlag;
    }

    @XmlElement(name = "AddrFlag")
    public String getAddrFlag() {
        return AddrFlag;
    }

    public void setAddrFlag(String addrFlag) {
        AddrFlag = addrFlag;
    }

    @XmlElement(name = "MainAcctNo")
    public String getMainAcctNo() {
        return MainAcctNo;
    }

    public void setMainAcctNo(String mainAcctNo) {
        MainAcctNo = mainAcctNo;
    }

    @XmlElement(name = "InIDType")
    public String getInIDType() {
        return InIDType;
    }

    public void setInIDType(String inIDType) {
        InIDType = inIDType;
    }

    @XmlElement(name = "InIDNo")
    public String getInIDNo() {
        return InIDNo;
    }

    public void setInIDNo(String inIDNo) {
        InIDNo = inIDNo;
    }

    @Override
    public String toString() {
        try {
            JAXBContext context = JAXBContext.newInstance(SingleTransferRequest.class);
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
