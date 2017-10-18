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


		<h1>Spring Boot + JPA + Twitter Bootstrap</h1>
		<p>This example is a quick exercise to illustrate how do the
			following :
		<ol>
			<li>Spring Boot</li>
			<li>Spring MVC</li>
			<li>JPA with MySQL</li>
			<li>Relationship (ManyToOne, OneToMany)</li>
			<li>Log4j2</li>
			<li>Twitter bootstrap</li>
			<li>Dpendency - Maven</li>
			<li>Version Control - Git : https://github.com/vinodvpillai/SpringBoot_JPA_Log4j_CourseTopic</li>
		</ol>
		<b>Pending work are :</b>
		<ol>
			<li>All relationships (OneToOne and ManyToMany)</li>
			<li>Hibernate Validation</li>
			<li>JUnit and Mockito Testing</li>
			<li>REST API for the same</li>
			<li>Swagger Documentation for REST API</li>
			<li>AOP</li>
			<li>Spring Security</li>
			<li>i18N</li>
		</ol>
		</p>
		<p>
			<a class="btn btn-lg btn-primary" href="/courses" role="button">View
				the Application</a>
		</p>


	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/js/bootstrap.min.js"></script>
</body>
</html>