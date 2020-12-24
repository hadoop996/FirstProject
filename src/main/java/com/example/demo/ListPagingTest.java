package com.example.demo;


import com.example.utils.PagingList;

import java.util.*;

/**
 * @author kevin.chen
 * Date 2017/11/9
 * Time 18:05
 */
public class ListPagingTest {


    public static void main(String[] args) {
        List<String> list = Arrays.asList("ab", "ce", "re", "asf", "saf", "abc", "111", "222", "333", "444", "555");

        PagingList<String> paging = new PagingList<>(list, 2);


        Map<String, Object> map = new HashMap<>();
        map.put("data", paging.pag(2, 6, list));
        map.put("pageTotal", Math.ceil((double) (list.size()) / 2));
        map.put("total", list.size());
        System.out.println(map);
//        while (paging.hasNext()) {
//            paging.next().forEach(System.out::println);
//            System.out.println(paging.getCurPageNo()+"-----"+paging.getTotalPage());
//        }
    }
}
