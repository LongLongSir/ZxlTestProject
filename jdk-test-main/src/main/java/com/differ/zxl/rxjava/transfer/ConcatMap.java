package com.differ.zxl.rxjava.transfer;

import rx.Observable;

import java.util.concurrent.TimeUnit;

/**
 * @auth zhangxl
 * @date 2022/2/9
 */
public class ConcatMap {

    public static void main(String[] args) throws InterruptedException {
        //testFlatMap();

        testConcatMap();

    }

    //异步，无序，一变多
    public static void testFlatMap() throws InterruptedException {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .flatMap(i -> Observable.just(i).delay(10, TimeUnit.MILLISECONDS))
                .subscribe(d -> System.out.println(d));

        System.out.println("----------end-----------");
        TimeUnit.SECONDS.sleep(2);
    }

    //异步，有序
    public static void testConcatMap() throws InterruptedException {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9,5)
                .concatMap(i -> Observable.just(i).delay(10, TimeUnit.MILLISECONDS))
                .subscribe(d -> System.out.println(d));

        System.out.println("----------end-----------");
        TimeUnit.SECONDS.sleep(2);
    }

}
