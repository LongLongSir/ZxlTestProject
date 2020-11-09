package com.differ.zxl.managelistener.listener;


import com.differ.zxl.managelistener.event.EndEvent;

public class MyListenerEnd implements ZxlEventListener<EndEvent> {

    @Override
    public void onEvent(EndEvent endEvent) {
        System.out.println("Listener endEvent:=====Source:"+endEvent.getSource());
    }
}
