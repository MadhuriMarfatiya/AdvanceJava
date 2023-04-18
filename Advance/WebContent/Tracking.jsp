<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--this is first way to get cookies and get session id   -->
<h3><a href="MyJsp1.jsp">SimpleLink</a></h3>
 
<!--this is second way to trace session   -->


<!-- way(a): response 's encoded url method which gives encoded url and we can give that url to hyperlink -->
<% String enURL=response.encodeURL("MyJsp1.jsp"); %>

<%=response.encodeURL("MyJsp1.jsp") %>
<!-- Way (b) : Stringquery me seesion ki getid method ko append karva kar  -->
<h3><a href="MyJSp1.jsp?jsessionid=<%=session.getId()%>">Hamari Link</a></h3>
<%=session.getId()%>

<!--this is third way to get session tracking   -->
<form action="MyJsp1.jsp" method="get">
<input type="hidden" name="jsessionid" value="<%=session.getId() %>"/>
</form>
<%=session.getId() %>
</body>
</html>