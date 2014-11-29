<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <link rel="stylesheet" href="${contextPath}/css/main.css">
</head>
<body>
<h2>Table Topics</h2>
<ul>
    <c:forEach var="topic" items="${topics}">
        <li>
            ${topic.topic} <form:form action="${contextPath}/tableTopics/delete" method="post">
                <input id="id" name="id" type="hidden" value="${topic.id}">
                <input type="submit" value="Delete">
            </form:form>
        </li>
    </c:forEach>
</ul>
<form:form action="${contextPath}/tableTopics/create" method="post">
    <label for="topic">Topic</label>
    <input id="topic" type="text" name="topic" title="topic">
    <input type="submit" value="Create">
</form:form>
</body>
</html>
