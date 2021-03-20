package com.example.utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;

/**
 * @author wangby
 * @Classname AesUtil
 * @Description AES加密解密工具类
 * @Date 2019/3/21 14:28
 */
@Slf4j
public class AesUtil {

    private static final String AES = "AES";
    private static final String AES_CBC = "AES/CBC/PKCS5Padding";


    /**
     * @功能:推送加密
     * @param str
     * @return
     */
//    public static String pushAesEncrypt(String str) {
//        return  hexEncode(aesEncrypt(str.getBytes(),
//                 hexDecode(MobileHallContans.PUSH_KEY),
//                 hexDecode(MobileHallContans.PUSH_IV)));
//    }


    /**
     * Hex编码.
     */
    public static String hexEncode(byte[] input) {
        return Hex.encodeHexString(input);
    }
    /**
     * Hex解码.
     */
    public static byte[] hexDecode(String input) {
        try {
            return Hex.decodeHex(input.toCharArray());
        } catch (DecoderException e) {
            throw new IllegalStateException("Hex Decoder exception", e);
        }
    }

    /**
     * 使用AES加密原始字符�?
     *
     * @param input
     *            原始输入字符数组
     * @param key
     *            符合AES要求的密�?
     * @param iv
     *            初始向量
     */
    public static byte[] aesEncrypt(byte[] input, byte[] key, byte[] iv) {
        return aes(input, key, iv, Cipher.ENCRYPT_MODE);
    }

    /**
     * 使用AES加密或解密无编码的原始字节数�? 返回无编码的字节数组结果.
     *
     * @param input
     *            原始字节数组
     * @param key
     *            符合AES要求的密�?
     * @param iv
     *            初始向量
     * @param mode
     *            Cipher.ENCRYPT_MODE �?Cipher.DECRYPT_MODE
     */
    private static byte[] aes(byte[] input, byte[] key, byte[] iv, int mode) {
        try {
            SecretKey secretKey = new SecretKeySpec(key, AES);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance(AES_CBC);
            cipher.init(mode, secretKey, ivSpec);
            return cipher.doFinal(input);
        } catch (GeneralSecurityException e) {
            log.error(e.getMessage(),e);
            return null;
        }
    }



    /**
     * 加密
     * 1.构造密钥生成器
     * 2.根据ecnodeRules规则初始化密钥生成器
     * 3.产生密钥
     * 4.创建和初始化密码器
     * 5.内容加密
     * 6.返回字符串
     */
    public static String aesEncode(String encodeRules, String content)  {
        try {
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(encodeRules.getBytes());
            keygen.init(128, secureRandom);
            //3.产生原始对称密钥
            SecretKey original_key = keygen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] raw = original_key.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(raw, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte[] byte_encode = content.getBytes("utf-8");
            //9.根据密码器的初始化方式--加密：将数据加密
            byte[] byte_AES = cipher.doFinal(byte_encode);
            //10.将加密后的数据转换为字符串
            //这里用Base64Encoder中会找不到包
            //解决办法：
            //在项目的Build path中先移除JRE System Library，再添加库JRE System Library，重新编译后就一切正常了。
            String AES_encode = new String(new BASE64Encoder().encode(byte_AES));
            //11.将字符串返回
            return AES_encode;
        } catch (Exception e) {
            log.error("加密算法异常",e.getMessage());
            return null;
        }
    }

    /**
     * 解密
     * 解密过程：
     * 1.同加密1-4步
     * 2.将加密后的字符串反纺成byte[]数组
     * 3.将加密内容解密
     */
    public static String aesDecode(String encodeRules, String content) throws InvalidKeyException {
        //1.构造密钥生成器，指定为AES算法,不区分大小写
        String AES_decode = null;
        try {
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            SecureRandom secureRandom=SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(encodeRules.getBytes());
            keygen.init(128, secureRandom);
            //3.产生原始对称密钥
            SecretKey original_key = keygen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] raw = original_key.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(raw, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, key);
            //8.将加密并编码后的内容解码成字节数组
            byte[] byte_content = new BASE64Decoder().decodeBuffer(content);
            /*
             * 解密
             */
            byte[] byte_decode = cipher.doFinal(byte_content);
            AES_decode = new String(byte_decode, "utf-8");
        } catch (Exception e) {
            log.error("解密算法异常",e.getMessage());
            throw new InvalidKeyException("解密异常");
        }
        return AES_decode;
    }
//    public static void main(String[] args) {
//        String password = AppPushAesIndexEnum.getRandomValue().getValue();
//
//        //log.info("结果：{}", "CfAaVIBblv+0ZpR4tL96fw==" == result);
//        try {
//            String content = "UUID" +"0005"+ AppPushAesIndexEnum.TWO.getValue();
//            String result = pushAesEncrypt(content);
//            log.info("加密:{}",result);
//        }catch (Exception e) {
//            log.error(e.getMessage(),e);
//        }
//
//    }

    /**
     * 充值信息同步使用：解密
     */
    public static byte[] aesRecharge(byte[] input, byte[] key, byte[] iv) {
        try {
            SecretKey secretKey = new SecretKeySpec(key, AES);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance(AES_CBC);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
            return cipher.doFinal(input);
        }
        catch (GeneralSecurityException e) {
            return new byte[]{};
        }
    }
    /**
     * 充值信息同步使用：加密
     */
    public static byte[] aesRechargeNew(byte[] input, byte[] key, byte[] iv, int mode) {
        try {
            SecretKey secretKey = new SecretKeySpec(key, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(mode, secretKey, ivSpec);
            return cipher.doFinal(input);
        }
        catch (GeneralSecurityException e) {
            return new byte[]{};
        }
    }

    /**
     * @功能:解密
     * @param str
     * @return
     */
    /**
     * @功能:解密
     * @param content 解密内容
     * @param key 密钥
     * @param iv 加密向量
     * @return
     */
    public static String userLabelDecrypt(String content,String key,String iv) {
        String hexEncode = aesDecrypt(
                AesUtil.hexDecode(content),
                AesUtil.hexDecode(key),
                AesUtil.hexDecode(iv));
        return hexEncode;
    }

    /**
     * @功能:加密
     * @param content
     * @param key 密钥
     * @param iv 加密向量
     * @return
     */
    public static String userLabelAesEncrypt(String content,String key,String iv) {
        return  hexEncode(aesEncrypt(content.getBytes(),
                hexDecode(key),
                hexDecode(iv)));
    }
    /**
     * 使用AES解密字符�? 返回原始字符�?
     *
     * @param input Hex编码的加密字符串
     * @param key   符合AES要求的密�?
     * @param iv    初始向量
     */
    public static String aesDecrypt(byte[] input, byte[] key, byte[] iv) {
        byte[] decryptResult = aes(input, key, iv, Cipher.DECRYPT_MODE);
        return new String(decryptResult);
    }



}
