package com.example.ALLTest;

import cn.hutool.core.convert.Convert;

import java.util.*;

public class StringSplic {
    public static void main(String[] args) {
        String a = "86b042g\n" +
                "86b07fq\n" +
                "86b10nn\n" +
                "86b16ns\n" +
                "86b21xn\n" +
                "86b2c2q\n" +
                "86b2hbn\n" +
                "86b3m36";
        String b = "彝良县海诚商贸有限公司固网代理点\n" +
                "威信县联谊网络科技固网代理点\n" +
                "镇雄鲁滇通科技有限公司固网渠道\n" +
                "水富鲁滇通科技有限公司固网渠道\n" +
                "镇雄县林口邓麟书固网代理店\n" +
                "鲁甸县文屏镇小冲村固网代理点\n" +
                "镇雄胡庆春集团直销\n" +
                "昭通公众互联网营销部巧家县分部九江自配送社会直销渠道";
        String[] newStr = a.split("\n");
        String[] oldStr = b.split("\n");
//        Integer[] all = Convert.toIntArray(newStr);
//        Integer[] me = Convert.toIntArray(oldStr);
        String str = "";
        for (int i=0;i<newStr.length;i++) {
            String update = "";
            update = "update t_install_person set source_channel_name = '"+oldStr[i]+"' where source_channel_code = '"+ newStr[i]+"' and source_channel_name is null and status = 1";
            System.out.println(update);
        }
    }

    /**
     * 求并集
     *
     * @param m
     * @param n
     * @return
     */
    private static Integer[] getB(Integer[] m, Integer[] n)
    {
        // 将数组转换为set集合
        Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(m));
        Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(n));

        // 合并两个集合
        set1.addAll(set2);

        Integer[] arr = {};
        return set1.toArray(arr);
    }

    /**
     * 求交集
     *
     * @param m
     * @param n
     * @return
     */
    private static Integer[] getJ(Integer[] m, Integer[] n)
    {
        List<Integer> rs = new ArrayList<Integer>();

        // 将较长的数组转换为set
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(m.length > n.length ? m : n));

        // 遍历较短的数组，实现最少循环
        for (Integer i : m.length > n.length ? n : m)
        {
            if (set.contains(i))
            {
                rs.add(i);
            }
        }

        Integer[] arr = {};
        return rs.toArray(arr);
    }

    /**
     * 求差集
     *
     * @param m
     * @param n
     * @return
     */
    private static Integer[] getC(Integer[] m, Integer[] n)
    {
        // 将较长的数组转换为set
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(m.length > n.length ? m : n));

        // 遍历较短的数组，实现最少循环
        for (Integer i : m.length > n.length ? n : m)
        {
            // 如果集合里有相同的就删掉，如果没有就将值添加到集合
            if (set.contains(i))
            {
                set.remove(i);
            } else
            {
                set.add(i);
            }
        }

        Integer[] arr = {};
        return set.toArray(arr);
    }

}
