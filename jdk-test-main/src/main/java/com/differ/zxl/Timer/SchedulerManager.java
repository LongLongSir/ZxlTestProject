package com.differ.zxl.Timer;

import java.util.TimerTask;
import java.util.concurrent.*;

public class SchedulerManager {

    private ScheduledExecutorService schedule;

    private ThreadPoolExecutor firstExecutor;

    private ThreadPoolExecutor secondExecutor;

    public SchedulerManager(){

        schedule=Executors.newScheduledThreadPool(2,
                new ZxlThreadFactoryBuilder()
                        .setDaemon(true)
                        .setNameFormat("zxl-test-schedule-%d")
                        .build());

        firstExecutor=new ThreadPoolExecutor(1,2,
                0,TimeUnit.SECONDS,new SynchronousQueue<Runnable>(),
                new ZxlThreadFactoryBuilder()
                        .setDaemon(true)
                        .setNameFormat("firstExecutor-%d")
                        .build());

        secondExecutor=new ThreadPoolExecutor(1,2,
                0,TimeUnit.SECONDS,new SynchronousQueue<Runnable>(),
                new ZxlThreadFactoryBuilder()
                        .setDaemon(true)
                        .setNameFormat("secondExecutor-%d")
                        .build());

    }

    public void schedule(TimerTask timerTask){

        //schedule.schedule(timerTask)

    }


}
