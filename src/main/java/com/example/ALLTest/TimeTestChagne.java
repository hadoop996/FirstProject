package com.example.ALLTest;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 郝少杰
 * @date 2021/2/28 9:42
 */
public class TimeTestChagne {
    public static void main(String[] args) {
        System.out.println(timeFormat("3.6"));
        System.out.println(gtDateVdvoing());
    }
    public static String timeFormat(String time) {
        if(time == null){
            return time;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Double aDouble = Double.valueOf(time);
//        double v = aDouble * 60;
        System.out.println("转换为dubbo类型"+aDouble);
        DecimalFormat df = new DecimalFormat("######0"); //四色五入转换成整数
        int i = Integer.parseInt(df.format(aDouble));
        System.out.println("四舍五入结果"+i);
        int hours = (int) Math.floor(i / 60);
        int minutes = i % 60;
        String average_install_time = stringBuffer.append("" + hours + "小时" + minutes + "分钟").toString();
        return average_install_time;
    }

    public static String gtDateVdvoing() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");

        Date nowTime = null;
        //设定时间段
        Date amBeginTime = null;
        Date amEndTime = null;

        try {
            nowTime = df.parse(df.format(new Date()));
            amBeginTime = df.parse("00:00");
            amEndTime = df.parse("10:06");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //设置当前时间
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        //设置时间段
        Calendar amBegin = Calendar.getInstance();
        amBegin.setTime(amBeginTime);
        Calendar pmBegin = Calendar.getInstance();
        pmBegin.setTime(amEndTime);

        // 判断是否在时间段内
        if ((date.after(amBegin) && date.before(pmBegin))) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            // 前一天的日期
            calendar.add(Calendar.DATE, -1);
            return dateFormat.format(calendar.getTime());
        } else {
            // 当天日期
            return dateFormat.format(new Date());
        }
    }
}
