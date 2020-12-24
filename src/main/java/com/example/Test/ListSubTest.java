package com.example.Test;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * @author 郝少杰
 * @date 2020/11/20 16:20
 */
public class ListSubTest {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        int i = 0;
        list.add(i++);
        System.out.println(list);
        System.out.println(++i);
    }
}
