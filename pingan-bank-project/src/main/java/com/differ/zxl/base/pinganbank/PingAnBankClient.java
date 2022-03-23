package com.differ.zxl.base.pinganbank;

import com.alibaba.fastjson.JSON;
import com.differ.zxl.base.model.PingAnBankPacket;
import com.differ.zxl.base.pinganbank.request.*;
import com.differ.zxl.base.pinganbank.response.*;
import com.differ.zxl.util.PingAnBankUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 平安银行客户端
 *
 * @author zhuyuchao
 * @date 2020/7/9
 */
@Service("pingAnBankClient")
//@RefreshScope
public class PingAnBankClient {
    private static Logger logger = LoggerFactory.getLogger(PingAnBankClient.class);
    // 银企代码
    @Value("${jackyun.cms.pinganbank.enterprisecode}")
    private String enterPrisecode;
    // 前置机服务地址
    @Value("${jackyun.cms.pinganbank.serverurl}")
    private String serverUrl;
    //付款账号
    @Value("${jackyun.cms.pinganbank.jk.payaccountno}")
    private String jkPayAccountNo;
    @Value("${jackyun.cms.pinganbank.df.payaccountno}")
    private String dfPayAccountNo;
    //付款账户名
    @Value("${jackyun.cms.pinganbank.jk.payaccountname}")
    private String jkPayAccountName;
    @Value("${jackyun.cms.pinganbank.df.payaccountname}")
    private String dfPayAccountName;
    // 服务端口号
    private static final int SERVER_PORT = 7072;
    // 受理成功状态码
    private static final String SUCCESS_CODE = "000000";
    // 账户余额查询
    private static final String ACCOUNT_BALANCE_TRANCODE = "4001";
    // 单笔转账
    private static final String TRANSFER_TRANCODE = "4004";
    // 批量转账
    private static final String BATCH_TRANSFER_TRANCODE = "4018";
    // 单笔转账进度查询
    private static final String TRANSFER_QUERY_TRANCODE = "4005";
    // 当日历史交易明细[4013]
    private static final String TRANSACTION_DETAILS_TRANCODE = "4013";

    /**
     * 获取银行账户余额
     *
     * @param account
     * @param ccyType
     * @param ccyCode
     */
    public AccountBalanceResponse getAccountBalance(String account, String ccyType, String ccyCode) {

        AccountBalanceRequest accountBalanceRequest = new AccountBalanceRequest();
        accountBalanceRequest.setAccount(account);
        accountBalanceRequest.setCcyCode(ccyCode);
        accountBalanceRequest.setCcyType(ccyType);
        String txtSend = accountBalanceRequest.toString();
        // 组装报文
        String packets = PingAnBankUtil.assemblyRequestPackets(enterPrisecode, ACCOUNT_BALANCE_TRANCODE, txtSend);
        AccountBalanceResponse balanceResponse = null;
        try {
            // 发送请求
            //Packets packetsRP = PingAnBankUtil.send2server(serverIp, iPort, packets); //socket
            PingAnBankPacket packetsRP = PingAnBankUtil.send2httpServer(serverUrl, SERVER_PORT, packets); //http
            // 处理响应请求
            ThreeTuple<String, String, String> threeTuple = sendRequest(packetsRP);
            if (StringUtils.isEmpty(threeTuple.c)) {
                balanceResponse = new AccountBalanceResponse();
                balanceResponse.setCode(threeTuple.a);
                balanceResponse.setMessage(threeTuple.b);
            } else {
                JAXBContext context = JAXBContext.newInstance(AccountBalanceResponse.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                balanceResponse = (AccountBalanceResponse) unmarshaller.unmarshal(new StringReader(threeTuple.c));
                if (balanceResponse != null) {
                    balanceResponse.setCode(threeTuple.a);
                    balanceResponse.setMessage(threeTuple.b);
                }
            }
        } catch (Exception e) {
            logger.warn("解析返回的结果出错", e);
        }
        if (balanceResponse == null) {
            throw new PingAnBankException("查询银行账户余额失败,原因是：与云直联前置客户端通讯失败");
        }

        if (!"000000".equals(balanceResponse.getCode())) {
            String msg = "查询银行账户余额失败,错误码是:" + balanceResponse.getCode() + "; 原因是：" + balanceResponse.getMessage().substring(0, 50).trim();
            throw new PingAnBankException(msg);
        }
        return balanceResponse;
    }

    /**
     * 单笔资金划转 [4004]
     */
    public SingleTransferResponse singleTransfer(PaymentTransferDTO paymentApplyDto) {
        SingleTransferRequest transferRequest = new SingleTransferRequest();
        transferRequest.setThirdVoucher(paymentApplyDto.getThirdVoucher());
        transferRequest.setCstInnerFlowNo(paymentApplyDto.getPaymentNo());
        transferRequest.setCcyCode("RMB");
        if(paymentApplyDto.getSystemSource().equals(1)){
            transferRequest.setOutAcctNo(dfPayAccountNo);
            transferRequest.setOutAcctName(dfPayAccountName);
        }else {
            transferRequest.setOutAcctNo(jkPayAccountNo);
            transferRequest.setOutAcctName(jkPayAccountName);
        }

        transferRequest.setInAcctNo(paymentApplyDto.getReceAccNo());
        transferRequest.setInAcctName(paymentApplyDto.getReceAccName());
        transferRequest.setInAcctBankName(paymentApplyDto.getReceOpenBank());

        transferRequest.setTranAmount(paymentApplyDto.getApplyPayAmount().toString());
        transferRequest.setUseEx(paymentApplyDto.getApplyPayUseName());
        //  行内跨行标志  1：行内转账，0：跨行转账
        transferRequest.setUnionFlag(paymentApplyDto.getBankInternal());
        transferRequest.setSysFlag("N");
        transferRequest.setAddrFlag("1");
        String txtSend1 = transferRequest.toString();
        String txtSend = "<?xml version=\"1.0\" encoding=\"GBK\"?>" + txtSend1;
        // 组装报文
        String packets = PingAnBankUtil.assemblyRequestPackets(enterPrisecode, TRANSFER_TRANCODE, txtSend);
        SingleTransferResponse balanceResponse = new SingleTransferResponse();
        try {
            // 发送请求
            //Packets packetsRP = PingAnBankUtil.send2server(serverIp, iPort, packets); //socket
            PingAnBankPacket packetsRP = PingAnBankUtil.send2httpServer(serverUrl, SERVER_PORT, packets); //http
            // 处理响应请求
            ThreeTuple<String, String, String> threeTuple = sendRequest(packetsRP);
            balanceResponse.setCode(threeTuple.a);
            balanceResponse.setMessage(threeTuple.b);
            String body = threeTuple.c;
            if (StringUtils.isEmpty(body)) {
                return balanceResponse;
            }

            JAXBContext context = JAXBContext.newInstance(SingleTransferResponse.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            balanceResponse = (SingleTransferResponse) unmarshaller.unmarshal(new StringReader(body));
            balanceResponse.setCode(threeTuple.a);
            balanceResponse.setMessage(threeTuple.b);
            return balanceResponse;
        } catch (Exception e) {
            logger.warn("解析返回的结果出错", e);
        }
        return balanceResponse;
    }

    /**
     * 单条转账查询 4005
     * @param origThirdVoucher
     * @return
     */
    public SingleTransferQueryResponse getSingleTransferQuery(String origThirdVoucher) {
        SingleTransferQueryRequset singleTransferQueryRequset = new SingleTransferQueryRequset();
        singleTransferQueryRequset.setOrigThirdVoucher(origThirdVoucher);
        //不必传
        //singleTransferQueryRequset.setOrigFrontLogNo(origFrontLogNo);
        String txtSend = singleTransferQueryRequset.toString();

        // 组装报文
        String packets = PingAnBankUtil.assemblyRequestPackets(enterPrisecode, TRANSFER_QUERY_TRANCODE, txtSend);
        try {
            PingAnBankPacket packetsRP = PingAnBankUtil.send2httpServer(serverUrl, SERVER_PORT, packets); //http
            // 处理响应请求
            ThreeTuple<String, String, String> threeTuple = sendRequest(packetsRP);
            if (StringUtils.isEmpty(threeTuple.c)) {
                //若4005在报文头返回“MA0103:没有满足条件记录”（无报文体），则表示发送给银行的记录未收到或者未收妥(需要延时在发起4005查询交易)，这里直接返回null
                //原交易发起30分钟后可以置原交易为失败状态
                return null;
            }
            JAXBContext context = JAXBContext.newInstance(SingleTransferQueryResponse.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            SingleTransferQueryResponse balanceResponse = (SingleTransferQueryResponse) unmarshaller.unmarshal(new StringReader(threeTuple.c));
            return balanceResponse;
        } catch (Exception ex) {
            logger.warn("解析返回的结果出错", ex);
        }
        return null;
    }


    /**
     * 3.8查询账户当日历史交易明细[4013]
     */
    public TransactionDetailsResponse getTransactionDetails(TransactionDetailsRequest request) {

        TransactionDetailsRequest transactionDetailsRequest = new TransactionDetailsRequest();
        transactionDetailsRequest.setAcctNo(request.getAcctNo());
        transactionDetailsRequest.setBeginDate(request.getBeginDate());
        transactionDetailsRequest.setEndDate(request.getEndDate());
        transactionDetailsRequest.setCcyCode(request.getCcyCode());
        transactionDetailsRequest.setPageSize(request.getPageSize());
        transactionDetailsRequest.setPageNo(request.getPageNo());
        transactionDetailsRequest.setOrderMode(request.getOrderMode());
        String txtSend1 = transactionDetailsRequest.toString();
        String txtSend = "<?xml version=\"1.0\" encoding=\"GBK\"?>" + txtSend1;
        // 组装报文
        String packets = PingAnBankUtil.assemblyRequestPackets(enterPrisecode, TRANSACTION_DETAILS_TRANCODE, txtSend);
        TransactionDetailsResponse detailsResponse = null;
        try {
            // 发送请求
            //Packets packetsRP = PingAnBankUtil.send2server(serverIp, iPort, packets); //socket
            PingAnBankPacket packetsRP = PingAnBankUtil.send2httpServer(serverUrl, SERVER_PORT, packets); //http
            // 处理响应请求
            ThreeTuple<String, String, String> threeTuple = sendRequest(packetsRP);
            if (StringUtils.isEmpty(threeTuple.c)) {
                detailsResponse = new TransactionDetailsResponse();
                detailsResponse.setCode(threeTuple.a);
                detailsResponse.setMessage(threeTuple.b);
            } else {
                JAXBContext context = JAXBContext.newInstance(TransactionDetailsResponse.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                detailsResponse = (TransactionDetailsResponse) unmarshaller.unmarshal(new StringReader(threeTuple.c));
                if (detailsResponse != null) {
                    detailsResponse.setCode(threeTuple.a);
                    detailsResponse.setMessage(threeTuple.b);
                }
            }
        } catch (Exception e) {
            logger.warn("解析返回的结果出错", e);
        }

        if (detailsResponse == null) {
            throw new PingAnBankException("查询账户当日历史交易明细失败，原因是：与云直联前置客户端通讯失败");
        }

        if (!"000000".equals(detailsResponse.getCode())) {
            String msg = "查询账户当日历史交易明细失败,错误码是:" + detailsResponse.getCode() + "; 原因是：" + detailsResponse.getMessage().substring(0, 30).trim();
            throw new PingAnBankException(msg);
        }
        return detailsResponse;
    }


    /**
     * 解析报文，获取响应体
     *
     * @param packetsRP
     * @return
     * @throws UnsupportedEncodingException
     */
    private ThreeTuple<String, String, String> sendRequest(PingAnBankPacket packetsRP) throws UnsupportedEncodingException {
        // 响应体
        byte[] headRP = packetsRP.getHead();
        int bodyRpLen = packetsRP.getBodyLength();
        // 响应体
        byte[] bodyRP = packetsRP.getBody();

        //StringBuilder head = new StringBuilder();
        StringBuilder body = new StringBuilder();
//        if (headRP != null) {
//            head.append(new String(headRP, PingAnBankUtil.CHARSET_DEFAULT));
//            System.out.println("[code:返回描述]="+new String(headRP,87,100,PingAnBankUtil.CHARSET_DEFAULT));
//            //System.out.println("[返回描述2]="+new String(headRP,94,100,PingAnBankUtil.CHARSET_DEFAULT));
//        }
        if (bodyRpLen > 0 && bodyRP != null) {
            body.append(new String(bodyRP, PingAnBankUtil.CHARSET_DEFAULT));
        }
        String codeAndMsg=new String(headRP,87,100,PingAnBankUtil.CHARSET_DEFAULT);
        //logger.debug("head:{} ", head);
        // 截取返回报文头：前六位表示状态码，后100位表示状态描述
        String[] string = codeAndMsg.split(":");
        String code = string[0];
        logger.debug("code:{} ", code);
        String msg = string[1].trim();
        logger.debug("msg:{} ", msg);
        if (!SUCCESS_CODE.equals(code)) {
            logger.warn("银行失败返回，code={}，msg={} ",code, msg);
            return new ThreeTuple<>(code, msg, null);
        }
        return new ThreeTuple<>(code, msg, body.toString());
    }

    /**
     * 企业大批量资金划转[4018]，企业使用4015查询批次转账进度的间隔为10分钟
     * 4018接口同4014的区别在于，允许上送的笔数为500笔，且处理模式为异步。只返回银行受理结果信息，转账结果需要通过4015接口查询。
     * 单笔转账失败不会影响其他记录。此接口单批只支持一个付款账户。
     *
     * @return
     */
    public BatchTransferResponse sendBatchTransfer(String batchTransferNo,int systemSource,List<PaymentTransferDTO> paymentApplyList) {
        BatchTransferRequest batchTransferRequest = new BatchTransferRequest();
        // 汇总数据
        batchTransferRequest.setTotalCts(String.valueOf(paymentApplyList.size()));
        BigDecimal totalPayAmount = paymentApplyList.stream().map(PaymentTransferDTO::getApplyPayAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        batchTransferRequest.setTotalAmt(totalPayAmount.toString());
        batchTransferRequest.setBatchSummary("批量转账");
        batchTransferRequest.setBSysFlag("N");
        batchTransferRequest.setCcyCode("RMB");
        if(systemSource==1){
            //笛佛
            batchTransferRequest.setOutAcctNo(dfPayAccountNo);
            batchTransferRequest.setOutAcctName(dfPayAccountName);
        }else {
            //吉客云
            batchTransferRequest.setOutAcctNo(jkPayAccountNo);
            batchTransferRequest.setOutAcctName(jkPayAccountName);
        }
        batchTransferRequest.setThirdVoucher(batchTransferNo);
        //batchTransferRequest.setOutAcctAddr("");
        batchTransferRequest.setPayType("0");
        batchTransferRequest.setBizFlag1("0");
        List<BatchTransferDetailRequest> detailRequestList = new ArrayList<>();
        for (PaymentTransferDTO paymentApply : paymentApplyList) {
            BatchTransferDetailRequest detailRequest = new BatchTransferDetailRequest();
            detailRequest.setSThirdVoucher(paymentApply.getThirdVoucher());
            detailRequest.setCstInnerFlowNo(paymentApply.getPaymentNo());
            detailRequest.setInAcctNo(paymentApply.getReceAccNo());
            detailRequest.setInAcctName(paymentApply.getReceAccName());
            detailRequest.setInAcctBankName(paymentApply.getReceOpenBank());
            /*detailRequest.setInAcctProvinceCode("");
            detailRequest.setInAcctCityName("");*/
            detailRequest.setTranAmount(paymentApply.getApplyPayAmount().toString());
            detailRequest.setUseEx(paymentApply.getApplyPayUseName());
            detailRequest.setUnionFlag(paymentApply.getBankInternal());
            detailRequest.setAddrFlag("1");
            detailRequestList.add(detailRequest);
        }
        batchTransferRequest.setBatchTransferDetailRequestList(detailRequestList);
        String txtSend1 = batchTransferRequest.toString();
        String txtSend = "<?xml version=\"1.0\" encoding=\"GBK\"?>" + txtSend1;
        // 组装报文
        String packets = PingAnBankUtil.assemblyRequestPackets(enterPrisecode, BATCH_TRANSFER_TRANCODE, txtSend);

        try {
            // 发送请求
            //Packets packetsRP = PingAnBankUtil.send2server(serverIp, iPort, packets); //socket
            PingAnBankPacket packetsRP = PingAnBankUtil.send2httpServer(serverUrl, SERVER_PORT, packets); //http
            // 处理响应请求
            ThreeTuple<String, String, String> threeTuple = sendRequest(packetsRP);
            BatchTransferResponse batchTransferResponse = new BatchTransferResponse();
            batchTransferResponse.setCode(threeTuple.a);
            batchTransferResponse.setMessage(threeTuple.b);
            if (StringUtils.isEmpty(threeTuple.c)) {
                return batchTransferResponse;
            }
            JAXBContext context = JAXBContext.newInstance(BatchTransferResponse.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            batchTransferResponse = (BatchTransferResponse) unmarshaller.unmarshal(new StringReader(threeTuple.c));
            batchTransferResponse.setCode(threeTuple.a);
            batchTransferResponse.setMessage(threeTuple.b);
            return batchTransferResponse;
        } catch (Exception e) {
            logger.warn("解析返回的结果出错", e);
        }
        return null;
    }

    /**
     * 3.6批量转账指令查询[4015]
     * 单条转账查询
     */
    public void getBatchTransferQuery(String thirdVoucher) {
        BatchTransferQueryRequset batchTransferQueryRequset = new BatchTransferQueryRequset();
        batchTransferQueryRequset.setOrigThirdVoucher(thirdVoucher);
        batchTransferQueryRequset.setQueryType("0");
        String txtSend = batchTransferQueryRequset.toString();

        // 组装报文
        String packets = PingAnBankUtil.assemblyRequestPackets(enterPrisecode, "4015", txtSend);
        try {
            PingAnBankPacket packetsRP = PingAnBankUtil.send2httpServer(serverUrl, SERVER_PORT, packets); //http
            // 处理响应请求
            ThreeTuple<String, String, String> threeTuple = sendRequest(packetsRP);
            if (StringUtils.isEmpty(threeTuple.c)) {
                //只有在转账记录银行未收到的情况下，报文头报错：记录不存在
                return;
            }
            JAXBContext context = JAXBContext.newInstance(BatchTransferQueryResponse.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            BatchTransferQueryResponse balanceResponse = (BatchTransferQueryResponse) unmarshaller.unmarshal(new StringReader(threeTuple.c));
            System.out.println(JSON.toJSONString(balanceResponse));
        } catch (Exception ex) {
            logger.warn("解析返回的结果出错", ex);
        }
    }


    /**
     * 快付单笔资金划转KHKF03
     */
    public PayFastSingleTransferResponse payFastSingleTransfer(PaymentApplySelectDTO paymentApplyDto) {
        PayFastSingleTransferRequest transferRequest = new PayFastSingleTransferRequest();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = simpleDateFormat.format(new Date());
//        MemberInfo memberInfo = MemberHolder.getMemberInfo();
//        transferRequest.setOrderNumber(timestamp + memberInfo.getMemberName());
        transferRequest.setBusiType("00000");
        transferRequest.setCcyCode("RMB");
        transferRequest.setAcctNo(paymentApplyDto.getPayAccNo());
        transferRequest.setInAcctNo(paymentApplyDto.getReceAccNo());
        transferRequest.setInAcctName(paymentApplyDto.getReceAccName());
        transferRequest.setInAcctBankName(paymentApplyDto.getReceOpenBank());
        transferRequest.setRemark(paymentApplyDto.getPayRemark());
        transferRequest.setTranAmount(paymentApplyDto.getApplyPayAmount().toString());
        transferRequest.setBusPdtFlag("00");

        String txtSend1 = transferRequest.toString();
        String txtSend = "<?xml version=\"1.0\" encoding=\"GBK\"?>" + txtSend1;
        // 组装报文
        String packets = PingAnBankUtil.assemblyRequestPackets(enterPrisecode, "KHKF03", txtSend);
        PayFastSingleTransferResponse balanceResponse = new PayFastSingleTransferResponse();
        try {
            // 发送请求
            //Packets packetsRP = PingAnBankUtil.send2server(serverIp, iPort, packets); //socket
            PingAnBankPacket packetsRP = PingAnBankUtil.send2httpServer(serverUrl, SERVER_PORT, packets); //http
            // 处理响应请求
            ThreeTuple<String, String, String> threeTuple = sendRequest(packetsRP);
            String body = threeTuple.c;
            balanceResponse.setCode(threeTuple.a);
            balanceResponse.setMessage(threeTuple.b);
            if (StringUtils.isEmpty(body)) {
                return balanceResponse;
            }
            JAXBContext context = JAXBContext.newInstance(PayFastSingleTransferResponse.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            balanceResponse = (PayFastSingleTransferResponse) unmarshaller.unmarshal(new StringReader(body));
            balanceResponse.setCode(threeTuple.a);
            balanceResponse.setMessage(threeTuple.b);
            return balanceResponse;
        } catch (Exception e) {
            logger.warn("解析返回的结果出错", e);
        }
        return balanceResponse;
    }


    /**
     * 3.7历史余额查询[4012]
     * 查询账户某天的日终账面、账单余额，可查询的范围为最近100天。
     *
     * @param account
     * @param rptDate
     */
    public AccountHistoryBalanceResponse getHistoryAccountBalance(String account, String rptDate) {

        AccountHistoryBalanceRequest historyBalanceRequest = new AccountHistoryBalanceRequest();
        historyBalanceRequest.setAccount(account);
        historyBalanceRequest.setRptDate(rptDate);
        String txtSend = historyBalanceRequest.toString();
        // 组装报文
        String packets = PingAnBankUtil.assemblyRequestPackets(enterPrisecode, "4012", txtSend);
        AccountHistoryBalanceResponse balanceResponse = new AccountHistoryBalanceResponse();
        try {
            // 发送请求
            //Packets packetsRP = PingAnBankUtil.send2server(serverIp, iPort, packets); //socket
            PingAnBankPacket packetsRP = PingAnBankUtil.send2httpServer(serverUrl, SERVER_PORT, packets); //http
            // 处理响应请求
            ThreeTuple<String, String, String> threeTuple = sendRequest(packetsRP);
            if (StringUtils.isEmpty(threeTuple.c)) {
                return balanceResponse;
            }

            JAXBContext context = JAXBContext.newInstance(AccountHistoryBalanceResponse.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            balanceResponse = (AccountHistoryBalanceResponse) unmarshaller.unmarshal(new StringReader(threeTuple.c));
            return balanceResponse;
        } catch (Exception e) {
            logger.warn("解析返回的结果出错", e);
        }
        return balanceResponse;
    }


    /**
     * 快付单笔单条转账查询 KHKF04
     */
    public PayFastSingleTransferQueryResponse getPayFastSingleTransferQuery(String AcctNo, String OrderNumber, String BussFlowNo, String SubAcctNo) {
        PayFastSingleTransferQueryRequset queryRequset = new PayFastSingleTransferQueryRequset();
        // 20200717155954844
        queryRequset.setAcctNo(AcctNo);
        queryRequset.setOrderNumber(OrderNumber);
        queryRequset.setBussFlowNo(BussFlowNo);
        queryRequset.setSubAcctNo(SubAcctNo);
        String txtSend = queryRequset.toString();

        // 组装报文 enterPrisecode
        String packets = PingAnBankUtil.assemblyRequestPackets(enterPrisecode, "KHKF04", txtSend);
        PayFastSingleTransferQueryResponse balanceResponse = new PayFastSingleTransferQueryResponse();
        try {
            PingAnBankPacket packetsRP = PingAnBankUtil.send2httpServer(serverUrl, SERVER_PORT, packets); //http
            // 处理响应请求
            ThreeTuple<String, String, String> threeTuple = sendRequest(packetsRP);
            balanceResponse.setCode(threeTuple.a);
            balanceResponse.setMessage(threeTuple.b);
            if (StringUtils.isEmpty(threeTuple.c)) {
                return balanceResponse;
            }
            JAXBContext context = JAXBContext.newInstance(PayFastSingleTransferQueryResponse.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            balanceResponse = (PayFastSingleTransferQueryResponse) unmarshaller.unmarshal(new StringReader(threeTuple.c));
            balanceResponse.setCode(threeTuple.a);
            balanceResponse.setMessage(threeTuple.b);
            return balanceResponse;
        } catch (Exception ex) {
            logger.warn("解析返回的结果出错", ex);
        }
        return null;
    }

    public static void main(String[] args) {
        PingAnBankClient client=new PingAnBankClient();
        client.enterPrisecode="00901080000002222000";
        client.serverUrl="192.168.4.81";
        client.jkPayAccountNo="15000100714817";
        client.jkPayAccountName="前端数据支持测试海南弥佣有限公司";
        //余额查询
        //client.getAccountBalance("15000100714817", null, "RMB");
        String batchNo=System.currentTimeMillis()+"";
        PaymentTransferDTO dto=new PaymentTransferDTO();
        dto.setThirdVoucher(batchNo+"001");
        System.out.println(dto.getThirdVoucher());

        dto.setReceAccNo("15000100714914");
        dto.setReceAccName("前端数据支持测试河北槽钟有限公司");
        dto.setReceOpenBank("平安银行");

        dto.setApplyPayAmount(new BigDecimal("2"));
        dto.setApplyPayUseName("保证金返款");
        dto.setBankInternal("1");
        //单笔转账
//        client.singleTransfer(dto);
//
//        client.getSingleTransferQuery("1639365240962");
        //client.getSingleTransferQuery("1639377200336002");
//
        List<PaymentTransferDTO> paymentApplyList=new ArrayList<>();
        paymentApplyList.add(dto);
        PaymentTransferDTO dto2=new PaymentTransferDTO();
        dto2.setReceAccNo("15000100715034");
        dto2.setReceAccName("前端数据支持测试广东踢襟有限公司");
        dto2.setReceOpenBank("平安银行");

        dto2.setApplyPayAmount(new BigDecimal("3"));
        dto2.setApplyPayUseName("保证金返款");
        dto2.setBankInternal("1");
        dto2.setThirdVoucher(batchNo+"002");
        paymentApplyList.add(dto2);
        client.sendBatchTransfer(batchNo,2,paymentApplyList);
//
        //client.getBatchTransferQuery("1639377200336");

//        client.getTransactionDetails();

//        client.payFastSingleTransfer(null);
//
//        client.getPayFastSingleTransferQuery("15000090244196",null,"8043432011122257580861",null);
//
//        client.getHistoryAccountBalance(null,null);

    }

}
