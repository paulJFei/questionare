<!-- 蒲建飞 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page isELIgnored="false" %>  <!-- 2.4版本默认启用el表达式，如果使用2.5版本，默认el表达式是关闭的 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
body{
background: url(Picture/图书gu.jpg) no-repeat 0 0px; 
background-attachment:fixed;
background-size:100%;
height:auto;
}
.ques{
	width: 600px;	
	margin-left: 30px;
}
#main{
background: #f3eddd;
width: 780px;
margin: 0px auto;
border-bottom-width: 6px;
padding: 25px 0 20px;
box-shadow: 0px 0px 15px 5px #aaa;
border-radius: 10px;
opacity:0.8; 

}
#main_top{
margin-top:0px;
text-align: center; 
color: #19a8ee;
word-wrap: break-word;
font-family: "微软雅黑","Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
font-size: 24px ;
position: relative;
height: 40px;
}
#main_button{
margin-top:0px;
text-align: center; 
word-wrap: break-word;
font-family: "微软雅黑","Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
font-size: 24px ;
position: relative;
height: 40px;
}
#main_sub{
background-color:#5bb75b;
width: 100px;
height: 40px;
text-align: center;
font-weight: normal;
border-radius: 7px;
 margin-left: 320px;
 margin-bottom: 20px
}
</style>


</head>
<body>
<div id="body1">
<P style="color: #f3eddd">欢迎用户：${account}</P>
<hr>
<div id="main">
<div id="main_top"><p >欢迎使用做的全队调查问卷</p></div>
<form action="http://localhost:8080/Questionare/Submit?account=${account}" method="post">
   <c:forEach var="ques" items="${list}">	
  	<div class="ques">
	    <p><i>${ques.id}: </i>  ${ques.content}<br/></p>
		    <c:forEach var="option" items="${ques.list_o}">
		    	<c:if test="${not empty option.option1}">
			    <p><input type="radio" name="${option.id}" value="${option.queId}"/>${option.queId}:${option.option1}<br/></p>
			    </c:if>
		    </c:forEach> 
   	</div>	
   </c:forEach>  
    <input type="submit" value="问卷提交" id="main_sub"/>
</form>
</div>
<hr>
<div id="main_button"><p>欢迎参与本次问卷调查</p></div>
</div>
</body>
</html>