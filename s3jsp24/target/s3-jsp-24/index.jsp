<%@ page pageEncoding="utf-8" %>
<html>
<body>
部门:<select id="dep" onchange="findempbydid()">
</select>

员工:<select id="emp">
</select>

</body>
</html>

<script>
    onload = function(){
        //创建请求对象
        var request = new XMLHttpRequest();

        request.onreadystatechange = function() {
            if(request.readyState==4 && request.status==200){
                var ret = request.responseText;
                var json = eval(ret);

                for(var i = 0 ;i<json.length;i++){
                    var option = new Option(json[i].depname , json[i].depid);
                    document.getElementById("dep").append(option);
                }
                findempbydid();
            }
        }




        //打开
        request.open("get" , "dep.do?p=findall" ,false );// 是否异步  默认是异步
        request.send(null);// 发送参数
       // alert(1);

    }


    function findempbydid(){
        var did = document.getElementById("dep").value;
        //创建请求对象
        var request = new XMLHttpRequest();
        //打开
        request.open("get" , "emp.do?p=findempbydid&did="+did );
        request.send(null);// 发送参数

        request.onreadystatechange = function() {
            if(request.readyState==4 && request.status==200){
                var ret = request.responseText;//接受服务器的结果
                var json = eval(ret);
                document.getElementById("emp").innerHTML="";
                for (var i = 0 ;i<json.length;i++){
                    var option = new Option(json[i].empname , json[i].empid);
                    document.getElementById("emp").append(option);
                }
            }
        }




    }




</script>


