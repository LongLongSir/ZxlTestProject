package com.differ.zxl.future;


import com.differ.jackyun.business.config.nettyserver.request.RequestMessage;
import com.differ.jackyun.business.config.nettyserver.response.ResponseMessage;
import com.differ.zxl.exception.JKYConfigServiceException;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @auth zhangxl
 * @date 2020/12/4
 */
public class NettyClientFutureResponse implements Future<ResponseMessage> {

    private boolean done=false;

    private ResponseMessage responseMessage;

    private RequestMessage requestMessage;

    private Object lock=new Object();

    public NettyClientFutureResponse(RequestMessage requestMessage){
        this.requestMessage=requestMessage;
        ResponseFutureManager.setResponseFuture(requestMessage.getRequestId(),this);
    }

    public void setResponseMessage(ResponseMessage responseMessage) {
        this.responseMessage = responseMessage;
        synchronized (lock){
            done=true;
            lock.notifyAll();
        }
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public ResponseMessage get() throws InterruptedException, ExecutionException {
        try {
            return get(-1,TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            throw new JKYConfigServiceException(e);
        }
    }

    @Override
    public ResponseMessage get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        if(!done){
            synchronized (lock){
                try {
                    if(timeout<0){
                        lock.wait();
                    }else{
                        //转为毫秒
                        long time=unit==TimeUnit.MILLISECONDS?timeout:TimeUnit.MILLISECONDS.convert(timeout,unit);
                        lock.wait(time);
                    }
                }catch (Exception e){
                    throw new JKYConfigServiceException(e);
                }
            }
        }
        if(!done){
            throw new JKYConfigServiceException("请求副本"+requestMessage.getDuplicateId()+"超时异常");
        }
        return responseMessage;
    }
}
