package com.zxl.mvc.controller;

import com.zxl.mvc.dto.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/getPerson")
    public Person getPerson(){
        Person p=new Person();
        p.setId(3);
        p.setName("erwe");
        return p;
    }

    @GetMapping("/getPerson/v2")
    public Person getPersonV2(){
        Person p=new Person();
        p.setId(3);
        p.setName("erwe");
        return p;
    }

    @GetMapping("/getPerson/v/3")
    public Person getPersonV3(){
        Person p=new Person();
        p.setId(3);
        p.setName("erwe");
        return p;
    }

}
