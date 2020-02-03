<%@ page isELIgnored="false" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="score" value="98"></c:set>

<c:choose>
    <c:when test="${score>=0 && score<60}">不及格</c:when>
    <c:when test="${score>=60 && score<70}">及格</c:when>
    <c:when test="${score>=70 && score<80}">一般</c:when>
    <c:when test="${score>=80 && score<90}">良好</c:when>
    <c:when test="${score>=90 && score<=100}">你是秀儿</c:when>
    <c:otherwise>出喜喜了</c:otherwise>
</c:choose>








