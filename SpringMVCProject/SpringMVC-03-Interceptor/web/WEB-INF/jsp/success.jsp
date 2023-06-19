<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功页面</title>
</head>
<body>
 ${user}
<a href="${pageContext.request.contextPath}/user/logout">注销</a>
</body>
</html>
