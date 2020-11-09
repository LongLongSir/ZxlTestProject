package com.differ.zxl.managelistener.event;

public class ZxlEvent {

    private Object source;

    public ZxlEvent(Object source){
        this.source=source;
    }

    public Object getSource(){
        return this.source;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
