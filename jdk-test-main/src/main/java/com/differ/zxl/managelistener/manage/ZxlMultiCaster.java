package com.differ.zxl.managelistener.manage;

import com.differ.zxl.managelistener.event.ZxlEvent;
import com.differ.zxl.managelistener.listener.ZxlEventListener;
import org.springframework.core.ResolvableType;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZxlMultiCaster {


    private Map<String,List<ZxlEventListener>> listenerList=new HashMap<>();


    public void addListener(ZxlEventListener eventListener){
        //ResolvableType r=ResolvableType.forClass(eventListener.getClass().getInterfaces()[0]);
        //ResolvableType generic = r.getGeneric();

        //spring 获取泛型参数的方法
        ResolvableType theType = ResolvableType.forClass(eventListener.getClass()).as(ZxlEventListener.class).getGeneric();

        //获取泛型参数类型
        Class<?> genericClazz = (Class)((ParameterizedType)eventListener.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];

        String cacheKey = buildListenerCacheKey(genericClazz);
        List<ZxlEventListener> list = listenerList.get(cacheKey);
        if(list==null){
            list=new ArrayList<>();
        }
        list.add(eventListener);
        listenerList.put(cacheKey,list);
    }


    public void publishEvent(ZxlEvent event){
        String cacheKey = buildListenerCacheKey(event.getClass());
        List<ZxlEventListener> list = listenerList.get(cacheKey);
        if(list==null){
            System.out.println("=====没有这个事件的监听器，事件类型："+ event.getClass().getName());
        }else{
            list.forEach(t->t.onEvent(event));
        }
    }


    private String buildListenerCacheKey(Class<?> clazz){
        return clazz.getTypeName();
    }


}
