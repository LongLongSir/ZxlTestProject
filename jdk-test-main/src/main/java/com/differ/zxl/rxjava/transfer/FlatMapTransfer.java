package com.differ.zxl.rxjava.transfer;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

import java.util.concurrent.TimeUnit;

/**
 * 无序
 * @auth zhangxl
 * @date 2021/11/17
 */
public class FlatMapTransfer {
    public static void main(String[] args) throws InterruptedException {
        Observer observer1=new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError："+e);
            }

            @Override
            public void onNext(String o) {
                System.out.println("onNext："+o);
            }
        };

        Observable.just("vvv","zzz").flatMap(new Func1<String, Observable<String >>() {
            @Override
            public Observable<String> call(String s) {
                return Observable.just(s+"0",s+"1",s+"2");
            }
        }).subscribe(observer1);
        System.out.println("----------end-----------");
        TimeUnit.SECONDS.sleep(2);
    }
}
