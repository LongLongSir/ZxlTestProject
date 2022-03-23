package com.differ.zxl.rsa;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * @auth zhangxl
 * @date 2022/1/13
 */
public class DecodeMain {

    public static void main(String[] args) {
        String privateKey="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMXELDsHmxX8d9At6On0+vU/RdouqSYcwbVyvmy2wLt8O2pU0RYgVXEfOrC+Uy3jPLqDBu8pUA1n47Sm8Aj9/93fBwy8tVgCBNQoi7vG0ROCX0646hCC9UbAD551XVtqj2hygqHdbPZkoli/UBqw0l8ElbP/9+twwt1/XaAbx1V5AgMBAAECgYAPkiqJW0fyqzYjxfmYshkwRhMR4qqevZTi3G3x0VHLcTScYqEzxMf1aCgO0m1qJ4IYjUh2fCI5a/yZtKshih4jDlfEPpn3w5pXbYQ8Jkm/fV5QjVSdoN6Waic3zuhAy9AkjxM4ceMPkLNHmXysTZZbZXqJ44xayg2EzPdygch8AQJBAPjU94+7UdcckzziIdcEJ/JYaaHpX96hMhzxCckJUci3vXA7X5uSuJ3fSeKkwh6mjTqw7iFmwkXNmS9XEbGfIEkCQQDLdp4v1/jLJmqaHc9kl9iOJr//VEn4QwyplljVmk2ydzP6We/YgBK5heuyyG3kMoSZkwsGWBb9TKQ9KRzXJ+uxAkEA0oxxxZ79CwXU2GmHtMaBfqCtESHFyz2eh7q1SvSlzS8cDoFOzvcBXCR6AlrjHshTLFxVwtGOhT4I5nPINwGscQJAKaaWq2Si4bNzjykbE5SiGDeGhlZS7ieLqAvHE7MKxMXyNgXDO6a8Lo5jua2eEWDmFCotz5ao3iGaXYrVBJZ/gQJAQDpJKeFR7CAYttjGte803QQflqkw62VumEivuclgAhdFKhmiaGLEGyT5drjNPDUqS1tPFA3YylxK6BB9tn/v1g==";

        String password="Q/qXsEsmM9ooyINuxgRiKMb6avadCIZ4mz4sXG4BsVGrOqMFIh38mlb036vw4yv+crYL4WOo++s8zODrjFDkffQZvE+2MiIR7sObCQauKV6h7/c7FDce3eDwAzrl5vlhX/68QuUimBTocoIODab5I2bnv8F+vl2FkyuAH/6PZRY=";

        // 解密密码
        try {
            byte[] decode = RsaUtil.decryptByPrivateKey(Base64.decodeBase64(password), Base64.decodeBase64(privateKey));

            System.out.println( new String(decode));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
