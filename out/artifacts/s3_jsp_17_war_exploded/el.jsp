<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<%
    Map<String , String> map = new HashMap<String , String>();
    map.put("name" , "jack");
    map.put("first]name" , "jackMa");
    request.setAttribute("fn","first]name");
    request.setAttribute("map" , map);
%>
<body>
    ${map.name}
    ${map["first]name"]}
    ${map[fn]}
</body>
</html>
