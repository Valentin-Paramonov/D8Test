<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Add User</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/d8test.css">
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/d8test.js"></script>
</head>
<body>
    <div id="welcome">
        <h1>Add new user</h1>
    </div>
    <table id="addUserTable">
        <tr>
            <td>
                <form:form id="addUserForm" method="POST" commandName="user" action="add">
                    <form:errors path="*" cssClass="errorBlock" element="div" />
                    <table id="addUserTable2">
                        <tr>
                            <td colspan="2"><form:errors path="name" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td>User Name:</td>
                            <td><form:input path="name" /></td>
                        <tr>
                        <tr>
                            <td colspan="2"><form:errors path="age" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td>User Age:</td>
                            <td><form:input path="age" /></td>
                        </tr>
                        <tr>
                            <td><form:errors path="active" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td>User Activity:</td>
                            <td><form:checkbox path="active" /></td>
                        </tr>
                    </table>
                </form:form>
            </td>
        </tr>
        <tr>
            <td>
                <button id="cancelButton" onclick="location.href = '${pageContext.request.contextPath}/user/list';">Cancel</button>
                <button id="addUserButton" onclick="submitForm(document.getElementById('addUserForm'), '${pageContext.request.contextPath}/user/add');">
                    Add
                </button>
            </td>
        </tr>
    </table>
</body>
</html>
