<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

	<head>
		<title>Dragontalker Company Home Page</title>
	</head>

	<body>
		<h2>Dragontalker Company Home Page - Yoohoo - Silly Goose!!!</h2>
		<hr>
		
		<p>
			Welcome to the Dragontalker company home page!
		</p>
		
		<!-- Add a logout button -->
		<form:form action="${ pageContext.request.contextPath }/logout" method="POST">
		
			<input type="submit" value="Logout" />
			
		</form:form>
	</body>

</html>