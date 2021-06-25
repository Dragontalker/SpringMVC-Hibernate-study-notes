<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
	
	<head>
		<title>Customer Registration Form</title>
	</head>
	
	<body>
	
		<form:form action="processForm" modelAttribute="customer">
		
			First name: <form:input path="firstName" />
			
			<br><br>
			
			Last name: <form:input path="lastName" />
			
			<br><br>
			
		</form:form>
	
	</body>


</html>