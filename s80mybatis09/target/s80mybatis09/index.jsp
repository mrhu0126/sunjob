<%@ page pageEncoding="utf-8" %>
<html>
<body>
部门:<select id="dep">

    </select>

</body>
</html>




<script>

    onload = function(){
        var request = new XMLHttpRequest();

        request.open("get" , "dep.do?p=findall");
        request.send(null);

        request.onreadystatechange=function () {

            if (request.readyState == 4 && request.status == 200) {
                var ret = request.responseText;
                alert(ret);
                var json = eval(ret);

                for (var i = 0; i < json.length; i++) {
                    var option = new Option(json[i].depname, json[i].depid)
                    document.getElementById("dep").append(option);
                }
            }
        }

    }



</script>
