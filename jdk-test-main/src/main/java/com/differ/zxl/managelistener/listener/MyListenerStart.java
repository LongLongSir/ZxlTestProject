package com.differ.zxl.managelistener.listener;

import com.differ.zxl.managelistener.event.StartEvent;

public class MyListenerStart implements ZxlEventListener<StartEvent> {

    @Override
    public void onEvent(StartEvent startEvent) {
        System.out.println("Listener startEvent:=====Source:"+startEvent.getSource());
    }
}
