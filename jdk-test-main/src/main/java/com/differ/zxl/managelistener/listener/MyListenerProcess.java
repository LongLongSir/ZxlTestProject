package com.differ.zxl.managelistener.listener;

import com.differ.zxl.managelistener.event.ProcessEvent;

public class MyListenerProcess implements ZxlEventListener<ProcessEvent> {

    @Override
    public void onEvent(ProcessEvent processEvent) {
        System.out.println("Listener processEvent:=====Source:"+processEvent.getSource());
    }

}
