<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search By Id</title>
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
			</a>
		    <a class="nav-link" href="index.jsp">Home</a>
			<a class="nav-link" href="turbi">Register</a>
		</nav>
		<a class="navbar-brand" href="#"> 
		<img src="https://tse2.mm.bing.net/th?id=OIP.phzccXej_Pd-CP3sJ4jnzwHaE8&pid=Api&P=0"
			width="80" height="50"></a>
	</nav>
	
	<h3><span style="color:red">${message}</span></h3>
	<form action="searchbyid" method="get">
	     <pre>
	        Search By Id <input type="text" name="id">
	        
	        <input type="submit" class="btn btn-primary" value="Search">
	        
	              CompanyName : ${dto.companyName}
	              Cost        : ${dto.cost}
	              Type        : ${dto.type}
	              country     : ${dto.country}
	     </pre> 
	     
	</form>
</body>
</html>