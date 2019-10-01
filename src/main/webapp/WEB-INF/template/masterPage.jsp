<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<spring:url var="resources" value="/resources/uu" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>


<head>
    
     <!-- Title -->
	<title> Bus Uncle : ${title}</title>
	
	<script>
		window.menu = '${title}';
		
		window.contextRoot = '${contextRoot}'
	</script>
	
    <!-- Meta Tags -->
    <meta charset="utf-8">
    <meta name="keywords" content="HTML5 Template" />
    <meta name="description" content="Travelo - Travel, Tour Booking HTML5 Template">
    <meta name="author" content="SoapTheme">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
     <%-- <meta name="_csrf" content="${_csrf.token}">
	<meta name="_csrf_header" content="${_csrf.headerName}"> --%>
    
   
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    
    <!-- Theme Styles -->
    <link rel="stylesheet" href="${resources}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${resources}/css/font-awesome.min.css">
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="${resources}/css/animate.min.css">
    
    <!-- Current Page Styles -->
    <link rel="stylesheet" type="text/css" href="${resources}/components/revolution_slider/css/settings.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${resources}/components/revolution_slider/css/style.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${resources}/components/jquery.bxslider/jquery.bxslider.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${resources}/components/flexslider/flexslider.css" media="screen" />
    
    <!-- Main Style -->
    <link id="main-style" rel="stylesheet" href="${resources}/css/style.css">
    <script type="text/javascript">
        var mainStyle = "style.html";
        if (typeof localStorage != "undefined") {
            var colorSkin = localStorage.getItem("colorSkin");
            if (colorSkin != null) {
                mainStyle = "style-" + colorSkin + ".css";
            }
        }
        document.write('<link id="main-style" rel="stylesheet" href="css/' + mainStyle + '">');
    </script>
    
    <!-- Updated Styles -->
    <link rel="stylesheet" href="css/updates.css">

    <!-- Custom Styles -->
    <link rel="stylesheet" href="css/custom.css">
    
    <!-- Responsive Styles -->
    <link rel="stylesheet" href="css/responsive.css">
    
    <!-- CSS for IE -->
    <!--[if lte IE 9]>
        <link rel="stylesheet" type="text/css" href="css/ie.css" />
    <![endif]-->
    
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script type='text/javascript' src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
      <script type='text/javascript' src="http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.js"></script>
    <![endif]-->

    <!-- Javascript Page Loader -->
    <script type="text/javascript" src="js/pace.min.js" data-pace-options='{ "ajax": false }'></script>
    <script type="text/javascript" src="js/page-loading.js"></script>
    
    <!-- Select Picker JS & CSS -->
	<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/css/bootstrap-select.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>
	 -->
	 
	 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
	 
	 <style>

	.blue {
	    background: red;
	}
</style>

<style type="text/css">

	div#full-size{
		background: contain;
	}
	
	div.blockseat{
		background: url('/resources/seat/selected_seat_img.gif');
	}
</style>
	 
</head>

<body>
    
    <div id="page-wrapper">
    
    	<!-- Header Area Start -->
	    <%@include file="shared/header.jsp"%>
	    <!-- Header Area End -->
        
        
	    <%-- <%@include file="shared/slider.jsp"%> --%>
	    
        
		<!-- Slider Area Start -->
        <c:if test="${userClickHomeSlider == true }">
	    	<%@include file="shared/slider.jsp"%>
	    </c:if>
		<!-- Slider Area End -->
	    
        <!-- Body Area Start -->
        
        <c:if test="${userClickHome == true }">
	    	<%@include file="index.jsp"%>
	    </c:if>

		<c:if test="${userClickSearchBuses == true }">
	    	<%@include file="search.jsp"%>
	    </c:if>
	    
	    <%-- <c:if test="${userClickPasengerInfo == true }">
	    	<%@include file="passInfo.jsp"%>
	    </c:if> --%>
	    
	    <c:if test="${userClickSuccess == true }">
	    	<%@include file="success.jsp"%>
	    </c:if>
	    
	    
         <!-- Body Area End -->
         
        
        <!-- Footer Area Start -->
        <%@include file="shared/footer.jsp"%>
        <!-- Footer Area End -->
    
    </div>
     
    <div id="style-changer" class="style-changer dark">
        <div class="style-changer-header">
            <a href="#" class="style-toggle open">
                <i class="fa fa-gear"></i>
            </a>
            <h2 class="style-main-title">Customize Travelo</h2>
        </div>
        <div class="style-chagner-main">
            <label for="header-style">header style</label>
            <div class="selector">
                <select class="full-width" name="header-style" id="header-style">
                    <option value="">Default Style</option>
                    <option value="style1">Style1</option>
                    <option value="style2">Style2</option>
                    <option value="style3">Style3</option>
                    <option value="style4">Style4</option>
                    <option value="style5">Style5</option>
                    <option value="style6">Style6</option>
                    <option value="style7">Style7</option>
                </select>
            </div>
            <!--<label for="inner-start-style">inner start style</label>
            <div class="selector">
                <select class="full-width" name="inner-start-style" id="inner-start-style">
                    <option value="">Default Style</option>
                    <option value="style1">Style1</option>
                    <option value="style2">Style2</option>
                    <option value="style3">Style3</option>
                    <option value="style4">Style4</option>
                    <option value="style5">Style5</option>
                    <option value="style6">Style6</option>
                </select>
            </div>
            <label for="search-style">search style</label>
            <div class="selector">
                <select class="full-width" name="search-style" id="search-style">
                    <option value="">please select</option>
                </select>
            </div>-->
            <label for="footer-style">footer style</label>
            <div class="selector">
                <select class="full-width" name="footer-style" id="footer-style">
                    <option value="">Default Style</option>
                    <option value="style1">Style1</option>
                    <option value="style2">Style2</option>
                    <option value="style3">Style3</option>
                    <option value="style4">Style4</option>
                    <option value="style5">Style5</option>
                    <option value="style6">Style6</option>
                </select>
            </div>
            <label>design skins</label>
            <ul class="design-skins column-5 clearfix">
                <li class="active light-blue"><a href="#"><i class="soap-icon-check-1"></i></a></li>
                <li class="purple"><a href="#"><i class="soap-icon-check-1"></i></a></li>
                <li class="orange"><a href="#"><i class="soap-icon-check-1"></i></a></li>
                <li class="light-orange"><a href="#"><i class="soap-icon-check-1"></i></a></li>
                <li class="sea-blue"><a href="#"><i class="soap-icon-check-1"></i></a></li>
                <li class="sky-blue"><a href="#"><i class="soap-icon-check-1"></i></a></li>
                <li class="dark-orange"><a href="#"><i class="soap-icon-check-1"></i></a></li>
                <li class="dark-blue"><a href="#"><i class="soap-icon-check-1"></i></a></li>
                <li class="light-yellow"><a href="#"><i class="soap-icon-check-1"></i></a></li>
                <li class="red"><a href="#"><i class="soap-icon-check-1"></i></a></li>
            </ul>
            <a class="button full-width btn-medium green uppercase" href="#">apply settings</a>
        </div>
    </div>


    <!-- Javascript -->
    <script type="text/javascript" src="${resources}/js/jquery-1.11.1.min.js"></script> 
    <script type="text/javascript" src="${resources}/js/jquery.noconflict.js"></script>
    <script type="text/javascript" src="${resources}/js/modernizr.2.7.1.min.js"></script>
    <script type="text/javascript" src="${resources}/js/jquery-migrate-1.2.1.min.js"></script>
    <script type="text/javascript" src="${resources}/js/jquery.placeholder.js"></script>
    <script type="text/javascript" src="${resources}/js/jquery-ui.1.10.4.min.js"></script>
    
    <!-- Twitter Bootstrap -->
    <script type="text/javascript" src="${resources}/js/bootstrap.min.js"></script>
    
    <!-- load revolution slider scripts -->
    <script type="text/javascript" src="${resources}/components/revolution_slider/js/jquery.themepunch.tools.min.js"></script>
    <script type="text/javascript" src="${resources}/components/revolution_slider/js/jquery.themepunch.revolution.min.js"></script>
    
    <!-- load BXSlider scripts -->
    <script type="text/javascript" src="${resources}/components/jquery.bxslider/jquery.bxslider.min.js"></script>

    <!-- Flex Slider -->
    <script type="text/javascript" src="${resources}/components/flexslider/jquery.flexslider-min.js"></script>

    <!-- parallax -->
    <script type="text/javascript" src="${resources}/js/jquery.stellar.min.js"></script>

    <!-- waypoint -->
    <script type="text/javascript" src="${resources}/js/waypoints.min.js"></script>

    <!-- load page Javascript -->
    <script type="text/javascript" src="${resources}/js/theme-scripts.js"></script>
    <script type="text/javascript" src="${resources}/js/scripts.js"></script>
    
    <script type="text/javascript">
        tjq(document).ready(function() {
            tjq('.revolution-slider').revolution(
            {
                sliderType:"standard",
				sliderLayout:"auto",
				dottedOverlay:"none",
				delay:10000,
				navigation: {
					keyboardNavigation:"off",
					keyboard_direction: "horizontal",
					mouseScrollNavigation:"off",
					mouseScrollReverse:"default",
					onHoverStop:"on",
					touch:{
						touchenabled:"on",
						swipe_threshold: 75,
						swipe_min_touches: 1,
						swipe_direction: "horizontal",
						drag_block_vertical: false
					}
					,
					arrows: {
						style:"default",
						enable:true,
						hide_onmobile:false,
						hide_onleave:false,
						tmp:'',
						left: {
							h_align:"left",
							v_align:"center",
							h_offset:20,
							v_offset:0
						},
						right: {
							h_align:"right",
							v_align:"center",
							h_offset:20,
							v_offset:0
						}
					}
				},
				visibilityLevels:[1240,1024,778,480],
				gridwidth:1170,
				gridheight:646,
				lazyType:"none",
				shadow:0,
				spinner:"spinner4",
				stopLoop:"off",
				stopAfterLoops:-1,
				stopAtSlide:-1,
				shuffle:"off",
				autoHeight:"off",
				hideThumbsOnMobile:"off",
				hideSliderAtLimit:0,
				hideCaptionAtLimit:0,
				hideAllCaptionAtLilmit:0,
				debugMode:false,
				fallbacks: {
					simplifyAll:"off",
					nextSlideOnWindowFocus:"off",
					disableFocusListener:false,
				}
            });
        });
    </script>
    
</body>

</html>