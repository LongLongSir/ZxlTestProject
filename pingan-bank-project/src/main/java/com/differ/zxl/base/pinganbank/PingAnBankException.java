package com.differ.zxl.base.pinganbank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 平安银行异常
 * @auth zhangxl
 * @date 2021/12/13
 */
public class PingAnBankException extends RuntimeException {

    private static Logger logger = LoggerFactory.getLogger(PingAnBankException.class);

    private static final String BANK_EXCEPTION_PREFIX="【平安银行】：";

    public PingAnBankException(String message){
        super(message);
        logger.warn(BANK_EXCEPTION_PREFIX+message);
    }

    public PingAnBankException(String message,Throwable cause){
        super(message,cause);
        logger.warn(BANK_EXCEPTION_PREFIX+message,cause);
    }

}
