package com.differ.zxl.base.pinganbank;

import java.math.BigDecimal;

/**
 * @auth zhangxl
 * @date 2021/12/13
 */
public class PaymentTransferDTO {

    /**
     * 流水号
     */
    private String thirdVoucher;

    /**
     * 申请单号
     */
    private String paymentNo;

    /**
     * 收款方账户号码
     */
    private String receAccNo;
    /**
     * 收款方账户名称
     */
    private String receAccName;
    /**
     * 开户银行
     */
    private String receOpenBank;
    /**
     * 申请付款金额
     */
    private BigDecimal applyPayAmount;
    /**
     * 申请用途的字段值
     */
    private String applyPayUseName;

    /**
     *  1：行内转账  0：跨行转账
     */
    private String bankInternal;

    /**
     * 1：笛佛   2：吉客云
     */
    private Integer systemSource;

    public String getThirdVoucher() {
        return thirdVoucher;
    }

    public void setThirdVoucher(String thirdVoucher) {
        this.thirdVoucher = thirdVoucher;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getReceAccNo() {
        return receAccNo;
    }

    public void setReceAccNo(String receAccNo) {
        this.receAccNo = receAccNo;
    }

    public String getReceAccName() {
        return receAccName;
    }

    public void setReceAccName(String receAccName) {
        this.receAccName = receAccName;
    }

    public String getReceOpenBank() {
        return receOpenBank;
    }

    public void setReceOpenBank(String receOpenBank) {
        this.receOpenBank = receOpenBank;
    }

    public BigDecimal getApplyPayAmount() {
        return applyPayAmount;
    }

    public void setApplyPayAmount(BigDecimal applyPayAmount) {
        this.applyPayAmount = applyPayAmount;
    }

    public String getApplyPayUseName() {
        return applyPayUseName;
    }

    public void setApplyPayUseName(String applyPayUseName) {
        this.applyPayUseName = applyPayUseName;
    }

    public String getBankInternal() {
        return bankInternal;
    }

    public void setBankInternal(String bankInternal) {
        this.bankInternal = bankInternal;
    }

    public Integer getSystemSource() {
        return systemSource;
    }

    public void setSystemSource(Integer systemSource) {
        this.systemSource = systemSource;
    }
}
