package com.differ.zxl.Timer;

import java.util.TimerTask;

public class ZxlTimerTask extends TimerTask {

    @Override
    public void run() {

        System.out.println("ZxlTimerTask===ThreadName:"+Thread.currentThread().getName());

    }
}
