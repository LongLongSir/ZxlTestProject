package com.differ.zxl;

import com.differ.zxl.annotation.AppSwitch;
import com.differ.zxl.annotation.IncludeAppSwitch;
import com.differ.zxl.mycomponent.AppA;
import com.differ.zxl.mycomponent.AppB;
import com.differ.zxl.mycomponent.IMyComp;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@AutoConfigureAfter  //只对spring.factories文件中的配置类排序
@Configuration
@ComponentScan(basePackages = "com.differ.zxl.mycomponent")
public class SpringMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringMain.class);

        //AppA appA = (AppA) context.getBean("appA");

        IMyComp myComp=context.getBean(IMyComp.class);

        //String[] strs = context.getBeanNamesForAnnotation(IncludeAppSwitch.class);

//        Map<String, Object> map = context.getBeansWithAnnotation(IncludeAppSwitch.class);
//
//        map.entrySet().forEach(t->{
//            Field[] fields = t.getValue().getClass().getDeclaredFields();
//            for (Field field: fields) {
//                if(Modifier.isStatic(field.getModifiers()) && Modifier.isPublic(field.getModifiers())){
//                    field.setAccessible(true);
//                    AppSwitch annotation = field.getAnnotation(AppSwitch.class);
//                    System.out.println(field.getDeclaringClass().toString()+"========="+annotation.des()+"=========="+annotation.code());
//                }
//            }
//
//        });


    }

}
