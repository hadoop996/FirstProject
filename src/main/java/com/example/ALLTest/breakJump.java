package com.example.ALLTest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 郝少杰
 * @date 2020/12/2 10:05
 */
@Slf4j
public class breakJump {
    public static void main(String[] args) {
        b:for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                if(j==5&&i==j){
                    System.out.println("j:"+j);
                    break b;
                }
            }
            System.out.println("i:"+i);
        }
        System.out.println("11111");
    }
}
