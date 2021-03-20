package com.example.ALLTest;


import org.assertj.core.util.Lists;

import java.util.List;

/**
 * @author 郝少杰
 * @date 2021/3/14 11:19
 */
public class BingTest {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.indexOf(1));
        list.set(list.indexOf(2),list.get(list.indexOf(2))+1);
        System.out.println(list);
//        list.set(1,"99999");
//        System.out.println(list);
    }
}
