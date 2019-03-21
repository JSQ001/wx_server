package com.jsq.message;

import com.jsq.message.impl.TextMessage;

import java.util.Map;

/**
 * 类名: BaseMessage
 * 描述: 请求消息的基类
 * 开发人员： jsq
 * 创建时间： 2019/03/19
 * 发布版本：V1.0
 */
public class BaseMessage {
    // 开发者微信号
    protected String ToUserName;
    // 发送方帐号（一个OpenID）
    protected String FromUserName;
    // 消息创建时间 （整型）
    protected long CreateTime;
    // 消息类型（text/image/location/link）
    protected String MsgType;
    // 消息id，64位整型
    protected long MsgId;


    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime() {
        CreateTime = Long.parseLong(String.valueOf(System.currentTimeMillis()).substring(0,10));
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }


    //回复类型
    public  <T> T initMessage(Map<String,String> map) {
        //给实例赋值
        this.setCreateTime();
        this.setFromUserName(map.get("ToUserName"));
        this.setToUserName(map.get("FromUserName")); //此处没弄明白什么鬼，暂时这样取巧
        this.setMsgType(map.get("MsgType"));
        this.setMsgId(Long.parseLong(map.get("MsgId")));
        return (T)this;
    }


    @Override
    public String toString() {
        return this.getToUserName()+"-"+this.getFromUserName()+"-"+this.getCreateTime()+"-"+this.getMsgType()+"-"+this.getMsgId();
    }
}