<%@ page pageEncoding="utf-8" %>
<html>
<body>
<form method="" action="">
    <input type="text" name="username" id="username" onblur="check()" ><span id="flag"></span><br>
    <input type="submit" value="登录">
</form>
</body>
</html>

<script>
    function check(){
        //创建了一个请求对象
        var request = new XMLHttpRequest();
        var username = document.getElementById("username").value;
        request.open("get" , "test.do?username="+username );
        request.send(null);

        request.onreadystatechange = function(){
            if(request.status==200 && request.readyState==4){
                var ret = request.responseText;//接受服务器的结果

                if(ret.trim()=="yes"){
                    document.getElementById("flag").innerHTML="√";
                }else{
                    document.getElementById("flag").innerHTML="×";
                }
            }


        }







    }



</script>
