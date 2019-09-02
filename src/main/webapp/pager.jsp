<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/8/25
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="org.lanqiao.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://page.way2a.com/tag" prefix="pager" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html lang="en">
<head>
    <title>留言板</title>
    <meta charset="UTF-8">
    <style>
        div {
            margin: 0;
            padding: 0;
            font-size: 12px;
            margin: 0 auto;
        }

        h3 {
            text-align: center
        }

        #container {
            width: 500px;
        }

        .article {
            border: 1px solid #a6cbe7;
            margin-top: 5px;
        }

        .author {
            background-color: #0099FF;
            width: 100%;
            height: 24px;
            line-height: 24px;
        }

        .content {
            height: 40px;
            padding: 10px;
        }

        .author span {
            float: right;
            padding-right: 10px;
        }

        .time {
            border-top: solid 1px #a6cbe7;
        }

        .page {
            text-align: right;
            height: 30px;
            line-height: 30px;
            padding-right: 10px;
        }
    </style>
</head>

<body>
<div id="container">
    <div><h3>留言板</h3></div>
    <div>
        <c:forEach var="msg" items="${pageInfo.list}">
            <div class="article">
                <div class="author">用户:${msg.author}<span>${msg.id}#</span></div>
                <div class="content">${msg.msg}</div>
                <div class="time page">发表于:${msg.date}</div>${msgList[0].author}
            </div>
        </c:forEach>
    </div>
    <div class="page">
        <pager:page pageNo="${pageInfo.pageNum}" totalRecord="${pageInfo.total}" pageSize="${pageInfo.pageSize}" url="/get"></pager:page>
    </div><br>
    <div>
        <c:forEach var="error" items="${errors}">
            <div>${error.getDefaultMessage()}</div>
        </c:forEach>
    </div>
    <div>
        <form action="/insert" method="post">
            <div>
                用户: <input type="text" name="author" value=""/>
            </div><br>
            <div>
                留言: <textarea name="msg" rows="5" cols="72"></textarea>
            </div>
            <div align="center"><input type="reset" value="清除"/> <input type="submit" value="发表"/></div>
        </form>
    </div>
</div>
</body>
</html>
