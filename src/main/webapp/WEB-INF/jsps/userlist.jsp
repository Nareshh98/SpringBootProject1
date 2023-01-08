<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="/css/main.css" var="demoCSS" /> 
  
<link href="${demoCSS}" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User  Details</title>
</head>
<body>
    <table>
        <tr>
            <th>User Name</th>
            <th>User Email</th>

        </tr>
        <c:forEach var="listValue" items="${usersList}">
            <tr>
                <td>${listValue.userName}</td>
                <td>${listValue.userEmail}</td>

            </tr>
        </c:forEach>
        </table> 
  
     
  
</body>
</html>
