package com.example.H5;

import com.example.utils.Encrypt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 郝少杰
 * @date 2020/9/14 15:13
 */
@Component
@Slf4j
public class Demo {
    @Value("${test.public.url123}")
    static String a;

    public static void main(String[] args) throws Exception {
        String url = "http://t.newbuydev.chinaunicom.cn/sp/gzclzx/H5/H5.html";
        for (String s : GenShortKey(url)) {

            System.out.println(s);
        }
//        System.out.println("报错前");
//        String a = getMath1();
//        System.out.println("报错后");
    }

    private static String getLastMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
        date = calendar.getTime();
        String accDate = format.format(date);
        return accDate;
    }

    public static String getDate() {
        long l = System.currentTimeMillis();
        Date date = new Date(l);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nyr = dateFormat.format(date);
        return nyr;
    }

    private static String getPreDay(String strData) {
        String preDate = "";
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(strData);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day1 = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day1 - 1);
        preDate = sdf.format(c.getTime());
        return preDate;
    }

    private static String getLastMonth1() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
        date = calendar.getTime();
        String accDate = format.format(date);
        return accDate;
    }

    public static String getMath() throws Exception {
        String a = null;
        a.toString();
        return "456";
    }

    public static String getMath1() throws Exception {
        String a = null;
        try {
            a = getMath();
        } catch (Exception e) {
            log.error(e.getMessage());
            //throw new Exception(e.getMessage());
        }
        System.out.println(a);
        return a;
    }

    public static void subStr() {
        String a = "http://10.10.10.10:8080?to_url=http&a=123&b=21312&ticket=123&vvvv=1233333";
        int b = a.indexOf("to_url");
        String[] xxStrings = a.substring(b).split("\\&");
        for (String z : xxStrings) {
            if (z.length() > 6) {
                if ("ticket".equals(z.substring(0, 6))) {
                    System.out.println(z.substring(7));
                    break;
                }
            }
        }
        String a1 = null;
        if (a1 == null) {
            System.out.println("123");
        }
        System.out.println(getPreDay("2020-09-24 15:21:22"));
        System.out.println(getPreDay("2020-10-13"));
        System.out.println(getLastMonth1());
    }

    public static String[] GenShortKey(String url) {
        String[] resUrl = new String[4];
        String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
                "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A",
                "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
                "W", "X", "Y", "Z"
        };
        // 可以自定义生成 MD5 加密字符传前的混合加密key
        int max = 100, min = 1;
        long randomNum = System.currentTimeMillis();
        int ran3 = (int) (randomNum % (max - min) + min);

        String key = "strategy" + ran3;
        // 对传入网址进行 MD5 加密，key是加密字符串
        String sMD5EncryptResult = Encrypt.md5(key + url);
        String hex = sMD5EncryptResult;

        for (int i = 0; i < 4; i++) {
            // 把加密字符按照8位一组16进制与0x3FFFFFFF进行位与运算
            String sTempSubString = hex.substring(i * 8, i * 8 + 8);

            // 这里需要使用 long 型来转换，因为 Inteter.parseInt() 只能处理 31 位 , 首位为符号位 , 如果不用 long ，则会越界
            long lHexLong = 0x3FFFFFFF & Long.parseLong(sTempSubString, 16);
            String outChars = "";
            for (int j = 0; j < 6; j++) {
                // 把得到的值与 0x0000003D 进行位与运算，取得字符数组 chars 索引
                long index = 0x0000003D & lHexLong;
                // 把取得的字符相加
                outChars += chars[(int) index];
                // 每次循环按位右移 5 位
                lHexLong = lHexLong >> 5;
            }
            // 把字符串存入对应索引的输出数组
            resUrl[i] = outChars;
        }
        return resUrl;
    }


}


