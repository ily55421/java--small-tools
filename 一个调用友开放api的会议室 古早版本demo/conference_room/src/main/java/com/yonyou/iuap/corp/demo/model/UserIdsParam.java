package com.yonyou.iuap.corp.demo.model;

import lombok.*;

import java.util.List;

/**
 * 描述: 根据用户ids查询用户信息请求参数
 *
 * @author mantan
 * @create 2019-08-06 下午1:21
 */
@Getter
@Setter
public class UserIdsParam {
    private List<String> userIds;

}
