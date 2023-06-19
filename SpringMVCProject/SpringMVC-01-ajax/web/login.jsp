<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>
    <script>
        function a1(){
            $.post({
                url:"${pageContext.request.contextPath}/test4",
                data:{'name':$("#name").val()},
                success:function (data){
                    if (data.toString() == 'OK'){
                        $("#userInfo").css("color","green");
                        console.log(data.toString());
                    }else{
                        console.log(data.toString())
                        $("#userInfo").css("color","red");
                    }
                    $("#userInfo").html(data);
                }
            })
        }
        function a2(){
            $.post({
                url:"${pageContext.request.contextPath}/test4",
                data:{'pwd':$("#pwd").val()},
                success:function (data){
                    if (data.toString() == 'OK'){
                        $("#pwdInfo").css("color","green");
                        console.log(data.toString());
                    }else{
                        $("#pwdInfo").css("color","red");
                        console.log(data.toString())
                    }
                    $("#pwdInfo").html(data);
                }
            })
        }
    </script>
</head>
<body>
<p>
    用户名：<input type="text" id="name" onblur="a1()">
    <span id="userInfo"></span>
</p>
<p>
    密 码：<input type="text" id="pwd" onblur="a2()">
    <span id="pwdInfo"></span>
</p>
</body>
</html>
