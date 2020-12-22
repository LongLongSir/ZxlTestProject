package com.differ.zxl.mycomponent;

import com.differ.zxl.annotation.AppSwitch;
import com.differ.zxl.annotation.IncludeAppSwitch;
import org.springframework.stereotype.Component;

@IncludeAppSwitch
@Component
public class AppA {
    @AppSwitch(des = "aaas",code = "faddas")
    private static String s="zcxcz";
}
