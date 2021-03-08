package com.example.ALLTest;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author 郝少杰
 * @date 2021/2/7 23:30
 */
public class MathTest {
    public static void main(String[] args) {
        get();
    }

    public static void get(){
        for (int i = 10;i<=28;i++){
            int c = i+3;
            int d = i+4;
            BigDecimal bigDecimal = new BigDecimal(c);
            // 除数，实现2/12
            BigDecimal divisor = new BigDecimal(i);
            MathContext mc = new MathContext(2, RoundingMode.HALF_UP);
            Double calcResult = bigDecimal.divide(divisor, mc).doubleValue();
            String a = "update e_customer_evaluation_month set evaluation_count = "+d+",evaluation_score = "+c+ ",evaluation_score_avg  = "+calcResult +" where date_vdoing ='2021-02-"+i+"' and engineer_name not in ('杨萌','郭强')";

//            String a1 = "update e_customer_evaluation_month set evaluation_score = "+c+" where date_vdoing ='2021-02-"+i+"' and engineer_name ='郭强'";
//            String a2 = "update e_customer_evaluation_month set evaluation_score_avg  = "+calcResult +" where date_vdoing ='2021-02-"+i+"'  and engineer_name ='郭强'";
            System.out.println(a);
//            System.out.println(a1);
//            System.out.println(a2);
        }
    }
}
