package com.differ.zxl.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 修改哈希值
 * @auth zhangxl
 * @date 2023/4/4
 */
public class ModifyHashTest {

    /**
     * 假设该对象实例变量a,d是关键域
     * a,d分别相等的对象逻辑相等
     */
    private int a;
    private double d;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModifyHashTest that = (ModifyHashTest) o;
        return a == that.a &&
                Double.compare(that.d, d) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, d);
    }

    public ModifyHashTest(int a, double d) {
        this.a = a;
        this.d = d;
    }

    public ModifyHashTest() {
    }

    @Override
    public String toString() {
        return "HashCodeTest{" +
                "a=" + a +
                ", d=" + d +
                '}';
    }

    public static void main(String[] args) {
        HashMap<ModifyHashTest, Integer> map = new HashMap<>();
        ModifyHashTest h1 = new ModifyHashTest(1, 1.5);
        map.put(h1, 100);
        map.put(new ModifyHashTest(2, 2.5), 200);

        //修改关键域 导致改变哈希值
        h1.a=100;

        System.out.println(map.remove(h1));//null

        Set<Map.Entry<ModifyHashTest, Integer>> entrySet = map.entrySet();
        for (Map.Entry<ModifyHashTest, Integer> entry : entrySet) {
            System.out.println(entry);
        }

    }
}
