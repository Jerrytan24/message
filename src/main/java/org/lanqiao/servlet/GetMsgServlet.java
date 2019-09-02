package org.lanqiao.servlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.lanqiao.entity.Msg;
import org.lanqiao.service.MsgMybatisImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet("/msg")
public class GetMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    private static Logger logger = Logger.getLogger(GetMsgServlet.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Msg>msglist=new MsgMybatisImpl().getAllmsg();
//        request.setAttribute("list",msglist);
//        request.getRequestDispatcher("message.jsp").forward(request,response);
        int pageNo = 1;
        if(request.getParameter("pageNo") != null){
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
        }
        PageHelper.startPage(pageNo, 3);
        //查询
        List<Msg>msglist=new MsgMybatisImpl().getAllmsg();
        //创建PageInfo对象，保存查询出的结果，PageInfo是pageHelper中的对象
        PageInfo<Msg> p =new PageInfo<Msg>(msglist);
        //数据存储到request
        request.setAttribute("pageInfo",p);
        logger.debug("没有问题");
        //转发到message.jsp页面
        request.getRequestDispatcher("pager.jsp").forward(request,response);

    }
}
