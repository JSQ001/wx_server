package com.jsq.message.impl;

import com.jsq.message.BaseMessage;

/**
 * 类名: TextMessage
 * 描述: 文本消息
 * 开发人员： jsq
 * 创建时间：  2019/03/19
 * 发布版本：V1.0
 */

public class TextMessage extends BaseMessage {
    // 消息内容
    private String Content;
    public String getContent() {
        return Content;
    }
    public void setContent(String content) {
        Content = content;
    }

}
