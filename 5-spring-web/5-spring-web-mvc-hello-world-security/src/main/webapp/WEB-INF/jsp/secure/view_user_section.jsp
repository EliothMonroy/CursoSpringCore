<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC Application</title>

<c:set var="r" value="${pageContext.request}" scope="request" />
<c:set var="site_url"
	value="${r.scheme}://${r.serverName}:${r.serverPort}${r.contextPath}/"
	scope="request" />
<base href="${site_url}" />

<link rel="stylesheet" type="text/css" href="resources/css/theme1.css" />
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/sweetalert.css" />

<!--[if IE]>
<link rel="stylesheet" type="text/css" href="resources/css/ie-sucks.css" />
<![endif]-->

<script src="resources/js/jquery-1.10.2.js"></script>
<script src="resources/js/jquery.cookies.2.2.0.min.js"></script>
<script>
	var currentPage = document.URL.replace('${site_url}', '');
	var currentSecc = ('${currentSecc}' !== '') ? ('${currentSecc}')
			: (currentPage);
</script>
<script src="resources/js/allPages.js"></script>
<script src="resources/js/sweetalert.min.js"></script>

</head>

<body>
	<div id="container">
		<div id="header">
			<h2>Spring MVC CRUD Application</h2>
			<jsp:include page="../template/top_menu.jsp" />
		</div>
		<div id="top-panel">
			<div id="panel">
				<ul>
					<li><a href="#" class="report">Sales Report</a></li>
					<li><a href="#" class="report_seo">SEO Report</a></li>
					<li><a href="#" class="search">Search</a></li>
					<li><a href="#" class="feed">RSS Feed</a></li>
				</ul>
			</div>
		</div>
		<div id="wrapper">
			<div id="content">
				<jsp:include page="content_user_section.jsp" />
			</div>
			<div id="sidebar">
				<jsp:include page="../template/sidebar.jsp" />
			</div>
		</div>
		<div id="footer">
			<jsp:include page="../template/footer.jsp" />
		</div>
	</div>
</body>
</html>





