<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站后台管理系统</title>
</head>
<frameset rows="88,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="${pageContext.request.contextPath}/adminMain/top" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset cols="187,*" frameborder="no" border="0" framespacing="0">
    <frame src="${pageContext.request.contextPath}/adminMain/left" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="${pageContext.request.contextPath}/adminMain/index" name="rightFrame" id="rightFrame" title="rightFrame" />
  </frameset>
</frameset>
<body>
</body>
</html>
