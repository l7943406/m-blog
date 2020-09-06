<%--
  Created by IntelliJ IDEA.
  User: 木辰
  Date: 2020/8/17
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>
        <%out.print(ConfigService.getConfig().getTitle());%>
    </title>
    <link rel="stylesheet" href="../css/index.css">
    <script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
</head>
<body>
    <div class="header">
        <%@ include file="header.jsp"%>
    </div>

    <div class="main">
        <%@ include file="main.jsp"%>
    </div>

    <div class="footer">
        <%@ include file="footer.jsp"%>
    </div>
    <script>

    </script>
</body>
</html>
