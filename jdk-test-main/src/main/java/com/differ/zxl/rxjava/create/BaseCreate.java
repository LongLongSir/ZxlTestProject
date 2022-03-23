package com.differ.zxl.rxjava.create;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * @auth zhangxl
 * @date 2021/11/17
 */
public class BaseCreate {

    public static void main(String[] args) {

        //被观察者
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("call");
                subscriber.onNext("zxczxcz");

                subscriber.onError(new Exception("xxxxx"));
                subscriber.onCompleted();
            }
        });

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

        observable.subscribe(observer1);

    }

}
