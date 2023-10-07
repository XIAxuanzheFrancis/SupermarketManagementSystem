<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>	
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Supermarket Management System</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css" />
</head>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>Supermarket Management System</h1>
        <div class="publicHeaderR">
            <p><span>Hello！</span><span style="color: #fff21b"> ${userSession.userName }</span> , Welcome！</p>
            <a href="${pageContext.request.contextPath }/jsp/logout.do">exit</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">Saturday 7th October 2023 13:14</span>
        <a href="#">Warm tip: Please use a high version of browser in order to be able to browse properly! (IE10+)</a>
    </section>

 <section class="publicMian ">
     <div class="left">
         <h2 class="leftH2"><span class="span1"></span>Function List <span></span></h2>
         <nav>
             <ul class="list">
                 <li ><a href="${pageContext.request.contextPath }/jsp/bill.do?method=query">Orders</a></li>
              <li><a href="${pageContext.request.contextPath }/jsp/provider.do?method=query">Suppliers</a></li>
              <li><a href="${pageContext.request.contextPath }/jsp/user.do?method=query">Users</a></li>
              <li><a href="${pageContext.request.contextPath }/jsp/pwdmodify.jsp">Password Change</a></li>
              <li><a href="${pageContext.request.contextPath }/jsp/logout.do">Exit system</a></li>
             </ul>
         </nav>
     </div>
     <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
     <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>