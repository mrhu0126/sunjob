<%--
  Created by IntelliJ IDEA.
  User: Mr胡
  Date: 2019/10/14
  Time: 8:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
  <head>
    <title>EL</title>
  </head>
  <body>
      ${1+2}
      ${1+"2"}
      ${"1"+"2"}
      \${"a" + "b"}
      ${1/2}
      ${2%5}
      ${1>2}
      ${1<2}
      ${1 le 2}
      ${1 lt 2}
      ${1 ge 2}
      ${1 gt 3}
      ${1 ne 2}
      ${1 eq 2}

      ${true && false}  <%-- false--%>
      
      ${1>2 ? 1 : 2}



  </body>
</html>
