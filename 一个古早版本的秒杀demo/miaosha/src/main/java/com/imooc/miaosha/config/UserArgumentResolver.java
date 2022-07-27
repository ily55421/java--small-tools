package com.imooc.miaosha.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.service.MiaoshaUserService;

/**
 * @author 14688
 * TODO 用户参数解析器
 */
@Service
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    /**
     * 秒杀服务
     */
    @Autowired
    MiaoshaUserService userService;

    /**
     * 参数支持 判断
     * @param parameter
     * @return
     */
    public boolean supportsParameter(MethodParameter parameter) {
        // 获取请求参数类型
        Class<?> clazz = parameter.getParameterType();

        return clazz != null ? clazz == MiaoshaUser.class : false;
    }

    /**
     * 参数解决处理
     * @param parameter 方法参数
     * @param mavContainer  视图模型容器
     * @param webRequest 原生网络请求
     * @param binderFactory web 数据绑定工厂
     * @return
     * @throws Exception
     */
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //获取原生请求对象
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        //获取原生响应对象
        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
        //获取token请求参数
        String paramToken = request.getParameter(MiaoshaUserService.COOKI_NAME_TOKEN);
        //获取cookie中token的值
        String cookieToken = getCookieValue(request, MiaoshaUserService.COOKI_NAME_TOKEN);
        // 判空
        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
            return null;
        }
        //得到token
        String token = StringUtils.isEmpty(paramToken) ? cookieToken : paramToken;
        // 根据token 返回用户对象
        return userService.getByToken(response, token);
    }

    /**
     * TODO 根据参数名获取cookie中的值
     *
     * @param request 请求对象
     * @param cookiName cookie参数名称
     * @return
     */
    private String getCookieValue(HttpServletRequest request, String cookiName) {
        // 获取所有cookie
        Cookie[] cookies = request.getCookies();
        // 判空
        if (cookies == null || cookies.length <= 0) {
            return null;
        }
        // 获取对应名称的值
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookiName)) {
                return cookie.getValue();
            }
        }
        // 未找到默认返回null
        return null;
    }

}
