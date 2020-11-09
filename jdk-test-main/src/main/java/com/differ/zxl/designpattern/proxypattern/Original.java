package com.differ.zxl.designpattern.proxypattern;

public class Original implements OriginBase{

    @Override
    public void printBase() {
        System.out.println("printBase in Original");
    }

//    public void print(){
//        System.out.println("Original operation");
//    }
}
