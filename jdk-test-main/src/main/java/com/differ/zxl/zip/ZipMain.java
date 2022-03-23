package com.differ.zxl.zip;

import cn.hutool.core.util.ZipUtil;

/**
 * @auth zhangxl
 * @date 2021/10/14
 */
public class ZipMain {

    public static void main(String[] args) {
//                String data="casf g dfg gfgsdsb  sdfv   dsg但是经过iOS的 发到手机 gdfgd";
        //String data="snowolf@zlex.org;dongliang@zlex.org;zlex.dongliang@zlex.org";

        String data="[838243]调用接口:[FinFbsFeignClient.getWalletvalue],参数:[\"838243\",1265421981503818752,null] 耗时: 7 ms 返回：{\"code\":200,\"msg\":\"查询成功！\",\"result\":{\"contextId\":\"1266518988743082240\",\"data\":[{\"companyId\":\"676788847422342016\",\"companyName\":\"北京天时恒生网络股份有限公司\",\"walletType\":\"-1\",\"trValue\":1599.0,\"cuValue\":1599.0,\"offerTrValue\":0.0,\"offerCuValue\":0.0,\"sumTrValue\":1599.0,\"sumCuValue\":1599.0,\"fcCode\":\"CNY\",\"fcName\":\"人民币\",\"frozenTrValue\":0,\"frozenCuValue\":0}]},\"subCode\":\"0240100802\"}";


        byte[] inbytes = data.getBytes();
        System.out.println(inbytes.length);
        byte[] zlib = ZipUtil.zlib(inbytes, 5);
        System.out.println(zlib.length);
        System.out.println(new String(zlib));
        System.out.println("==================");
        byte[] bytes = ZipUtil.unZlib(zlib);
        System.out.println(new String(bytes));
        System.out.println("==================");
        byte[] zlib1 = ZipUtil.zlib(data, "UTF-8", 2);
        System.out.println(zlib1.length);
        byte[] bytes1 = ZipUtil.unZlib(zlib);



    }

}
