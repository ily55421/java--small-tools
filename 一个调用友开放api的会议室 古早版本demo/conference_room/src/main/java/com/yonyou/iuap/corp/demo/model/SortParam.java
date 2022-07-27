package com.yonyou.iuap.corp.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SortParam {

    /**
     * 排序字段
     */
    private String field;

    /**
     * 升降序标志
     */
    private Boolean asc = true;


}
