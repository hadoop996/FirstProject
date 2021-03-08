package com.example.ALLTest;

import java.util.Arrays;


/**
 * @author 郝少杰
 * @date 2021/2/4 16:21
 */
public class PublicListTest {
    public static void main(String[] args) {
//        String a ="03";
//        String[] phoneList = {"01","06","12","14","19","20","23","24","25","27","28","29"};
//        String[] broadbandList = {"03","15","21","31"};
//        if (Arrays.asList(phoneList).contains(a)){
//            System.out.println(123);
//        }else if (Arrays.asList(broadbandList).contains(a)){
//            System.out.println(321);
//        }

        String userPhone = "0140-01016725170";
//        if (1==1){
//            String str=c.substring(0, c.indexOf("-"));
//            c = c.substring(str.length()+1,c.length());
//        }
//        System.out.println(c);

        String[] broadbandList = {"03","15","21","31"};
        if (Arrays.asList(broadbandList).contains("03")){
            //传入宽带账号 截取字符串
            String str=userPhone.substring(0, userPhone.indexOf("-"));
            userPhone = userPhone.substring(str.length()+1,userPhone.length());
            System.out.println(userPhone);
        }
    }
}
