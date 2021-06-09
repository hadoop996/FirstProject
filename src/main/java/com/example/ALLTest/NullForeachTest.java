package com.example.ALLTest;

import java.util.ArrayList;
import java.util.List;

public class NullForeachTest {
    public static void main(String[] args) {
        List<String> list = null;
        for (String s : list) {
            System.out.println(1);
        }
        if (list.contains("Q")){
            System.out.println(2);
        }
        List list1 = new ArrayList();
        list.stream().forEach(item->{
            list1.add(item);
        });
    }
}
