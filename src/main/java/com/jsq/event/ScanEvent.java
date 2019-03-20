package com.jsq.event;

/**
 * 类名: ScanEvent
 * 描述: 扫描带参数二维码事件
 * 开发人员： jsq
 * 创建时间： 2019/03/19
 * 发布版本：V1.0
 */
public class ScanEvent extends BaseEvent {
    // 事件KEY值
    private String EventKey;
    // 用于换取二维码图片
    private String Ticket;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }
}