package com.differ.zxl.base.pinganbank;

/**
 * @author 方枫宁
 * @version 1.0
 * @since 10:58 2020/5/6
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {

    public final C c;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        this.c = c;
    }
}
