package com.differ.zxl.concurrent.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {

    public static void main(String[] args) {

        //延迟队列，无界，队列中存的对象必须实现了Delayed接口；对象只能在其到期时才能从队列中取走，队头对象的延期时间最长
        DelayQueue<DelayTask> queue=new DelayQueue<>();

        queue.add(new DelayTask("t1",1000));
        queue.add(new DelayTask("t2",4000));
        queue.add(new DelayTask("t3",3000));
        queue.add(new DelayTask("t4",2000));

        new Thread(()->{
            try{
                while (true){
                    System.out.println(queue.poll(3000,TimeUnit.MILLISECONDS));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
    }

    public static class DelayTask implements Delayed {

        private String name;
        private long delayTime;
        private long start = System.currentTimeMillis();

        public DelayTask(String name,long delayTime){
            this.delayTime=delayTime;
            this.name=name;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert((start+delayTime) - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            DelayTask m=(DelayTask)o;
            return (int)(this.getDelay(TimeUnit.MILLISECONDS)-m.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString() {
            return "ModelDelay{" +
                    "name='" + name + '\'' +
                    ", delayTime=" + delayTime +
                    '}';
        }
    }
}
