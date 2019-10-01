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

</head>
<body>
    
    
    
    
    <!-- Header Area Start -->
    <%@include file="shared/header.jsp"%>
    <!-- Header Area End -->
    
    
    
    <!-- Slider Area Start -->
    <%@include file="shared/slider.jsp" %>
    <!-- Slider Area End -->
    
    

    <!-- Body Area Start -->
    
    errorTitle : ${errorTitle}
     <br />
    errorDescription : ${errorDescription}
    <!-- Body Area End -->
    
    
    <!-- Footer Area Start -->
    <%@include file="shared/footer.jsp"%>
    <!-- Footer Area End -->

    
    
    <!-- jQuery -->
    <script src="${resources}/js/jquery.min.js"></script>
    
    <!-- Bootstrap JS -->
    <script src="${resources}/js/bootstrap.min.js"></script>
    
    <!-- Featherlight JS -->
    <script src="${resources}/js/featherlight.js"></script>
    
    <!-- Featherlight Gallery JS -->
    <script src="${resources}/js/featherlight.gallery.js"></script>
    
    <!-- OwlCarousel JS -->
    <script src="${resources}/js/owl.carousel.min.js"></script>
    
    <!-- SlickNav JS -->
    <script src="${resources}/js/jquery.slicknav.min.js"></script>
    
    <!-- Gmap JS -->
    <script src="${resources}/js/gmap.js"></script>
    
    <!-- Progressbar js -->
    <script src="${resources}/js/progressbar.min.js"></script>
    
    <!-- Counter JS -->
    <script src="${resources}/js/jquery.counterup.min.js"></script>
    
    <!-- Counter JS -->
    <script src="${resources}/js/waypoints-min.js"></script>
    
    <!-- Custom JS -->
    <script src="${resources}/js/custom.js"></script>

    
</body>


</html>