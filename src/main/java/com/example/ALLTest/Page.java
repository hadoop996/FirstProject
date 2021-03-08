package com.example.ALLTest;

import com.github.pagehelper.PageHelper;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 郝少杰
 * @date 2021/1/20 13:48
 */
public class Page {
    public static void main(String[] args) {
        List list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add(0,"5");
        System.out.println(list);
    }
}
