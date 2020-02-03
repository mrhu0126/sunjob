<%@ page isELIgnored="false" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!-- 通用 -->
<c:set var="x" value="10" ></c:set>
${x}
<c:out value="${x}"></c:out>
<c:remove var="x"></c:remove>
${x}




