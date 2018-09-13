<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="box">
	<h3 id="adduser">Manage Customers</h3>
	<form>
		<fieldset id="personal">
			<legend>Customer Detail</legend>
			<label for="id">ID: </label>
			<c:out value="${customer.id}" />
			<br />
			<br />
			<label for="name">Name: </label>
			<c:out value="${customer.name}" />
			<br />
			<br />
			<label for="lastname">Last Name: </label>
			<c:out value="${customer.lastName}" />
			<br />
			<br />
			<label for="username">Username: </label>
			<c:out value="${customer.user.username}" />
			<br />
			<br />
			<label for="password">Password: </label>
			<c:out value="${customer.user.password}" />
			<br />
			<br />
			<label for="accountExpired">Account is expired: </label>
			<c:out value="${!customer.user.accountNonExpired}" />
			<br />
			<br />
			<label for="accountLocked">Account is locked: </label>
			<c:out value="${!customer.user.accountNonLocked}" />
			<br />
			<br />
			<label for="credentialsExpired">Account credentials is expired: </label>
			<c:out value="${!customer.user.credentialsNonExpired}" />
			<br />
			<br />
			<label for="enabled">Account is enabled: </label>
			<c:out value="${customer.user.enabled}" />
			<br />
			<br />
			<label for="authorities">Authorities: </label>
			<c:forEach items="${customer.user.authorities}" var="authority">
				<c:out value="${authority.authorityName}" />
				<br />
			</c:forEach>
			 
		</fieldset>
		<div align="center">
			<input class="button" data-accion="regresar" type="button" value="Back" />
		</div>
	</form>
</div>
<br />