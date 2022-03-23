package com.differ.zxl.rxjava.create;

import rx.Observable;
import rx.Observer;

/**
 * 将一个或多个对象转换成发射这个或这些对象的一个Observable。如果是单个对象，内部创建的是ScalarSynchronousObservable对象。如果是多个对象，则是调用了from方法创建。
 * @auth zhangxl
 * @date 2021/11/17
 */
public class JustCreate {
    public static void main(String[] args) {

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

        Observable.just("zzzzz").subscribe(observer1);


        String single = Observable.just("zzzzz").toBlocking().single();
        System.out.println(single);
    }
}
