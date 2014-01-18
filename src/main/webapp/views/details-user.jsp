<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>User Details: ${user.name}</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/d8test.css">
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/d8test.js"></script>
</head>
<body>
    <div id="updateUserForm">
       <form:form method="POST" commandName="user" action="update">
            <form:errors path="*" cssClass="errorBlock" element="div" />
            <input type="hidden" name="id" value="${user.id}">
        	<table id="updateUserTable">
        	    <tr>
        			<td colspan="2"><form:errors path="name" cssClass="error" /></td>
        		</tr>
        		<tr>
                    <td>User Name:</td>
                    <td><form:input path="name" /></td>
                </tr>
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
                    <td colspan="2">
                        <table>
                            <c:forEach var="book" items="${user.books}" varStatus="i" begin="0">
                                <tr>
                                    <td>
                                        <form:input path="books[${i.index}].title" />
                                    </td>
                                    <td>
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td>
                                    <%--<form:input path="books[].title" />--%>
                                </td>
                                <td>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
        		<tr>
        			<td colspan="2"><input id="updateUserButton" value="Update" type="submit" /></td>
        		</tr>
        	</table>
       </form:form>
    </div>
</body>
</html>
