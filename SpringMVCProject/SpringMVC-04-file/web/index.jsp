<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="/upload2" enctype="multipart/form-data" method="post">
      <input type="file" name="file"/>
      <input type="submit" value="upload">
    </form>
  <a href="${pageContext.request.contextPath}/download">下载文件</a>
  </body>
</html>
