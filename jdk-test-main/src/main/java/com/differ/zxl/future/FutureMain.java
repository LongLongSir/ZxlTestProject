package com.differ.zxl.future;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureMain {

    public static void main(String[] args)throws Exception {

        FutureTask<String> future=new FutureTask(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("====1111====");
                return "222";
            }
        });

        new Thread(future).start();

        System.out.println(future.get());

    }

}
