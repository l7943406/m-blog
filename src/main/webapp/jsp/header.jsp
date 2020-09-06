<%@ page import="cn.muchen7.service.ConfigService" %><%--
  Created by IntelliJ IDEA.
  User: 木辰
  Date: 2020/8/17
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="header-container">
    <span class="header-container-title-span">
        <a href="${pageContext.request.contextPath}/jsp/index.jsp" class="header-container-title-span-a">
            <% out.print(ConfigService.getConfig().getTitle()); %>
        </a>
    </span>
    <span class="header-container-link">
        <ul>
            <li><a href="#">首页</a></li>
            <li><a href="#">留言本</a></li>
            <li><a href="#">学习笔记</a></li>
            <li><a href="#">算法题解</a></li>
        </ul>
    </span>

</div>
