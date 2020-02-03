<%@ page pageEncoding="utf-8" %>
<html>
<body id="b">
<h2>Hello World!</h2>

<div style="width: 100px ;height: 30px;border: 1px solid red" onmouseover="query(1)" >手机</div>

<div style="width: 100px ;height: 30px;border: 1px solid red" onmouseover="query(2)">电视</div>

</body>

</html>

<script>

    function query(p){
        alert(1);
        var request = new XMLHttpRequest();
        request.open("get" , "goods.do?p=findbykind");
        request.send(null);

        request.onreadystatechange = function(){
            if(request.readyState==4 && request.status==200 ){
                var ret = request.responseText;
                var json = eval(ret);
               // alert(json);

                for(var i = 0 ; i <json.length ; i++){

                    var big Di

                    var d = document.createElement("div");
                    d.innerHTML="" + json[i].goodsid+""+json[i].goodsname;
                    d.style="border:1px solid blue;width:200px ;height:200px ;float:left;";

                    var img = document.createElement("img");
                    img.src="${pageContext.request.contextPath}/image/"+json[i].goodspic;
                    d.append(img);

                    document.body.append(d);

                }



            }


        }


    }



</script>



