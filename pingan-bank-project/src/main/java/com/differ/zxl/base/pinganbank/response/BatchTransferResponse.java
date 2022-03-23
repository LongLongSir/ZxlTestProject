package com.differ.zxl.base.pinganbank.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author zhuyuchao
 * @date 2020/7/29
 */
@XmlRootElement(name = "Result")
public class BatchTransferResponse {
    /**
     * 批量转账凭证号
     */
    private String ThirdVoucher;
    /**
     * 交易状态码
     */
    private String code;

    /**
     * 交易信息
     */
    private String message;

    @XmlElement(name = "ThirdVoucher")
    public String getThirdVoucher() {
        return ThirdVoucher;
    }

    public void setThirdVoucher(String thirdVoucher) {
        ThirdVoucher = thirdVoucher;
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
}
