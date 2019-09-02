<%@ page import="java.util.List" %>
<%@ page import="org.lanqiao.entity.Msg" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/8/22
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>留言板</title>
    <meta charset="UTF-8">
    <style>
        .error {
            color: red
        }
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
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/jquery.validate.js"></script>
    <script src="js/jquery.validate.regex.js"></script>
</head>
<body>
<div id="container">
    <div><h3>留言板</h3></div>
    <div>
        <%
            List<Msg>msgList=(List<Msg>)request.getAttribute("list");
            for(Msg msg:msgList){%>
        <div class="article">
                   <div class="author">用户：<%=msg.getAuthor()%><span><%=msg.getId()%></span></div>
                   <div class="content"><%=msg.getMsg()%></div>
                   <div class="time page">发表于：<%=msg.getDate()%></div>
        </div>
        <%}%>
    </div>
    <div class="page">
        <input class="btn1" type="button" value="上一页">
        <input class="btn1" type="button" value="下一页">
    </div><br>
    <div>
        <form id="myform" action="/insert" method="post">
            <div>
                用户: <input type="text" name="author" value=""/>
            </div><br>
            <div>
                留言: <textarea name="message" rows="5" cols="72"></textarea>
            </div>
            <div align="center"><input type="reset" value="清除"/> <input type="submit" value="发表"/></div>
        </form>
    </div>
</div>
</body>
</html>

