<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>App Sort</title>

    <spring:url value="/resources/styles/materialize.min.css" var="materializeCss" />
    <spring:url value="/resources/styles/bootstrap.min.css" var="bootstrapCss" />
    <spring:url value="/resources/styles/cover.css" var="customCss"/>
    <link type="text/css" href="${bootstrapCss}" rel="stylesheet" />
    <link type="text/css" href="${customCss}" rel="stylesheet" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<section id="site-content">
    <tiles:insertAttribute name="body"/>
</section>


<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
<script type="text/javascript" src="${bootstrapJs}"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>