package com.differ.zxl.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ZxlModel {

    public static void main(String[] args) {
        String createBegin = LocalDate.now().plusDays(-30).format(DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00"));
        System.out.println(createBegin);




    }

}
