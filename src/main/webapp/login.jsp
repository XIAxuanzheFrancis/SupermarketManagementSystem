<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>System Login - SupermarketManagementSystem</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
    <script type="text/javascript">
	/* if(top.location!=self.location){
	      top.location=self.location;
	 } */
    </script>
</head>
<body class="login_bg">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>SupermarketManagementSystem</h1>
        </header>
        <section class="loginCont">
	        <form class="loginForm" action="${pageContext.request.contextPath }/login"  name="actionForm" id="actionForm"  method="post" >
				<div class="info">${error}</div>
				<div class="inputbox">
                    <label for="userCode">user ID：</label>
					<input type="text" class="input-text" id="userCode" name="userCode" placeholder="Please enter your username" required/>
				</div>	
				<div class="inputbox">
                    <label for="userPassword">password：</label>
                    <input type="password" id="userPassword" name="userPassword" placeholder="Please enter your password" required/>
                </div>	
				<div class="subBtn">
					
                    <input type="submit" value="sign in"/>
                    <input type="reset" value="reset"/>
                </div>	
			</form>
        </section>
    </section>
</body>
</html>
