package com.example.recursion;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 郝少杰
 * @date 2021/3/8 15:43
 */
@Slf4j
public class RecursionTest {
    public static void main(String[] args) {
        int num = 1;
        diGui(num);
        log.info(String.valueOf(num));
    }

    public static int diGui(int num){
        if (num == 6){
            log.info("num符合{}",String.valueOf(num));
            return num;
        }else {
            num++;
            log.info("第一次num不符合，数为{}",String.valueOf(num));
            return diGui(num);
        }

    }
}
