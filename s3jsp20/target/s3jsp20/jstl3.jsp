<%@ page isELIgnored="false" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%
    String[] strings = new String[]{"aa" , "bb" , "cc"};
    request.setAttribute("s" , strings);
%>

<c:forEach items="${s}" var="string">
    ${string}<br>
</c:forEach>





