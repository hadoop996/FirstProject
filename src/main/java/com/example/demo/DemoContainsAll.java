package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class DemoContainsAll {
    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("a");         //向列表中添加数据

        list.add("b");        //向列表中添加数据

        list.add("c");        //向列表中添加数据

        list.add("d");        //向列表中添加数据


        List<String> list1 = new ArrayList<String>();

        list1.add("a");         //向列表中添加数据

        list1.add("b");        //向列表中添加数据

        list1.add("d");        //向列表中添加数据

        containsList(list, list1);
        // System.out.println(list.containsAll(list1));

    }

    //Check the expectList in actualList
    public static void containsList(List<String> actualList, List<String> expectList) {
        if (actualList.containsAll(expectList)) {
            System.out.println("true");
        } else {
            expectList.retainAll(actualList);
            System.out.println(expectList);
        }
    }
}
