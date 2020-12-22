package com.differ.zxl.Timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimerMain {
    public static void main(String[] args)throws Exception {
        Timer t=new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("xczczxc");
            }
        }, 3000,2000);
        System.out.println("start");
        //Thread.sleep(6000);
        //t.cancel();
    }
}
