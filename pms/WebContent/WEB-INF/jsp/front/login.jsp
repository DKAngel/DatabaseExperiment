<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>登录</title>

    <!-- Bootstrap Core CSS -->
    <link href="/pms/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/pms/static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/pms/static/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/pms/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">业主登录</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" action = "${pageContext.request.contextPath}/frontLogin/check" method="post" >
                            <fieldset>
                                <div class="form-group">
                               
							        <c:choose>  
							            <c:when test="${not empty loginEmail}">
							                <input class="form-control" value = "${requestScope.loginEmail}" name="email" type="email" autofocus>
							            </c:when>  
							            <c:otherwise>  
							               <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus>  
							            </c:otherwise>  
							        </c:choose>  
                               
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="密码" name="password" type="password" value="">
                                </div>
                                
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">记住密码
                                    </label>
                                </div>
                                
                                <div class="checkbox">
                                    <font size = 3>
                                    	<a href="${pageContext.request.contextPath}/frontLogin/forget" style="float:right"> 忘记密码  </a>
                                	</font>
                                    <font size = 3>
                                    	<a href="${pageContext.request.contextPath}/frontRegister/register" > 注册  </a>
                                	</font>
                                </div>
                                
                                <font size = 4 color = red> ${loginError} </font>
                                <button type = "submit" class="btn btn-lg btn-success btn-block">登录</button>
                           		<br>
                           		<div class="form-group">智能小区物业管理系统 联系电话：15116223640 QQ：740324579</div>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
	
    <!-- jQuery -->
    <script src="/pms/static/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/pms/static/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/pms/static/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/pms/static/dist/js/sb-admin-2.js"></script>

</body>

</html>
