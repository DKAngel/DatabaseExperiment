 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
    <tr>  
        <td>房间号</td>  
        <td>房间大小</td>  
    </tr>  
        <c:choose>  
            <c:when test="${not empty roomList}">
                <c:forEach items="${roomList}" var="Room">
                    <tr>
                        <td>${Room.roomId}</td>
                        <td>${Room.roomSize}</td>  
                    </tr>  
                </c:forEach>
            </c:when>  
            <c:otherwise>  
               <tr>  
                   <td colspan="2">无数据!</td>  
               </tr>  
            </c:otherwise>  
        </c:choose>  
	</table> 
</body>
</html>