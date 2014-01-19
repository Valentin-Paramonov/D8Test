<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Users</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/d8test.css">
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/d8test.js"></script>
</head>
<body>
    <div id="welcome">
            <h1>Users</h1>
    </div>
    <table id="userListTable">
        <tr><th>Name</th><th>Age</th><th>Active</th><th>&nbsp;</th></tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.name}</td><td>${user.age}</td><td>${user.active  ? "Active" : "Not active"}</td>
            <td class="buttons">
                <table>
                    <tr>
                        <td>
                            <form method="POST" action="${pageContext.request.contextPath}/user/details">
                                <input type="hidden" name="id" value="${user.id}">
                                <input value="Details" type="submit" />
                            </form>
                        </td>
                        <td>
                            <form method="POST" onsubmit="return confirmDelete(this, 'user ' + '${user.name}', '${pageContext.request.contextPath}/user/delete')">
                                <input type="hidden" name="id" value="${user.id}">
                	            <input value="Delete" type="submit" />
                            </form>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="books">
                ${user.books[0] != null ? "Books:" : ""}
                <ul>
                <c:forEach var="book" items="${user.books}" varStatus="i">
                    <li>${book.title}</li>
                </c:forEach>
                </ul>
            </td>
        </tr>
    </c:forEach>
        <tr>
            <td colspan="4">
                <button id="addUserButton2" onclick="location.href='${pageContext.request.contextPath}/user/add'">Add user</button>
            </td>
        </tr>
    </table>
</body>
</html>

