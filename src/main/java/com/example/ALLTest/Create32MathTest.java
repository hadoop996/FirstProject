package com.example.ALLTest;

import java.util.Random;

/**
 * @author 郝少杰
 * @date 2021/2/26 15:42
 */
public class Create32MathTest {
    public static void main(String[] args) {
        Random rand = new Random();
        StringBuffer sb=new StringBuffer();
        for (int i=1;i<=32;i++){
            int randNum = rand.nextInt(9)+1;
            String num=randNum+"";
            sb=sb.append(num);
        }
        String random=String.valueOf(sb);
        System.out.println(random);
    }
}
