<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>User Details</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/d8test.css">
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/d8test.js"></script>
</head>
<body>
    <div id="welcome">
        <h1>User details</h1>
    </div>
    <div id="updateUserForm">
        <table id="updateUserTable">
            <tr>
                <td>
                   <form:form id="userDetailsForm" method="POST" commandName="user" action="update">
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
                                ${booksSize != 0 ? "<tr><td colspan=\"2\">User Books:</td></tr>" : ""}
                            <tr>
                                <td colspan="2">
                                    <table id="userBooks">
                                        <c:forEach var="book" items="${user.books}" varStatus="i" begin="0">
                                            <tr class="bookEntry">
                                                <td class="bookTitle">
                                                    ${book.title}
                                                    <input type="hidden" id="books[${i.index}].id" name="books[${i.index}].id" value="${i.index}" />
                                                    <form:hidden path="books[${i.index}].title" />
                                                </td>
                                                <td>
                                                <button id="deleteBookButton"
                                                    onclick="if(confirm('Delete book ${book.title} ?')) submitForm(document.getElementById('userDetailsForm'), '${pageContext.request.contextPath}/user/${user.id}/book/delete/${i.index}'); else return false;">
                                                    X
                                                </button>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </td>
                            </tr>
                        </table>
                   </form:form>
                </td>
            </tr>
            <tr>
                <td>
                    <form:form id="addBookForm" method="POST" commandName="newBook" action="${pageContext.request.contextPath}/user/${user.id}/book/add">
                        <form:errors path="*" cssClass="errorBlock" element="div" />
                        <input type="hidden" id="id" name="id" value="${booksSize}">
                        <table id="addBookTable">
                            <tr>
                                <td class="title">
                                    <form:input path="title"/>
                                </td>
                                <td>
                                    <input type="submit" value="Add Book"/>
                                </td>
                            </tr>
                        </table>
                    </form:form>
                </td>
            </tr>
            <tr>
                <td>
                    <button id="cancelButton" onclick="location.href = '${pageContext.request.contextPath}/user/list';">Cancel</button>
                    <button id="updateUserButton"
                        onclick="submitForm(document.getElementById('userDetailsForm'), '${pageContext.request.contextPath}/user/update');">
                        Update
                    </button>
                </td>
            </tr>
       </table>
    </div>
</body>
</html>
