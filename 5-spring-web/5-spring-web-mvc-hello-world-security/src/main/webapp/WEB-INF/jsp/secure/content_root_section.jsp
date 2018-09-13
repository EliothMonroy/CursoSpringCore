<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
	$(document).ready(function() {
		$("input[data-call-method=adminMethod]").on("click", function() {
			document.location.href = "${site_url}rootSection?callmethod=admin";
		});
		$("input[data-call-method=rootMethod]").on("click", function() {
			document.location.href = "${site_url}rootSection?callmethod=root";
		});
		$("input[data-call-method=userMethod]").on("click", function() {
			document.location.href = "${site_url}rootSection?callmethod=user";
		});
	});
</script>

Hello Root
<br />
<br />
Welcome
<security:authentication property="principal.username" />
to your Root section !
<br />
<br />
Your roles:
<security:authentication property="principal.authorities" />
<br />
<br />
<input data-call-method="adminMethod" type="button"
	value="Call Admin Method" />
<br />
<input data-call-method="rootMethod" type="button"
	value="Call Root Method" />
<br />
<input data-call-method="userMethod" type="button"
	value="Call User Method" />
<br />

${server_data}
