package com.differ.zxl.parameterized.ResolvableType.achieve;

import com.differ.zxl.parameterized.ResolvableType.base.EventB;
import com.differ.zxl.parameterized.ResolvableType.base.Processor;
import org.springframework.stereotype.Component;

@Component
public class ProcessorB implements Processor<EventB> {

    @Override
    public void process(EventB eventB) {
        System.out.println("======process eventB=====");
    }
}
