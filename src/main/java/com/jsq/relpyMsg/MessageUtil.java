package com.jsq.relpyMsg;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.jsq.message.BaseMessage;
import com.jsq.message.impl.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import com.thoughtworks.xstream.XStream;

public class MessageUtil {
    public static final Map<Object,Class> msgTypeMap = new HashMap<Object, Class>();
    public static final Map<String,String> textContentMap = new HashMap<String, String>();
    public static final String MESSAGE_TEXT = "text";

    static {
        msgTypeMap.put("text",TextMessage.class);  //文本
        msgTypeMap.put("image",ImageMessage.class);//图片
        msgTypeMap.put("voice",VoiceMessage.class);//语音
        //msgTypeMap.put("music",VoiceMessage.class);//音乐
        //msgTypeMap.put("news",VoiceMessage.class);//图文
        msgTypeMap.put("video",VideoMessage.class);//视频
        msgTypeMap.put("link",LinkMessage.class);//视频
        msgTypeMap.put("location",LocationMessage.class);//视频

        textContentMap.put("1","对啊！我也是这么觉得！小宝贝无敌美！");
        textContentMap.put("2","好可怜啊！你年级轻轻地就瞎了！");
        textContentMap.put("3","暂时还没有什么好的想法啊！");
        String type[] = new String[]{
            "text",     //文本
            "image",    //图片
            "voice",    //语音
            "music",    //音乐
            "news",     //图文
            "video",    //视频
            "shortvideo",//小视频
            "link",     //链接
            "location", //地理位置
            "event",    //事件推送
            "subscribe", //订阅
            "unsubscribe", //取消订阅
            "subscribe", //subscribe(订阅)
            "CLICK",    //CLICK(自定义菜单)
            "VIEW",
            "SCAN",     //用户已关注时的扫描带参数二维码
            "LOCATION", //LOCATION(上报地理位置)
        };
    }


    /**
     * 将XML转为MAP集合
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public static Map<String , String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{

        Map<String , String> map = new HashMap<String, String>();

        SAXReader reader = new SAXReader();

        //从request对象中获取输入流
        InputStream ins = request.getInputStream();

        //使用reader对象读取输入流,解析为XML文档
        Document doc = reader.read(ins);

        //获取XML根元素
        Element root = doc.getRootElement();

        //将根元素的所有节点，放入列表中
        List<Element> list = root.elements();

        //遍历list对象，并保存到集合中
        for (Element element : list) {
            map.put(element.getName(), element.getText());
        }
        ins.close();
        return map;
    }

    /**
     * 图片消息对象转换成xml （多态实现）
     * @param baseMessage 图片消息对象
     * @return xml
     */
    public static String messageToXml(BaseMessage baseMessage) {
        XStream xstream = new XStream();
        //将xml的根节点替换成<xml>  默认为TextMessage的包名
        xstream.alias("xml", baseMessage.getClass());
        return xstream.toXML(baseMessage);
    }

    /**
     * 拼接关注主菜单
     */
    public static String menuText(){
        StringBuffer sb = new StringBuffer();
        sb.append("欢迎关注史上最帅公众号，请选择:\n\n");
        sb.append("1、xbb。\n");
        sb.append("2、cnm。\n\n");
        sb.append("回复？调出主菜单。\n\n");
        return sb.toString();
    }


    /**
     * 初始化回复消息
     */
    public static String initText(Map<String,String> map){
        String text = "";
        switch (map.get("MsgType")){
            case "text":{   //文本消息
                TextMessage textMessage = new TextMessage().initMessage(map);
                switch (map.get("Content")){//回复特定信息
                    case "1":
                        textMessage.setContent("对啊！我也是这么觉得！小宝贝无敌美！");break;
                    case "2":
                        textMessage.setContent("好可怜啊！你年级轻轻地就瞎了！");break;
                    case "3":
                        textMessage.setContent("暂时还没有什么好的想法啊！");break;
                    default: textMessage.setContent(MessageUtil.menuText());break;  //提示菜单
                }

                text = MessageUtil.messageToXml(textMessage);
                System.out.println(textMessage);
                System.out.println("132"+text);
            }break;
            case "event":{  //事件类型
                String eventType = map.get("Event");
                switch (map.get("Event")){
                    case "subscribe":{
                    }
                }
            }
        }

        TextMessage textMessage = new TextMessage();
        return MessageUtil.messageToXml(textMessage);
        //return text;
    }
}