package com.differ.zxl.jdbc;

import com.differ.zxl.jdbc.dao.ZxlDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MybatisMain {

    //线程池10核心线程，执行插入数据
    public static void main(String[] args) throws Exception{
        ExecutorService service = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch=new CountDownLatch(100);
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession(ExecutorType.BATCH);
        ZxlDao zxlDao = sqlSession.getMapper(ZxlDao.class);
        long s=System.currentTimeMillis();
        for(int j=0;j<2;j++){
            service.execute(()->{
                //SqlSession sqlSession = factory.openSession(ExecutorType.BATCH);
                try{
                    //ZxlDao zxlDao = sqlSession.getMapper(ZxlDao.class);
                    for(int i=0;i<50;i++){
                        zxlDao.insertData(i);
                        countDownLatch.countDown();
                    }
                    sqlSession.commit();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    //sqlSession.close();
                }
            });
        }
        countDownLatch.await();
        long e=System.currentTimeMillis();
        System.out.println("耗时："+(e-s));
        service.shutdown();
    }
}
