<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script> -->

<div class="page-title-container">
    <div class="container">
        <div class="page-title pull-left">
            <h2 class="entry-title">Bus Search Results</h2>
        </div>
        <ul class="breadcrumbs pull-right">
            <li><a href="#">HOME</a></li>
            <li class="active">Bus Search Results</li>
        </ul>
    </div>
</div>

<section id="content">
    <div class="container">
        <div id="main">
            <div class="row">
                 
                 <div class="col-md-9">
					
                     <div class="flight-list listing-style3 flight">
                         
                         <c:if test="${!empty listBus}">
                         <c:forEach items="${listBus}" var="bus">
                         
                         <!-- <article class="box" data-toggle="collapse" data-target="#collapse_1"> -->
                         <article class="box" data-toggle="collapse" data-target="#collapse_${bus.id}" id="btn1">
                             <figure class="col-xs-3 col-sm-2">
                                 <!-- <span><img width="94" height="90" alt="" src="images/shortcodes/listings/style02/flight/2.png"></span> -->
                                 <span><img width="94" height="90" alt="" src="${contextRoot}/resources/img/BUSDB9C678303.jpg"></span>
                             </figure>
                             <div class="details col-xs-9 col-sm-10">
                                 <div class="details-wrapper">
                                     <div class="first-row">
                                         <div>
                                             <h4 class="box-title">${bus.name}<%-- <small>${bus.startPoint}</small> --%></h4>
                                             <a class="button btn-mini stop" style="font-size: 1.2em; height: 23px; line-height: 21px;">
                                             ${bus.startPoint} to ${bus.endPoint}</a>
                                             <div class="amenities">
                                                 <i class="soap-icon-wifi circle"></i>
                                                 <i class="soap-icon-entertainment circle"></i>
                                                 <i class="soap-icon-fork circle"></i>
                                                 <i class="soap-icon-suitcase circle"></i>
                                             </div>
                                         </div>
                                         <div>
                                             <span class="price"><small>FARE</small>${bus.fare}</span>
                                         </div>
                                     </div>
                                     <div class="second-row">
                                         <div class="time">
                                             <div class="take-off col-sm-4">
                                                 <div class="icon"><i class="soap-icon-plane-right yellow-color"></i></div>
                                                 <div>
                                                     <span class="skin-color">Boarding Time</span><br />${bus.startTime}
                                                 </div>
                                             </div>
                                             <div class="landing col-sm-4">
                                                 <div class="icon"><i class="soap-icon-plane-right yellow-color"></i></div>
                                                 <div>
                                                     <span class="skin-color">Arrival Time</span><br />${bus.endTime}
                                                 </div>
                                             </div>
                                             <div class="total-time col-sm-4">
                                                 <div class="icon"><i class="soap-icon-clock yellow-color"></i></div>
                                                 <div>
                                                     <span class="skin-color">total time</span><br />13 Hour, 40 minutes
                                                 </div>
                                             </div>
                                         </div>
                                         <div class="action">
                                             <a href="flight-detailed.html" class="button btn-small full-width">SELECT NOW</a>
                                         </div>
                                         
                                     </div>
                                 </div>
                             </div>
                         </article>
                         
                         <div id="row">
							
							<script>
								window.busId = '${bus.id}';
							</script>
							
							
							<div class=" bg-success">
								<div class="row">
									<div class="col-md-5">
										<div id="subViewDiv">
										
										${seatStructure}
										</div>

									</div>
								</div>
								<div class="row">
									<div class="col-md-7">
										<div id="">
										<form action="${contextRoot}/passengerInfo/${bus.id}" method="GET"> 						
											<label>Seat</label>
											<select name="seat" class="selectpicker" multiple data-max-options="2" data-live-search="true">
											  <option data-tokens="1A">1A</option>
											  <option data-tokens="2A">2A</option>
											  <option data-tokens="1B">1B</option>
											</select>
											<button type="submit" class="btn btn-secondary">Proceed</button>
										</form> 
										</div>
									</div>
									<div class="col-md-5">
										<div>										
										<label>Seats : 1, 2</label>
										</div>
										<div>
										<label>Boarding Point :
										<select name="seat" class="form-control">
											  <option data-tokens="1A">Ladies Park</option>
											  <option data-tokens="2A">Babu Ghat</option>
										</select></label>
										</div>
										<div>
										Fare : ${bus.fare}
										</div>
									</div>
									
								</div>
								
								
						
							</div>
                         
                         	
                         	
						 </div>
						 
						 
                         </c:forEach>
                         
                         
                         </c:if>
                         
                     </div>
                     <a class="button uppercase full-width btn-large">load more listings</a>
                 </div>
             </div>
         </div>
     </div>
 </section>



<!-- <script type="text/javascript">
function doAjaxPost() {

    $.ajax({
        type: "GET",
        url: window.contextRoot + '/bus/' + window.busId +'/seatLayout',
        success: function(response) {
            $("#subViewDiv").html( response );
        }
    });
}
</script> -->

