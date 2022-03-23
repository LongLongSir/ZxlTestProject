package com.differ.zxl.base.pinganbank.request;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;

/**
 * 查询交易明细请求实体类
 */
@XmlRootElement(name = "Result")
public class TransactionDetailsRequest {

    /**
     * 账号
     */

    private String AcctNo;
    /**
     * 币种
     */
    private String CcyCode;
    /**
     * 开始日期  若查询当日明细，开始、结束日期必须为当天；若查询历史明细，开始、结束日期必须是历史日期。
     */

    private String BeginDate;
    /**
     * 结束日期
     */

    private String EndDate;

    /**
     * 查询页码
     */
    private String PageNo;

    /**
     * 当日明细默认每页30条记录，支持最大每页100条，若上送PageSize>100无效，等同100；
     * 历史明细默认每页30条记录，支持最大每页1000条，若上送PageSize>1000则提示输入错误；
     * 且每次查询必须固定为此值，否则出现明细遗漏
     */
    private String PageSize;

    /**
     * 001：按交易时间降序；
     * 002：按交易时间升序；
     * 说明：
     * ①当为历史交易明细查询时，默认按照001：按交易时间降序；
     * ②当为当日明细查询时，默认按照002：按交易时间升序；
     * （注：当日明细在交易量大的情况下，必须采用正序查询，否则会导致交易遗漏和重复）
     */
    private String OrderMode;


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

    @XmlElement(name = "BeginDate")
    public String getBeginDate() {
        return BeginDate;
    }

    public void setBeginDate(String beginDate) {
        BeginDate = beginDate;
    }

    @XmlElement(name = "EndDate")
    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    @XmlElement(name = "PageNo")
    public String getPageNo() {
        return PageNo;
    }

    public void setPageNo(String pageNo) {
        PageNo = pageNo;
    }

    @XmlElement(name = "PageSize")
    public String getPageSize() {
        return PageSize;
    }

    public void setPageSize(String pageSize) {
        PageSize = pageSize;
    }

    @XmlElement(name = "OrderMode")
    public String getOrderMode() {
        return OrderMode;
    }

    public void setOrderMode(String orderMode) {
        OrderMode = orderMode;
    }

    @Override
    public String toString() {
        try {
            JAXBContext context = JAXBContext.newInstance(TransactionDetailsRequest.class);
            Marshaller marshaller = context.createMarshaller();
            // 编码格式
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
            // 是否省略xml头信息（<?xml version="1.0" encoding="gb2312" standalone="yes"?>）
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            StringWriter writer = new StringWriter();
            marshaller.marshal(this, writer);
            return writer.toString();
        } catch (JAXBException e) {
            return "";
        }
    }
}
