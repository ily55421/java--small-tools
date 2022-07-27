package com.yonyou.iuap.corp.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yonyou.iuap.corp.demo.constraint.EventType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 事件内容
 */
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventContent implements Serializable {

    /**
     * 事件类型
     **/
    private EventType type;

    /**
     * 事件唯一的业务 uuid
     **/
    private String eventId;

    /**
     * 事件创建的 unix 时间戳
     **/
    private long timestamp;

    /**
     * 事件涉及的租户 id
     **/
    private String tenantId;

    /**
     * 变动的 staff id
     **/
    private String[] staffId;

    /**
     * 变动的 dept id
     **/
    private String[] deptId;

    /**
     * 变动的 user id
     */
    private String[] userId;

}
