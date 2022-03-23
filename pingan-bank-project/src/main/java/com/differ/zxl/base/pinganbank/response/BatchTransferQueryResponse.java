package com.differ.zxl.base.pinganbank.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 批量转账指令查询响应类
 * @author zhuyuchao
 * @date 2020/7/29
 */
@XmlRootElement(name = "Result")
public class BatchTransferQueryResponse {

    /**
     * 成功笔数
     */
    private String successCts;
    /**
     * 成功金额
     */
    private String successAmt;
    /**
     * 失败笔数
     */
    private String faildCts;
    /**
     * 失败金额
     */
    private String faildAmt;
    /**
     * 处理中笔数
     */
    private String processCts;
    /**
     * 处理中金额
     */
    private String processAmt;
    /**
     * 批次总记录数
     */
    private String TotalCts;
    /**
     * 符合当前查询条件
     */
    private String CTotalCts;
    /**
     * 当前页返回的记录数
     */
    private String PTotalCts;
    /**
     * 记录结束标志
     */
    private String IsEnd;
    /**
     * 批次状态
     * 20：成功
     * 30：失败
     * 其他为银行受理成功处理中
     */
    private String batchSTT;
    /**
     * 子批次状态描述
     * 格式:
     * [子批次号]-[状态]-[错误码]-[错误信息];
     */
    private String subBatchSTT;
    /**
     * 网银批次号
     * 若为直连录入、企业网银复核的交易，则返回企业网银的批次号
     */
    private String CorBatchNo;

    /**
     * 错误描述
     */
    private String batchSttDesc;



    private List<BatchTransferQueryDetailResponse> batchTransferQueryDetailResponses;

    @XmlElement(name = "successCts")
    public String getSuccessCts() {
        return successCts;
    }

    public void setSuccessCts(String successCts) {
        this.successCts = successCts;
    }
    @XmlElement(name = "successAmt")
    public String getSuccessAmt() {
        return successAmt;
    }

    public void setSuccessAmt(String successAmt) {
        this.successAmt = successAmt;
    }
    @XmlElement(name = "faildCts")
    public String getFaildCts() {
        return faildCts;
    }

    public void setFaildCts(String faildCts) {
        this.faildCts = faildCts;
    }
    @XmlElement(name = "faildAmt")
    public String getFaildAmt() {
        return faildAmt;
    }

    public void setFaildAmt(String faildAmt) {
        this.faildAmt = faildAmt;
    }
    @XmlElement(name = "processCts")
    public String getProcessCts() {
        return processCts;
    }

    public void setProcessCts(String processCts) {
        this.processCts = processCts;
    }
    @XmlElement(name = "processAmt")
    public String getProcessAmt() {
        return processAmt;
    }

    public void setProcessAmt(String processAmt) {
        this.processAmt = processAmt;
    }
    @XmlElement(name = "TotalCts")
    public String getTotalCts() {
        return TotalCts;
    }

    public void setTotalCts(String totalCts) {
        TotalCts = totalCts;
    }
    @XmlElement(name = "CTotalCts")
    public String getCTotalCts() {
        return CTotalCts;
    }

    public void setCTotalCts(String CTotalCts) {
        this.CTotalCts = CTotalCts;
    }
    @XmlElement(name = "PTotalCts")
    public String getPTotalCts() {
        return PTotalCts;
    }

    public void setPTotalCts(String PTotalCts) {
        this.PTotalCts = PTotalCts;
    }
    @XmlElement(name = "IsEnd")
    public String getIsEnd() {
        return IsEnd;
    }

    public void setIsEnd(String isEnd) {
        IsEnd = isEnd;
    }
    @XmlElement(name = "batchSTT")
    public String getBatchSTT() {
        return batchSTT;
    }

    public void setBatchSTT(String batchSTT) {
        this.batchSTT = batchSTT;
    }
    @XmlElement(name = "subBatchSTT")
    public String getSubBatchSTT() {
        return subBatchSTT;
    }

    public void setSubBatchSTT(String subBatchSTT) {
        this.subBatchSTT = subBatchSTT;
    }
    @XmlElement(name = "CorBatchNo")
    public String getCorBatchNo() {
        return CorBatchNo;
    }

    public void setCorBatchNo(String corBatchNo) {
        CorBatchNo = corBatchNo;
    }

    @XmlElement(name = "batchSttDesc")
    public String getBatchSttDesc() {
        return batchSttDesc;
    }

    public void setBatchSttDesc(String batchSttDesc) {
        this.batchSttDesc = batchSttDesc;
    }

    @XmlElement(name = "list")
    public List<BatchTransferQueryDetailResponse> getBatchTransferQueryDetailResponses() {
        return batchTransferQueryDetailResponses;
    }

    public void setBatchTransferQueryDetailResponses(List<BatchTransferQueryDetailResponse> batchTransferQueryDetailResponses) {
        this.batchTransferQueryDetailResponses = batchTransferQueryDetailResponses;
    }
}
