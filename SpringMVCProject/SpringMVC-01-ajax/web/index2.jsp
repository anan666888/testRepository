<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>
    <script>
        $(function () {
            $("#btn").click(function (){
                $.post("${pageContext.request.contextPath}/test3",function (data) {
                    console.log(data);
                    var html = "";
                    for (var i = 0; i < data.length; i++) {
                        html+="<tr>" +
                                "<td>"+data[i].id+"</td>" +
                                "<td>"+data[i].name+"</td>" +
                                "<td>"+data[i].age+"</td>" +
                                "<td>"+data[i].id+"</td>" +
                            "</tr>"
                    }
                })
            })
        })
    </script>
</head>
<body>
    <input type="button" id="btn" value="获取数据"/>
    <table width: 80% align="center">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
        </tr>
        <tbody id="content"></tbody>
    </table>

    <script></script>
</body>
</html>
