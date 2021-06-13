package com.example.utils;

import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 *
 * RSA非对称加密类
 * @author : john
 * @date : Created 09:58 2017/11/14
 *
 */
public class RsaCrypt {

    private static final String KEY_ALGORITHM = "RSA";
    /**
     *公钥
     */
    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC9RIXk6jheGCzsvZtt1c5ZAChqc22KoO8dOLEY\n"+
    "q6fX2WcCEz43qx06L5s0eySD6xKPg9/PU3tYCaFPtZ1nms45Mb0Nnhp8r0MGTkoWuxbfyEwTe8+M\n"+
    "BgP/oImygbZd3pdv4mhBiEpeM4UOx+syx2/sjDSE6KtbJWozX6co8l+n8wIDAQAB";

    /**
     * 生产私钥
     */
    private static final String PRIVATE_KEY ="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAL1EheTqOF4YLOy9m23VzlkAKGpzbYqg7x04sRirp9fZZwITPjerHTovmzR7JIPrEo+D389Te1gJoU+1nWeazjkxvQ2eGnyvQwZOSha7Ft/ITBN7z4wGA/+gibKBtl3el2/iaEGISl4zhQ7H6zLHb+yMNIToq1slajNfpyjyX6fzAgMBAAECgYEAoxUmIgdHppxCKYN/J/bwpHOkX4UyQB9HqfAteMqAB1dGkN0v4RvKRVa7706kOh8VkR/ae3S9dTBnFJ2zEZCsW9NSQuDigLU34HSUwDehIHuAAav2ELkbZNYgwxgilGujS0pTYsjZoyF4OJmKIVC5MHHU6HaNq9LDBT9Ngix9jyECQQDuo9TdURS+IZ0zCeXREuKWTG+BVKjnwmOuK0LIIWjCXI4mmpYTKcKkysEGMFI6IxXeta4z39DQN7K+rl86ETvLAkEAywk8cCQFZYSTQXiCmppQwHG7OctepcItFJ/7yxK4URA1mlW9GbI88Nw44IkYxWTXkhlA3MBujzGKlSeHjPyPeQJACZhGt7tJ1Tcuxd2RAu36dEaQeSe5PtA/B8KvhbJqLt5fzMeMXyrfq5aHWkNZGwNMHs85ONa345dJtYb3RzNoLwJAXMh6uxBq+upr1MZ6gKY2cstGcPHT7dHfggZeLX3/huPuavn1cZG3Maahw1JDZKlhrd0me/rgS0Wre9/VnQMpmQJBAOIRxG6Xm1W74GkXKUtyOySJrIZy0o8uo0dnolYKcn2r5hysVf+wcoXzTKwchQqYLo9F1IrdUDnWv2pO7clmd+s=";

    private static final String PUBLIC_KEY1 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjizsdeTctALJKRVIBGun2Ole4o+KzDb9zvo77\n" +
            "I8XkmIxGMWuJyYZEuvyOOvb7UW583SlCNMdPNVVavRkscl3dWD5cD0bm2JKTxP9JcTX8BjCew6s5\n" +
            "WhD0WH/5O9mBD0WuWrPZM3CeRo4ofOWA5fTp5IRr4M4yWwV5cM/kusSwXwIDAQAB";
    private static final String PRIVATE_KEY1 = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKOLOx15Ny0AskpFUgEa6fY6V7ij4rMNv3O+jvsjxeSYjEYxa4nJhkS6/I469vtRbnzdKUI0x081VVq9GSxyXd1YPlwPRubYkpPE/0lxNfwGMJ7DqzlaEPRYf/k72YEPRa5as9kzcJ5Gjih85YDl9OnkhGvgzjJbBXlwz+S6xLBfAgMBAAECgYBI/T2v5MZ0RkhMD24O4jUi2F0IIdRudydH//cOLKQIZvDL7wiAoTlUeWN4EubhuTEndwkP7EA7oKDsc1LF3HD5Pm+3U1i0h9MbENRh9igdOT68KPQ27YKU2DAu7Bsp8extsyfgl4UzaDoiE1YidTKIPQQdKjlKURNzJ5Ud9iMkaQJBANtrXXOo+3kk7mjNxHKXohRJEhbrDzmEy+Uqg9GNhtAPVtyE1KOZvTauXQHduRVbedL7br/9kkVVDc4jDkDofLUCQQC+zyVET6FFHyVz3WbUOJnX5IJFWJkXymS7BlgruZD7CUmbPtXvJX6BflwuNVsz9QT6RtzPrQZB6JL1uYGuIPlDAkEAkMPicVfRKpliLoVsEgrXJbkcFUDa16E1ASqus8hDZOxp6647uQDK5NPfi0alQWEMHFZFOKhtJA88v39DfTGmbQJAdeEzfMhVMYbUdIhLhsCRCre5Y24g5nm7UW/R+PFjiDNsreRb9qqLRSTzffiop6ivso8ky4hxXTZ51CUO4KyuUQJAdrfNUcC+3a9UURtznG1Mu6zydGl1qvRDgC3+NZhw9UI61QUYFiyXfOW4Rr6UhC3jP97rVCVCoSWhBmoU+0uM9Q==";

    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;
    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
     * 公钥加密过程
     *
     * @param content 明文数据
     * @return 密文
     *
     */
    public static String encrypt(String content)
            {
        try {
            // 使用默认RSA
            RSAPublicKey rsaPublicKey= KeyHelper.getRSAPublicKey(PUBLIC_KEY);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, rsaPublicKey);
            byte [] data=content.getBytes();
            int inputLen = data.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段加密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] encryptedData = out.toByteArray();
            out.close();
            String result=new BASE64Encoder().encodeBuffer(encryptedData);
            return result.replaceAll("\r|\n", "") ;
        } catch (Exception e) {
            return "";
        }
    }
    /**
     * 私钥解密过程
     *
     * @param content 密文数据
     * @return 明文
  
     *
     */
    public static String decrypt(String content,String a) throws Exception {
        RSAPrivateKey rsaPrivateKey = null;
        if ("0".equals(a)){
            rsaPrivateKey= KeyHelper.getRSAPrivateKey(PRIVATE_KEY1);
        }else if ("1".equals(a)){
            rsaPrivateKey= KeyHelper.getRSAPrivateKey(PRIVATE_KEY);

        }
            // 使用默认RSA
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, rsaPrivateKey);
            int inputLen = Base64.decode(content).length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(Base64.decode(content), offSet, MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(Base64.decode(content), offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_DECRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();
            return new String(decryptedData);
    }
    
    
    /**
     * 私钥解密过程
     *
     * @param content 密文数据
     * @return 明文
     *
     */
    public static String decryptByPublic( String content) throws  Exception{
    	RSAPublicKey rsaPrivateKey= KeyHelper.getRSAPublicKey(PRIVATE_KEY1);
            // 使用默认RSA
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, rsaPrivateKey);
            int inputLen = Base64.decode(content).length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(Base64.decode(content), offSet, MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(Base64.decode(content), offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();
            return new String(decryptedData);
    }



    private static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    /**
     * 秘钥生成方法
     *
     * @return 秘钥对
     * @throws Exception 解密过程中的异常信息
     *
     */
    private static KeyPair initKey() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        return keyPairGen.generateKeyPair();
    }

    public static void main(String[] args) throws Exception {
        String encrypt = "DWt+Bu2ODeEgikhdL5/sYaJgQAowmJUedngCHemkZoyZiK3qx+lnzZyjCTqihTt/Hvb0HWKwwQ+MGQ4rMTsvUeel90XGWasFvp/w0LsKvKIJcC+zL/hPcYxcZ0HsxF5gHiUO8jWhA94khZ3ihgqUuA+3rqfo95PcQ7ISi9YJNis=";

        //解密 a 0 测试 1生产
        String decrypt = decrypt(encrypt,"0");
        System.out.println(decrypt);
    }

}