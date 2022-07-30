package com.sovava.web.servlet;

import com.alibaba.fastjson.JSON;
import com.sovava.pojo.Opera;
import com.sovava.pojo.PageBean;
import com.sovava.servlet.OperaService;
import com.sovava.servlet.impl.OperaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Description: TODO
 *
 * @author: ykn
 * @date: 2022年07月29日 17:19
 **/
@WebServlet("/opera/*")
public class OperaServlet extends BaseServlet {
    private OperaService operaService = new OperaServiceImpl();

    /**
     * Description: 查询所有
     *
     * @param request:
     * @param response:
     * @author: ykn
     * @date: 2022/7/29 21:59
     * @return: void
     */
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 调用service查询
        List<Opera> operas = operaService.selectAll();
        String jsonString = JSON.toJSONString(operas);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 新增一个剧目
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        Opera opera = JSON.parseObject(s, Opera.class);

        operaService.add(opera);
        response.getWriter().write("success");

    }

    /**
     * 批量删除
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        String s = reader.readLine();

        int[] ids = JSON.parseObject(s, int[].class);
        operaService.deleteByIds(ids);
        response.getWriter().write("success");
    }


    /**
     * 根据条件查询
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        System.out.println(_currentPage + "---" + _pageSize);
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        BufferedReader reader = request.getReader();
        String s = reader.readLine();

        Opera opera = JSON.parseObject(s, Opera.class);

        PageBean<Opera> operaPageBean = operaService.selectByPageAndCondition(currentPage, pageSize, opera);

        String jsonString = JSON.toJSONString(operaPageBean);
        System.out.println(jsonString);
        response.setContentType("text/json;charset=utf-8");

        response.getWriter().write(jsonString);
    }

    public void playOpera1(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println(11);
        String localPath = new String(request.getParameter("localPath").getBytes("ISO-8859-1"), "utf-8");
        System.out.println(localPath);
        int i = localPath.lastIndexOf('/');
        localPath = localPath.substring(i);


//        Runtime ru = Runtime.getRuntime();
//        try {
//            调用播放器文件播放指定MP4 注意,media Player路径和要播放的文件路径中间用一个空格隔开.
//            Process p1 = ru.exec("C:\\Program Files\\Windows Media Player\\wmplayer D:\\我的2\\京剧\\视频" + localPath);
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

//        request.setAttribute("localpath",localPath);
//        request.getRequestDispatcher("/play.jsp").forward(request,response);
    }
}
