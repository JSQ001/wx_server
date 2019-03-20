package com.jsq.message.impl;

import com.jsq.message.BaseMessage;

/**
 * 类名: TextMessage
 * 描述: 请求消息之文本消息
 * 开发人员： jsq
 * 创建时间：  2019/03/19
 * 发布版本：V1.0
 */
public class ImageMessage extends BaseMessage {
    // 图片链接
    private String PicUrl;
    private String MediaId;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

}
