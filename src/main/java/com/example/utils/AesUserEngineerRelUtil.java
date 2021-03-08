package com.example.utils;

import com.example.domain.Engineer;
import com.example.domain.User;
import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import net.sf.json.JSONObject;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringEscapeUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 支持HMAC-SHA1消息签名 ??DES/AES对称加密的工具类.
 * 
 * 支持Hex与Base64两种编码方式.
 * 
 * @author 石龙义
 */
public class AesUserEngineerRelUtil {
	private static final String AES = "AES";
	private static final String AES_CBC = "AES/CBC/PKCS5Padding";
	private static final int DEFAULT_AES_KEYSIZE = 128;
	private static final int DEFAULT_IVSIZE = 16;

	private static SecureRandom random = new SecureRandom();

	/**
	 * 使用AES加密原始字符??
	 * 
	 * @param input 原始输入字符数组
	 * @param key 符合AES要求的密??
	 */
	public static byte[] aesEncrypt(byte[] input, byte[] key) {
		return aes(input, key, Cipher.ENCRYPT_MODE);
	}

	/**
	 * 使用AES加密原始字符??
	 * 
	 * @param input 原始输入字符数组
	 * @param key 符合AES要求的密??
	 * @param iv 初始向量
	 */
	public static byte[] aesEncrypt(byte[] input, byte[] key, byte[] iv) {
		return aes(input, key, iv, Cipher.ENCRYPT_MODE);
	}

	/**
	 * 使用AES解密字符?? 返回原始字符??
	 * 
	 * @param input Hex编码的加密字符串
	 * @param key 符合AES要求的密??
	 */
	public static String aesDecrypt(byte[] input, byte[] key) {
		byte[] decryptResult = aes(input, key, Cipher.DECRYPT_MODE);
		return new String(decryptResult);
	}

	/**
	 * 使用AES解密字符?? 返回原始字符??
	 * 
	 * @param input Hex编码的加密字符串
	 * @param key 符合AES要求的密??
	 * @param iv 初始向量
	 */
	public static String aesDecrypt(byte[] input, byte[] key, byte[] iv) {
		byte[] decryptResult = aes(input, key, iv, Cipher.DECRYPT_MODE);
		return new String(decryptResult);
	}

	/**
	 * 使用AES加密或解密无编码的原始字节数?? 返回无编码的字节数组结果.
	 * 
	 * @param input 原始字节数组
	 * @param key 符合AES要求的密??
	 * @param mode Cipher.ENCRYPT_MODE ??Cipher.DECRYPT_MODE
	 */
	private static byte[] aes(byte[] input, byte[] key, int mode) {
		try {
			SecretKey secretKey = new SecretKeySpec(key, AES);
			Cipher cipher = Cipher.getInstance(AES);
			cipher.init(mode, secretKey);
			return cipher.doFinal(input);
		} catch (GeneralSecurityException e) {
			// throw Exceptions.unchecked(e);
			return null;
		}
	}

	/**
	 * 使用AES加密或解密无编码的原始字节数?? 返回无编码的字节数组结果.
	 * 
	 * @param input 原始字节数组
	 * @param key 符合AES要求的密??
	 * @param iv 初始向量
	 * @param mode Cipher.ENCRYPT_MODE ??Cipher.DECRYPT_MODE
	 */
	private static byte[] aes(byte[] input, byte[] key, byte[] iv, int mode) {
		try {
			SecretKey secretKey = new SecretKeySpec(key, AES);
			IvParameterSpec ivSpec = new IvParameterSpec(iv);
			Cipher cipher = Cipher.getInstance(AES_CBC);
			cipher.init(mode, secretKey, ivSpec);
			return cipher.doFinal(input);
		} catch (GeneralSecurityException e) {
			// throw Exceptions.unchecked(e);
			return null;
		}
	}

	/**
	 * 生成AES密钥,返回字节数组, 默认长度??28??16字节).
	 */
	public static byte[] generateAesKey() {
		return generateAesKey(DEFAULT_AES_KEYSIZE);
	}

	/**
	 * 生成AES密钥,可??长度??28,192,256??
	 */
	public static byte[] generateAesKey(int keysize) {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
			keyGenerator.init(keysize);
			SecretKey secretKey = keyGenerator.generateKey();
			return secretKey.getEncoded();
		} catch (GeneralSecurityException e) {
			// throw Exceptions.unchecked(e);
			return null;
		}
	}

	/**
	 * 生成随机向量,默认大小为cipher.getBlockSize(), 16字节.
	 */
	public static byte[] generateIV() {
		byte[] bytes = new byte[DEFAULT_IVSIZE];
		random.nextBytes(bytes);
		return bytes;
	}




	private static final String DEFAULT_URL_ENCODING = "UTF-8";

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
	 * Base64编码.
	 */
	public static String base64Encode(byte[] input) {
		return new String(Base64.encodeBase64(input));
	}

	/**
	 * Base64编码, URL安全(将Base64中的URL非法字符如+,/=转为其他字符, 见RFC3548).
	 */
	public static String base64UrlSafeEncode(byte[] input) {
		return Base64.encodeBase64URLSafeString(input);
	}

	/**
	 * Base64解码.
	 */
	public static byte[] base64Decode(String input) {
		return Base64.decodeBase64(input);
	}

	/**
	 * URL 编码, Encode默认为UTF-8.
	 */
	public static String urlEncode(String input) {
		try {
			return URLEncoder.encode(input, DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("Unsupported Encoding Exception", e);
		}
	}

	/**
	 * URL 解码, Encode默认为UTF-8.
	 */
	public static String urlDecode(String input) {
		try {
			return URLDecoder.decode(input, DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("Unsupported Encoding Exception", e);
		}
	}

	/**
	 * Html 转码.
	 */
	public static String htmlEscape(String html) {
		return StringEscapeUtils.escapeHtml(html);
	}

	/**
	 * Html 解码.
	 */
	public static String htmlUnescape(String htmlEscaped) {
		return StringEscapeUtils.unescapeHtml(htmlEscaped);
	}

	/**
	 * Xml 转码.
	 */
	public static String xmlEscape(String xml) {
		return StringEscapeUtils.escapeXml(xml);
	}

	/**
	 * Xml 解码.
	 */
	public static String xmlUnescape(String xmlEscaped) {
		return StringEscapeUtils.unescapeXml(xmlEscaped);
	}

	/**
	 * 调用示例
	 * @param args
	 */
	public static void main(String[] args) {
		//秘钥、向量-生产
//		String ENKEY = "a78092a4b0d040d69e1a624181d9babe";
//		String IV = "7bf502cebdce578d67c333fcc5631067";
		//秘钥、向量-测试
		String ENKEY = "a78092a4b0d040d69e1a624181d9babe";
		String IV = "7bf502cebdce578d67c333fcc5631067";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("phone","18618473899");



//


//		String enStr = AesUserEngineerRelUtil.hexEncode(AesUserEngineerRelUtil.aesEncrypt(JsonUtils.toString(jsonObject).getBytes(), AesUserEngineerRelUtil.hexDecode(ENKEY), AesUserEngineerRelUtil.hexDecode(IV)));
//		System.out.println(enStr);
//		// 解密
//		String deStr = AesUserEngineerRelUtil.aesDecrypt(AesUserEngineerRelUtil.hexDecode(JsonUtils.toString(jsonObject)), AesUserEngineerRelUtil.hexDecode(ENKEY), AesUserEngineerRelUtil.hexDecode(IV));
//		System.out.println("de==="+deStr);

//		String enStr = AesUserEngineerRelUtil.hexEncode(AesUserEngineerRelUtil.aesEncrypt(JsonUtils.toString(jsonObject).getBytes(), AesUserEngineerRelUtil.hexDecode(ENKEY), AesUserEngineerRelUtil.hexDecode(IV)));

		String a = "fd2c9a6e424d89ed213fa223872ba8381b9186362762a292e64e02c443cc8952594aed24687c78a182fe85e711730f5e6cec68d55f04f59a1d2207b6bf6efefc547b6093406b5444ffcd58884377db968f2afb29b8af052b548d4edfcbc1af0a";
//		System.out.println(enStr);
		// 解密
		String deStr = AesUserEngineerRelUtil.aesDecrypt(AesUserEngineerRelUtil.hexDecode(a), AesUserEngineerRelUtil.hexDecode(ENKEY), AesUserEngineerRelUtil.hexDecode(IV));
		System.out.println(deStr);
	}

//	public static String mianmi(){
//		Date d = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//
//		User user = new User();
//		user.setAddress("生产测试地址");
//		user.setCardId("1");
//		user.setCardType("1");
//		user.setCity("110");
//		user.setMobile("18612081234");
//		user.setName("生产测试宽带账号");
//		user.setNumber("1122334455");
//		user.setProductId("123");
//		user.setProductName("生产测试商品");
//		user.setProvince("11");
//
//		Engineer engineer = new Engineer();
//		engineer.setCity("110");
//		engineer.setDevelopDepartId("91-0910");
//		engineer.setDevelopDepartName("生产测试渠道名称");
//		engineer.setDevelopId("1107663252");
//		engineer.setDevelopName("姜圆贺");
//		engineer.setState("1");
//		engineer.setDevelopStaffId("18322339149");
//		engineer.setId("18612345678");
//		engineer.setMobile("18618473899");
//		engineer.setName("姜圆贺");
//		engineer.setProvince("11");
//
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("engineer",engineer);
//		jsonObject.put("user",user);
//		jsonObject.put("bindTime",sdf.format(d));
//	}
}