package com.sovava.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Description: TODO
 *
 * @author: ykn
 * @date: 2022年07月29日 17:12
 **/
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 获取请求路径
        String uri = req.getRequestURI();

        //获取最后一段路径
        int index = uri.lastIndexOf('/');

        String methodName = uri.substring(index + 1);

        System.out.println(methodName);
        //2. 获取方法  Opera/selectAll

        Class<? extends BaseServlet> cls = this.getClass();

        Method method = null;
        try {
            method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
