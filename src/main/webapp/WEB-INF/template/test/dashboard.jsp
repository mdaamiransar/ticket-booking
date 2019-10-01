<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
    <!-- Promo Area Start -->
    <section class="bleezy-promo-area section_100" style="background:white">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="site-heading">
                        <h2>Our Products</h2>
                    </div>
                </div>
            </div>
            <div class="row">
            	<c:if test="${!empty topProduct}">
            	<c:forEach items="${topProduct}" var="p">
                <div class="col-md-3 col-sm-3">
                    <div class="single-promo">
                        <div class="promo-image">
                            <a href="#">
                                <img src="/resources/img/${p.code}.jpg" alt="promo" />
                            </a>
                        </div>
                        <div class="promo-text">
                            <h2><a href="#">Buy</a></h2>
                        </div>
                    </div>
                </div>
                </c:forEach>
                </c:if>
                
                
            </div>
        </div>
    </section>
    <!-- Promo Area End -->
    
    
    
    <!-- Count Area Start -->
    <section class="bleezy-count-area section_100">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="counts-text">
                        <h3>We are ready to provide security in resonable price and guarantee your safety in any situation in your life </h3>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 col-sm-4">
                    <div class="count-box">
                        <h3 class="counter">2800</h3>
                        <h4>Project <span>Done</span></h4>
                    </div>
                </div>
                <div class="col-md-4 col-sm-4">
                    <div class="count-box">
                        <h3 class="counter">1200</h3>
                        <h4>Qualified <span>Employee</span></h4>
                    </div>
                </div>
                <div class="col-md-4 col-sm-4">
                    <div class="count-box">
                        <h3 class="counter">3100</h3>
                        <h4>Deal <span>Assigned</span></h4>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Count Area End -->
    
    
    <!-- Blog Area Start -->
    <section class="bleezy-blog-area section_t_100 section_b_70">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="site-heading">

                        <h2>Our Latest News</h2>
                    </div>
                </div>
            </div>
            <div class="row">
            <c:forEach items="${topNews}" var="p">
                <div class="col-md-4 col-sm-4">
                    <div class="single-blog">
                        <div class="blog-image">
                            <a href="#">
                                <img src="resources/img/${p.image}.jpg" alt="blog" />
                            </a>
                        </div>
                        <div class="blog-text">
                            <h2><a href="#">${p.name}</a></h2>
                            <div class="blog-meta">
                                <p>-: ${p.shortDescription}</p>
                            </div>
                        </div>
                    </div>
                </div>
			</c:forEach>
            </div>
        </div>
    </section>
    <!-- Blog Area End -->
    
    <!-- Testimonial Area Start -->
    <section class="bleezy-testimonial-area section_100" style="background-image:url('resources/ui/bg1920x900.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="site-heading-black">
                        <!--<h3>What They Say</h3>-->
                        <h2>Testimonials</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="testimonial-slide">
                    <c:forEach items="${topTestimonial}" var="p">
                        <div class="single-testimonial">
                            <div class="testimonial-text">
                                <p>${p.description}</p>
                            </div>
                            <div class="testimonial-info">
                                <div class="info-img">
                                    <img src="${resources}/img/client1.jpg" alt="client" />
                                </div>
                                <div class="info-name">
                                    <h4>${p.name}</h4>
                                    <p>${p.shortDescription}</p>
                                </div>
                            </div>
                        </div>
					</c:forEach>

                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Testimonial Area End -->
    
    
    
  
    
    
    
    <!-- Broucher Area Start -->
<!--     <section class="bleezy-broucher-area">
        <div class="broucher-overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-9 col-sm-8">
                    <div class="broucher-left">
                        <h3>Download our corporate brochure</h3>
                    </div>
                </div>
                <div class="col-md-3 col-sm-4">
                    <div class="broucher-right">
                        <div class="download-btn">
                            <a href="#">Download.Pdf <span class="fa fa-arrow-circle-o-down"></span></a>
                            <i class="fa fa-file-pdf-o"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section> -->
    <!-- Broucher Area End -->