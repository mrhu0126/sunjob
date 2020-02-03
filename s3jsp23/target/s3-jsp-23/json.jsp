<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>

<script>

    onload = function () {
            var s = "[{'username':'sunjob','password':'sunjob'},{'username':'saijiebo','password':'saijiebo'}]";
            var json = eval(s);

            for (var i = 0 ;i<json.length ; i++){
                alert(json[i].username+json[i].password);
            }

    }


</script>



