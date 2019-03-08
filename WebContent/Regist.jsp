<!-- 钟鑫注册 -->

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
<title>注册界面</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<style type="text/css">
.login-page {
 width: 360px;
 padding: 8% 0 0;
 margin: auto;
}
.form {
 position: relative;
 z-index: 1;
 background: #FFFFFF;
 max-width: 360px;
 margin: 0 auto 100px;
 padding: 45px;
 text-align: center;
 box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.form input {
 font-family: "Roboto", sans-serif;
 outline: 0;
 background: #f2f2f2;
 width: 100%;
 border: 0;
 margin: 0 0 15px;
 padding: 15px;
 box-sizing: border-box;
 font-size: 14px;
}
.form button {
 font-family: "Microsoft YaHei","Roboto", sans-serif;
 text-transform: uppercase;
 outline: 0;
 background: #4CAF50;
 width: 100%;
 border: 0;
 padding: 15px;
 color: #FFFFFF;
 font-size: 14px;
 -webkit-transition: all 0.3 ease;
 transition: all 0.3 ease;
 cursor: pointer;
}
.form button:hover,.form button:active,.form button:focus {
 background: #43A047;
}
.form .message {
 margin: 15px 0 0;
 color: #b3b3b3;
 font-size: 12px;
}
.form .message a {
 color: #4CAF50;
 text-decoration: none;
}
.form .register-form {
 display: none;
}

body {
 background: #76b852; /* fallback for old browsers */
 background: -webkit-linear-gradient(right, #76b852, #8DC26F);
 background: -moz-linear-gradient(right, #76b852, #8DC26F);
 background: -o-linear-gradient(right, #76b852, #8DC26F);
 background: linear-gradient(to left, #76b852, #8DC26F);
 font-family: "Roboto", sans-serif;
 -webkit-font-smoothing: antialiased;
 -moz-osx-font-smoothing: grayscale;      
}
.shake_effect{
-webkit-animation-name: shake;
  animation-name: shake;
  -webkit-animation-duration: 1s;
  animation-duration: 1s;
}

p.center{
color: #fff;font-family: "Microsoft YaHei";
}
</style>
<script src='http://localhost:8080/Questionare/jquery/jquery-1.8.2.min.js'></script>
<script type="text/javascript">
function mySubmit(){
	
	
	console.log($("input[name=Rname]").val()+"\t"+$("#password").val());
	$.ajax({
		url:"/Questionare/CommomRigest",
		type:"post",
		data:{
			Rname:$("input[name=Rname]").val(),
			Rpassword:$("#password").val()
		},
		success:function(resp,status){
			if(resp == "ok"){
				alert("注册成功")
				window.location.href="http://localhost:8080/Questionare/Login.html";
			}else{
				alert("用户名已被使用")
				window.location.href="http://localhost:8080/Questionare/Regist.jsp";
			}
		}
	});
}

</script>
</head>
<body>




<p class="center" style="display:block;text-align:center;">欢迎进入西华师大学生实训问卷调查系统</p>
<p class="center" style="display:block;text-align:center;">非常感谢你花费宝贵的时间参与此次调查</p>
<div id="wrapper" class="login-page">
 <div id="login_form" class="form">

   <div class="login-form">
   
     <input type="text" placeholder="用户名" id="user_name" name="Rname" onkeyup="this.value=this.value.replace(/[^\w]/g,'');" maxlength="10"/>
     <input type="password" placeholder="密码" id="password" name="Rpassword" onkeyup="this.value=this.value.replace(/[^\w]/g,'');" maxlength="10"/>
     <button id="login" onclick="mySubmit()">注册</button>
     <p class="message">有账户? <a href="http://localhost:8080/Questionare/Login.html">立刻登录</a></p>
   </div>
 </div>
</div>


<script type="text/javascript">


</script>
</body>
</html>
