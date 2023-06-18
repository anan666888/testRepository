<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>

    <script>
      function aq(){
        $.post({
          url:"${pageContext.request.contextPath}/test2",
          data:{'name':$("#username").val()},
          success:function (data,status) {
            alert(data);
            alert(status);
          },
          error:function (data,status) {
            alert(data);
            alert(status);
          }
        })
      }
    </script>
  </head>
  <body>
  $END$
    用户名：<input type="text" id="username" onclick="aq()"/>
  </body>
</html>
