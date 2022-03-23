package com.differ.zxl.zip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


public class GzipUtil {


    public static void main(String[] args) {
        String a = "123";

        System.out.println(a.length());

        String compress = compress(a);
        System.out.println(compress);
        System.out.println(compress.length());

        String uncompress = uncompress(compress);
//        System.out.println(uncompress);
        System.out.println(uncompress.length());
    }

    /**
     * 将字符串进行gzip压缩
     *
     * @param data
     * @return
     */
    public static String compress(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(data.getBytes("utf-8"));
            gzip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] encode = java.util.Base64.getEncoder().encode(out.toByteArray());
        return new String(encode);

    }

    public static String uncompress(String data) {

        byte[] decode = java.util.Base64.getDecoder().decode(data);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(decode);
        GZIPInputStream gzipStream = null;
        try {
            gzipStream = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = gzipStream.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                if (gzipStream != null) {
                    gzipStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new String(out.toByteArray(), Charset.forName("utf-8"));
    }
}