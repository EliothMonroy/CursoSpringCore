<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="topmenu">
	<ul>
		<c:set var="topMenuRendered" value="false"></c:set>

		<li><a href="${site_url}login" data-seccion="login">Login</a></li>


		<!-- permitir visualización si el usuario está autenticado -->

			<li><a href="${site_url}welcome" data-seccion="welcome">Welcome</a></li>
	
			<li><a href="${site_url}adminSection" data-seccion="adminSection">Admin
					Section</a></li>
	
			<li><a href="${site_url}rootSection" data-seccion="rootSection">Root
					Section</a></li>
	
			<li><a href="${site_url}userSection" data-seccion="userSection">User
					Section</a></li>
	
			<li><a href="#" data-href-url="${site_url}logout"
				data-seccion="logout">Logout</a></li>

		<!--  -->

	</ul>
</div>