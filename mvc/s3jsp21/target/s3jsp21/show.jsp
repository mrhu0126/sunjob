<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
    <tr>
        <td>用户名</td>
        <td>密码</td>
        <td>操作</td>
    </tr>

    <c:forEach items="${map.list}" var="userinfo">
        <tr>
            <td>${userinfo.username}</td>
            <td>${userinfo.password}</td>
            <td><a href="">删除</a></td>
        </tr>
    </c:forEach>

</table>

<a href="user.do?p=findall&page=1&size=${map.size}">首页</a>
<a href="user.do?p=findall&page=${map.page-1}&size=${map.size}">上一页</a>
<a href="user.do?p=findall&page=${map.page+1}&size=${map.size}">下一页</a>
<a href="user.do?p=findall&page=${map.pageCount}&size=${map.size}">尾页</a>




