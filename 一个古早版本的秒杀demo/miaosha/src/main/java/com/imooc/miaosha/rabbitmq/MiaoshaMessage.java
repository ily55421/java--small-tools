package com.imooc.miaosha.rabbitmq;

import com.imooc.miaosha.domain.MiaoshaUser;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 14688
 */
@Getter
@Setter
public class MiaoshaMessage {
	private MiaoshaUser user;
	private long goodsId;

}
