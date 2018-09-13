<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>404</title>

<c:set var="r" value="${pageContext.request}" scope="request" />
<c:set var="site_url"
	value="${r.scheme}://${r.serverName}:${r.serverPort}${r.contextPath}/"
	scope="request" />
<base href="${site_url}" />
</head>
<body>

	<img src="${site_url}resources/img/focus-404.png" />

</body>
</html>