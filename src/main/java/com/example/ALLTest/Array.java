package com.example.ALLTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hsj
 * @createTime 2021年07月19日 15:25:00
 */
public class Array {
    public static void main(String[] args) {

        List list = new ArrayList(12);
        System.out.println(list);

        List<String> strings = Arrays.asList("11","12");
        System.out.println(strings);
    }
}
