<%@ page contentType="text/html; charset = utf-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=${member.id}</li>  <%--id=<%=((member).request.getAttribute("member")).getId()이런식으로 길게 써여했다%>--%>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li> <%--프로퍼티접근 = 조회할때 getAge 여기에 값을 넣으면 setAge--%>
</ul>
<a href="/index.html">메인</a>
</body>
</html>