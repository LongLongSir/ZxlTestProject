/**
 * Copyright(C) 2020 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
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
import java.util.List;

/**
 * 交易明细查询 ebank节点
 */
@XmlRootElement(name = "Result")
public class TransactionDetailsResponse{

    /**
     * 账号
     */
    private String AcctNo;

    /**
     * 货币类型
     */
    private String CcyCode;
    /**
     * 数据结束标志
     * “Y”---表示查询结果已全部输出完毕；
     * “N”---表示查询结果只输出一部分，后续部分有待请求输出；
     */
    private String EndFlag;
    /**
     * 预留字段
     */
    private String Reserve;
    /**
     * 查询页码
     */
    private String PageNo;
    /**
     * 记录笔数
     */
    private String PageRecCount;
    /**
     * 明细记录
     */
    private List<TransactionDetailsResponseData> list;
    /**
     * 交易状态码
     */
    private String code;

    /**
     * 交易信息
     */
    private String message;




    @XmlElement(name = "AcctNo")
    public String getAcctNo() {
        return AcctNo;
    }

    public void setAcctNo(String acctNo) {
        AcctNo = acctNo;
    }

    @XmlElement(name = "CcyCode")
    public String getCcyCode() {
        return CcyCode;
    }

    public void setCcyCode(String ccyCode) {
        CcyCode = ccyCode;
    }

    @XmlElement(name = "EndFlag")
    public String getEndFlag() {
        return EndFlag;
    }

    public void setEndFlag(String endFlag) {
        EndFlag = endFlag;
    }

    @XmlElement(name = "Reserve")
    public String getReserve() {
        return Reserve;
    }

    public void setReserve(String reserve) {
        Reserve = reserve;
    }

    @XmlElement(name = "PageNo")
    public String getPageNo() {
        return PageNo;
    }

    public void setPageNo(String pageNo) {
        PageNo = pageNo;
    }

    @XmlElement(name = "PageRecCount")
    public String getPageRecCount() {
        return PageRecCount;
    }

    public void setPageRecCount(String pageRecCount) {
        PageRecCount = pageRecCount;
    }

    @XmlElement(name = "list")
    public List<TransactionDetailsResponseData> getList() {
        return list;
    }

    public void setList(List<TransactionDetailsResponseData> list) {
        this.list = list;
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
            JAXBContext context = JAXBContext.newInstance(TransactionDetailsResponse.class);
            Marshaller marshaller = context.createMarshaller();
            // 编码格式
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
            // 是否省略xml头信息（<?xml version="1.0" encoding="gb2312" standalone="yes"?>）
            // 不能省略，document格式xml文件需要获取编码方式
            StringWriter writer = new StringWriter();
            marshaller.marshal(this, writer);
            //  杭州银行失败返回<output></output>，接收之后去验签入参格式变为<output/>，需要格式化为标准格式<output></output>
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
