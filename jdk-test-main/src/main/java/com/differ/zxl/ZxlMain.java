package com.differ.zxl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.differ.zxl.dto.ZxlDTO;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;
import java.util.stream.Collectors;

public class ZxlMain {


    public static void main(String[] args) {

//        Map<String,String> map=new HashMap<>();
//        map.put("1","a");
//        map.put("2","b");
//        map.put(null,"xxx");
//
//        System.out.println(map.get("1"));
//        System.out.println(map.get(""));
//        System.out.println(map.get(null));

//        Integer i=128;
//
//        String str="123_21";
//        int index=str.indexOf("_");
//        if(index==-1){
//            index=str.length();
//        }
//        System.out.println(str.substring(0,index));
//
//        List<ZxlDTO> list=new ArrayList<>();
//
//        list.sort((x,y)->x.getSort()-y.getSort());
//
//        Map<String, List<ZxlDTO>> collect = list.stream().collect(Collectors.groupingBy(t -> t.getName()));

        //collect.values().forEach();


//        JSON.parseArray("[\"2427806376819903844\"]");


        MultiValueMap<String, String> paramters = new LinkedMultiValueMap<>();

        paramters.add("zxcz","123");
        paramters.add("ewr","456");
        String jsonStr=JSON.toJSONString(paramters);
        System.out.println(jsonStr);

        MultiValueMap<String, String> paramters2 = new LinkedMultiValueMap<>();
        Object param=JSON.parse(jsonStr);
        if(param instanceof JSONObject){
            ((JSONObject)param).getInnerMap().forEach((key,val)->{
                String realVal;
                if(val instanceof JSONArray){
                    realVal = ((JSONArray) val).get(0).toString();
                }else {
                    realVal=val.toString();
                }
                //realVal=JSON.toJSONString(val);
                System.out.println("key="+key+"，val="+realVal);
                paramters2.add(key,JSON.toJSONString(val));
            });

        }
    }

}
