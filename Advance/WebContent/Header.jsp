<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		UserBean bean = (UserBean) session.getAttribute("bean");
	%>
	<table>
		<tr>

			<img src="img/logo.png" height="80" align="right">


			<td><a href="Welcome.jsp">Welcome</a> <%
 	if (bean != null) {
 %> <a href="login?operation=logout">|Logout</a></td>
		</tr>
		<tr>
			<td width="90%"><h3>
					Hi,<%=bean.getFirstName()%></h3></td></tr>
		<tr><td>	<h3>
				<a href="userlist.do">UserList</a>
			</h3></td>
</tr>
			<%
				} else {
			%>
		
		<tr>
			<td width=90%>
				<h3>Hi,Guest</h3> <%
 	}
 %>
			</td>
		</tr>

		</tr>

	</table>
	<hr>

</body>
</html>