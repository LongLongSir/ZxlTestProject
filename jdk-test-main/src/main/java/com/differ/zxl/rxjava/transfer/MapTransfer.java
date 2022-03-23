package com.differ.zxl.rxjava.transfer;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

/**
 * 对Observable发射的每一项数据应用一个函数，执行变换操作。
 * Map操作符对原始Observable发射的每一项数据应用一个你选择的函数，然后返回一个发射这些结果的Observable。
 * RxJava将这个操作符实现为map函数。这个操作符默认不在任何特定的调度器上执行。其实就是将一个对象转换成自己想要的对象。
 * 应用：请求前需要获取token，就可以使用map在call中获取token，在onNext中进行下一步操作。
 * @auth zhangxl
 * @date 2021/11/17
 */
public class MapTransfer {

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

        Observable.just("aaa").map(new Func1<String, String >() {
            @Override
            public String call(String s) {
                return "mapCall："+s;
            }
        }).subscribe(observer1);

    }

}
