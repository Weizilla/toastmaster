<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link rel="stylesheet" href="${contextPath}/css/main.css">
    <script src="${contextPath}/jquery-2.1.1.min.js"></script>
    <script>
        $(document).ready(
            function () {
                $(".update").hide();
                $(".cancel").hide();
            }
        );
        function edit(id) {
            $("#topicInput-" + id).val($("#topic-" + id).text());
            $("#update-" + id).show();
            $("#cancel-" + id).show();
            $("#edit-" + id).hide();
            $("#topic-" + id).hide();
        }
        function cancel(id) {
            $("#update-" + id).hide();
            $("#cancel-" + id).hide();
            $("#edit-" + id).show();
            $("#topic-" + id).show();
        }
    </script>
</head>
<body>
<h2>Table Topics</h2>
<ul>
    <c:forEach var="topic" items="${topics}">
        <li>
            <div>
                <div id="topic-${topic.id}">${topic.topic}</div>
                <a id="edit-${topic.id}" href="#" onclick="edit(${topic.id})">Edit</a>
                <form:form class="update" id="update-${topic.id}" action="${contextPath}/tableTopics/update" method="post">
                    <input id="id" name="id" type="hidden" value="${topic.id}">
                    <input id="topicInput-${topic.id}" name="topic" type="text" value="${topic.topic}">
                    <input type="submit" value="Update">
                </form:form>

                <a id="cancel-${topic.id}" class="cancel" href="#" onclick="cancel(${topic.id})">Cancel</a>

                <form:form action="${contextPath}/tableTopics/delete" method="post">
                    <input id="id" name="id" type="hidden" value="${topic.id}">
                    <input type="submit" value="Delete">
                </form:form>
            </div>
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
