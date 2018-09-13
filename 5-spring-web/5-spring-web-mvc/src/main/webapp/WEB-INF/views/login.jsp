<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!-- %@ taglib uri="http://www.springframework.org/security/tags" prefix="security" % -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div id="login-error" class="error">${error}<br /> <br />
</div>

<form:form id="form" action="login" method="post" commandName="command">
	<fieldset id="personal">
		<legend>Login</legend>
		<label for="username">Username:</label> <input id="username"
			name="username" type="text" /> <br /> <label for="password">Password:</label>
		<input id="password" name="password" type="password" /> <br /> <br />
	</fieldset>

	<div align="center">
		<input class="button" type="reset" value="Clear" /> <input
			class="button" type="submit" value="Login" />
	</div>
</form:form>
