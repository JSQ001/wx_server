package com.jsq.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.net.URISyntaxException;

@Controller
@RequestMapping("/api")
public class Api {
    @GetMapping("/test")
    public ResponseEntity test ()throws URISyntaxException {
        System.out.print("hello world");

        return new ResponseEntity("hello world", HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping("/jsq")
    public void run(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        //OutputStream os=resp.getOutputStream();  //会报错
        out.println("你好啊,我是一个好人");
        out.println("你是一个好人");
        out.close();
    }
}


