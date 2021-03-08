package com.example.ALLTest;

import com.example.utils.ValidatorUtil;

/**
 * @author 郝少杰
 * @date 2021/3/3 20:19
 */
public class RegexTest {
    public static void main(String[] args) {
        String a = "1393265-667";
        System.out.println(ValidatorUtil.isMobile(a));

    }
}
