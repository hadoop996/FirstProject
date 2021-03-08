package com.example.ALLTest;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author 郝少杰
 * @date 2021/2/7 23:30
 */
public class MathTest1 {
    public static void main(String[] args) {
        get();
    }

    public static void get(){
        for (int i = 7;i<=9;i++){
            int c = i+8;
            int c1 = i+2;
            int c2 = 213+i;
            BigDecimal bigDecimal = new BigDecimal(c1*100);
            // 除数，实现2/12
            BigDecimal divisor = new BigDecimal(c);
            MathContext mc = new MathContext(4, RoundingMode.HALF_UP);
            Double calcResult = bigDecimal.divide(divisor, mc).doubleValue();

            BigDecimal bigDecima2 = new BigDecimal(c2);
            // 除数，实现2/12
            BigDecimal divisor2 = new BigDecimal(c);
            MathContext mc2 = new MathContext(2, RoundingMode.HALF_UP);
            Double calcResult2 = bigDecima2.divide(divisor2, mc2).doubleValue();
            String a = "update t_smart_engineer_month set install_order_count = "+c+",complete_order_count ="+c1+",install_total_time ="+c2+",success_rate ="+calcResult+" ,average_install_time ="+calcResult2+" where date_vdoing ='2021-02-0"+i+"' and engineer_name  not in ('杨萌','郭强')";

//            String a1 = "update e_customer_evaluation_month set evaluation_score = "+c+" where date_vdoing ='2021-02-"+i+"' and engineer_name ='郭强'";
//            String a2 = "update e_customer_evaluation_month set evaluation_score_avg  = "+calcResult +" where date_vdoing ='2021-02-"+i+"'  and engineer_name ='郭强'";
            System.out.println(a);
//            System.out.println(a1);
//            System.out.println(a2);
        }
    }
}
