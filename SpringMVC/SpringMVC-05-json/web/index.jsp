<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  <script type="text/javascript">
    //编写一个js的对象
    var user = {
      name:"姓名1",
      age:"13",
      sex:"男"
    };
    //将js对象转换成json字符串
    var str = JSON.stringify(user);
    console.log(str);
    //运行结果：'{"name":"姓名1","age":"13","sex":"男"}'
    //将json字符串转换为js对象
    var user2 = JSON.parse(str);
    console.log(user2,user.name,user.age,user.sex);
    //运行结果：{age:"13" name:"姓名1" sex:"男"}
  </script>
  </body>
</html>
