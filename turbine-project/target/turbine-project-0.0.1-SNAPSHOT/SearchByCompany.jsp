<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous">
</script>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<nav class="navbar navbar-dark bg-dark">
			<a class="navbar-brand" href="#"> <img
				src="https://tse4.mm.bing.net/th?id=OIP.un91CaXqNMjadbNPwESv7gHaE8&pid=Api&P=0"
				width="80" height="50">
			</a> <a class="nav-link" href="index.jsp">Home</a>
		</nav>
		<a class="navbar-brand" href="#"> <img
			src="https://tse2.mm.bing.net/th?id=OIP.phzccXej_Pd-CP3sJ4jnzwHaE8&pid=Api&P=0"
			width="80" height="50"></a>
	</nav>
	
	<span style="color:blue;">${deletemsg}</span>
	
	<h1>Welcome To TURBINE Search</h1>
	<form action="searchbycompany" method="get">

		Search By Company <input type="text" name="companyName"> <input
			type="submit" class="btn btn-primary" value="search">
	</form>

	<table>
		<tr>
			<th>Id</th>
			<th>Company Name</th>
			<th>Cost</th>
			<th>Type</th>
			<th>Country</th>
		</tr>

		<c:forEach items="${list}" var="t">
			<tr>
				<td>${t.id}</td>
				<td>${t.companyName}</td>
				<td>${t.cost}</td>
				<td>${t.type}</td>
				<td>${t.country}</td>
				<td><a href="update?id=${t.id}"> Update </a></td>
				<td><a href="delete?id=${t.id}"> Delete </a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
