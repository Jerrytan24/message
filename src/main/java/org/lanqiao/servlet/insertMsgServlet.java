package org.lanqiao.servlet;

//import org.lanqiao.entity.Msg;
//import org.lanqiao.service.MsgServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/insert")
//public class insertMsgServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        String author=request.getParameter("author");
//        String message=request.getParameter("message");
//        Msg msg=new Msg();
//        msg.setAuthor(author);
//        msg.setMsg(message);
//        new MsgServiceImpl().insert(msg);
//        response.sendRedirect("/msg");
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
