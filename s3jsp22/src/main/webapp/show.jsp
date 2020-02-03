<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        #bigDiv{
            margin: auto;
            width: 1000px;
            height: 300px;
            text-align: center;
            border: 1px solid red;
        }

        .smallDiv{
            width: 200px;
            height: 250px;
            text-align: center;
            border: 1px solid blue;
            float: left;
            margin-left: 37px;
            margin-top: 20px;
        }

    </style>

</head>

<body>

        <c:if test="${empty userinfo}" var="f">
            <a>登录</a>|<a>注册</a>
        </c:if>


        <c:if test="${not f}">
            欢迎${userinfo.username}<a>购物车</a><a href="user.do?p=findcollection">收藏</a>
        </c:if>

        名称:<input type="text" id="name" value="${map.name}">
        价格:<input type="text" id="bottom" value="${map.bottom}">-<input type="text" id="top" value="${map.top}">
        <input type="button" value="查找" onclick="query()">
        <div id="bigDiv">
            <c:forEach items="${map.list}" var="goods">
                <div class="smallDiv">
                    ${goods.goodsname}${goods.goodsprice}
                    <a href="goods.do?p=findbyid&goodsid=${goods.goodsid}"><img style="width: 160px ;height: 200px" src="${pageContext.request.contextPath}/image/${goods.goodspic}"></a>
                </div>
            </c:forEach>
        </div>

        <a href="goods.do?p=fenye&page=1&size=${map.size}&name=${map.name}&bottom=${map.bottom}&top=${map.top}">首页</a>
        <a href="goods.do?p=fenye&page=${map.page-1}&size=${map.size}&name=${map.name}&bottom=${map.bottom}&top=${map.top}">上一页</a>
        <a href="goods.do?p=fenye&page=${map.page+1}&size=${map.size}&name=${map.name}&bottom=${map.bottom}&top=${map.top}">下一页</a>
        <a href="goods.do?p=fenye&page=${map.pageCount}&size=${map.size}&name=${map.name}&bottom=${map.bottom}&top=${map.top}">尾页</a>

</body>

<script>

    function query(){

        var name = document.getElementById("name").value ;
        var bottom = document.getElementById("bottom").value ;
        var top = document.getElementById("top").value ;

        location = "goods.do?p=fenye&name="+name+"&bottom="+bottom+"&top="+top;





    }


</script>




</html>
