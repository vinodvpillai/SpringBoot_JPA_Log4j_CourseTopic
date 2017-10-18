<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<br /> <a type="button" class="btn btn-primary" href="/topics">View
			Topics</a> <br />
		<h1>Create New Topic</h1>

		<form:form action="/topics/save" method="post" modelAttribute="topic">

			<div class="form-group">
				<form:input type="text" class="form-control" placeholder="Title"
					path="title"></form:input>
			</div>
			<div class="form-group">
				<form:input type="text" class="form-control"
					placeholder="Description" path="description"></form:input>
			</div>

			<form:button type="submit" class="btn btn-default">Submit</form:button>
		</form:form>

	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/js/bootstrap.min.js"></script>
</body>
</html>