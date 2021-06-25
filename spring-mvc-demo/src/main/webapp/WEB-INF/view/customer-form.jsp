<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
	
	<head>
		<title>Customer Registration Form</title>
	</head>
	
	<body>
	
		<form:form action="processForm" modelAttribute="customer">
		
			Fill out the form. Asterisk(*) means required.
			
			<br><br>
		
			First name: <form:input path="firstName" />
			
			<br><br>
			
			Last name(*): <form:input path="lastName" />
			<form:errors path="lastName" cssClass="error" />
			
			<br><br>
			
		</form:form>
	
	</body>


</html>