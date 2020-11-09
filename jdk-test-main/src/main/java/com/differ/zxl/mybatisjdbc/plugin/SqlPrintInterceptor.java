package com.differ.zxl.mybatisjdbc.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

@Intercepts(
        {
                @Signature(type = Executor.class,method = "query",args = {MappedStatement.class,Object.class,RowBounds.class,ResultHandler.class}),
                @Signature(type=Executor.class,method = "update",args = {MappedStatement.class,Object.class})
        }
) //对Executor执行器中指定的方法进行拦截，不使用该注解则 不会 拦截执行器的任何方法
public class SqlPrintInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("=======intercept(Invocation invocation)======");
        Object[] objs=invocation.getArgs();
        MappedStatement ms=(MappedStatement)objs[0];
        Object currentArgs=objs[1];
        BoundSql boundSql = ms.getBoundSql(currentArgs);
        String sql = boundSql.getSql();
        System.out.println("sql:"+sql);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        System.out.println("=======plugin(Object target)=======");
        if(target instanceof Executor){
            return Plugin.wrap(target,this);//解析 @Intercepts，返回（jdk动态代理）代理对象 没有则抛异常
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("======setProperties(Properties properties)=======");
    }


    private String getSql(BoundSql boundSql){


        return "";
    }
}
