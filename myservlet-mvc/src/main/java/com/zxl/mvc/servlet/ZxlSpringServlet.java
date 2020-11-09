package com.zxl.mvc.servlet;

import com.alibaba.fastjson.JSON;
import com.zxl.mvc.dto.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/ZxlSpringServlet",loadOnStartup = 1)
public class ZxlSpringServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=====ZxlSpringServlet=====");
        Person p=new Person();
        p.setId(5);
        p.setName("zzzzz");
        resp.getWriter().write(JSON.toJSONString(p));
    }

    @Override
    public void init() throws ServletException {
        super.init();

    }
}
