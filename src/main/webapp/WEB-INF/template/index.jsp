<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section id="content">
            
	<div class="search-box-wrapper">
	    <div class="search-box container" style="margin-top:-39px !important;">
	       <!-- <ul class="search-tabs clearfix">
	            <li class="active"><a href="#flight-status-tab" data-toggle="tab">BUS BOOKING</a></li>
	        </ul>
	        <div class="visible-mobile">
	            <ul id="mobile-search-tabs" class="search-tabs clearfix">
	                
	                <li><a href="#flight-status-tab">BUS BOOKING</a></li>
	            </ul>
	        </div>
	        -->
	        <div class="search-tab-content">
	            
	            <div class="tab-pane fade active in" id="flight-status-tab">
	                <form id="myForm" action="/search" method="GET">
	                <!-- <form id="myForm" action="/search" method="GET"> -->
	                    <div class="row">
	                        <div class="col-md-6">
	                            <div class="form-group row">
	                                <div class="col-xs-6">
	                                    <label>From</label>
	                                    <input name="boardPoint" type="text" class="input-text full-width" placeholder="Source" />
	                                </div>
	                                <div class="col-xs-6">
	                                    <label>Going To</label>
	                                    <input name="dropPoint" type="text" class="input-text full-width" placeholder="Destination"/>
	                                </div>
	                            </div>
	                        </div>
	                        
	                        <div class="col-xs-6 col-md-2">
	                            <div class="form-group">
	                                <label>Departure Date</label>
	                                <div class="datepicker-wrap">
	                                    <input name="departureDate" type="text" class="input-text full-width" placeholder="mm/dd/yy" />
	                                </div>
	                            </div>
	                        </div>
	                        
	                        <div class="col-xs-6 col-md-2">
	                            <div class="form-group">
	                                <label>Return Date(Optional)</label>
	                                <div class="datepicker-wrap">
	                                    <input name="returnDate" ng-model="returnDate" type="text" class="input-text full-width" placeholder="mm/dd/yy" />
	                                </div>
	                            </div>
	                        </div>
	                        <div class="form-group col-md-2">
	                            <label class="hidden-xs">&nbsp;</label>
	                            <button class="icon-check full-width">SEARCH NOW</button>
	                        </div>
	                    </div>
	                </form>
	            </div>
	            
	        </div>
	    </div>
	</div>
	
	<!-- Popuplar Destinations -->
	<div class="destinations section">
	    <div class="container">
	        <h2>Popular Destinations</h2>
	        <div class="row image-box style1 add-clearfix">
	            <div class="col-sms-6 col-sm-6 col-md-3">
	                <article class="box">
	                    <figure class="animated" data-animation-type="fadeInDown" data-animation-duration="1">
	                        <a href="ajax/slideshow-popup.html" title="" class="hover-effect popup-gallery"><img src="${resources}/images/destinations01.jpg" alt="" width="270" height="160" /></a>
	                    </figure>
	                    <div class="details">
	                        <span class="price"><small>FROM</small>$490</span>
	                        <h4 class="box-title"><a href="hotel-detailed.html">Atlantis - The Palm<small>Paris</small></a></h4>
	                    </div>
	                </article>
	            </div>
	            <div class="col-sms-6 col-sm-6 col-md-3">
	                <article class="box">
	                    <figure class="animated" data-animation-type="fadeInDown" data-animation-duration="1" data-animation-delay="0.3">
	                        <a href="ajax/slideshow-popup.html" title="" class="hover-effect popup-gallery"><img src="${resources}/images/destinations02.jpg" alt="" width="270" height="160" /></a>
	                    </figure>
	                    <div class="details">
	                        <span class="price"><small>FROM</small>$170</span>
	                        <h4 class="box-title"><a href="hotel-detailed.html">Hilton Hotel<small>LONDON</small></a></h4>
	                    </div>
	                </article>
	            </div>
	            <div class="col-sms-6 col-sm-6 col-md-3">
	                <article class="box">
	                    <figure class="animated" data-animation-type="fadeInDown" data-animation-duration="1" data-animation-delay="0.6">
	                        <a href="ajax/slideshow-popup.html" title="" class="hover-effect popup-gallery"><img src="${resources}/images/destinations03.jpg" alt="" width="270" height="160" /></a>
	                    </figure>
	                    <div class="details">
	                        <span class="price"><small>FROM</small>$130</span>
	                        <h4 class="box-title"><a href="hotel-detailed.html">MGM Grand<small>LAS VEGAS</small></a></h4>
	                    </div>
	                </article>
	            </div>
	            <div class="col-sms-6 col-sm-6 col-md-3">
	                <article class="box">
	                    <figure class="animated" data-animation-type="fadeInDown" data-animation-duration="1" data-animation-delay="0.9">
	                        <a href="ajax/slideshow-popup.html" title="" class="hover-effect popup-gallery"><img src="${resources}/images/destinations04.jpg" alt="" width="270" height="160" /></a>
	                    </figure>
	                    <div class="details">
	                        <span class="price"><small>FROM</small>$290</span>
	                        <h4 class="box-title"><a href="hotel-detailed.html">Crown Casino<small>ASUTRALIA</small></a></h4>
	                    </div>
	                </article>
	            </div>
	        </div>
	    </div>
	</div>
	
	<!-- Honeymoon -->
	<div class="honeymoon section global-map-area promo-box parallax" data-stellar-background-ratio="0.5">
	    <div class="container">
	        <div class="col-sm-6 content-section description pull-right">
	            <h1 class="title">Popular Destinations for Honeymoon</h1>
	            <p>Nunc cursus libero purusac congue arcu cursus utsed vitae pulvinar massa idporta neque purusac Etiam elerisque mi id faucibus iaculis vitae pulvinar.</p>
	            <div class="row places image-box style9">
	                <div class="col-sms-4 col-sm-4">
	                    <article class="box">
	                        <figure>
	                            <a href="hotel-list-view.html" title="" class="hover-effect yellow middle-block animated" data-animation-type="fadeInUp" data-animation-duration="1">
	                                <img src="${resources}/images/places01.jpg" alt="" width="306" height="170" /></a>
	                        </figure>
	                        <div class="details">
	                            <h4 class="box-title">Paris<small>(990 PLACES)</small></h4>
	                            <a href="hotel-list-view.html" title="" class="button">SEE ALL</a>
	                        </div>
	                    </article>
	                </div>
	                <div class="col-sms-4 col-sm-4">
	                    <article class="box">
	                        <figure>
	                            <a href="hotel-list-view.html" title="" class="hover-effect yellow middle-block animated" data-animation-type="fadeInUp" data-animation-duration="1" data-animation-delay="0.4"><img src="${resources}/images/places02.jpg" alt="" width="175" height="175" /></a>
	                        </figure>
	                        <div class="details">
	                            <h4 class="box-title">Greece<small>(990 PLACES)</small></h4>
	                            <a href="hotel-list-view.html" title="" class="button">SEE ALL</a>
	                        </div>
	                    </article>
	                </div>
	                <div class="col-sms-4 col-sm-4">
	                    <article class="box">
	                        <figure>
	                            <a href="hotel-list-view.html" title="" class="hover-effect yellow middle-block animated" data-animation-type="fadeInUp" data-animation-duration="1" data-animation-delay="0.8"><img src="${resources}/images/places03.jpg" alt="" width="340" height="226" /></a>
	                        </figure>
	                        <div class="details">
	                            <h4 class="box-title">Australia<small>(990 PLACES)</small></h4>
	                            <a href="hotel-list-view.html" title="" class="button">SEE ALL</a>
	                        </div>
	                    </article>
	                </div>
	            </div>
	        </div>
	        <div class="col-sm-6 image-container no-margin">
	            <img src="${resources}/images/couple.png" alt="" class="animated" data-animation-type="fadeInUp" data-animation-duration="2">
	        </div>
	    </div>
	</div>
	
	<!-- Did you Know? section -->
	            <div class="offers section">
	                <div class="container">
	                    <h1 class="text-center">Did you know?</h1>
	                    <p class="col-xs-9 center-block no-float text-center">Mauris ullamcorper nibh quis leo ultrices in hendrerit velit tristiqueut augue in nulla lacinia bibendum liberoras rutrum ac purus ut tristique.
	Nullam placerat lacinia dolor quis pretium. Phasellus vitae lacinia quam, at pellentesque lorem. Sed euismod turpis quis mattis fringilla.</p>
	                    <div class="row image-box style2">
	                        <div class="col-md-6">
	                            <article class="box">
	                                <figure class="animated" data-animation-type="fadeInLeft" data-animation-duration="1">
	                                    <a href="#" title=""><img src="${resources}/images/offers01.jpg" alt="" width="272" height="192" /></a>
	                                </figure>
	                                <div class="details">
	                                    <h4>Hire Cars</h4>
	                                    <p>Nunc cursus libero purus ac congue ar lorem cursus ut sed vitae pulvinar massa idend porta nequetiam elerisque mi id.</p>
	                                    <a href="#" title="" class="button">SEE ALL</a>
	                                </div>
	                            </article>
	                        </div>
	                        <div class="col-md-6">
	                            <article class="box">
	                                <figure class="animated" data-animation-type="fadeInLeft" data-animation-duration="1" data-animation-delay="0.4">
	                                    <a href="#" title=""><img src="${resources}/images/offers02.jpg" alt="" width="272" height="192" /></a>
	                                </figure>
	                                <div class="details">
	                                    <h4>Cruise Deals</h4>
	                                    <p>Nunc cursus libero purus ac congue ar lorem cursus ut sed vitae pulvinar massa idend porta nequetiam elerisque mi id.</p>
	                                    <a href="#" title="" class="button">SEE ALL</a>
	                                </div>
	                            </article>
	                        </div>
	                        <div class="col-md-6">
	                            <article class="box">
	                                <figure class="animated" data-animation-type="fadeInLeft" data-animation-duration="1">
	                                    <a href="#" title=""><img src="${resources}/images/offers03.jpg" alt="" width="272" height="192" /></a>
	                                </figure>
	                                <div class="details">
	                                    <h4>Things To Do</h4>
	                                    <p>Nunc cursus libero purus ac congue ar lorem cursus ut sed vitae pulvinar massa idend porta nequetiam elerisque mi id.</p>
	                                    <a href="#" title="" class="button">SEE ALL</a>
	                                </div>
	                            </article>
	                        </div>
	                        <div class="col-md-6">
	                            <article class="box">
	                                <figure class="animated" data-animation-type="fadeInLeft" data-animation-duration="1" data-animation-delay="0.4">
	                                    <a href="#" title=""><img src="${resources}/images/offers04.jpg" alt="" width="272" height="192" /></a>
	                                </figure>
	                                <div class="details">
	                                    <h4>Fly in Comfort</h4>
	                                    <p>Nunc cursus libero purus ac congue ar lorem cursus ut sed vitae pulvinar massa idend porta nequetiam elerisque mi id.</p>
	                                    <a href="#" title="" class="button">SEE ALL</a>
	                                </div>
	                            </article>
	                        </div>
	                    </div>
	                </div>
	            </div>
	            
	            <!-- Features section -->
	    <div class="features section global-map-area parallax" data-stellar-background-ratio="0.5">
	        <div class="container">
	            <div class="row image-box style7">
	                <div class="col-sms-6 col-sm-6 col-md-3">
	                    <article class="box">
	                        <figure class="middle-block">
	                            <img src="${resources}/images/shortcodes/image-box/style07/1.jpg" alt="" class="middle-item" width="283" height="200" />
	                            <span class="opacity-wrapper"></span>
	                        </figure>
	                        <div class="details">
	                            <h4><a href="#">Best Price Guarantee</a></h4>
	                            <p>
	                                Nunc cursus libero purus ac congue arcu cursus ut sed vitae pulvinar massa idporta nequetiam elerisque mi id faucibus iaculis vitae pulvinar.
	                            </p>
	                        </div>
	                    </article>
	                </div>
	                <div class="col-sms-6 col-sm-6 col-md-3">
	                     <article class="box">
	                        <figure class="middle-block">
	                            <img src="${resources}/images/shortcodes/image-box/style07/2.jpg" alt="" class="middle-item" width="276" height="126" />
	                            <span class="opacity-wrapper"></span>
	                        </figure>
	                        <div class="details">
	                            <h4><a href="#">Travel Insurance</a></h4>
	                            <p>
	                                Nunc cursus libero purus ac congue arcu cursus ut sed vitae pulvinar massa idporta nequetiam elerisque mi id faucibus iaculis vitae pulvinar.
	                            </p>
	                        </div>
	                    </article>
	                </div>
	                <div class="col-sms-6 col-sm-6 col-md-3">
	                     <article class="box">
	                        <figure class="middle-block">
	                            <img src="${resources}/images/shortcodes/image-box/style07/3.jpg" alt="" class="middle-item" width="284" height="189" />
	                            <span class="opacity-wrapper"></span>
	                        </figure>
	                        <div class="details">
	                            <h4><a href="#">Why Chose Us</a></h4>
	                            <p>
	                                Nunc cursus libero purus ac congue arcu cursus ut sed vitae pulvinar massa idporta nequetiam elerisque mi id faucibus iaculis vitae pulvinar.
	                            </p>
	                        </div>
	                    </article>
	                </div>
	                <div class="col-sms-6 col-sm-6 col-md-3">
	                     <article class="box">
	                        <figure class="middle-block">
	                            <img src="${resources}/images/shortcodes/image-box/style07/4.jpg" alt="" class="middle-item" width="274" height="142" />
	                            <span class="opacity-wrapper"></span>
	                        </figure>
	                        <div class="details">
	                            <h4><a href="#">Need Help?</a></h4>
	                            <p>
	                                Nunc cursus libero purus ac congue arcu cursus ut sed vitae pulvinar massa idporta nequetiam elerisque mi id faucibus iaculis vitae pulvinar.
	                            </p>
	                        </div>
	                    </article>
	                </div>
	            </div>
	        </div>
	    </div>
	
	</section>
	
<script type="text/javascript">

$(document).ready(function() {

	$( "#boardPoint" ).autocomplete({
		source: '${pageContext.request.contextPath}/findBoardPoint'
	});
	
	$( "#dropPoint" ).autocomplete({
		source: '${pageContext.request.contextPath}/findDropPoint'
	});
	
});

</script>


