package com.yonyou.iuap.corp.demo.model;

import lombok.*;

/**
 * 分页查询参数
 * @author 14688
 */
@Getter
@Setter
public class UserPageParam {
    /**
     * 第几页
     */
    public String index;
    /**
     * 一页大小
     */
    public String size;
    /**
     * 排序字段，默认按字段升序排列
     */
    public String sortType;
    /**
     * 查询条件(手机号/邮箱/用户名)
     */
    public String searchcode;
}
