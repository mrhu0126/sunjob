<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    String[] strings = new String[]{"aa", "bb", "cc"};
    request.setAttribute("s", strings);

    List<String> list = new ArrayList<String>();
    list.add("gg");
    list.add("ff");
    list.add("rr");
    request.setAttribute("list" , list);
%>

<body>
${s[0]}
${requestScope.s[2]}
${list[2]}
</body>
</html>
