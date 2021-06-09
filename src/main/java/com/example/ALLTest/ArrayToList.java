package com.example.ALLTest;

import com.example.utils.JsonUtils;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ArrayToList {
    public static void main(String[] args) {
        String a = "[\"056709887644\",\"056709887646\"]";

        List<Object> objects = JsonUtils.toList(a);
        System.out.println(123);
        System.out.println(objects);
    }
}
