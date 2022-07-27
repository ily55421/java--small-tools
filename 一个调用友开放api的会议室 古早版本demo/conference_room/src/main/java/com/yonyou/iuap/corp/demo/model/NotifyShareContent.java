package com.yonyou.iuap.corp.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 描述: 工作通知消息体
 *
 * @author mantan
 * @create 2019-04-09 下午4:51
 */
@Getter
@Setter
public class NotifyShareContent extends CommonContent{

    /**
     * 有地址时点击跳转: 移动端打开地址
     */
    private String url;

    /**
     * 有地址时点击跳转: WEB打开地址
     */
    private String webUrl;

    /**
     * 接收范围，list根据to发送
     */
    private String sendScope;

    /**
     * sendScope=list时，接收人范围，yhtUserIds列表结构，用户ID列表
     */
    private List<String> yhtUserIds;

    NotifyShareContent(String tenantId, String appId, String title, String content) {
        super(tenantId, appId, title, content);
    }


}
