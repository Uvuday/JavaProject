<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>x-workz</title>
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
			<a class="navbar-brand" href="#">
			<img src="https://tse4.mm.bing.net/th?id=OIP.un91CaXqNMjadbNPwESv7gHaE8&pid=Api&P=0"
				width="80" height="50">
			</a> <a class="nav-link" href="index.jsp">Home</a>
		</nav>
		<a class="navbar-brand" href="#"> 
		<img src="https://tse2.mm.bing.net/th?id=OIP.phzccXej_Pd-CP3sJ4jnzwHaE8&pid=Api&P=0"
			width="80" height="50"></a>

	</nav>

    <c:forEach items="${error}" var="e">
    <p>
      <span style="color:red;">${e.message}</span>
      </p>
    </c:forEach>   
     
     <h3>
		<span style="color: green;">${sv}</span>
	</h3>
	<form action="turbi" method="post">   
	 
		<div class="form-group">
			<label for="exampleFormControlInput1">Company Name :</label> 
			<input type="text" class="form-control" placeholder="Enter Company Name" name="companyName">
		</div>
		
		<div class="form-group">
			<label for="exampleFormControlInput1">Cost :</label> 
			<input type="text" class="form-control" placeholder="Enter Cost" name="cost">
		</div>
		
		<div class="form-group">
			<label for="exampleFormControlSelect1">Type :</label> 
			<select class="form-control" name="type">
				<option value="">SELECT TYPE</option>
				<c:forEach items="${type}" var="t">
				<option value="${t}">${t}</option>
				</c:forEach>
			</select>
		</div>
		 
		<div class="form-group">
			<label for="exampleFormControlSelect1">COUNTRY :</label> 
			<select class="form-control" name="country">
				<option value="">SELECT COUNTRY</option>
				<c:forEach items="${country}" var="c">
				<option value="${c}">${c}</option>
				</c:forEach>
			</select>
		</div>
		
	<input type="submit" class="btn btn-primary" value="submit">
	</form> 
</body> 
</html>