<%@ page import="com.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page isELIgnored="false" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%
    Student student = new Student();
    student.setStuid(1);
    student.setStuname("张三");

    Student student1 = new Student();
    student1.setStuid(2);
    student1.setStuname("李四");

    List<Student> list = new ArrayList<Student>();
    list.add(student);
    list.add(student1);

    request.setAttribute("l" ,list);
%>

<c:forEach items="${l}" var="s">
    ${s.stuid}${s.stuname}
</c:forEach>

