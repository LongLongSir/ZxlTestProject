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
 * 单笔转账指令查询请求类
 * @author zhuyuchao
 * @date 2020/7/10
 */
@XmlRootElement(name = "Result")
public class SingleTransferQueryRequset {
    /**
     * 转账凭证号 使用4004接口上送的ThirdVoucher或者4014上送的SThirdVoucher
     */
    private String OrigThirdVoucher;

    /**
     * 银行流水号
     */
    private String OrigFrontLogNo;

    @XmlElement(name = "OrigThirdVoucher")
    public String getOrigThirdVoucher() {
        return OrigThirdVoucher;
    }

    public void setOrigThirdVoucher(String origThirdVoucher) {
        OrigThirdVoucher = origThirdVoucher;
    }

    @XmlElement(name = "OrigFrontLogNo")
    public String getOrigFrontLogNo() {
        return OrigFrontLogNo;
    }

    public void setOrigFrontLogNo(String origFrontLogNo) {
        OrigFrontLogNo = origFrontLogNo;
    }

    @Override
    public String toString() {
        try {
            JAXBContext context = JAXBContext.newInstance(SingleTransferQueryRequset.class);
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
