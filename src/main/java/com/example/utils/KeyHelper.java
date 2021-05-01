package com.example.utils;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.Charset;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA 密钥相关
 *
 * @author sunjinshan@sinovatech.com
 */
public class KeyHelper {
	/**
	 * RSA 加密算法简写
	 */
	public static final String ALGORITHM_RSA = "RSA";
	/**
	 * 签名算法
	 */
	public static final String ALGORITHMS_SHA1WithRSA = "SHA1WithRSA";
	/**
	 * 默认字符集 utf-8
	 */
	public static final String DEFAULT_CHARSET_ENCODING = "UTF-8";
	/**
	 * AES 加密算法简写
	 */
	public static final String ALGORITHM_AES = "AES";
	/**
	 * DES 加密算法简写
	 */
	public static final String ALGORITHM_DES = "DES";
	/**
	 * DES 加密算法简写
	 */
	public static final String PADDING_DES_CBC = "DES/CBC/PKCS5Padding";
	/**
	 * AES 填充方式
	 */
	public static final String PADDING_AES_CBC = "AES/CBC/PKCS5Padding";

	public static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	/**
	 * 实例化公钥
	 *
	 * @param rsaPublicKey 公钥字符串
	 * @return 公钥
	 */
	public static RSAPublicKey getRSAPublicKey(String rsaPublicKey) {
		return getPublicKey(ALGORITHM_RSA, rsaPublicKey);
	}

	/**
	 * 实例化私钥
	 *
	 * @param rsaPrivateKey RSA私钥
	 * @return 私钥
	 */
	public static RSAPrivateKey getRSAPrivateKey(String rsaPrivateKey) {
		return getPrivateKey(ALGORITHM_RSA, rsaPrivateKey);
	}

	/**
	 * 实例化公钥
	 *
	 * @param algorithm 对称算法
	 * @param publicKey 公钥字符串
	 * @return 公钥
	 */
	@SuppressWarnings("unchecked")
	public static <T extends PublicKey> T getPublicKey(String algorithm, String publicKey) {
		X509EncodedKeySpec spec = new X509EncodedKeySpec(DatatypeConverter.parseBase64Binary(publicKey));
		try {
			return (T) KeyFactory.getInstance(algorithm).generatePublic(spec);
		} catch (InvalidKeySpecException e) {
			throw new IllegalArgumentException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException("No such algorithm: " + algorithm, e);
		}
	}

	/**
	 * 实例化私钥
	 *
	 * @param algorithm  对称算法
	 * @param privateKey 私钥字符串
	 * @return 私钥
	 */
	@SuppressWarnings("unchecked")
	public static <T extends PrivateKey> T getPrivateKey(String algorithm, String privateKey) {
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(DatatypeConverter.parseBase64Binary(privateKey));
		try {
			return (T) KeyFactory.getInstance(algorithm).generatePrivate(spec);
		} catch (InvalidKeySpecException e) {
			throw new IllegalArgumentException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException("No such algorithm: " + algorithm, e);
		}
	}

	/**
	 * 添加默认的字符集
	 */
	public static Charset getDefaultCharset() {
		try {
			return Charset.forName(DEFAULT_CHARSET_ENCODING);
		} catch (Exception e) {
			throw new IllegalArgumentException("Unsupported charset " + DEFAULT_CHARSET_ENCODING);
		}
	}


	/**
	 * 生成随机向量,默认大小为cipher.getBlockSize(), 16字节.
	 */
	public static byte[] generateAES_16() {
		byte[] bytes = new byte[16];
		new SecureRandom().nextBytes(bytes);
		return bytes;
	}

	/**
	 * 生成键对
	 *
	 * @param algorithm 加密方式
	 * @param keySize   密钥长度
	 */
	public static KeyPair generateKeyPairs(String algorithm, int keySize) {
		KeyPairGenerator generator;
		try {
			generator = KeyPairGenerator.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException(e);
		}
		try {
			generator.initialize(keySize);
			return generator.generateKeyPair();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	/**
	 * 生成加密密钥
	 *
	 * @param algorithm 加密算法
	 * @param keySize   密钥长度
	 * @return arr[0]:publicKey；arr[1]:privateKey
	 */
	public static String[] generateStringKeyPires(String algorithm, int keySize) {
		KeyPair keyPair = generateKeyPairs(algorithm, keySize);
		String[] rtnArr = new String[2];
		rtnArr[0] = DatatypeConverter.printBase64Binary(keyPair.getPublic().getEncoded());
		rtnArr[1] = DatatypeConverter.printBase64Binary(keyPair.getPrivate().getEncoded());
		return rtnArr;
	}

}
