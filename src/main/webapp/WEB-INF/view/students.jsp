<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Spring Boot + JPA</title>

<!-- Bootstrap -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
	
	    <!-- Navigation Bar -->
	    <jsp:include page="common/nav.jsp"></jsp:include>
	    
		<br /> <a type="button" class="btn btn-primary"
			href="/students/create">Add New Student</a> <br />
		<h1>All Students</h1>
		
		${successmsg}
		${errormsg}
		<table class="table"> 

			<thead>
				<tr>
					<th>#</th>
					<th>Full Name</th>
					<th>Email</th>
					<th>Address</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:set var="no" value="1"></c:set>
				<c:forEach var="student" items="${studentlist}">
					<tr>

						<th scope="row">${no}</th>
						<td>${student.fullname }</td>
						<td>${student.emailid }</td>
						<td>${student.address }</td>
						<td><a type="button" class="btn btn-info"
							href="/students/${student.id }">View</a></td>
						<td><a type="button" class="btn btn-success"
							href="/students/edit/${student.id }">Edit</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/students/delete/${student.id }">Delete</a></td>

						<c:set var="no" value="${no+1}"></c:set>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/js/bootstrap.min.js"></script>
</body>
</html>