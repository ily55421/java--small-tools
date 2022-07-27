package com.yonyou.iuap.corp.demo.model;

import lombok.*;

/**
 * 通用的消息体参数
 * @author 14688
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonContent {

    /**
     * 租户id
     */
    private String tenantId;

    /**
     * 应用id
     */
    private String appId;

    /**
     * 文本内容
     */
    private String title;

    /**
     * 文本描述
     */
    private String content;


}
