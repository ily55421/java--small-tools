package com.imooc.miaosha.vo;

import java.time.LocalDateTime;
import java.util.Date;

import com.imooc.miaosha.domain.Goods;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsVo extends Goods{
	private Double miaoshaPrice;
	private Integer stockCount;
	private Date startDate;
	private Date endDate;

	/**
	 * 获取秒杀开始时间
	 * @return
	 */
	public Long getStartTime() {
		return Long.parseLong(LocalDateTime.now().toString());
	}

}
