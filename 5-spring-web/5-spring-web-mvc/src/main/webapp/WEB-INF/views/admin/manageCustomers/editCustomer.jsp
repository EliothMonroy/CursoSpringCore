<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="box">
	<h3 id="adduser">Manage Customers</h3>
	<form:form id="form" action="${site_url}admin/manage/customers/editCustomer" commandName="editCustomerForm"
		method="POST">
		<fieldset id="personal">
			<legend>Edit Customer</legend>
			<label for="id">ID: </label>
			<form:input path="id" readonly="true" />
			<br />
			<label for="name">Name: </label>
			<form:input path="name" size="30" tabindex="1" />
			<form:errors path="name" cssClass="error" />
			<br />
			<label for="lastname">Last Name: </label>
			<form:input path="lastName" size="30" tabindex="2" />
			<form:errors path="lastName" cssClass="error" />
			<br />
			<label for="username">
				<b>Username</b>:
			</label>
			<form:input path="user.username" size="30" tabindex="3" readonly="true" disabled="true" />
			<form:errors path="user.username" cssClass="error" />
			<br />
			<label for="password">Password: </label>
			<form:password path="user.password" size="30" tabindex="4" showPassword="true" />
			<form:errors path="user.password" cssClass="error" />
			<br />
			<label for="authorities">Authorities: </label>

			<form:select multiple="true" path="user.idAuthorities">
				<form:options items="${authoritiesCatalog}" />
			</form:select>
			<form:errors path="user.idAuthorities" cssClass="error" />
			<br />

		</fieldset>
		<div align="center">
			<input class="button" data-accion="regresar" type="button" value="Back" />
			<input class="button" type="submit" value="Update" />
		</div>
	</form:form>
</div>
<br />