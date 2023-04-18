<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Header.jsp"%>
	<form action="userlist.do" method="post" >
		<%
			List list = (List) request.getAttribute("list");
		%>
		<center>
			<div align="center">
				<h1>UserList</h1>
			</div>

			<%
				Iterator it = list.iterator();
				if (list != null) {
			%>
			<%String update=(String)request.getAttribute("updatemsg");
			if(update!=null){%>
			<h4 style="color: Green">
			<%=update %>
			<%} %>
			<table align="center">
			<tr>
			<th>FirstName :</th><td><input type="text" name=firstName placeholder="Write your First Name"></td>
			<th>Last Name: </th><td><input type="text" name=lastName placeholder="Write your Last Name"></td>
			<td><input type="submit" value="search" name="operation" ></td>
			</tr>
			
			</table>

			<br>

			<table border="1" width="100%" align="center" cellpadding=6px
				cellspacing=".2">
				
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Login Id</th>
					<th>Password</th>
					<th>Edit</th>
				</tr>

				<%
					while (it.hasNext()) {
							UserBean bean1 = (UserBean) it.next();
				%>

				<tr align="center">

					<td><%=bean1.getId()%></td>
					<td><%=bean1.getFirstName()%></td>
					<td><%=bean1.getLastName()%></td>
					<td><%=bean1.getLoginId()%></td>
					<td><%=bean1.getPassword()%></td>
					<td><a href="userRegistration?id=<%=bean1.getId()%>">edit</a></td>
				</tr>
				<%
					}
				%>
				<%
					}
				%>

				</center>
			</table>
	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>