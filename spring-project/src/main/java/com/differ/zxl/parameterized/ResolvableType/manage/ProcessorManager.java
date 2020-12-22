package com.differ.zxl.parameterized.ResolvableType.manage;

import com.differ.zxl.parameterized.ResolvableType.base.Processor;
import org.springframework.beans.factory.annotation.Autowired;

public class ProcessorManager<T> {

    @Autowired
    private Processor<T> processor;


    public void realProcess(T t){
        processor.process(t);
    }


}
