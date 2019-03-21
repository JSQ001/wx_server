package com.jsq.token;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class GetToken {

    public static final String APPID = "wxd3a67b59803060bc";

    public static final String APPSECRET = "1b53bf9648b7c27b1e9cee19fe18e993";

    public static final String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?" +
            "grant_type=client_credential&" +
            "appid=wxd3a67b59803060bc&" +
            "secret=1b53bf9648b7c27b1e9cee19fe18e993";;


    /**全局token 所有与微信有交互的前提 */
    public static String ACCESS_TOKEN;

    /**全局token上次获取事件 */
    public static long LASTTOKENTIME;

    /**
     * 获取全局token方法
     * 该方法通过使用HttpClient发送http请求，HttpGet()发送请求
     * 微信返回的json中access_token是我们的全局token
     */
    public static synchronized void getAccess_token(){
        if(ACCESS_TOKEN == null || System.currentTimeMillis() - LASTTOKENTIME > 7000*1000){
            try {
              //  System.out.println("获取微信服务器接口token...");
                //请求access_token地址
                String url = TOKEN_URL;

                //首先需要先创建一个DefaultHttpClient的实例
                HttpClient httpClient = new DefaultHttpClient();

                //创建提交方式 HttpGet对象,传入目标的网络地址,然后调用HttpClient的execute()方法即可:
                HttpGet httpGet = new HttpGet(url);

                //发送请求并得到响应
                HttpResponse response = httpClient.execute(httpGet);

                //判断请求是否成功
                if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                    //将得到的响应转为String类型
                    String str = EntityUtils.toString(response.getEntity(), "utf-8");
                    //字符串转json
                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        //输出access_token
                      //  System.out.println("微信接口token："+(String) jsonObject.get("access_token"));
                        //给静态变量赋值，获取到access_token
                        ACCESS_TOKEN = (String) jsonObject.get("access_token");
                    }catch (Exception e){
                        e.getStackTrace();
                    }
                    //给获取access_token时间赋值，方便下此次获取时进行判断
                    LASTTOKENTIME = System.currentTimeMillis();
                }
            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
