<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Form</title>
</head>
<body>
	<h2>Contact us</h2>

	<form:form method="POST" commandName="contactForm">
		<table>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><form:radiobuttons path="gender" items="${genders}" /></td>
				<td><form:errors path="gender" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" showPassword="true" /></td>
				<td><form:errors path="password" cssStyle="color: #ff0000;" />
				</td>
			<tr>
				<td>Confirm Password:</td>
				<td><form:password path="confirmPassword" showPassword="true" />
				</td>
				<td><form:errors path="confirmPassword"
						cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Favorite Courses:</td>
				<td><form:checkboxes path="courses" items="${availableCourses}" />
				</td>
				<td><form:errors path="courses" cssStyle="color: #ff0000;" />
				</td>
			</tr>
			<tr>
				<td>Select your Tutor:</td>
				<td><form:select path="tutor">
						<form:option value="" label="...." />
						<form:options items="${availableTutors}" />
					</form:select></td>
				<td><form:errors path="tutor" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<form:hidden path="hiddenMessage" />
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Submit">
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>