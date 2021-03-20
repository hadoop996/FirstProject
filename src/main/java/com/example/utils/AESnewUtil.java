package com.example.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;

/**
 * @author Ning Baoqi
 * @date 2019/10/30 19:15
 */
@Slf4j
public class AESnewUtil {


    private static final String AES = "AES";
    private static final String AES_CBC = "AES/CBC/PKCS5Padding";


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

    public static void main(String[] args) {
        String AESKEY1="db38200f45444fd489aa6c9551bab2e5";
        String AESIV="ac7ff7b9ac3c4376bce0e0b05d1ff284";
        //待加密内容
        String content = "{\"phoneNumber\": \"15532634373\"}";
        String encryption = userLabelAesEncrypt(content, AESKEY1, AESIV);
        System.out.println(encryption);
        String encString = "706689e5bde02b91cff83c208fa806103994e969418259dfcb64eb8b01b9221cb171ea1a56f17fd990a091f87f5ce42052bb8903884090b1295a8bc30173ba5864de625c470d35c3267c191e509257295273c975b6c0ce2e2bf63523b91e4e7feae738391d6bbeff594ca948f70e1c5f";
        String decryption = userLabelDecrypt(encString, AESKEY1, AESIV);
        System.out.println(decryption);
    }
}
