<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:if test="${not empty serviceError}">
	<%
		pageContext.setAttribute("newLineChar", "\n");
		pageContext.setAttribute("quotes", "\'");
	%>

	<c:set var="msg" value="${fn:replace(serviceError, quotes, '\"')}" />
	<c:set var="msg" value="${fn:replace(msg, newLineChar, '<br />')}" />

</c:if>

<script>
  $(document).ready(function(event) {

    <c:if test="${not empty serviceError}" >
    var msg = '<c:out value="${msg}" escapeXml="false" />';
    util.showCommandMensaje(msg, true, function() {
      console.log(msg);
    });
    </c:if>

  });
</script>



<div id="command-mensaje" class="error"></div>

<div id="box">
	<h3 id="adduser">Manage Accounts</h3>
	<form:form id="form" action="${site_url}customer/manage/accounts/createAccount" commandName="createAccountForm"
		method="POST">
		<fieldset id="personal">
			<legend>Create Account</legend>
			<label for="number">Account Number: </label>
			<form:input path="accountNumber" size="30" tabindex="1" />
			<form:errors path="accountNumber" cssClass="error" />
			<br />
			<label for="balance">Initial Balance: </label>
			<form:input path="balance" size="30" tabindex="1" />
			<form:errors path="balance" cssClass="error" />
			<br />

		</fieldset>
		<div align="center">
			<input class="button" data-accion="regresar" type="button" value="Back" />
			<input class="button" type="submit" value="Create" />
		</div>
	</form:form>
</div>
<br />