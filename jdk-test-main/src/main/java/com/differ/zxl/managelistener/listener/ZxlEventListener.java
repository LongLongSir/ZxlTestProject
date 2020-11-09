package com.differ.zxl.managelistener.listener;


import com.differ.zxl.managelistener.event.ZxlEvent;

public interface ZxlEventListener<E extends ZxlEvent> {

    void onEvent(E e);
}
