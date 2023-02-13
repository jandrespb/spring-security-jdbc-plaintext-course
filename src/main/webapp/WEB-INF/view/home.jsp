<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<h2>My code Jand company</h2>
	<hr>
	<!-- DISPLAY USERNAME AND ROLE -->
	<p>
		User:
		<security:authentication property="principal.username" />
		<br> <br> Role(s):
		<security:authentication property="principal.authorities" />
	</p>
	<hr>
	<p>Welcome to new code Spring home page development practice!!
		Enjoy trip</p>

	<hr>
	<security:authorize access="hasRole('MANAGER')">
		<!-- Add a link to point to /leaders... this is for managers-->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">LeaderShip
				Meeting</a> <span>(Only for Manager peeps)</span>
		</p>
	</security:authorize>

	<!-- Add a link to point to /systems... this is for admins-->
	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">Admin IT
				Systems Meeting</a> <span>(Only for Admin peeps)</span>
		</p>
	</security:authorize>

	<hr>

	<!-- Add logut button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>
</body>
</html>