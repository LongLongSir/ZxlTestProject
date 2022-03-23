package com.differ.zxl.rxjava.create;

import rx.Observable;
import rx.Observer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @auth zhangxl
 * @date 2021/11/17
 */
public class FromAndDefer {

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
        //遍历数组
        Observable.from(new String[]{"aaa","bbb","ccc"}).subscribe(observer1);

        //call中调get()
        //将一个Iterable, 一个Future, 或者一个数组，内部通过代理的方式转换成一个Observable。
        // Future转换为OnSubscribe是通过OnSubscribeToObservableFuture进行的，Iterable转换通过OnSubscribeFromIterable进行。数组通过OnSubscribeFromArray转换。
        Observable.from(new Future<String >() {
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
                return false;
            }

            @Override
            public String get() throws InterruptedException, ExecutionException {
                return "haha";
            }

            @Override
            public String get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }
        }).subscribe(observer1);

        //延迟创建被观察者Observable
        //只有当订阅者订阅才创建Observable，为每个订阅创建一个新的Observable。内部通过OnSubscribeDefer在订阅时调用Func0创建Observable。
        Observable.defer(()->{
            return Observable.just("zczxc");
        }).subscribe(observer1);
    }
}
