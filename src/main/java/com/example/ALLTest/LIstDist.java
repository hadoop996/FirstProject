package com.example.ALLTest;

import com.example.utils.JsonUtils;
import org.assertj.core.util.Lists;

import java.util.List;

/**
 * @author 郝少杰
 * @date 2020/12/22 15:33
 */
public class LIstDist {
    public static void main(String[] args) {
        List list1 = Lists.newArrayList();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("z");

        List list2 = Lists.newArrayList();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("d");
        list2.add("e");
        list2.add("f");

        list2.removeAll(list1);
        System.out.println(JsonUtils.toString(list2));
    }
}
