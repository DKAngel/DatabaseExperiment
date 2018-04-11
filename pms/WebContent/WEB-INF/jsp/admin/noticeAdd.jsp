<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公告管理</title>
<link href="/pms/static/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/pms/static/js/jquery.js"></script>
<script type="text/javascript" src="/pms/static/editor/kindeditor.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
</script>
  
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="${pageContext.request.contextPath}/adminMain/index">首页</a></li>
    <li><a href="${pageContext.request.contextPath}/adminMain/notice">公告管理</a></li>
    <li><a href="${pageContext.request.contextPath}/adminMain/notice" class="selected">发布公告</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div id="usual1" class="usual">
    
    <div class="itab">
  	<ul> 
    <li><a href="${pageContext.request.contextPath}/adminMain/notice" class="selected">发布公告</a></li> 
    <li><a href="${pageContext.request.contextPath}/adminNotice/getAllNotice">公告查询</a></li> 
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    
    <div class="formtext">Hi，<b>${sessionScope.user.getAdminName()}</b>，欢迎您使用公告发布功能！</div>
    
    <ul class="forminfo">
    
    <form id="loginForm" action="${pageContext.request.contextPath}/adminNotice/addNotice" method="post">
    
    <li><label>公告标题<b>*</b></label><input name="noticeTitle" type="text" class="dfinput" placeholder="标题" style="width:518px;"/></li>
    
    <li><label>公告内容<b>*</b></label>
    
    <textarea id="content7" name="noticeContent" style="width:700px;height:250px;visibility:hidden;"></textarea>
    
    </li>
    <font size=5 color=red>${noticeError}</font>
    <li><label>&nbsp;</label> <button type="submit" class="btn" >马上发布</button></li>
    </form>
    </ul>
    </div>
    
	</div>
 
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
	
    </div>

</body>
</html>
