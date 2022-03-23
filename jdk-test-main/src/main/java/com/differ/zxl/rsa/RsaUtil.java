/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.differ.zxl.rsa;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @since 2018年6月15日 下午6:36:50
 * @author CaiYH
 * @desc
 */
public class RsaUtil {

    public static final String KEY_ALGORITHM = "RSA";

    private RsaUtil() {
    }

//    private static RsaKeyProperties getInstance() {
//        return SpringUtil.getBean(RsaKeyProperties.class);
//    }

    /**
     * 公钥加密
     *
     * @param data
     *            待加密数据
     * @param key
     *            密钥
     * @return byte[] 加密数据
     */
    public static byte[] encryptByPublicKey(byte[] data, byte[] key) throws Exception {

        // 实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 初始化公钥
        // 密钥材料转换
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);
        // 产生公钥
        PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);

        // 数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        return cipher.doFinal(data);
    }

    /**
     * 私钥解密
     *
     * @param data
     *            待解密数据
     * @param key
     *            密钥
     * @return byte[] 解密数据
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data, byte[] key) throws Exception {
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 生成私钥
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

//    public static void main(String[] args) throws UnsupportedEncodingException, Exception {
//
//        String pubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDFxCw7B5sV/HfQLejp9Pr1P0XaLqkmHMG1cr5stsC7fDtqVNEWIFVxHzqwvlMt4zy6gwbvKVANZ+O0pvAI/f/d3wcMvLVYAgTUKIu7xtETgl9OuOoQgvVGwA+edV1bao9ocoKh3Wz2ZKJYv1AasNJfBJWz//frcMLdf12gG8dVeQIDAQAB";
//
//        String priKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMXELDsHmxX8d9At6On0+vU/RdouqSYcwbVyvmy2wLt8O2pU0RYgVXEfOrC+Uy3jPLqDBu8pUA1n47Sm8Aj9/93fBwy8tVgCBNQoi7vG0ROCX0646hCC9UbAD551XVtqj2hygqHdbPZkoli/UBqw0l8ElbP/9+twwt1/XaAbx1V5AgMBAAECgYAPkiqJW0fyqzYjxfmYshkwRhMR4qqevZTi3G3x0VHLcTScYqEzxMf1aCgO0m1qJ4IYjUh2fCI5a/yZtKshih4jDlfEPpn3w5pXbYQ8Jkm/fV5QjVSdoN6Waic3zuhAy9AkjxM4ceMPkLNHmXysTZZbZXqJ44xayg2EzPdygch8AQJBAPjU94+7UdcckzziIdcEJ/JYaaHpX96hMhzxCckJUci3vXA7X5uSuJ3fSeKkwh6mjTqw7iFmwkXNmS9XEbGfIEkCQQDLdp4v1/jLJmqaHc9kl9iOJr//VEn4QwyplljVmk2ydzP6We/YgBK5heuyyG3kMoSZkwsGWBb9TKQ9KRzXJ+uxAkEA0oxxxZ79CwXU2GmHtMaBfqCtESHFyz2eh7q1SvSlzS8cDoFOzvcBXCR6AlrjHshTLFxVwtGOhT4I5nPINwGscQJAKaaWq2Si4bNzjykbE5SiGDeGhlZS7ieLqAvHE7MKxMXyNgXDO6a8Lo5jua2eEWDmFCotz5ao3iGaXYrVBJZ/gQJAQDpJKeFR7CAYttjGte803QQflqkw62VumEivuclgAhdFKhmiaGLEGyT5drjNPDUqS1tPFA3YylxK6BB9tn/v1g==";
//
//        String ming = "woaitt)#)@";
//
//        // 公钥加密
//        byte[] encoded = RsaUtil.encryptByPublicKey(ming.getBytes(), Base64.decodeBase64(pubKey));
//
//        String 密文 = Base64.encodeBase64String(encoded);
//
//        System.err.println("密文 = " + 密文);
//
//        // 私钥解密
//        byte[] decoded = RsaUtil.decryptByPrivateKey(Base64.decodeBase64(
//                "SmVDzDX9/Zgp9WLFcA3HhoaPfEOP0onipw5S7Z7ngPHxglHDvqgnSRbVV915kDNwXGwp9vZgEsydRX2+SeJgzILHC7C5ctc4bXdH7wuJJuI5wSZCD34YIUP0RMGlIP+n6qvsCVUQHj+l1LdAx1cuLeyBoa5WgVxJUA8BO6mYMog="),
//                Base64.decodeBase64(priKey));
//
//        System.err.println("明文= " + new String(decoded));
//
//    }
}
