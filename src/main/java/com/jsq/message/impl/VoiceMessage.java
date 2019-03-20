package com.jsq.message.impl;

import com.jsq.message.BaseMessage;

/**
 * 类名: TextMessage
 * 描述: 声音消息
 * 开发人员： jsq
 * 创建时间：  2019/03/19
 * 发布版本：V1.0
 */
public class VoiceMessage extends BaseMessage {

    // 媒体ID
    private String MediaId;
    // 语音格式
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}