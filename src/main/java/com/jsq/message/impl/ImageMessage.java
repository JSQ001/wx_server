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

    public class Image{
        public Image(String mediaId) {
            MediaId = mediaId;
        }
        //http://mmbiz.qpic.cn/mmbiz_jpg/2qQalmPiaJdQAUiaeEobVTVmia9ckSkkO0Dlc7y2wS4uxe3sfdZaS9sVCDXSvmZiaqxoqtd1wuwiabxXOhc4ukl0uOA/0

        private String MediaId;

        public String getMediaId() {
            return MediaId;
        }

        public void setMediaId(String mediaId) {
            MediaId = mediaId;
        }
    }

    // 图片链接
    private String PicUrl;
    private String MediaId;
    private Image Image;


    public Image getImage() {
        return Image;
    }

    public void setImage(String mediaId) {
        Image = new Image(mediaId);;
    }

    public void setImage2(Image image) {
        Image = image;
    }

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
