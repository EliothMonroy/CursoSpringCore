<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- %@ taglib uri="http://www.springframework.org/security/tags" prefix="security" % -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div id="topmenu">
	<ul>
		<c:set var="topMenuRendered" value="false"></c:set>

		<li>
			<a href="${site_url}" data-seccion="login">Login</a>
		</li>

	</ul>
</div>
