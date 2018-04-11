<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="/pms/static/css/style.css" rel="stylesheet" type="text/css" />

</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="${pageContext.request.contextPath}/adminMain/index">首页</a></li>
    <li><a href="${pageContext.request.contextPath}/adminMain/notice">公告管理</a></li>
    <li><a href="${pageContext.request.contextPath}/adminNotice/getAllNotice">公告查询</a></li>
    <li><a href="#">公告详情</a></li>
    </ul>
    </div>
    
    <div class="itab">
  	<ul> 
    <li><a href="${pageContext.request.contextPath}/adminMain/notice" class="selected">发布公告</a></li> 
    <li><a href="${pageContext.request.contextPath}/adminNotice/getAllNotice">公告查询</a></li> 
  	</ul>
    </div> 

	<div>
	<h1>${ notice.noticeTitle }</h1>
	<h3>
		时间：<fmt:formatDate value = "${notice.noticeTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	</h3>
	<h3>发布人：${ notice.adminName }</h3>
	${ notice.noticeContent }
	</div>
	
	<div>
		<a href="${pageContext.request.contextPath}/adminNotice/deleteNotice/${notice.noticeId}"> <button type="button">删除</button></a>
	</div>
	
</body>
</html>