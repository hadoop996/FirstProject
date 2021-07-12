package com.example.ALLTest;

import com.ohaotian.plugin.base.exception.ZTBusinessException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 郝少杰
 * @date 2020/12/9 15:46
 */
@Slf4j
public class ExceptionTest {

    public static void main(String[] args) {
        try {
            throw new ZTBusinessException("异常");
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

//    public static void main(String[] args) {
//        try {
//            getTry();
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("m---"+e.getMessage());
//            System.out.println("e---"+e);
//        }
//        System.out.println("go on");
//    }
//
//    public static void getTry() throws Exception{
//        String a = null;
//        a.toString();
//        System.out.println("内");
//    }

}
