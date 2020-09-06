<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 木辰
  Date: 2020/8/17
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<div class="footer-container">
    <%out.print(ConfigService.getConfig().getCopyright());%>
</div>
