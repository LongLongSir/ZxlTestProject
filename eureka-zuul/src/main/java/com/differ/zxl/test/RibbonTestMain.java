package com.differ.zxl.test;

import com.netflix.loadbalancer.*;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;
import rx.Observable;
import rx.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @auth zhangxl
 * @date 2022/1/14
 */
public class RibbonTestMain {

    public static void main(String[] args) {

        // 重要接口 LoadBalancerClient

        List<Server> serverList=new ArrayList<>();
        serverList.add(new Server("localhost",10001));
        serverList.add(new Server("localhost",10002));
        serverList.add(new Server("localhost",10003));
        ILoadBalancer loadBalancer= LoadBalancerBuilder.newBuilder()
                //.withRule(new BestAvailableRule())
                .buildFixedServerListLoadBalancer(serverList);

        LoadBalancerCommand command = LoadBalancerCommand.builder().withLoadBalancer(loadBalancer).build();

        Observable observable = command.submit(new ServerOperation<String>() {
            @Override
            public Observable<String> call(Server server) {
                System.out.println(server.getHostPort());
                return Observable.just("hhah+"+server.getHostPort());
            }
        });
        for (int i=0;i<5;i++){
            observable.subscribe(new Observer<String>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(String o) {
                    System.out.println(o);
                }
            });
        }


    }

}
