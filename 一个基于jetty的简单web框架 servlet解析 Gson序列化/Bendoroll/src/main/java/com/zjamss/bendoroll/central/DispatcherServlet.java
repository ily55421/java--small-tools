package com.zjamss.bendoroll.central;

import com.zjamss.bendoroll.context.Context;
import com.zjamss.bendoroll.context.DefaultHttpContext;
import com.zjamss.bendoroll.exception.ExceptionMapper;
import com.zjamss.bendoroll.handler.Handler;
import com.zjamss.bendoroll.handler.HandlerMapping;
import com.zjamss.bendoroll.handler.HandlerType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Program: cn.zjamss.bendoroll
 * @Description:
 * @Author: ZJamss
 * @Create: 2022-08-03 21:07
 **/

public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String handlerType = req.getMethod();
        String path = req.getRequestURI();
        final HandlerMapping mapping = Context.matchMapping(path, HandlerType.valueOf(handlerType));
        if (mapping != null) {
            final Handler handler = mapping.getHandler();
            resp.getWriter().println("404");
            doProcess(req, resp, handler);
        } else {
            resp.getWriter().println("404");
            throw new RuntimeException("404");
        }
    }

    void doProcess(HttpServletRequest req, HttpServletResponse res, Handler handler) {
        try {
            handler.handle(new DefaultHttpContext(req, res));
        } catch (Exception e) {
            final ExceptionMapper exceptionMapper = Context.matchMapper(e.getClass());
            if (exceptionMapper != null) {
                exceptionMapper.getExceptionHandler().handler(e, new DefaultHttpContext(req, res));
            } else {
                throw e;
            }
        }
    }

}
