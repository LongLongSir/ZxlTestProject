package com.differ.zxl.mycomponent;

import com.differ.zxl.annotation.AppSwitch;
import com.differ.zxl.annotation.IncludeAppSwitch;
import org.springframework.stereotype.Component;


@IncludeAppSwitch
@Component
public class AppB {

    @AppSwitch(des = "AppB",code = "zzz")
    public static Integer t=1;
}
