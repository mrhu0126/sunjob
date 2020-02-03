<%@ page isELIgnored="false" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set value="1" var="sex"></c:set>
<!--条件标签-->
<c:if test="${sex==1}" var="flag">
男
</c:if>
<c:if test="${sex!=1}">
女
</c:if>

<c:if test="${!flag}">
女
</c:if>







