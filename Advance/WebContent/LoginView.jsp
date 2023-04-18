<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@includefile= "Header.jsp" %>
	<form action="login" method="post">
		<br> <br> <br>
		<div align=center>
			<h1>Login</h1>
			<table>
				<tr>
					<%
						String msg = (String) request.getAttribute("msg");
						String m1 = (String) request.getAttribute("m1");
						String m2 = (String) request.getAttribute("m2");
						String uri=(String) request.getAttribute("uri");
						String add=(String)request.getAttribute("ADDmsg");
						if (msg != null) {
					%>
					<h4 style="color: red">
						<%=msg%></h4>
					<%
						}
					%>
					<%if(add!=null){ %>
					<h4 style="color: Green">
						<%=add%></h4>
					<%
						}
					%>
					
				</tr>
				<tr>
					<th align=right>Login Id:</th>
					<td><input type="text" name="loginId">
					<td>
						<%
							if (m1 != null) {
						%>
						<h4 style="color: red">
							<%=m1%></h4> <%
 	}
 %>
					</td>
				</tr>
				<tr>
					<th align=right>Password:</th>
					<td><input type="password" name="password"></td>
					<td>
						<%
							if (m2 != null) {
						%>
						<h4 style="color: red">
							<%=m2%></h4> <%
 	}
 %>
					</td>
				</tr>
				<tr>
					<td></td>
					<td rowspan=2><input type="submit" value="SignIn"
						name="operation">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
						type="submit" value="SignUp" name="operation">
				</tr>
				<tr><input type="hidden" name="uri" value="<%=uri %>"></tr>
			</table>
	</form>
	</div>
	<%@includefile= "Footer.jsp" %>
</body>
</html>