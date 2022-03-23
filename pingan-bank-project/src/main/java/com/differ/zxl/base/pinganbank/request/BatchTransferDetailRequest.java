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
 * 批量资金划转明细记录请求类
 * @author zhuyuchao
 * @date 2020/7/29
 */
@XmlRootElement(name = "HOResultSet4018R")
public class BatchTransferDetailRequest {
    /**
     * 单笔转账凭证号(批次中的流水号)/序号
     * 同一个批次内不能重复，建议按顺序递增生成，若上送返回则按此字段递增排序。；建议为递增序号，如从1开始
     */
    private String SThirdVoucher;
    /**
     * 客户自定义凭证号
     * 用于客户转账登记和内部识别，通过转账结果查询可以返回。银行不检查唯一性
     */
    private String CstInnerFlowNo;
    /**
     * 收款人开户行行号
     * 跨行转账不落地，则必输。为人行登记在册的商业银行号
     */
    private String InAcctBankNode;
    /**
     * 跨行转账不落地，则必输。为人行登记在册的商业银行号
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
     * 建议格式：xxx银行xx分行xx支行
     */
    private String InAcctBankName;
    /**
     * 收款账户开户省代码
     * 建议上送，减少跨行转账落单率。对照码参考“附录-省对照表”
     */
    private String InAcctProvinceCode;
    /**
     * 收款账户开户市
     * 建议上送，减少跨行转账落单率
     */
    private String InAcctCityName;
    /**
     * 转出金额
     */
    private String TranAmount;
    /**
     * 资金用途
     */
    private String UseEx;
    /**
     * 行内跨行标志
     * 1：行内转账，
     * 0：跨行转账
     */
    private String UnionFlag;
    /**
     * 同城/异地标志
     * 1:同城
     * 2:异地
     * 若无法区分，则默认可以填写同城
     */
    private String AddrFlag;

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

    @XmlElement(name = "AddrFlag")
    public String getAddrFlag() {
        return AddrFlag;
    }

    public void setAddrFlag(String addrFlag) {
        AddrFlag = addrFlag;
    }





    @Override
    public String toString() {
        try {
            JAXBContext context = JAXBContext.newInstance(BatchTransferDetailRequest.class);
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
