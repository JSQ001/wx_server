package com.jsq.message.impl;

import com.jsq.message.BaseMessage;

/**
 * 类名: TextMessage
 * 描述: 视频消息
 * 开发人员： jsq
 * 创建时间：  2019/03/19
 * 发布版本：V1.0
 */
public class VideoMessage  extends BaseMessage {

    // 媒体ID
    private String MediaId;
    // 语音格式
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }
    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
    public String getThumbMediaId() {
        return ThumbMediaId;
    }
    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }



}
