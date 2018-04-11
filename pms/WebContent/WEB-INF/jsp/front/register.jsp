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

    <title>注册</title>

    <!-- Bootstrap Core CSS -->
    <link href="/pms/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/pms/static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/pms/static/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/pms/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <script>  
        function checkLength(){  
            var pwd1 = document.getElementById("pwd1").value;  
            var spanLen = document.getElementById("spanLen");  
  
            if(pwd1.length <= 3 && pwd1.length > 0)  
                spanLen.innerHTML="弱";  
            else if(pwd1.length <= 6)  
                spanLen.innerText="中";  
            else  
                spanLen.innerText="强";  
  
        }  
  
        function checkPSW(){
            var pwd1 = document.getElementById("pwd1").value;  
            var pwd2 = document.getElementById("pwd2").value;  
            var pswInfo = document.getElementById("pswInfo");  

            if(pwd1 != pwd2){
            	pswInfo.innerText="两次密码不同";   // alert("两次密码不同");
                document.getElementById("btregister").disabled = true;
            }
            else {
            	pswInfo.innerText="";
            	document.getElementById("btregister").disabled = false;
            } 
        }  
    </script> 

</head>

<body>

   <div class="container">
    <div class="row">
     <div class="col-md-4 col-md-offset-4">
      <div class="login-panel panel panel-default">
       <div class="panel-heading">
           <h3 class="panel-title">业主注册</h3>
       </div>
       <div class="panel-body">
           <form role="form" action = "${pageContext.request.contextPath}/frontRegister/check" method="post" >
               <fieldset>
                   <div class="form-group">
				       <c:choose>  
				         <c:when test="${not empty registerEmail}">
				             <input class="form-control" value = "${requestScope.registerEmail}" name="email" type="email" required autofocus>
				         </c:when>
				         <c:otherwise>
				             <input class="form-control" placeholder="E-mail" name="email" type="email" required autofocus>  
				         </c:otherwise>
				       </c:choose>
                   </div>
                   
                   <div class="form-group">
                       <c:choose>  
				         <c:when test="${not empty registerPassword}">
				             <input class="form-control" value = "${requestScope.registerPassword}" id="pwd1" name="password" type="password" required onkeyup="checkLength()">
				         	 <span id="spanLen"></span>
				         </c:when>
				         <c:otherwise>
				             <input class="form-control" placeholder="密码" id="pwd1" name="password" type="password" required onkeyup="checkLength()">
				         	 <span id="spanLen"></span>
				         </c:otherwise>
				       </c:choose>
                   </div>
                   
                   <div class="form-group">
                       <input class="form-control" placeholder="确认密码" id="pwd2" name="password2" type="password" required onblur="checkPSW()">
                       <span id="pswInfo" style="color: #c41a15;"></span>
                   </div>
                   
                   <div class="form-group">
                       <c:choose>  
				         <c:when test="${not empty registerRoomId}">
				             <input class="form-control" value = "${requestScope.registerRoomId}" name="roomId" type="text" required >
				         </c:when>
				         <c:otherwise>
				             <input class="form-control" placeholder="单元号" name="roomId" type="text" required >
				         </c:otherwise>
				       </c:choose>
                   </div>
                   
                   <font size = 3>
                       <a href="${pageContext.request.contextPath}/frontLogin/login" style="float:center">已有账号，登录</a>
                   </font>
                   
                   <font size = 4 color = red> ${loginError} </font>
                   
                   <button id="btregister" type = "submit" class="btn btn-lg btn-success btn-block">注册</button>
              		
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
