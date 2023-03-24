<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous">
    </script>

</head>
<body>
	<nav class="navbar navbar-dark bg-dark">

		<nav class="navbar navbar-dark bg-dark">
			<a class="navbar-brand" href="#"> <img
				src="https://tse1.mm.bing.net/th?id=OIP.bxyDtFEupXIi1Xr32QDQhgHaF7&pid=Api&rs=1&c=1&qlt=95&w=132&h=105"
				alt="" width="80" height="48">
			</a>
			<a class="nav-link" href="index.jsp">home</a>
		</nav>
	</nav>
<form action="">
<div class="mb-3">
		<label for="exampleFormControlInput1" class="form-label">Company : </label> 
			<input type="text" class="form-control" name="company"
				   id="exampleFormControlInput1" placeholder="Enter Company">
	</div>
	
	<div class="mb-3">
		<label for="exampleFormControlInput1" class="form-label">Name : </label> 
			<input type="text" class="form-control" name="name"
				   id="exampleFormControlInput1" placeholder="Enter name">
	</div>
	
	<div class="mb-3">
		<label for="exampleFormControlInput1" class="form-label">Cost : </label> 
			<input type="text" class="form-control" name="cost"
				   id="exampleFormControlInput1" placeholder="Enter Cost">
	</div>
	
	<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">COUNTRY : </label> 
			<select class="custom-select" name="country" >
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