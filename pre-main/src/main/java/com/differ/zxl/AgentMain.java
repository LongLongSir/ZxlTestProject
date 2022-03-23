package com.differ.zxl;

import com.alibaba.fastjson.JSON;
import com.differ.zxl.model.User;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * @auth zhangxl
 * @date 2020/12/31
 */
public class AgentMain {


    public static void premain(String args, Instrumentation ins){
        System.out.println("=====premain begin=======");
        System.out.println("args:"+args);
        User user=new User();
        user.setName("zxl");
        user.setAge(18);
        System.out.println(JSON.toJSONString(user));
        System.out.println("=====premain end=======");
        ins.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
                System.out.println("加载的类："+className);
                return new byte[0];
            }
        });
    }

}
