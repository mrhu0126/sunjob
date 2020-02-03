<%@ page isELIgnored="false" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<style>

    .odd{
        background-color: yellow;
    }

    .even{
        background-color: red;
    }


</style>

<%
    String[] strings = new String[]{"aa" , "bb" , "cc" , "cc" , "dd"};
    request.setAttribute("s" , strings);
%>

<table>
    <c:forEach items="${s}" var="string" varStatus="sta" >
    <tr class="${sta.index%2==0 ? 'even' :'odd'}">
        <td>
            ${string}
        </td>
    </tr>
    </c:forEach>
</table>





