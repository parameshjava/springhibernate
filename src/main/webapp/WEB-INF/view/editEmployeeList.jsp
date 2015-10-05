<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Spring 3 hibernate integration example on sample.springhibenate Solutions</title>
    <spring:url value="/resources/css/main.css" var="mainCss" />
    <link href="${mainCss}" rel="stylesheet" />
</head>
<body>
 
<h2>Employee Management Screen : Spring 3 hibernate integration example on sample.springhibenate Solutions</h2>
 
<form:form method="post" action="add" commandName="employee">
<table>
    <tr>
        <td><a href="?lang=en">English</a></td>
        <td><a href="?lang=zh_CN">Chinese</a></td>
    </tr>
    <tr>
        <td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
        <td><form:input path="firstname" /></td>
        <td align="left"><form:errors path="firstname" cssClass="error"/></td>
    </tr>
    <tr>
        <td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
        <td><form:input path="lastname" /></td>
        <td align="left"><form:errors path="email" cssClass="lastname"/></td>
    </tr>
    <tr>
        <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
        <td><form:input path="email" /></td>
        <td align="left"><form:errors path="email" cssClass="error"/></td>
    </tr>
    <tr>
        <td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
        <td><form:input path="telephone" /></td>
        <td align="left"><form:errors path="telephone" cssClass="error"/></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="submit" value="<spring:message code="label.add"/>" class="btn"/>
        </td>
    </tr>
</table> 
</form:form>
 
     
<h3>Employees</h3>
<c:if  test="${!empty employeeList}">
<table class="alternate_color">
<tr>
    <th>Name</th>
    <th>Email</th>
    <th>Telephone</th>
    <th>Action</th>
</tr>
<c:forEach items="${employeeList}" var="emp">
    <tr>
        <td>${emp.lastname}, ${emp.firstname} </td>
        <td>${emp.email}</td>
        <td>${emp.telephone}</td>
        <td><a href="delete/${emp.id}">delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
 
</body>
</html>