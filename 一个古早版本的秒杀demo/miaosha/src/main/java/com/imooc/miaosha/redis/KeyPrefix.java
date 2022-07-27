package com.imooc.miaosha.redis;

/**
 * @author 14688
 * 前缀关键字
 */
public interface KeyPrefix {
		
	public int expireSeconds();
	
	public String getPrefix();
	
}
