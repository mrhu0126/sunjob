<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
部门:<select id="dep" onchange="findempbydid()">


</select>

员工:<select id="emp">


</select>

</body>
</html>

<script>

    onload = function () {
        var request = new XMLHttpRequest();

        request.open("get", "dep.do" ,false);
        request.send(null);

        request.onreadystatechange = function () {
            if (request.readyState == 4 && request.status == 200) {
                var ret = request.responseText;
                var json = eval(ret);

                for (var i = 0; i < json.length; i++) {
                    var option = new Option(json[i].depname , json[i].depid);
                    document.getElementById("dep").append(option);
                }
                findempbydid();

            }
        }
    }

    function findempbydid(){
        var depid = document.getElementById("dep").value ;

        var request = new XMLHttpRequest();
        request.open("get" , "emp.do?depid="+depid);
        request.send(null);

        document.getElementById("emp").innerHTML="";

        request.onreadystatechange = function () {
            if (request.readyState == 4 && request.status == 200) {
                var ret = request.responseText;
                var json = eval(ret);
                for (var i = 0; i < json.length; i++) {
                    var option = new Option(json[i].empname , json[i].empid);
                    document.getElementById("emp").append(option);
                }

            }
        }


    }




</script>



