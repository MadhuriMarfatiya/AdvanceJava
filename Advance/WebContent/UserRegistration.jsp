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
	<%@includefile= "Header.jsp" %>
	<div class=center>
		<form action="userRegistration" method="post">

			<%
				UserBean bean1 = (UserBean) request.getAttribute("bean1");
			%>
			<%
				if (bean1 != null) {
			%>
			<table align=center>
				<h1 align=center><b>User Update Form</b></h1>
				<tr><th></th><td>
					<%
						String msg = (String) request.getAttribute("msg");
							if (msg != null) {
					%>
					<h4 style="color: green">
						<%=msg%></h4>
					<%
						}
					%></td>
				<tr>
					<input type="hidden" name="id" value=<%=bean1.getId()%>>
				</tr>
				<tr>
					<th align=right>First Name:</th>
					<td><input type="text" name="firstName"
						value=<%=bean1.getFirstName()%>></td>
				</tr>
				<tr>
					<th align=right>Last Name:</th>
					<td><input type="text" name="lastName"
						value=<%=bean1.getLastName()%>></td>
				</tr>
				<tr>
					<th align=right>Login Id:</th>
					<td><input type="text" name="loginId"
						value=<%=bean1.getLoginId()%>></td>
				</tr>
				<tr>
					<th align=right>Password:</th>
					<td><input type="text" name="password"
						value=<%=bean1.getPassword()%>></td>
				</tr>
				<tr>
					<th></th>
					<td align="center"><input type="submit" value="Update"
						name="operation"></td>
				</tr>
			</table>

			<%
				} else {
			%>
			<table align=center>
				<h1 align=center>User Registration Form</h1>
	
				<tr>
					<th align=right>First Name:</th>
					<td><input type="text" name="firstName"></td>
				</tr>
				<tr>
					<th align=right>Last Name:</th>
					<td><input type="text" name="lastName"></td>
				</tr>
				<tr>
					<th align=right>Login Id:</th>
					<td><input type="text" name="loginId"></td>
				</tr>
				<tr>
					<th align=right>Password:</th>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<th></th>
					<td align="center"><input type="submit" value="Add"
						name="operation"></td>
				</tr>
			</table>
			<%
				}
			%>


		</form>
	</div>
	<%@includefile= "Footer.jsp" %>
</body>
</html>