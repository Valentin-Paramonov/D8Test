<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Add User</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/d8test.css">
</head>
<body>
    <div id="addUserForm">
    <form:form method="POST" commandName="user" action="add">
    	<form:errors path="*" cssClass="errorBlock" element="div" />
    	<table id="addUserTable">
    	    </tr>
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
    		<tr>
    			<td colspan="2"><input id="addUserButton" value="Add" type="submit" /></td>
    		</tr>
    	</table>
    </form:form>
    </div>
</body>
</html>
