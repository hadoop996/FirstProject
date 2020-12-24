package com.example.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 请求入参报文拼装
 * @Author: lym
 * @CreateDate: 2020/5/20 19:16
 */
public class ReqStrUtils {

    /**
     * 根据能力ID，拼装能力平台报文,繁体字转简体字
     *
     * @author lym
     * @return
     * @exception
     * @date 2020/5/21 11:36
     */

    private static final String app_id = "8kWvRB5qvg";
    private static final String appSecret = "rDG4rBkSBI6ZkG1fbAhjs0rmTtAk5PH6";
    public static final String APP_ID = "APP_ID";
    public static final String TRANS_ID = "TRANS_ID";
    public static final String TIMESTAMP = "TIMESTAMP";
    public static final String TOKEN = "TOKEN";


    public static String getReqStrIntelligence(String reqMsg) {
        Map<String, String> map = getToken();
        // 拼接报文
        StringBuilder sb = new StringBuilder();

        sb.append(" {                                                             ");
        sb.append("     \"UNI_BSS_HEAD\"  :  {                                    ");
        sb.append("         \"RESERVED\"  :  [  {                                 ");
        sb.append("            \"RESERVED_VALUE\"  :  \"ycHy8tAzHK\",             ");
        sb.append("             \"RESERVED_ID\"  :  \"pFOBNIh1qlEL3\"              ");
        sb.append("         }  ],                                                   ");
        sb.append("         \"TRANS_ID\"  :  \"");
        sb.append(map.get(TRANS_ID));
        sb.append("\",                      ");
        sb.append("         \"TIMESTAMP\"  :  \"");
        sb.append(map.get(TIMESTAMP));
        sb.append("\",          ");
        sb.append("         \"TOKEN\"  :  \"");
        sb.append(map.get(TOKEN));
        sb.append("\",                        ");
        sb.append("         \"APP_ID\"  :  \"");
        sb.append(app_id);
        sb.append("\" ");
        sb.append("     },                                                          ");
        sb.append("     \"UNI_BSS_ATTACHED\"  :  {                                   ");
        sb.append("         \"MEDIA_INFO\"  :    \"                                  ");
        sb.append(reqMsg);
        sb.append("    \" },                                                          ");
        sb.append("     \"UNI_BSS_BODY\"  :  {                                      ");
        sb.append("         \"CHANGE_START_REQ\"  :  {                              ");
        sb.append("             \"query\"  :       \"                                ");
        sb.append(reqMsg);
        sb.append("       \"  }                                                       ");
        sb.append("     }                                                          ");
        sb.append(" }                                                              ");
        return sb.toString();
    }

    /**
     * 人脸对比调用能力平台报文
     *
     * @return
     * @throws
     * @author lym
     * @date 2020/5/21 13:53
     */
    public static String getReqStrFaceCompace(String imageBase641, String imageBase642) {
        //生成 timestamp、transId、token
        Map<String, String> map = getToken();
        StringBuilder sb = new StringBuilder();
        sb.append(" {                                                                                               ");
        sb.append("     \"UNI_BSS_HEAD\" :  {                                                                        ");
        sb.append("         \"RESERVED\"  :  [  {                                                                     ");
        sb.append("             \"RESERVED_VALUE\"  :  \"HvGqnAOfKAPFc1CwK2pHE1gciMFDm5y5b0tN5dmk5I9G6KiJ\",            ");
        sb.append("            \"RESERVED_ID\"  :  \"ExJjp\"                                                           ");
        sb.append("         }  ],                                                                                   ");
        sb.append("         \"TRANS_ID\"  :  \"");
        sb.append(map.get(TRANS_ID));
        sb.append("\",                      ");
        sb.append("         \"TIMESTAMP\"  :  \"");
        sb.append(map.get(TIMESTAMP));
        sb.append("\",          ");
        sb.append("         \"TOKEN\"  :  \"");
        sb.append(map.get(TOKEN));
        sb.append("\",                        ");
        sb.append("         \"APP_ID\"  :  \"");
        sb.append(app_id);
        sb.append("\"");
        sb.append("     },                                                                                          ");
        sb.append("     \"UNI_BSS_ATTACHED\"  :  {                                                                    ");
        sb.append("         \"MEDIA_INFO\"  :  \"1212\"                                                                 ");
        sb.append("     },                                                                                          ");
        sb.append("     \"UNI_BSS_BODY\"  :  {                                                                        ");
        sb.append("         \"FACE_COMPARE_REQ\"  :  {                                                                ");
        sb.append("             \"SCENE\"  :  \"02\",                                                                   ");
        sb.append("             \"CERT_NAME\"  :  \"\",                                                                 ");
        sb.append("             \"CERT_NUM\"  :  \"142625199005282072\",                                                               ");
        sb.append("             \"FACEIMG\"  :                                        ");
        sb.append("\"");
        sb.append(imageBase641);
        sb.append("\",");
        sb.append("             \"BASEIMG\"  :                                    ");
        sb.append("\"");
        sb.append(imageBase642);
        sb.append("\",");
        sb.append("             \"SYSTEM\"  : \"02\",                                                                  ");
        sb.append("             \"SYS_CODE\"  :  \"3102\",                                                              ");
        sb.append("             \"IMGCODE\"  : \"12212121\",                                                           ");
        sb.append("             \"PROVINCE_CODE\"  :  \"uB\",                                                           ");
        sb.append("             \"COMPARE_TRANS_ID\"  :  \"uLLxDOsapE6jt2rxwpE2F\",                                     ");
        sb.append("             \"EPARCHY_CODE\"  : \"G\",                                                             ");
        sb.append("             \"PARA\"  :  [  {                                                                     ");
        sb.append("                 \"PARA_ID\"  :  \"au5tPC\",                                                         ");
        sb.append("                 \"PARA_VALUE\"  :  \"uq8G0FdskrA3D9rCE2jlOh9NflCphApCEhOmadhLLq8m\"                 ");
        sb.append("             }  ]                                                                                ");
        sb.append("         }                                                                                       ");
        sb.append("     }                                                                                           ");
        sb.append(" }                                                                                               ");

        return sb.toString();
    }

    /**
     * OCR信息认证在线体验调用能力平台请求报文
     *
     * @return
     * @throws
     * @author lym
     * @date 2020/5/21 14:16
     */
    public static String getReqStrOcrInfo(String imgBase64) {
        //生成 timestamp、transId、token
        Map<String, String> map = getToken();
        StringBuilder sb = new StringBuilder();
        sb.append("  {                                                                                                                                                                                                                                                      ");
        sb.append("      \"UNI_BSS_HEAD\"  :  {                                                                                                                                                                                                                               ");
        sb.append("          \"RESERVED\"  :  [  {                                                                                                                                                                                                                            ");
        sb.append("              \"RESERVED_VALUE\"  :  \"nJdLD9adFyHuIfok3\",                                                                                                                                                                                                  ");
        sb.append("              \"RESERVED_ID\"  :  \"5\"                                                                                                                                                                                                                      ");
        sb.append("          }  ],                                                                                                                                                                                                                                          ");
        sb.append("         \"TRANS_ID\"  :  \"");
        sb.append(map.get(TRANS_ID));
        sb.append("\",                      ");
        sb.append("         \"TIMESTAMP\"  :  \"");
        sb.append(map.get(TIMESTAMP));
        sb.append("\",          ");
        sb.append("         \"TOKEN\"  :  \"");
        sb.append(map.get(TOKEN));
        sb.append("\",                        ");
        sb.append("         \"APP_ID\"  :  \"");
        sb.append(app_id);
        sb.append("\"");
        sb.append("      },                                                                                                                                                                                                                                                 ");
        sb.append("      \"UNI_BSS_ATTACHED\"  :  {                                                                                                                                                                                                                           ");
        sb.append("          \"MEDIA_INFO\"  :  \"vFO9l3aarF4dw12DEipblKy9xjqf6O1zxcuiJCh5M5JzFkkPou2cqMKPJnl0c2k0dLNrMIyvgmy74OKiksEfvxi15NNby7aHyxyccPHreHrjafstnAO7kbAL62Lxx1dj0b6hmxixiN3AgrqLd5oCMma\"                                                                     ");
        sb.append("      },                                                                                                                                                                                                                                                 ");
        sb.append("      \"UNI_BSS_BODY\"  :  {                                                                                                                                                                                                                               ");
        sb.append("          \"OCR_INFO_REQ\"  :  {                                                                                                                                                                                                                           ");
        sb.append("              \"CHANNEL_TYPE\"  :  \"HE1d0Ii\",                                                                                                                                                                                                              ");
        sb.append("              \"OPERATOR_ID\"  :  \"bAoHKm6dcfh\",                                                                                                                                                                                                           ");
        sb.append("              \"PHOTO_INFO\"  :                                                                                                                                                                                           ");
        sb.append("\"");
        sb.append(imgBase64);
        sb.append("\",");
        sb.append("              \"CHANNEL_ID\"  :  \"zoO4\",                                                                                                                                                                                                                   ");
        sb.append("              \"SYS_CODE\"  :  \"M39I09OylHegd\",                                                                                                                                                                                                            ");
        sb.append("              \"FACE_CUT\"  :  \"1\",                                                                                                                                                                                                                         ");
        sb.append("              \"DISTRICT_CODE\"  :  \"prif3h\",                                                                                                                                                                                                              ");
        sb.append("              \"PROVINCE_CODE\"  :  \"rx\",                                                                                                                                                                                                                  ");
        sb.append("              \"EPARCHY_CODE\"  :  \"wt\",                                                                                                                                                                                                                   ");
        sb.append("              \"REQ_TRANS_ID\"  :  \"DIC7MIsE9\",                                                                                                                                                                                                            ");
        sb.append("              \"PARA\"  :  [  {                                                                                                                                                                                                                            ");
        sb.append("                  \"PARA_ID\"  :  \"7CwI\",                                                                                                                                                                                                                  ");
        sb.append("                  \"PARA_VALUE\"  :  \"KM98FxsGNgKIwCxlw58ae07jLqe\"                                                                                                                                                                                         ");
        sb.append("              }  ]                                                                                                                                                                                                                                       ");
        sb.append("          }                                                                                                                                                                                                                                              ");
        sb.append("      }                                                                                                                                                                                                                                                  ");
        sb.append("  }                                                                                                                                                                                                                                                      ");
        return sb.toString();
    }

    public static void main(String[] args) {

    }


    /**
     * 32位md5小写加密
     *
     * @param str
     * @return
     */
    public static String MD5LowerCase32(String str) {

        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            md5.update((str).getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte b[] = md5.digest();

        int i;
        StringBuffer buf = new StringBuffer("");

        for (int offset = 0; offset < b.length; offset++) {
            i = b[offset];
            if (i < 0) {
                i += 256;
            }
            if (i < 16) {
                buf.append("0");
            }
            buf.append(Integer.toHexString(i));
        }

        return buf.toString();
    }

    /**
     * 返回一个map集合，包含拼装报文所需要的信息
     *
     * @return
     * @throws
     * @author lym
     * @date 2020/5/22 13:03
     */
    public static Map<String, String> getToken() {
        Map<String, String> map = new HashMap<>();
        long times = System.currentTimeMillis();
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(times);
        String transId = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(times) + (int) ((Math.random() * 9 + 1) * 100000);
        String token = MD5LowerCase32(APP_ID + app_id + TIMESTAMP + timestamp
                + TRANS_ID + transId + appSecret);
        map.put(TIMESTAMP, timestamp);
        map.put(TRANS_ID, transId);
        map.put(TOKEN, token);
        return map;
    }
}
