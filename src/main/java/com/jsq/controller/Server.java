package com.jsq.controller;

import com.jsq.relpyMsg.MessageUtil;
import com.jsq.utils.WX_Util;
import com.jsq.token.GetToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Administrator on 2018/9/18.
 */
@Controller
@RequestMapping("/")
public class Server extends HttpServlet {
     /**
     * 配置微信公众号基本url，使其获取到token
     * */
    @ResponseBody
    @RequestMapping("/")
    public void run(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(request.getRequestURL());
        System.out.println(request.getMethod());
        if(GetToken.ACCESS_TOKEN==null){
            GetToken.getAccess_token();
        }
        switch (request.getMethod()){
            case "GET":  validateToken(request,response); break;   //token认证
            case "POST": reply(request, response);break;           //回复信息
        }


    }
    private void reply(HttpServletRequest request,HttpServletResponse response){
        //接受微信服务器发送过来的XML形式的消息

        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            request.setCharacterEncoding("UTF-8");
            Map<String , String> map = MessageUtil.xmlToMap(request);
            System.out.println("接收："+map);
            String message = MessageUtil.initText(map);
            System.out.println("回复："+message);
            out.print(message);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            out.close();
        }
    }

    private void validateToken(HttpServletRequest request,HttpServletResponse response){
        String str = WX_Util.check_Url(request);
        try {
            PrintWriter out = response.getWriter();
            //输出
            out.print(str);
            //刷新
            out.flush();
            //关闭流
            out.close();
        }catch (Exception e){
            System.out.println(e);
            System.err.println(e.getMessage());//打印异常原因                   ==》  一般给用户看
            System.err.println(e.toString());//打印异常名称以及异常原因  ==》 很少使用
            e.printStackTrace();//打印异常原因+异常名称+出现异常的位置      ==》 给程序员debug的时候看
        }

    }

}
