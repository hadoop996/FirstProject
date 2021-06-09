package com.example.ALLTest;

import cn.hutool.core.convert.Convert;

import java.util.*;

public class StringSplic {
    public static void main(String[] args) {
      String a = "10b3glx\n" +
              "10b3gm0\n" +
              "10b3gm1\n" +
              "30b23u5\n" +
              "30b262l\n" +
              "30b3joi\n" +
              "30b40ev\n" +
              "30b40vs\n" +
              "30b4820\n" +
              "30b4fcx\n" +
              "31b28k4\n" +
              "36b3f78\n" +
              "38b3xah\n" +
              "38b4apx\n" +
              "38b4apy\n" +
              "74a3341\n" +
              "74af077\n" +
              "74af244\n" +
              "74b05al\n" +
              "74b05lf\n" +
              "74b0c10\n" +
              "74b0e6z\n" +
              "74b107l\n" +
              "74b2djs\n" +
              "74b3yv7\n" +
              "74b4ut5\n" +
              "74b4ysv\n" +
              "74b4z13\n" +
              "74b4zjd\n" +
              "74b4zjw\n" +
              "74b4zk1\n" +
              "74b4zk8\n" +
              "75a4657\n" +
              "75a4661\n" +
              "75b14r7\n" +
              "75b1eda\n" +
              "75b1imm\n" +
              "75b1imp\n" +
              "75b1inu\n" +
              "75b1ipf\n" +
              "75b1jia\n" +
              "75b1jic\n" +
              "75b1jiu\n" +
              "75b1x3d\n" +
              "75b22fr\n" +
              "75b2m3h\n" +
              "75b2qhg\n" +
              "75b3o0v\n" +
              "75b3o0w\n" +
              "75b3wdh\n" +
              "84b361k\n" +
              "85b3xu9\n" +
              "86b042g\n" +
              "86b07fq\n" +
              "86b0dhp\n" +
              "86b10nn\n" +
              "86b16ns\n" +
              "86b1jbf\n" +
              "86b1kwh\n" +
              "86b1ql5\n" +
              "86b1wm2\n" +
              "86b1ylo\n" +
              "86b21qt\n" +
              "86b21xn\n" +
              "86b25wg\n" +
              "86b2c2q\n" +
              "86b2cf5\n" +
              "86b2dqy\n" +
              "86b2hbn\n" +
              "86b2i05\n" +
              "86b2q70\n" +
              "86b2w15\n" +
              "86b2w18\n" +
              "86b2w1j\n" +
              "86b2w1k\n" +
              "86b2w1o\n" +
              "86b2w1p\n" +
              "86b2w1s\n" +
              "86b2w6r\n" +
              "86b32px\n" +
              "86b37r2\n" +
              "86b3m36\n" +
              "86b3rke\n" +
              "86b3rkn\n" +
              "90b2b3p\n" +
              "91b1fms\n" +
              "97b11hn";

      String b = "中国联通支付有限公司直销服务通辽市分公司库伦旗分公司拓展直销渠道\n" +
              "中国联通支付有限公司直销服务通辽市分公司左中分公司拓展直销渠道\n" +
              "中国联通支付有限公司直销服务通辽市分公司后旗分公司拓展直销渠道\n" +
              "怀远新城营业厅\n" +
              "怀远荆山小西门营业厅\n" +
              "庐江城区营服王成（通发行销）\n" +
              "合肥市蜀山区辰婉通信器材经营部 (装维团队）\n" +
              "合肥市包河区孙伟网络科技服务部（装维团队）\n" +
              "合肥市包河区曹纪安通讯器材经营部（装维团队）\n" +
              "长丰县下塘镇思海CPN代理商\n" +
              "西区尹启社会化合作小区社会渠道\n" +
              "四川通发社会直销（柯城城中）\n" +
              "莆田市荔城区镇海街道玉步代理点（莆田装维团队）\n" +
              "莆田市城厢区霞林街道沟头益帆（非实体店）代理点\n" +
              "莆田市城厢区凤凰山街道龙德井俊平（非实体店）代理点\n" +
              "浏洞阳生物园广源固网沃店\n" +
              "合作装维渠道-岳塘区新蓝田社区沃店\n" +
              "合作装维渠道-湘潭市翼龙网络通信有限公司\n" +
              "合作装维渠道-湘潭市岳塘区博世科技网络通讯服务部\n" +
              "长沙公众社会直销个人\n" +
              "合作装维渠道-永兴城区网格荣鑫科技固网沃店\n" +
              "合作装维渠道-浏阳市蕉溪华信通讯行固网代理商\n" +
              "合作装维渠道-浏阳市淳口镇四通通讯行固网代理商\n" +
              "合作装维渠道-临武同益长城固网便利店\n" +
              "合作装维渠道-湘潭恒宸通信工程有限公司\n" +
              "浏阳市永安镇旺信通讯行固网代理商\n" +
              "雨花区武广网格自控类智家工程师专属渠道\n" +
              "郴州市汝城县汝城城区综合网格自控类智家工程师专属渠道\n" +
              "湘潭市雨湖区城西综合网格自控类专属渠道\n" +
              "湘潭市岳塘区城区综合网格自控类智家工程师专属渠道\n" +
              "湘潭县中路铺综合网格自控类智家工程师专属渠道\n" +
              "湘潭市雨湖新区砂子岭城区综合网格自控类智家工程师专属渠道\n" +
              "鹰潭市贵溪市贵白路塘湾龚辉宽带合作厅\n" +
              "鹰潭市贵溪罗河镇太田村罗河太田志书合作厅\n" +
              "鹰潭市贵溪贵百路志光徐明手机城\n" +
              "临川区秋溪镇王鹏合作厅\n" +
              "贵溪市周坊镇广电宽带合作商\n" +
              "贵溪泗沥镇叶爱民宽带合作商\n" +
              "贵溪市罗河镇商业街广电宽带合作商\n" +
              "鹰潭市贵溪市金屯大道汪敬民宽带合作商\n" +
              "鹰潭市贵溪市滨江镇柏里徐才福宽带合作商\n" +
              "鹰潭市贵溪市河潭周年旺合作商\n" +
              "鹰潭市贵溪县塔桥胡海平宽带合作商\n" +
              "鹰潭市贵溪市雷溪乡涂贵梅宽带合作商\n" +
              "鹰潭市余江县锦江镇李三仁宽带合作商\n" +
              "鹰潭市余江县画桥镇葛兰娇宽带合作商\n" +
              "鹰潭市贵溪市手机城方春亮合作厅\n" +
              "装维团队-鹰潭市月湖区自有代维装维\n" +
              "装维团队-鹰潭市余江县直销代维装维\n" +
              "鹰潭市贵溪市文坊力太联通营业部\n" +
              "吴堡综合网格公众业务组\n" +
              "中网运维科技股份有限公司（赫章城区）\n" +
              "彝良县海诚商贸有限公司固网代理点\n" +
              "威信县联谊网络科技固网代理点\n" +
              "巍山县北隅小区自营厅\n" +
              "镇雄鲁滇通科技有限公司固网渠道\n" +
              "水富鲁滇通科技有限公司固网渠道\n" +
              "云南集客能源化工行业线\n" +
              "华坪县城弘发合作厅\n" +
              "丽江裕祥（集客）直销点\n" +
              "(西山西市区)自有直销渠道\n" +
              "宁蒗县大兴宇翔合作厅\n" +
              "盘龙城东云南陆通网络有限公司\n" +
              "镇雄县林口邓麟书固网代理店\n" +
              "（盘龙北市区营服）云南陆通固网代理商\n" +
              "鲁甸县文屏镇小冲村固网代理点\n" +
              "丽江盛杰（集客）直销点\n" +
              "宁蒗县城大兴宇翔（集客）直销点\n" +
              "镇雄胡庆春集团直销\n" +
              "西山金碧丙投（他建他营）专营店\n" +
              "双柏腾讯地推渠道社会直销\n" +
              "楚雄州楚雄市装机队\n" +
              "楚雄州南华县装机队\n" +
              "楚雄州大姚县装机队\n" +
              "楚雄州永仁县装机队\n" +
              "楚雄州武定县装机队\n" +
              "楚雄州牟定县装机队\n" +
              "楚雄州禄丰县装机队\n" +
              "丽江装维班组（邱德龙）\n" +
              "楚雄市长城宽带有限公司固网BOT直销\n" +
              "下关营销中心（宽带支撑中心）\n" +
              "昭通公众互联网营销部巧家县分部九江自配送社会直销渠道\n" +
              "祥云智联商贸有限责任公司固网直销渠道\n" +
              "官渡区分公司空港网格自有直销渠道\n" +
              "延边州珲春市春化农村网格行销渠道\n" +
              "沈阳市辽中县分公司冷子卜客户服务中心\n" +
              "其他直销-黑河现业公众网格运营中心";
        String[] newStr = a.split("\n");
        String[] oldStr = b.split("\n");
//        Integer[] all = Convert.toIntArray(newStr);
//        Integer[] me = Convert.toIntArray(oldStr);
//        Integer[] all = Convert.toIntArray(newStr);
//        Integer[] me = Convert.toIntArray(oldStr);
//        Integer[] j = getJ(all, me);
//        System.out.println(j.toString());

//        String str = "";
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
