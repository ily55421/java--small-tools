package com.yonyou.iuap.corp.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author 14688
 */
@Getter
@Setter
@Builder
public class StaffPageParam {

    private Integer index = 1;

    private Integer size = 20;

    /**
     * 排序
     */
    private List<SortParam> orders;

}
