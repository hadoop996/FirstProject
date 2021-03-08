package com.example.ALLTest;

import org.assertj.core.util.Lists;

import java.text.DecimalFormat;
import java.util.List;

/**
 * @author 郝少杰
 * @date 2021/2/19 15:52
 */
public class ListSizeTest {
    public static void main(String[] args) {

        List list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println(list.subList(1,1));

    }
}
