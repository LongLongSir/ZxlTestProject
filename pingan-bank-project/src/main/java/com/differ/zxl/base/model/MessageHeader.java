package com.differ.zxl.base.model;

/**
 * @auth zhangxl
 * @date 2021/12/9
 */
public class MessageHeader {

    /**编码
     * 01：GBK缺省
     * 02：UTF8
     * 03：unicode
     * 04：iso-8859-1
     */
    private String messageEncoding;

    /**
     * 银行提供给企业的20位唯一的标识代码  Char(20)
     */
    private String identificationCode;

    /**
     * 报文数据长度  Num(10)
     */
    private Integer messageLength;

    /**
     * 交易码  Char(6)
     */
    private String interfaceCode;

    /**
     * 01：请求
     * 02：应答
     */
    private String operateType;

    /**
     * 交易日期  yyyymmdd
     */
    private String tradeDate;

    /**
     * 交易时间  hhmmss
     */
    private String tradeTime;

    /**
     * 请求方系统流水号  唯一标识一笔交易 Char(20)
     */
    private String requestContextId;

    /**
     * 返回码 Char(6)
     */
    private String responseCode;

    /**
     * 返回描述  Char(100)
     */
    private String responseDetail;

    public String getMessageEncoding() {
        return messageEncoding;
    }

    public void setMessageEncoding(String messageEncoding) {
        this.messageEncoding = messageEncoding;
    }

    public String getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }

    public Integer getMessageLength() {
        return messageLength;
    }

    public void setMessageLength(Integer messageLength) {
        this.messageLength = messageLength;
    }

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getRequestContextId() {
        return requestContextId;
    }

    public void setRequestContextId(String requestContextId) {
        this.requestContextId = requestContextId;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDetail() {
        return responseDetail;
    }

    public void setResponseDetail(String responseDetail) {
        this.responseDetail = responseDetail;
    }
}
