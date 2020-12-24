package com.example.H5;

/**
 * @author 郝少杰
 * @date 2020/10/27 15:39
 */
public class StrToObj {
    public static void main(String[] args) {
        String str = "ap-guangzhou\n" +
                "ap-shanghai\n" +
                "ap-beijing\n" +
                "ap-chengdu\n" +
                "ap-chongqing\n" +
                "cn-qingdao-b\n" +
                "cn-beijing\n" +
                "cn-zhangjiakou\n" +
                "cn-huhehaote\n" +
                "cn-hangzhou\n" +
                "cn-shanghai\n" +
                "cn-shenzhen\n";
        String[] split = str.split("\n");
        String str1 = "广州\n" +
                "上海\n" +
                "北京\n" +
                "成都\n" +
                "重庆\n" +
                "华北 1 \n" +
                "华北 2\n" +
                "华北 3\n" +
                "华北 5\n" +
                "华东 1\n" +
                "华东 2\n" +
                "华南 1\n";
        String[] split1 = str1.split("\n");
        String a = "";
        for (int i = 0; i < split.length; i++) {
            // <option value="10">内蒙古</option>
            a = a + "<option value=\"" + split[i] + "\">" + split1[i] + "</option>";
        }
        System.out.println(a);
    }
}
