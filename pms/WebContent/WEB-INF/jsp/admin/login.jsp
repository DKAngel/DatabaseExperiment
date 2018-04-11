<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录物业管理系统-后台</title>
<link href="/pms/static/css/style.css" rel="stylesheet" type="text/css" />
<script src="/pms/static/js/jquery.js"></script>
<script src="/pms/static/js/cloud.js" type="text/javascript"></script>

<script >
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


    <div class="logintop">    
        <span>欢迎登录物业管理系统-后台</span>    
        <ul>
            <li><a href="#">回首页</a></li>
            <li><a href="#">帮助</a></li>
            <li><a href="#">关于</a></li>
        </ul>    
    </div>

    <div class="loginbody">
        <span class="systemlogo"></span>       
        <div class="loginbox">
            <ul>
                <form id="loginForm" action="${pageContext.request.contextPath}/adminLogin/check" method="post">
                    <li><input id="user" name="account" type="text" class="loginuser" placeholder="账号"/></li>
                    <li><input id="pswd" name="password" type="password" class="loginpwd" placeholder="密码"/></li>
					<font size=5 color=red>${loginError}</font>
                    <li>
                        <button type="submit" class="loginbtn" >登录</button>
                        
                        <label><input id="remember" type="checkbox" value="" />记住密码</label>
                        <label><a href="#">忘记密码？</a></label>
                    </li>
                </form>
            </ul>  
        </div>
    </div>
    
    <script>
        window.onload = function(){
            var oForm = document.getElementById('loginForm');
            var oUser = document.getElementById('user');
            var oPswd = document.getElementById('pswd');
            var oRemember = document.getElementById('remember');
            //页面初始化时，如果帐号密码cookie存在则填充
            if(getCookie('user') && getCookie('pswd')){
              oUser.value = getCookie('user');
              oPswd.value = getCookie('pswd');
              oRemember.checked = true;
            }
            //复选框勾选状态发生改变时，如果未勾选则清除cookie
            oRemember.onchange = function(){
              if(!this.checked){
                delCookie('user');
                delCookie('pswd');
              }
            };
            //表单提交事件触发时，如果复选框是勾选状态则保存cookie
            oForm.onsubmit = function(){
              if(remember.checked){ 
                setCookie('user',oUser.value,7); //保存帐号到cookie，有效期7天
                setCookie('pswd',oPswd.value,7); //保存密码到cookie，有效期7天
              }
            };
        };
        //设置cookie
        function setCookie(name,value,day){
            var date = new Date();
            date.setDate(date.getDate() + day);
            document.cookie = name + '=' + value + ';expires='+ date;
        };
        //获取cookie
        function getCookie(name){
            var reg = RegExp(name+'=([^;]+)');
            var arr = document.cookie.match(reg);
            if(arr){
              return arr[1];
            }else{
              return '';
            }
        };
        //删除cookie
        function delCookie(name){
            setCookie(name,null,-1);
        };
    </script>

    <div class="loginbm">智能小区物业管理系统 联系电话：15116223640 QQ：740324579</div>
</body>
</html>