package com.tplink.zhangerchi.javaAssignment;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author KusaUsagi
 * @description
 * @date 2020/8/31
 */
public class lambdaTest2 {

    @Test
    public void test1(){

        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("buy with " + aDouble);
            }
        });

        System.out.println("**************");

        happyTime(400, money -> System.out.println("buy with " + money));

    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){

        List<String> list = Arrays.asList("北京","南京","天津");
        List<String> filter = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        System.out.println(filter);

        System.out.println("**************");

        List<String> filter1 = filterString(list, s -> s.contains("京"));


    }
    //根据给定规则过滤集合中的字符串，此规则由Predicate方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();

        for (String s : list){
            if (pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}
