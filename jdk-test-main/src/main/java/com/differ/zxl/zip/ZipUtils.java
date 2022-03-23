package com.differ.zxl.zip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * @auth zhangxl
 * @date 2021/10/14
 */
public class ZipUtils {

    public static void main(String[] args) {
        String data="casf g dfg gfgsdsb  sdfv   dsg但是经过iOS的 发到手机 gdfgd";
        //String data="snowolf@zlex.org;dongliang@zlex.org;zlex.dongliang@zlex.org";

        byte[] inByte = data.getBytes();

        System.out.println(inByte.length);

        byte[] compress = compress(inByte);
        System.out.println(compress.length);


        String s = new String(compress);


        byte[] outBytes = decompress(compress);

        System.out.println(s);
        System.out.println("==============");
        System.out.println(new String(outBytes));

    }


    public static byte[] compress(byte[] data) {
        byte[] output = new byte[0];

        Deflater compresser = new Deflater();

        compresser.reset();
        compresser.setInput(data);
        compresser.finish();
        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length);
        try {
            byte[] buf = new byte[1024];
            while (!compresser.finished()) {
                int i = compresser.deflate(buf);
                bos.write(buf, 0, i);
            }
            output = bos.toByteArray();
        } catch (Exception e) {
            output = data;
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        compresser.end();
        return output;
    }


    public static byte[] decompress(byte[] data) {
        byte[] output = new byte[0];

        Inflater decompresser = new Inflater();
        decompresser.reset();
        decompresser.setInput(data);

        ByteArrayOutputStream o = new ByteArrayOutputStream(data.length);
        try {
            byte[] buf = new byte[1024];
            while (!decompresser.finished()) {
                int i = decompresser.inflate(buf);
                o.write(buf, 0, i);
            }
            output = o.toByteArray();
        } catch (Exception e) {
            output = data;
            e.printStackTrace();
        } finally {
            try {
                o.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        decompresser.end();
        return output;
    }

}
