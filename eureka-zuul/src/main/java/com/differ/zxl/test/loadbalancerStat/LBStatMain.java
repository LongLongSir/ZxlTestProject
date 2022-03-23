package com.differ.zxl.test.loadbalancerStat;

import com.netflix.loadbalancer.LoadBalancerStats;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerStats;
import com.netflix.loadbalancer.ZoneSnapshot;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @auth zhangxl
 * @date 2022/1/18
 */
public class LBStatMain {

    public static void main(String[] args) {

        //ExecutorService executorService = Executors.newFixedThreadPool(3);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        List<Server> serverList=new ArrayList<>();
        serverList.add(new Server("localhost",10001){{setZone("zoneA");}});
        serverList.add(new Server("localhost",10002){{setZone("zoneA");}});
        serverList.add(new Server("localhost",10003){{setZone("zoneB");}});
        serverList.add(new Server("localhost",10004){{setZone("zoneB");}});
        //创建负载均衡统计器
        LoadBalancerStats loadBalancerStats=new LoadBalancerStats("zxl");

        Map<String ,List<Server>> zoneServerListMap=new HashMap<>();
        zoneServerListMap.put("zoneA",serverList.stream().filter(t->t.getZone().equals("zoneA")).collect(Collectors.toList()));
        zoneServerListMap.put("zoneB",serverList.stream().filter(t->t.getZone().equals("zoneB")).collect(Collectors.toList()));

        loadBalancerStats.updateServerList(serverList);
        loadBalancerStats.updateZoneServerMapping(zoneServerListMap);
        Random r = new Random(1459834);
        //模拟发送请求
        executorService.execute(()->{
            while (true){
                for (ServerStats serverStats : loadBalancerStats.getServerStats().values()){
                    CompletableFuture.runAsync(()->{
                        //模拟请求，记录耗时
                        double rl = r.nextDouble() * 25.2;
                        serverStats.noteResponseTime(rl);
                        serverStats.incrementNumRequests();

                    });
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //打印统计结果
        executorService.scheduleAtFixedRate(()->{
            for(String zone : zoneServerListMap.keySet()){
                System.out.println("==========区域："+zone+"==========");
                ZoneSnapshot zoneSnapshot = loadBalancerStats.getZoneSnapshot(zone);
                System.out.println("总活跃量："+zoneSnapshot.getActiveRequestsCount());
                System.out.println("打开断路器的实例量："+zoneSnapshot.getCircuitTrippedCount());
                System.out.println("实例总数："+zoneSnapshot.getInstanceCount());
                System.out.println("平均负载："+zoneSnapshot.getLoadPerServer());
                System.out.println("==========该区域下的服务状态==========");
                loadBalancerStats.getServerStats().forEach((k,v)->{
                    if(k.getZone().equals(zone)){
                        System.out.println("=======服务id："+k.getId()+"状态如下：");
                        System.out.println(v);
                    }
                });

            }
        },5,5, TimeUnit.SECONDS);

    }

}
