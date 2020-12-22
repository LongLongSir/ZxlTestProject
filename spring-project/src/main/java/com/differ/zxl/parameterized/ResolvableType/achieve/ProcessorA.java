package com.differ.zxl.parameterized.ResolvableType.achieve;

import com.differ.zxl.parameterized.ResolvableType.base.EventA;
import com.differ.zxl.parameterized.ResolvableType.base.Processor;
import org.springframework.stereotype.Component;

@Component
public class ProcessorA implements Processor<EventA> {


    @Override
    public void process(EventA eventA) {
        System.out.println("======process eventA=====");
    }
}
