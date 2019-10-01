<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<spring:url var="resources" value="/resources/ui" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- Title -->
    <title>${title}</title>
    
    <!-- Favicon -->
    <link rel="icon" type="image/png" sizes="32x32" href="favicon/favicon-32x32.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${resources}/css/bootstrap.min.css">
    
    <!-- Font awesome CSS -->
    <link rel="stylesheet" href="${resources}/css/font-awesome.min.css">
    
    <!-- Animate CSS -->
    <link rel="stylesheet" href="${resources}/css/animate.min.css">
    
    <!-- OwlCarousel CSS -->
    <link rel="stylesheet" href="${resources}/css/owl.carousel.css">
    
    <!-- Flaticon CSS -->
    <link rel="stylesheet" href="${resources}/flaticon/flaticon.css">
    
    <!-- SlickNav CSS -->
    <link rel="stylesheet" href="${resources}/css/slicknav.min.css">
    
    <!-- Featherlight  CSS -->
    <link rel="stylesheet" href="${resources}/css/featherlight.css">
    
    <!-- Featherlight Gallery CSS -->
    <link rel="stylesheet" href="${resources}/css/featherlight.gallery.css">
    
    <!-- Main CSS -->
    <link rel="stylesheet" href="${resources}/css/style.css">
    
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="${resources}/css/responsive.css">

	<script>
		window.menu = '${title}';
		
		window.contextRoot = '${contextRoot}'
		
	</script>

</head>
<body>
    
    
    
    <!-- Header Area Start -->
   
    <!-- Header Area End -->
    
    
    
    <!-- Breadcromb Area Start -->
    
    <!-- Breadcromb Area End -->
    
    
    
    <!-- Login Area Start -->
    <section class="bleezy-login-page-area section_100">
        <div class="container">
        	
        	<c:if test="${not empty message}">
				<div class="row">
					<div class="col-xs-12 col-md-offset-2 col-md-8">
						<div class="alert alert-danger fade in">${message}</div>
					</div>
				</div>
			</c:if>
	
            <div class="row">
                <div class="col-md-12">
                    <div class="login-page-box">
                        <div class="login-page-heading">
                            <i class="fa fa-key"></i>
                            <h3>sign in</h3>
                        </div>
                        <form action="${contextRoot}/login" method="POST" class="form-horizontal"
				         id="loginForm">
                            <div class="account-form-group">
                                <input type="text" name="username" id="username" class="form-control" placeholder="Username or Email" >
                                <i class="fa fa-user"></i>
                            </div>
                            <div class="account-form-group">
                                <input type="password" name="password" id="password" class="form-control" placeholder="Password" >
                                <i class="fa fa-lock"></i>
                            </div>
                            <p class="forgot">
                                <a href="#">Forgot username?</a>
                            </p>
                            <p>
                                <label>
                                    <input name="remember" type="checkbox">
                                    Remember Me
                                </label>
                            </p>
                            <p>
                            	<input type="hidden"  name="${_csrf.parameterName}"  value="${_csrf.token}"/>
                                <button type="submit" >Login</button>
                            </p>
                        </form>
                        <div class="login-sign-up">
                            <a href="register.html">Do you need an account?</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Login Area End -->
    
    
    
    <!-- Footer Area Start -->
    <!-- Footer Area End -->

    
    
    <!-- jQuery -->
    <script src="${resources}/js/jquery.min.js"></script>
    
    <!-- Bootstrap JS -->
    <script src="${resources}/js/bootstrap.min.js"></script>
    
    <!-- Custom JS -->
    <script src="${resources}/js/custom.js"></script>
    
    <script>
	
    </script>
</body>


</html>