<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>

    <style>
      a{
        text-decoration: none;
        color: black;
        font-size: 30px;
      }

      h1{
        width: 300px;
        height: 50px;
        margin: 100px auto;
        text-align: center;
        background: deepskyblue;
        line-height: 50px;
        border-radius: 10px;
      }
    </style>
  </head>
  <body>
  <h1>
    <a href="${pageContext.request.contextPath}/book/allBooks">进入书籍展示页面</a>
  </h1>
  </body>
</html>
