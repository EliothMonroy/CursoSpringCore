<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="box">
	<h3 id="adduser">Manage Accounts</h3>
	<form>
		<fieldset id="accountDetail">
			<legend>Account Detail</legend>
			<label for="id">ID: </label>
			<c:out value="${account.id}" />
			<br />
			<br />
			<label for="number">Number: </label>
			<c:out value="${account.accountNumber}" />
			<br />
			<br />
			<label for="createdDate">Created Date: </label>
			${account.createdDate}
			<br />
			<br />
			<label for="balance">Balance: </label>
			<spring:eval expression="new java.text.DecimalFormat('$ ###,###,###,###.00')" var="currencyFormat" />
			<spring:eval expression="currencyFormat.format(${account.balance}).toString()" var="balance" />
			${balance}
		</fieldset>

		<fieldset id="movements">
			<legend>Movements</legend>
			<table class="movements">
				<thead>
					<tr>
						<th>ID</th>
						<th>Origin Account</th>
						<th>Destination Account</th>
						<th>Amount</th>
						<th>Movement Type</th>
						<th>Operation Date</th>
						<th>Reference Number</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${movements}" var="movement">
						<tr>
							<td>
								<c:out value="${movement.id}" />
							</td>
							<td>
								<c:out value="${movement.originAccountNumber}" />
							</td>
							<td>
								<c:out value="${movement.destinationAccountNumber}" />
							</td>
							<td>
								<c:out value="${movement.amount}" />
							</td>
							<td>
								<c:out value="${movement.type}" />
							</td>
							<td>
								<c:out value="${movement.operationDate}" />
							</td>
							<td>
								<c:out value="${movement.referenceNumber}" />
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</fieldset>
		<div align="center">
			<input class="button" data-accion="regresar" type="button" value="Back" />
		</div>
	</form>
</div>
<br />