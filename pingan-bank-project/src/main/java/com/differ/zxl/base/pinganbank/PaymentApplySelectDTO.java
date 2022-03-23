
package com.differ.zxl.base.pinganbank;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 毛海龙
 * @since 2019/4/20 13:34
 */
public class PaymentApplySelectDTO implements Serializable {

    private String billDateDefultHead;

    public String getBillDateDefultHead() {
        return billDateDefultHead;
    }

    public void setBillDateDefultHead(String billDateDefultHead) {
        this.billDateDefultHead = billDateDefultHead;
    }

    private static final long serialVersionUID = -153952223533911681L;
    /**
     * 申请人名称
     */
    private String applicantName;
    /**
     * 申请人名称表头
     */
    private String applicantNameHead;
    /**
     * 申请人id
     */
    private Long applicantId;
    /**
     * 银行支付批次流水号
     */
    private String batchBusinessNumber;
    /**
     * 主键id
     */
    private String paymentIds;
    /**
     * 主键id
     */
    private Long paymentId;
    /**
     * 付款方公司id
     **/
    private Long payCompanyId;
    /**
     * 付款方的公司名称
     */
    private String payCompanyName;
    /**
     * 付款方账户类型
     **/
    private String payAcctypeCode;
    /**
     * 付款账户类型名称
     */
    private String payAcctypeName;
    /**
     * 付款方账户id
     **/
    private Integer payAccId;
    /**
     * 付款账户名称
     */
    private String payAccName;
    /**
     * 付款账户账号
     */
    private String payAccNo;
    /**
     * 角色 0-其他 1-客户 2-供应商 4-员工
     **/
    private Byte receRoleType;
    /**
     * 客户供应商id
     **/
    private Long receId;
    /**
     * 申请单号
     **/
    private String paymentNo;
    /**
     * 申请人名称
     **/
    private String applyUserName;
    /**
     * 申请开始日期
     **/
    private String startApplyDate;
    /**
     * 申请结束日期
     **/
    private String endApplyDate;
    /**
     * 申请部门
     **/
    private Long applyDepartId;
    /**
     * 用途编码
     **/
    private String applyPayUseCode;
    /**
     * 用款开始日期
     **/
    private String startApplyPayDate;
    /**
     * 用款结束日期
     **/
    private String endApplyPayDate;
    /**
     * 申请来源00=手工33=采购结算单41=售后结算单22=应付单
     **/
    private String applySourceCode;
    /**
     * 申请来源系统单据号
     **/
    private String applySourceBillno;
    /**
     * 申请来源系统单据号批量
     **/
    private String applySourceBillnos;
    /**
     * 单据状态 0=草稿1=待审核（已递交）2=已审核3=已完成4=已关闭
     **/
    private Byte status;
    /**
     * 单据状态字符串 0=草稿1=待审核（已递交）2=已审核3=已完成4=已关闭
     **/
    private String statusStr;
    /**
     * 递交人名称
     **/
    private String submitUserName;
    /**
     * 递交开始时间
     */
    private String startSubmitDate;
    /**
     * 递交结束时间
     */
    private String endSubmitDate;
    /**
     * 审核人
     */
    private String auditUserName;
    /**
     * 审核开始时间
     */
    private String startAuditDate;
    /**
     * 审核结束时间
     */
    private String endAuditDate;
    /**
     * 付款人
     */
    private String actualPayUserName;
    /**
     * 开始付款时间
     */
    private String startActualPayDate;

    /**
     * 结束付款时间
     */
    private String endActualPayDate;
    /**
     * 申请金额
     */
    private BigDecimal startApplyPayAmount;
    /**
     * 申请金额
     */
    private BigDecimal endApplyPayAmount;
    /**
     * 申请付款金额
     */
    private BigDecimal applyPayAmount;
    /**
     * 收款账户类型
     */
    private String receAcctypeCode;
    /**
     * 申请单状态 0-付款执行中，1-已付款
     */
    private Byte applyBillStatus;
    /**
     * 标记
     */
    private String flagData;
    /**
     * 收款方账户号码
     */
    private String receAccNo;
    /**
     * 收款方账户名称
     */
    private String receAccName;
    /**
     * 收款方账户类型名
     */
    private String receAcctypeName;
    /**
     * 开户银行
     */
    private String receOpenBank;
    /**
     * 往来单位名称
     */
    private String receName;
    /**
     * 币种code
     */
    private String currencyCode;
    /**
     * 币种名称
     */
    private String currencyName;
    /**
     * 付款备注
     */
    private String payRemark;
    /**
     * 用款日期
     */
    private String applyPayDate;

    /**
     * 申请用途的字典code
     */
    private String applyAayUseCode;

    /**
     * 申请用途的字段值
     */
    private String applyPayUseName;
    /**
     * 付款人id
     */
    private Long actualPayUserId;
    /**
     * 付款时间
     */
    private Date actualPayDate;
    /**
     * 实际付款金额
     */
    private BigDecimal actualPayAmount;

    /**
     * 在线支付，业务参考号
     */
    private String businessReferenceNo;

    private Byte payStatus;

    /**
     * 申请单号批量
     **/
    private String paymentNos;

    /**
     * 银行编码
     */
    private String bankCode;
    /**
     * 银行名称
     */
    private String bankName;
    /**
     * 国际银行帐户号码
     */
    private String internationalBankAccount;
    /**
     * 银行国际代码
     */
    private String swiftCode;
    /**
     * 国家地区
     */
    private String countriesRegions;
    /**
     * 汇率
     */
    private BigDecimal currencyRate;

    /**
     * 平安银行支付方式 1-普通支付 2-快捷支付
     */
    private Byte paymentType;

    private Integer pageIndex;

    private Integer pageSize;

    /**
     * 业务模式（模式编号)
     */
    private String busMod;

    /**
     * 结算通道
     * G 普通
     * Q 快速
     * R 实时
     */
    private String settleChannel;

    /**
     * 开户行地址
     */
    private String accountBankAddress;

    /**
     * 银行联行号
     */
    private String associateBankNumber;

    /**
     * 打印状态 0-未打印 1-打印过
     **/
    private Byte printStatus;

    /**
     * 打印状态多选
     **/
    private String printStatusStr;

    private String printStatusHead;

    public String getPrintStatusHead() {
        return printStatusHead;
    }

    public void setPrintStatusHead(String printStatusHead) {
        this.printStatusHead = printStatusHead;
    }

    public Byte getPrintStatus() {
        return printStatus;
    }

    public void setPrintStatus(Byte printStatus) {
        this.printStatus = printStatus;
    }

    public String getPrintStatusStr() {
        return printStatusStr;
    }

    public void setPrintStatusStr(String printStatusStr) {
        this.printStatusStr = printStatusStr;
    }

    public String getBusMod() {
        return busMod;
    }


    public String getApplySourceBillnos() {
        return applySourceBillnos;
    }

    public void setApplySourceBillnos(String applySourceBillnos) {
        this.applySourceBillnos = applySourceBillnos;
    }

    public String getPaymentNos() {
        return paymentNos;
    }

    public void setPaymentNos(String paymentNos) {
        this.paymentNos = paymentNos;
    }


    public String getAccountBankAddress() {
        return accountBankAddress;
    }

    public void setAccountBankAddress(String accountBankAddress) {
        this.accountBankAddress = accountBankAddress;
    }

    public String getAssociateBankNumber() {
        return associateBankNumber;
    }

    public void setAssociateBankNumber(String associateBankNumber) {
        this.associateBankNumber = associateBankNumber;
    }

    public String getSettleChannel() {
        return settleChannel;
    }

    public void setSettleChannel(String settleChannel) {
        this.settleChannel = settleChannel;
    }

    public void setBusMod(String busMod) {
        this.busMod = busMod;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Byte getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Byte paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(BigDecimal currencyRate) {
        this.currencyRate = currencyRate;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantNameHead() {
        return applicantNameHead;
    }

    public void setApplicantNameHead(String applicantNameHead) {
        this.applicantNameHead = applicantNameHead;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getInternationalBankAccount() {
        return internationalBankAccount;
    }

    public void setInternationalBankAccount(String internationalBankAccount) {
        this.internationalBankAccount = internationalBankAccount;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getCountriesRegions() {
        return countriesRegions;
    }

    public void setCountriesRegions(String countriesRegions) {
        this.countriesRegions = countriesRegions;
    }

//    /**
//     * 招行支付响应报文
//     */
//    private CmbPayResponseRoot cmbPayResponseRoot;
//    /**
//     * 支付宝支付响应报文
//     */
//    private TransferAccountResponse transferAccountResponse;
//    /**
//     * 杭州银行支付提交响应报文
//     */
//    private PaymentSubmitPayResponseData paymentSubmitPayResponseData;
//    /**
//     * 杭州银行支付提交响应报文
//     */
//    private PaymentSubmitPayResponse paymentSubmitPayResponse;

    /**
     * 系统标记 财务自定义
     */
    private String sysFlagIds;
    /**
     * 交易流水号
     */
    private String payTranNo;
    /**
     * 付款账户名
     */
    private String accOwner;
    /**
     * 来源单据id
     */
    private Long sourceBillId;
    /**
     * 付款执行支付方式 1-支付宝 2-招商银行 3-杭州银行
     */
    private Byte payWay;

    /**
     * 转账凭证号
     */
    private String thirdVoucher;

    private String payCompanyIdHead;
    private String payAccNameHead;
    private String receNameHead;
    private String paymentNoHead;
    private String applyPayDateHead;
    private String currencyCodeHead;
    private String applyPayAmountHead;
    private String applyDepartNameHead;
    private String applyPayUseCodeHead;
    private String applyUserNameHead;
    private String applyDateHead;
    private String flagDataHead;
    private String applyPayRemarkHead;
    private String statusHead;
    private String applySourceCodeHead;
    private String submitUserNameHead;
    private String submitDateHead;
    private String auditUserNameHead;
    private String auditDateHead;
    private String currencyRateHead;
    private String actualPayUserNameHead;
    private String actualPayDateHead;
    private String payTranNoHead;
    private String payOrderNoHead;
    private String payRemarkHead;
    private String applyPayCuAmountHead;
    private String payAccIdHead;
    private String receAcctypeNameHead;
    private String receOpenBankHead;
    private String receAccNameHead;
    private String receAccNoHead;
    private String applyBillStatusHead;
    private String sysFlagIdsHead;
    private String bankNameHead;

    public String getThirdVoucher() {
        return thirdVoucher;
    }

    public void setThirdVoucher(String thirdVoucher) {
        this.thirdVoucher = thirdVoucher;
    }

    public String getBankNameHead() {
        return bankNameHead;
    }

    public void setBankNameHead(String bankNameHead) {
        this.bankNameHead = bankNameHead;
    }

    public Long getSourceBillId() {
        return sourceBillId;
    }

    public void setSourceBillId(Long sourceBillId) {
        this.sourceBillId = sourceBillId;
    }

    public String getPayTranNo() {
        return payTranNo;
    }

    public void setPayTranNo(String payTranNo) {
        this.payTranNo = payTranNo;
    }

    public String getSysFlagIdsHead() {
        return sysFlagIdsHead;
    }

    public void setSysFlagIdsHead(String sysFlagIdsHead) {
        this.sysFlagIdsHead = sysFlagIdsHead;
    }

    public String getSysFlagIds() {
        return sysFlagIds;
    }

    public void setSysFlagIds(String sysFlagIds) {
        this.sysFlagIds = sysFlagIds;
    }

    public String getPayAccNo() {
        return payAccNo;
    }

    public void setPayAccNo(String payAccNo) {
        this.payAccNo = payAccNo;
    }

    public Byte getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    public String getBusinessReferenceNo() {
        return businessReferenceNo;
    }

    public void setBusinessReferenceNo(String businessReferenceNo) {
        this.businessReferenceNo = businessReferenceNo;
    }

    public BigDecimal getActualPayAmount() {
        return actualPayAmount;
    }

    public void setActualPayAmount(BigDecimal actualPayAmount) {
        this.actualPayAmount = actualPayAmount;
    }

    public Date getActualPayDate() {
        return actualPayDate;
    }

    public void setActualPayDate(Date actualPayDate) {
        this.actualPayDate = actualPayDate;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getActualPayUserId() {
        return actualPayUserId;
    }

    public void setActualPayUserId(Long actualPayUserId) {
        this.actualPayUserId = actualPayUserId;
    }

    public String getPayCompanyName() {
        return payCompanyName;
    }

    public void setPayCompanyName(String payCompanyName) {
        this.payCompanyName = payCompanyName;
    }

    public String getPayAcctypeName() {
        return payAcctypeName;
    }

    public void setPayAcctypeName(String payAcctypeName) {
        this.payAcctypeName = payAcctypeName;
    }

    public String getPayAccName() {
        return payAccName;
    }

    public void setPayAccName(String payAccName) {
        this.payAccName = payAccName;
    }

    public BigDecimal getApplyPayAmount() {
        return applyPayAmount;
    }

    public void setApplyPayAmount(BigDecimal applyPayAmount) {
        this.applyPayAmount = applyPayAmount;
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

    public String getReceAcctypeName() {
        return receAcctypeName;
    }

    public void setReceAcctypeName(String receAcctypeName) {
        this.receAcctypeName = receAcctypeName;
    }

    public String getReceOpenBank() {
        return receOpenBank;
    }

    public void setReceOpenBank(String receOpenBank) {
        this.receOpenBank = receOpenBank;
    }

    public String getReceName() {
        return receName;
    }

    public void setReceName(String receName) {
        this.receName = receName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getPayRemark() {
        return payRemark;
    }

    public void setPayRemark(String payRemark) {
        this.payRemark = payRemark;
    }

    public String getApplyPayDate() {
        return applyPayDate;
    }

    public void setApplyPayDate(String applyPayDate) {
        this.applyPayDate = applyPayDate;
    }

    public String getApplyAayUseCode() {
        return applyAayUseCode;
    }

    public void setApplyAayUseCode(String applyAayUseCode) {
        this.applyAayUseCode = applyAayUseCode;
    }

    public String getApplyPayUseName() {
        return applyPayUseName;
    }

    public void setApplyPayUseName(String applyPayUseName) {
        this.applyPayUseName = applyPayUseName;
    }

    public String getFlagData() {
        return flagData;
    }

    public void setFlagData(String flagData) {
        this.flagData = flagData;
    }

    public Byte getApplyBillStatus() {
        return applyBillStatus;
    }

    public void setApplyBillStatus(Byte applyBillStatus) {
        this.applyBillStatus = applyBillStatus;
    }

    public String getApplyBillStatusHead() {
        return applyBillStatusHead;
    }

    public void setApplyBillStatusHead(String applyBillStatusHead) {
        this.applyBillStatusHead = applyBillStatusHead;
    }

    /**
     * @return the payCompanyId
     */
    public Long getPayCompanyId() {
        return payCompanyId;
    }

    /**
     * @param payCompanyId the payCompanyId to set
     */
    public void setPayCompanyId(Long payCompanyId) {
        this.payCompanyId = payCompanyId;
    }

    /**
     * @return the payAcctypeCode
     */
    public String getPayAcctypeCode() {
        return payAcctypeCode;
    }

    /**
     * @param payAcctypeCode the payAcctypeCode to set
     */
    public void setPayAcctypeCode(String payAcctypeCode) {
        this.payAcctypeCode = payAcctypeCode;
    }

    /**
     * @return the payAccId
     */
    public Integer getPayAccId() {
        return payAccId;
    }

    /**
     * @param payAccId the payAccId to set
     */
    public void setPayAccId(Integer payAccId) {
        this.payAccId = payAccId;
    }

    /**
     * @return the receRoleType
     */
    public Byte getReceRoleType() {
        return receRoleType;
    }

    /**
     * @param receRoleType the receRoleType to set
     */
    public void setReceRoleType(Byte receRoleType) {
        this.receRoleType = receRoleType;
    }

    /**
     * @return the receId
     */
    public Long getReceId() {
        return receId;
    }

    /**
     * @param receId the receId to set
     */
    public void setReceId(Long receId) {
        this.receId = receId;
    }

    /**
     * @return the paymentNo
     */
    public String getPaymentNo() {
        return paymentNo;
    }

    /**
     * @param paymentNo the paymentNo to set
     */
    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    /**
     * @return the applyUserName
     */
    public String getApplyUserName() {
        return applyUserName;
    }

    /**
     * @param applyUserName the applyUserName to set
     */
    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    /**
     * @return the startApplyDate
     */
    public String getStartApplyDate() {
        return startApplyDate;
    }

    /**
     * @param startApplyDate the startApplyDate to set
     */
    public void setStartApplyDate(String startApplyDate) {
        this.startApplyDate = startApplyDate;
    }

    /**
     * @return the endApplyDate
     */
    public String getEndApplyDate() {
        return endApplyDate;
    }

    /**
     * @param endApplyDate the endApplyDate to set
     */
    public void setEndApplyDate(String endApplyDate) {
        this.endApplyDate = endApplyDate;
    }

    /**
     * @return the applyDepartId
     */
    public Long getApplyDepartId() {
        return applyDepartId;
    }

    /**
     * @param applyDepartId the applyDepartId to set
     */
    public void setApplyDepartId(Long applyDepartId) {
        this.applyDepartId = applyDepartId;
    }

    /**
     * @return the applyPayUseCode
     */
    public String getApplyPayUseCode() {
        return applyPayUseCode;
    }

    /**
     * @param applyPayUseCode the applyPayUseCode to set
     */
    public void setApplyPayUseCode(String applyPayUseCode) {
        this.applyPayUseCode = applyPayUseCode;
    }

    /**
     * @return the startApplyPayDate
     */
    public String getStartApplyPayDate() {
        return startApplyPayDate;
    }

    /**
     * @param startApplyPayDate the startApplyPayDate to set
     */
    public void setStartApplyPayDate(String startApplyPayDate) {
        this.startApplyPayDate = startApplyPayDate;
    }

    /**
     * @return the endApplyPayDate
     */
    public String getEndApplyPayDate() {
        return endApplyPayDate;
    }

    /**
     * @param endApplyPayDate the endApplyPayDate to set
     */
    public void setEndApplyPayDate(String endApplyPayDate) {
        this.endApplyPayDate = endApplyPayDate;
    }

    /**
     * @return the applySourceCode
     */
    public String getApplySourceCode() {
        return applySourceCode;
    }

    /**
     * @param applySourceCode the applySourceCode to set
     */
    public void setApplySourceCode(String applySourceCode) {
        this.applySourceCode = applySourceCode;
    }

    /**
     * @return the applySourceBillno
     */
    public String getApplySourceBillno() {
        return applySourceBillno;
    }

    /**
     * @param applySourceBillno the applySourceBillno to set
     */
    public void setApplySourceBillno(String applySourceBillno) {
        this.applySourceBillno = applySourceBillno;
    }

    /**
     * @return the status
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * @return the statusStr
     */
    public String getStatusStr() {
        return statusStr;
    }

    /**
     * @param statusStr the statusStr to set
     */
    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    /**
     * @return the submitUserName
     */
    public String getSubmitUserName() {
        return submitUserName;
    }

    /**
     * @param submitUserName the submitUserName to set
     */
    public void setSubmitUserName(String submitUserName) {
        this.submitUserName = submitUserName;
    }

    /**
     * @return the startSubmitDate
     */
    public String getStartSubmitDate() {
        return startSubmitDate;
    }

    /**
     * @param startSubmitDate the startSubmitDate to set
     */
    public void setStartSubmitDate(String startSubmitDate) {
        this.startSubmitDate = startSubmitDate;
    }

    /**
     * @return the endSubmitDate
     */
    public String getEndSubmitDate() {
        return endSubmitDate;
    }

    /**
     * @param endSubmitDate the endSubmitDate to set
     */
    public void setEndSubmitDate(String endSubmitDate) {
        this.endSubmitDate = endSubmitDate;
    }

    /**
     * @return the auditUserName
     */
    public String getAuditUserName() {
        return auditUserName;
    }

    /**
     * @param auditUserName the auditUserName to set
     */
    public void setAuditUserName(String auditUserName) {
        this.auditUserName = auditUserName;
    }

    /**
     * @return the startAuditDate
     */
    public String getStartAuditDate() {
        return startAuditDate;
    }

    /**
     * @param startAuditDate the startAuditDate to set
     */
    public void setStartAuditDate(String startAuditDate) {
        this.startAuditDate = startAuditDate;
    }

    /**
     * @return the endAuditDate
     */
    public String getEndAuditDate() {
        return endAuditDate;
    }

    /**
     * @param endAuditDate the endAuditDate to set
     */
    public void setEndAuditDate(String endAuditDate) {
        this.endAuditDate = endAuditDate;
    }

    /**
     * @return the payCompanyIdHead
     */
    public String getPayCompanyIdHead() {
        return payCompanyIdHead;
    }

    /**
     * @param payCompanyIdHead the payCompanyIdHead to set
     */
    public void setPayCompanyIdHead(String payCompanyIdHead) {
        this.payCompanyIdHead = payCompanyIdHead;
    }

    /**
     * @return the payAccNameHead
     */
    public String getPayAccNameHead() {
        return payAccNameHead;
    }

    /**
     * @param payAccNameHead the payAccNameHead to set
     */
    public void setPayAccNameHead(String payAccNameHead) {
        this.payAccNameHead = payAccNameHead;
    }

    /**
     * @return the receNameHead
     */
    public String getReceNameHead() {
        return receNameHead;
    }

    /**
     * @param receNameHead the receNameHead to set
     */
    public void setReceNameHead(String receNameHead) {
        this.receNameHead = receNameHead;
    }

    /**
     * @return the paymentNoHead
     */
    public String getPaymentNoHead() {
        return paymentNoHead;
    }

    /**
     * @param paymentNoHead the paymentNoHead to set
     */
    public void setPaymentNoHead(String paymentNoHead) {
        this.paymentNoHead = paymentNoHead;
    }

    /**
     * @return the applyPayDateHead
     */
    public String getApplyPayDateHead() {
        return applyPayDateHead;
    }

    /**
     * @param applyPayDateHead the applyPayDateHead to set
     */
    public void setApplyPayDateHead(String applyPayDateHead) {
        this.applyPayDateHead = applyPayDateHead;
    }

    /**
     * @return the currencyCodeHead
     */
    public String getCurrencyCodeHead() {
        return currencyCodeHead;
    }

    /**
     * @param currencyCodeHead the currencyCodeHead to set
     */
    public void setCurrencyCodeHead(String currencyCodeHead) {
        this.currencyCodeHead = currencyCodeHead;
    }

    /**
     * @return the applyPayAmountHead
     */
    public String getApplyPayAmountHead() {
        return applyPayAmountHead;
    }

    /**
     * @param applyPayAmountHead the applyPayAmountHead to set
     */
    public void setApplyPayAmountHead(String applyPayAmountHead) {
        this.applyPayAmountHead = applyPayAmountHead;
    }

    /**
     * @return the applyDepartNameHead
     */
    public String getApplyDepartNameHead() {
        return applyDepartNameHead;
    }

    /**
     * @param applyDepartNameHead the applyDepartNameHead to set
     */
    public void setApplyDepartNameHead(String applyDepartNameHead) {
        this.applyDepartNameHead = applyDepartNameHead;
    }

    /**
     * @return the applyPayUseCodeHead
     */
    public String getApplyPayUseCodeHead() {
        return applyPayUseCodeHead;
    }

    /**
     * @param applyPayUseCodeHead the applyPayUseCodeHead to set
     */
    public void setApplyPayUseCodeHead(String applyPayUseCodeHead) {
        this.applyPayUseCodeHead = applyPayUseCodeHead;
    }

    /**
     * @return the applyUserNameHead
     */
    public String getApplyUserNameHead() {
        return applyUserNameHead;
    }

    /**
     * @param applyUserNameHead the applyUserNameHead to set
     */
    public void setApplyUserNameHead(String applyUserNameHead) {
        this.applyUserNameHead = applyUserNameHead;
    }

    /**
     * @return the applyDateHead
     */
    public String getApplyDateHead() {
        return applyDateHead;
    }

    /**
     * @param applyDateHead the applyDateHead to set
     */
    public void setApplyDateHead(String applyDateHead) {
        this.applyDateHead = applyDateHead;
    }

    /**
     * @return the flagDataHead
     */
    public String getFlagDataHead() {
        return flagDataHead;
    }

    /**
     * @param flagDataHead the flagDataHead to set
     */
    public void setFlagDataHead(String flagDataHead) {
        this.flagDataHead = flagDataHead;
    }

    /**
     * @return the applyPayRemarkHead
     */
    public String getApplyPayRemarkHead() {
        return applyPayRemarkHead;
    }

    /**
     * @param applyPayRemarkHead the applyPayRemarkHead to set
     */
    public void setApplyPayRemarkHead(String applyPayRemarkHead) {
        this.applyPayRemarkHead = applyPayRemarkHead;
    }

    /**
     * @return the statusHead
     */
    public String getStatusHead() {
        return statusHead;
    }

    /**
     * @param statusHead the statusHead to set
     */
    public void setStatusHead(String statusHead) {
        this.statusHead = statusHead;
    }

    /**
     * @return the applySourceCodeHead
     */
    public String getApplySourceCodeHead() {
        return applySourceCodeHead;
    }

    /**
     * @param applySourceCodeHead the applySourceCodeHead to set
     */
    public void setApplySourceCodeHead(String applySourceCodeHead) {
        this.applySourceCodeHead = applySourceCodeHead;
    }

    /**
     * @return the submitUserNameHead
     */
    public String getSubmitUserNameHead() {
        return submitUserNameHead;
    }

    /**
     * @param submitUserNameHead the submitUserNameHead to set
     */
    public void setSubmitUserNameHead(String submitUserNameHead) {
        this.submitUserNameHead = submitUserNameHead;
    }

    /**
     * @return the submitDateHead
     */
    public String getSubmitDateHead() {
        return submitDateHead;
    }

    /**
     * @param submitDateHead the submitDateHead to set
     */
    public void setSubmitDateHead(String submitDateHead) {
        this.submitDateHead = submitDateHead;
    }

    /**
     * @return the auditUserNameHead
     */
    public String getAuditUserNameHead() {
        return auditUserNameHead;
    }

    /**
     * @param auditUserNameHead the auditUserNameHead to set
     */
    public void setAuditUserNameHead(String auditUserNameHead) {
        this.auditUserNameHead = auditUserNameHead;
    }

    /**
     * @return the auditDateHead
     */
    public String getAuditDateHead() {
        return auditDateHead;
    }

    /**
     * @param auditDateHead the auditDateHead to set
     */
    public void setAuditDateHead(String auditDateHead) {
        this.auditDateHead = auditDateHead;
    }

    /**
     * @return the actualPayUserName
     */
    public String getActualPayUserName() {
        return actualPayUserName;
    }

    /**
     * @param actualPayUserName the actualPayUserName to set
     */
    public void setActualPayUserName(String actualPayUserName) {
        this.actualPayUserName = actualPayUserName;
    }

    /**
     * @return the startActualPayDate
     */
    public String getStartActualPayDate() {
        return startActualPayDate;
    }

    /**
     * @param startActualPayDate the startActualPayDate to set
     */
    public void setStartActualPayDate(String startActualPayDate) {
        this.startActualPayDate = startActualPayDate;
    }

    /**
     * @return the endActualPayDate
     */
    public String getEndActualPayDate() {
        return endActualPayDate;
    }

    /**
     * @param endActualPayDate the endActualPayDate to set
     */
    public void setEndActualPayDate(String endActualPayDate) {
        this.endActualPayDate = endActualPayDate;
    }

    /**
     * @return the startApplyPayAmount
     */
    public BigDecimal getStartApplyPayAmount() {
        return startApplyPayAmount;
    }

    /**
     * @param startApplyPayAmount the startApplyPayAmount to set
     */
    public void setStartApplyPayAmount(BigDecimal startApplyPayAmount) {
        this.startApplyPayAmount = startApplyPayAmount;
    }

    /**
     * @return the endApplyPayAmount
     */
    public BigDecimal getEndApplyPayAmount() {
        return endApplyPayAmount;
    }

    /**
     * @param endApplyPayAmount the endApplyPayAmount to set
     */
    public void setEndApplyPayAmount(BigDecimal endApplyPayAmount) {
        this.endApplyPayAmount = endApplyPayAmount;
    }

    /**
     * @return the actualPayUserNameHead
     */
    public String getActualPayUserNameHead() {
        return actualPayUserNameHead;
    }

    /**
     * @param actualPayUserNameHead the actualPayUserNameHead to set
     */
    public void setActualPayUserNameHead(String actualPayUserNameHead) {
        this.actualPayUserNameHead = actualPayUserNameHead;
    }

    /**
     * @return the actualPayDateHead
     */
    public String getActualPayDateHead() {
        return actualPayDateHead;
    }

    /**
     * @param actualPayDateHead the actualPayDateHead to set
     */
    public void setActualPayDateHead(String actualPayDateHead) {
        this.actualPayDateHead = actualPayDateHead;
    }

    /**
     * @return the currencyRateHead
     */
    public String getCurrencyRateHead() {
        return currencyRateHead;
    }

    /**
     * @param currencyRateHead the currencyRateHead to set
     */
    public void setCurrencyRateHead(String currencyRateHead) {
        this.currencyRateHead = currencyRateHead;
    }

    /**
     * @return the payTranNoHead
     */
    public String getPayTranNoHead() {
        return payTranNoHead;
    }

    /**
     * @param payTranNoHead the payTranNoHead to set
     */
    public void setPayTranNoHead(String payTranNoHead) {
        this.payTranNoHead = payTranNoHead;
    }

    /**
     * @return the payOrderNoHead
     */
    public String getPayOrderNoHead() {
        return payOrderNoHead;
    }

    /**
     * @param payOrderNoHead the payOrderNoHead to set
     */
    public void setPayOrderNoHead(String payOrderNoHead) {
        this.payOrderNoHead = payOrderNoHead;
    }

    /**
     * @return the payRemarkHead
     */
    public String getPayRemarkHead() {
        return payRemarkHead;
    }

    /**
     * @param payRemarkHead the payRemarkHead to set
     */
    public void setPayRemarkHead(String payRemarkHead) {
        this.payRemarkHead = payRemarkHead;
    }

    /**
     * @return the applyPayCuAmountHead
     */
    public String getApplyPayCuAmountHead() {
        return applyPayCuAmountHead;
    }

    /**
     * @param applyPayCuAmountHead the applyPayCuAmountHead to set
     */
    public void setApplyPayCuAmountHead(String applyPayCuAmountHead) {
        this.applyPayCuAmountHead = applyPayCuAmountHead;
    }

    /**
     * @return the payAccIdHead
     */
    public String getPayAccIdHead() {
        return payAccIdHead;
    }

    /**
     * @param payAccIdHead the payAccIdHead to set
     */
    public void setPayAccIdHead(String payAccIdHead) {
        this.payAccIdHead = payAccIdHead;
    }

    /**
     * @return the receAcctypeCode
     */
    public String getReceAcctypeCode() {
        return receAcctypeCode;
    }

    /**
     * @param receAcctypeCode the receAcctypeCode to set
     */
    public void setReceAcctypeCode(String receAcctypeCode) {
        this.receAcctypeCode = receAcctypeCode;
    }

    /**
     * @return the receAcctypeNameHead
     */
    public String getReceAcctypeNameHead() {
        return receAcctypeNameHead;
    }

    /**
     * @param receAcctypeNameHead the receAcctypeNameHead to set
     */
    public void setReceAcctypeNameHead(String receAcctypeNameHead) {
        this.receAcctypeNameHead = receAcctypeNameHead;
    }

    /**
     * @return the paymentIds
     */
    public String getPaymentIds() {
        return paymentIds;
    }

    /**
     * @param paymentIds the paymentIds to set
     */
    public void setPaymentIds(String paymentIds) {
        this.paymentIds = paymentIds;
    }

    /**
     * @return the receOpenBankHead
     */
    public String getReceOpenBankHead() {
        return receOpenBankHead;
    }

    /**
     * @param receOpenBankHead the receOpenBankHead to set
     */
    public void setReceOpenBankHead(String receOpenBankHead) {
        this.receOpenBankHead = receOpenBankHead;
    }

    /**
     * @return the receAccNameHead
     */
    public String getReceAccNameHead() {
        return receAccNameHead;
    }

    /**
     * @param receAccNameHead the receAccNameHead to set
     */
    public void setReceAccNameHead(String receAccNameHead) {
        this.receAccNameHead = receAccNameHead;
    }

    /**
     * @return the receAccNoHead
     */
    public String getReceAccNoHead() {
        return receAccNoHead;
    }

    /**
     * @param receAccNoHead the receAccNoHead to set
     */
    public void setReceAccNoHead(String receAccNoHead) {
        this.receAccNoHead = receAccNoHead;
    }

    public String getAccOwner() {
        return accOwner;
    }

    public void setAccOwner(String accOwner) {
        this.accOwner = accOwner;
    }

    public Byte getPayWay() {
        return payWay;
    }

    public void setPayWay(Byte payWay) {
        this.payWay = payWay;
    }

    public String getBatchBusinessNumber() {
        return batchBusinessNumber;
    }

    public void setBatchBusinessNumber(String batchBusinessNumber) {
        this.batchBusinessNumber = batchBusinessNumber;
    }

    /**
     * @return
     * @author 毛海龙
     * @date 2019年7月4日 上午9:54:29
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentApplySelectDTO{");
        sb.append("applicantName='").append(applicantName).append('\'');
        sb.append(", applicantNameHead='").append(applicantNameHead).append('\'');
        sb.append(", applicantId=").append(applicantId);
        sb.append(", batchBusinessNumber='").append(batchBusinessNumber).append('\'');
        sb.append(", paymentIds='").append(paymentIds).append('\'');
        sb.append(", paymentId=").append(paymentId);
        sb.append(", payCompanyId=").append(payCompanyId);
        sb.append(", payCompanyName='").append(payCompanyName).append('\'');
        sb.append(", payAcctypeCode='").append(payAcctypeCode).append('\'');
        sb.append(", payAcctypeName='").append(payAcctypeName).append('\'');
        sb.append(", payAccId=").append(payAccId);
        sb.append(", payAccName='").append(payAccName).append('\'');
        sb.append(", payAccNo='").append(payAccNo).append('\'');
        sb.append(", receRoleType=").append(receRoleType);
        sb.append(", receId=").append(receId);
        sb.append(", paymentNo='").append(paymentNo).append('\'');
        sb.append(", applyUserName='").append(applyUserName).append('\'');
        sb.append(", startApplyDate='").append(startApplyDate).append('\'');
        sb.append(", endApplyDate='").append(endApplyDate).append('\'');
        sb.append(", applyDepartId=").append(applyDepartId);
        sb.append(", applyPayUseCode='").append(applyPayUseCode).append('\'');
        sb.append(", startApplyPayDate='").append(startApplyPayDate).append('\'');
        sb.append(", endApplyPayDate='").append(endApplyPayDate).append('\'');
        sb.append(", applySourceCode='").append(applySourceCode).append('\'');
        sb.append(", applySourceBillno='").append(applySourceBillno).append('\'');
        sb.append(", applySourceBillnos='").append(applySourceBillnos).append('\'');
        sb.append(", status=").append(status);
        sb.append(", statusStr='").append(statusStr).append('\'');
        sb.append(", submitUserName='").append(submitUserName).append('\'');
        sb.append(", startSubmitDate='").append(startSubmitDate).append('\'');
        sb.append(", endSubmitDate='").append(endSubmitDate).append('\'');
        sb.append(", auditUserName='").append(auditUserName).append('\'');
        sb.append(", startAuditDate='").append(startAuditDate).append('\'');
        sb.append(", endAuditDate='").append(endAuditDate).append('\'');
        sb.append(", actualPayUserName='").append(actualPayUserName).append('\'');
        sb.append(", startActualPayDate='").append(startActualPayDate).append('\'');
        sb.append(", endActualPayDate='").append(endActualPayDate).append('\'');
        sb.append(", startApplyPayAmount=").append(startApplyPayAmount);
        sb.append(", endApplyPayAmount=").append(endApplyPayAmount);
        sb.append(", applyPayAmount=").append(applyPayAmount);
        sb.append(", receAcctypeCode='").append(receAcctypeCode).append('\'');
        sb.append(", applyBillStatus=").append(applyBillStatus);
        sb.append(", flagData='").append(flagData).append('\'');
        sb.append(", receAccNo='").append(receAccNo).append('\'');
        sb.append(", receAccName='").append(receAccName).append('\'');
        sb.append(", receAcctypeName='").append(receAcctypeName).append('\'');
        sb.append(", receOpenBank='").append(receOpenBank).append('\'');
        sb.append(", receName='").append(receName).append('\'');
        sb.append(", currencyCode='").append(currencyCode).append('\'');
        sb.append(", currencyName='").append(currencyName).append('\'');
        sb.append(", payRemark='").append(payRemark).append('\'');
        sb.append(", applyPayDate='").append(applyPayDate).append('\'');
        sb.append(", applyAayUseCode='").append(applyAayUseCode).append('\'');
        sb.append(", applyPayUseName='").append(applyPayUseName).append('\'');
        sb.append(", actualPayUserId=").append(actualPayUserId);
        sb.append(", actualPayDate=").append(actualPayDate);
        sb.append(", actualPayAmount=").append(actualPayAmount);
        sb.append(", businessReferenceNo='").append(businessReferenceNo).append('\'');
        sb.append(", payStatus=").append(payStatus);
        sb.append(", paymentNos='").append(paymentNos).append('\'');
        sb.append(", bankCode='").append(bankCode).append('\'');
        sb.append(", bankName='").append(bankName).append('\'');
        sb.append(", internationalBankAccount='").append(internationalBankAccount).append('\'');
        sb.append(", swiftCode='").append(swiftCode).append('\'');
        sb.append(", countriesRegions='").append(countriesRegions).append('\'');
        sb.append(", currencyRate=").append(currencyRate);
        sb.append(", paymentType=").append(paymentType);
        sb.append(", pageIndex=").append(pageIndex);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", busMod='").append(busMod).append('\'');
        sb.append(", settleChannel='").append(settleChannel).append('\'');
//        sb.append(", cmbPayResponseRoot=").append(cmbPayResponseRoot);
//        sb.append(", transferAccountResponse=").append(transferAccountResponse);
//        sb.append(", paymentSubmitPayResponseData=").append(paymentSubmitPayResponseData);
//        sb.append(", paymentSubmitPayResponse=").append(paymentSubmitPayResponse);
        sb.append(", sysFlagIds='").append(sysFlagIds).append('\'');
        sb.append(", payTranNo='").append(payTranNo).append('\'');
        sb.append(", accOwner='").append(accOwner).append('\'');
        sb.append(", sourceBillId=").append(sourceBillId);
        sb.append(", payWay=").append(payWay);
        sb.append(", payCompanyIdHead='").append(payCompanyIdHead).append('\'');
        sb.append(", payAccNameHead='").append(payAccNameHead).append('\'');
        sb.append(", receNameHead='").append(receNameHead).append('\'');
        sb.append(", paymentNoHead='").append(paymentNoHead).append('\'');
        sb.append(", applyPayDateHead='").append(applyPayDateHead).append('\'');
        sb.append(", currencyCodeHead='").append(currencyCodeHead).append('\'');
        sb.append(", applyPayAmountHead='").append(applyPayAmountHead).append('\'');
        sb.append(", applyDepartNameHead='").append(applyDepartNameHead).append('\'');
        sb.append(", applyPayUseCodeHead='").append(applyPayUseCodeHead).append('\'');
        sb.append(", applyUserNameHead='").append(applyUserNameHead).append('\'');
        sb.append(", applyDateHead='").append(applyDateHead).append('\'');
        sb.append(", flagDataHead='").append(flagDataHead).append('\'');
        sb.append(", applyPayRemarkHead='").append(applyPayRemarkHead).append('\'');
        sb.append(", statusHead='").append(statusHead).append('\'');
        sb.append(", applySourceCodeHead='").append(applySourceCodeHead).append('\'');
        sb.append(", submitUserNameHead='").append(submitUserNameHead).append('\'');
        sb.append(", submitDateHead='").append(submitDateHead).append('\'');
        sb.append(", auditUserNameHead='").append(auditUserNameHead).append('\'');
        sb.append(", auditDateHead='").append(auditDateHead).append('\'');
        sb.append(", currencyRateHead='").append(currencyRateHead).append('\'');
        sb.append(", actualPayUserNameHead='").append(actualPayUserNameHead).append('\'');
        sb.append(", actualPayDateHead='").append(actualPayDateHead).append('\'');
        sb.append(", payTranNoHead='").append(payTranNoHead).append('\'');
        sb.append(", payOrderNoHead='").append(payOrderNoHead).append('\'');
        sb.append(", payRemarkHead='").append(payRemarkHead).append('\'');
        sb.append(", applyPayCuAmountHead='").append(applyPayCuAmountHead).append('\'');
        sb.append(", payAccIdHead='").append(payAccIdHead).append('\'');
        sb.append(", receAcctypeNameHead='").append(receAcctypeNameHead).append('\'');
        sb.append(", receOpenBankHead='").append(receOpenBankHead).append('\'');
        sb.append(", receAccNameHead='").append(receAccNameHead).append('\'');
        sb.append(", receAccNoHead='").append(receAccNoHead).append('\'');
        sb.append(", applyBillStatusHead='").append(applyBillStatusHead).append('\'');
        sb.append(", sysFlagIdsHead='").append(sysFlagIdsHead).append('\'');
        sb.append(", bankNameHead='").append(bankNameHead).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
