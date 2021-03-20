package com.example.utils;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author 郝少杰
 * @date 2021/3/18 18:50
 */
public class AesUtils {

    private static final byte[] IV = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};

    /**
     * 二进制转变为16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte[] buf) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    /**
     * 将16进制转变为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
                    16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * AES解密
     *
     * @param content 密文
     * @param keyWord 密钥
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] content, String keyWord)
            throws Exception {
        if (StringUtils.isEmpty(keyWord)) {
            return null;
        }
        try {
            SecretKeySpec key = new SecretKeySpec(keyWord.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV));
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            throw new Exception("解密失败");
        }
    }

    /**
     * AES 解密
     *
     * @param content 密文
     * @param keyWord 密钥
     * @return
     * @throws Exception
     */
    public static String decrypt(String content, String keyWord)
            throws Exception {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        byte[] contentBytes = parseHexStr2Byte(content);
        byte[] result = decrypt(contentBytes, keyWord);
        return new String(result, "UTF-8");
    }

    /**
     * AES 加密
     *
     * @param content 内容
     * @param keyWord 密钥
     * @return
     */
    public static byte[] encrypt(byte[] content, String keyWord)
            throws Exception {
        if (StringUtils.isEmpty(keyWord)) {
            return null;
        }
        try {
            SecretKeySpec key = new SecretKeySpec(keyWord.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV));
            byte[] encryptedData = cipher.doFinal(content);
            return encryptedData;
        } catch (Exception e) {
            throw new Exception("加密失败");
        }
    }

    /**
     * AES 加密
     *
     * @param content 内容
     * @param keyWord 密钥
     * @return
     */
    public static String encrypt(String content, String keyWord)
            throws Exception {
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        byte[] result = encrypt(content.getBytes("UTF-8"), keyWord);
        return parseByte2HexStr(result);
    }

    public static void main(String[] args) throws Exception {
        //测试密钥
        String secret = "D2XG78VG30yojwca";
        //待加密内容
        String content = "{\"phoneNumber\": \"17611220705\"}";
        //加密
        String encrypt = encrypt(content,secret);
        System.out.println(encrypt);
        //解密
        String decrypt = decrypt(encrypt,secret);
        System.out.println(decrypt);
    }
}
