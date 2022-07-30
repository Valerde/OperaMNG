<%--
  Created by IntelliJ IDEA.
  User: 笑靥如花
  Date: 2022/7/30
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>playOpera</title>
</head>
<body>

<video width="320" height="240" controls>
<%--    <source src="/file/a.mp4" type="video/mp4">--%>
    <source src="${localpath}" type="video/mp4">${localpath}
    <!--&lt;!&ndash;    <source src="movie.ogg" type="video/ogg">&ndash;&gt;-->
    <!--&lt;!&ndash;    您的浏览器不支持Video标签。&ndash;&gt;-->
    <!--<embed src="https://www.bilibili.com/video/BV1Ne4y1X7VB?spm_id_from=333.851.b_7265636f6d6d656e64.1&vd_source=2f8bf2415101c0811e704a9f1d15fbd3"-->
    <!--       width="480" height="400"-->
    <!--       type="video/mp4">-->
    <!--</embed>-->
</video>
</body>
</html>
