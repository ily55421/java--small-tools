package com.imooc.miaosha.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 14688
 * TODO 自定义 Web Mvc 配置器适配器
 */
@Configuration
public class WebConfig  extends WebMvcConfigurerAdapter{
	/**
	 * 用户参数解析器
	 */
	@Autowired
	UserArgumentResolver userArgumentResolver;

	/**
	 * 添加参数解析器
	 * @HandlerMethodArgumentResolver 处理方法参数解析器
	 * @param argumentResolvers  参数解析器
	 */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(userArgumentResolver);
	}
	
	
}
