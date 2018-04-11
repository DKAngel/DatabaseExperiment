<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/pms/static/css/style.css" rel="stylesheet" type="text/css" />
<script  src="/pms/static/js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>


</head>

<body style= "background-image:url(/pms/static/images/topbg.gif);background-repeat:repeat-x;">

    <div class="topleft">
    <a href="${pageContext.request.contextPath}/adminMain/main" target="_parent"><img src="/pms/static/images/logo.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
    <li><a href="default.html" target="rightFrame" class="selected"><img src="/pms/static/images/icon06.png" title="工作台" /><h2>工作台</h2></a></li>
    <li><a href="imgtable.html" target="rightFrame"><img src="/pms/static/images/icon02.png" title="模型管理" /><h2>模型管理</h2></a></li>
    <li><a href="imglist.html"  target="rightFrame"><img src="/pms/static/images/icon03.png" title="模块设计" /><h2>模块设计</h2></a></li>
    <li><a href="tools.html"  target="rightFrame"><img src="/pms/static/images/icon04.png" title="常用工具" /><h2>常用工具</h2></a></li>
    <li><a href="computer.html" target="rightFrame"><img src="/pms/static/images/icon05.png" title="文件管理" /><h2>文件管理</h2></a></li>
    
    <li>
    	<a href="${pageContext.request.contextPath}/adminMain/notice"  target="rightFrame">
    	<img src="/pms/static/images/icon01.png" title="公告管理" /><h2>公告管理</h2></a>
    </li>
    
    </ul>
            
    <div class="topright">    
    <ul>
    <li><span><img src="/pms/static/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="${pageContext.request.contextPath}/adminLogin/index" target="_parent">退出</a></li>
    </ul>

    <div class="user">
    <span>${sessionScope.user.getAdminName()}</span>
    <i>消息</i>
    <b>5</b>
    </div>    
    
    </div>
</body>
</html>