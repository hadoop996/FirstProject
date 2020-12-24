package com.example.ALLTest;

import org.assertj.core.util.Lists;

import java.util.Collections;
import java.util.List;

/**
 * @author 郝少杰
 * @date 2020/12/2 11:18
 */
public class SortList {
    public static void main(String[] args) {
        List list = Lists.newArrayList();
        list.add(1);
        list.add(12);
        list.add(14);
        list.add(15);
        list.add(16);
        Collections.sort(list);
    }
}
