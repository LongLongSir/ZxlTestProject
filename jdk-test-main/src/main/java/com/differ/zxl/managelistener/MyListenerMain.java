package com.differ.zxl.managelistener;

import com.differ.zxl.managelistener.event.ProcessEvent;
import com.differ.zxl.managelistener.listener.MyListenerEnd;
import com.differ.zxl.managelistener.listener.MyListenerProcess;
import com.differ.zxl.managelistener.listener.MyListenerStart;
import com.differ.zxl.managelistener.manage.ZxlMultiCaster;

public class MyListenerMain {


    public static void main(String[] args) {


        ZxlMultiCaster caster=new ZxlMultiCaster();

        caster.addListener(new MyListenerStart());

        caster.addListener(new MyListenerProcess());
        caster.addListener(new MyListenerProcess());
        caster.addListener(new MyListenerProcess());

        caster.addListener(new MyListenerEnd());

        caster.publishEvent(new ProcessEvent("处理源"));


    }

}
