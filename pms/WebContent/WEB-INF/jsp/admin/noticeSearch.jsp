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
    <li><a href="${pageContext.request.contextPath}/adminNotice/getAllNotice">公告查询</a></li>
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
    
  	<div id="tab2" class="tabson">
  	
  	<div class="formtext">Hi，<b>${sessionScope.user.getAdminName()}</b>，欢迎您使用公告查询功能！</div>
  	
    <ul class="seachform">
    <li><label>查询</label><input name="" type="text" class="scinput" /></li>
    
    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="查询"/></li>
    </ul>

    <table class="tablelist">
    	<thead>
    	<tr>
        <th>编号<i class="sort"><img src="/pms/static/images/px.gif" /></i></th>
        <th>标题</th>
        <th>发布人</th>
        <th>发布时间</th>
        <th>操作</th>
        </tr>
        </thead>

        <tbody>
        <c:choose>
            <c:when test="${not empty noticeList}">
                <c:forEach items="${noticeList}" var="notice">  
                	<tr>
                        <td>${notice.noticeId}</td>
                        <td>${notice.noticeTitle}</td>
                        <td>${notice.adminName}</td>
                        <td><fmt:formatDate value = "${notice.noticeTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>
				        	<a href="${pageContext.request.contextPath}/adminNotice/showNotice/${notice.noticeId}" class="tablelink">查看/</a> 
				        	<a href="${pageContext.request.contextPath}/adminNotice/showNotice/${notice.noticeId}" class="tablelink">删除</a>
				        </td>
					</tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
               <tr>
                   <td colspan="2">无数据!</td>  
               </tr>
            </c:otherwise>
        </c:choose>  
        </tbody>
    </table>
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
