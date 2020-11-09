package com.differ.zxl.springtest.ResolvableType.manage;

import com.differ.zxl.springtest.ResolvableType.base.Processor;
import org.springframework.beans.factory.annotation.Autowired;

public class ProcessorManager<T> {

    @Autowired
    private Processor<T> processor;


    public void realProcess(T t){
        processor.process(t);
    }


}
