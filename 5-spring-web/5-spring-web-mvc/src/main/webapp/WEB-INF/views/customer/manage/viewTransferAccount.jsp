<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="box">
	<h3 id="manageAccount">Manage Accounts</h3>
	<form>
		<fieldset id="accountDetail">
			<legend>Account Detail</legend>
			<label for="id">ID: </label>
			<c:out value="${account.id}" />
			<br /> <br /> <label for="number">Number: </label>
			<c:out value="${account.accountNumber}" />
			<br /> <br /> <label for="createdDate">Created Date: </label>
			${account.createdDate} <br /> <br /> <label for="balance">Balance:
			</label>
			<spring:eval
				expression="new java.text.DecimalFormat('$ ###,###,###,###.00')"
				var="currencyFormat" />
			<spring:eval
				expression="currencyFormat.format(${account.balance}).toString()"
				var="balance" />
			${balance}
		</fieldset>
		<div align="center">
			<input class="button" data-accion="regresar" type="button"
				value="Back" />
		</div>
	</form>
</div>
<br />