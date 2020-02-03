<%@ page import="java.util.Date" %>
<%@ page isELIgnored="false" pageEncoding="utf-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<%
    float f = 1.234567f;
    request.setAttribute("f" , f);
    Date date = new Date();
    request.setAttribute("date" , date);
%>

<fmt:formatNumber var="s" pattern=".###" value="${f}"></fmt:formatNumber>
${s}
<fmt:formatDate value="${date}" pattern="yyyy-MM-dd hh:m:ss"></fmt:formatDate>


<%
    String ss = "abcdef" +
            "" +
            "g";
    request.setAttribute("ss" , ss);
%>

${fn:length(ss)}

${fn:substring(ss,1 ,3 )}





