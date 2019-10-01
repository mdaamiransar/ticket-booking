<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" type="text/javascript"></script>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<head>
    <script type="text/css">

hr{
	border-color: black !important;
}

.ssb-seat-details {
    border: 1px solid #c1c1c1;
    background: white;
    padding: 2%;
    margin: auto;
    font-size: 1em;
    width: 80%;
    *zoom: 1;
    zoom: 1;
}

.seatgender{
  padding: 0px 0px 18px !important;
  margin: 0px 6px 0px;
}

hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border-color: brown;
}

    </script>
    <script type="text/javascript">
    function findSeatLayout(busId)
    {
        $.ajax({
            type: 'GET',
            url: window.contextRoot + '/check_avail/' + busId,
            data: {bus: busId},
            success: function(data) {
                $("#id_res_div").html(data);
            }
        });
        event.preventDefault();
    }

	function getSelectedSeats() {
		var seatsAndFare = $('.selected-seat').map(function(){
		    return $(this).attr('title')
		}).get()
		console.log("hhhhh "+seatsAndFare);
		var seatsToBook = [];
		for (i = 0; i < seatsAndFare.length; i++) {
			console.log("hfdhgjdh ");
			var seat = seatsAndFare[i];
			var seatNo = seat.split('|')[0];
			seatNo = seatNo.split(':')[1];
			seatNo = seatNo.trim();
			var seatFare = seat.split('|')[1];
			console.log("final seatNo>> "+seatNo);
			console.log("final seatFare>> "+seatFare);
			seatsToBook.push(seatNo);
		}
		$('#seatsToBlock').val(seatsToBook);
	}



    </script>
</head>
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
                <div class="col-md-3">
                    <h4 class="search-results-title"><i class="soap-icon-search"></i><b>1,984</b> results found.</h4>
                    <div class="toggle-container filters-container">

                        <div class="panel style1 arrow-right">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#modify-search-panel" class="collapsed">Modify Search</a>
                            </h4>
                            <div id="modify-search-panel" class="panel-collapse collapse">
                                <div class="panel-content">
                                    <form method="post">
                                        <div class="form-group">
                                            <input type="text" class="input-text full-width" placeholder="Leaving from"
                                                   value=""/>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="input-text full-width" placeholder="going to"
                                                   value=""/>
                                        </div>
                                        <div class="form-group">
                                            <div class="datepicker-wrap">
                                                <input type="text" name="date_from" class="input-text full-width"
                                                       placeholder="Departure on (mm/dd/yy)"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="datepicker-wrap">
                                                <input type="text" name="date_to" class="input-text full-width"
                                                       placeholder="Arrival on (mm/dd/yy)"/>
                                            </div>
                                        </div>
                                        <br/>
                                        <button class="btn-medium icon-check uppercase full-width">search again</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <div class="panel style1 arrow-right">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#flight-stops-filter" class="collapsed">Bus Types</a>
                            </h4>
                            <div id="flight-stops-filter" class="panel-collapse collapse">
                                <div class="panel-content">
                                    <ul class="check-square filters-option">
                                        <li><a href="#">AC</a></li>
                                        <li><a href="#">Non AC</a></li>
                                        <li class="active"><a href="#">Seater</a></li>
                                        <li><a href="#">Sleeper</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="panel style1 arrow-right">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#departureTime-filter" class="collapsed">Departure
                                    Time</a>
                            </h4>
                            <div id="departureTime-filter" class="panel-collapse collapse">
                                <div class="panel-content">
                                    <ul class="check-square filters-option">
                                        <li><a href="#">6 am to 12 pm
                                            <small>(2)</small>
                                        </a></li>
                                        <li><a href="#">12 pm to 6 pm
                                            <small>(2)</small>
                                        </a></li>
                                        <li class="active"><a href="#">After 6 pm
                                            <small>(1)</small>
                                        </a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="panel style1 arrow-right">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#airlines-filter" class="collapsed">Arrival Time</a>
                            </h4>
                            <div id="airlines-filter" class="panel-collapse collapse">
                                <div class="panel-content">
                                    <ul class="check-square filters-option">
                                        <li><a href="#">6 am to 12 pm
                                            <small>(2)</small>
                                        </a></li>
                                        <li><a href="#">12 pm to 6 pm
                                            <small>(2)</small>
                                        </a></li>
                                        <li class="active"><a href="#">After 6 pm
                                            <small>(1)</small>
                                        </a></li>
                                    </ul>
                                    <a class="button btn-mini">MORE</a>
                                </div>
                            </div>
                        </div>

                        <div class="panel style1 arrow-right">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#price-filter" class="collapsed">Price</a>
                            </h4>
                            <div id="price-filter" class="panel-collapse collapse">
                                <div class="panel-content">
                                    <div id="price-range"></div>
                                    <br/>
                                    <span class="min-price-label pull-left"></span>
                                    <span class="max-price-label pull-right"></span>
                                    <div class="clearer"></div>
                                </div><!-- end content -->
                            </div>
                        </div>

                    </div>
                </div>

                <div class="col-md-9">
                    <!-- <div class="container">
                        <h4 class="sort-by-title block-sm">Sort results by:</h4>
                    </div> -->
                    <div class="sort-by-section clearfix box">
                        <h4 class="sort-by-title block-sm">Sort results by:</h4>
                        <ul class="sort-bar clearfix block-sm">
                            <li class="sort-by-name"><a class="sort-by-container" href="#"><span>name</span></a></li>
                            <li class="sort-by-price"><a class="sort-by-container" href="#"><span>price</span></a></li>
                            <li class="sort-by-rating active"><a class="sort-by-container" href="#"><span>duration</span></a></li>
                        </ul>

                    </div>

                    <div class="flight-list listing-style3 flight">

                        <c:if test="${!empty listBus}">
                            <c:forEach items="${listBus}" var="bus">

                                <!-- <article class="box" data-toggle="collapse" data-target="#collapse_1"> -->
                                <article class="box" data-toggle="collapse" data-target="#collapse_${bus.id}"
                                         id="#collapse_${bus.id}">
                                    <figure class="col-xs-3 col-sm-2">
                                        <!-- <span><img width="94" height="90" alt="" src="images/shortcodes/listings/style02/flight/2.png"></span> -->
                                        <span><img style="max-width:139px !important" alt=""
                                                   src="${contextRoot}/resources/img/${bus.code}.jpg"></span>
                                    </figure>
                                    <div class="details col-xs-9 col-sm-10">
                                        <div class="details-wrapper">
                                            <div class="first-row">
                                                <div>
                                                    <a class="button btn-mini stop"
                                                       style="font-size: 1.2em; height: 23px; line-height: 21px;">
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
                                                        <div class="icon"><i
                                                                class="soap-icon-plane-right yellow-color"></i></div>
                                                        <div>
                                                            <span class="skin-color">Boarding Time</span><br/>${bus.startTime}
                                                        </div>
                                                    </div>
                                                    <div class="landing col-sm-4">
                                                        <div class="icon"><i
                                                                class="soap-icon-plane-right yellow-color"></i></div>
                                                        <div>
                                                            <span class="skin-color">Arrival Time</span><br/>${bus.endTime}
                                                        </div>
                                                    </div>
                                                    <div class="total-time col-sm-4">
                                                        <div class="icon"><i class="soap-icon-clock yellow-color"></i>
                                                        </div>
                                                        <div>
                                                            <span class="skin-color">total time</span><br/>13 Hour, 40
                                                            minutes
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="action">
                                                    <!-- <a href="flight-detailed.html" class="button btn-small full-width">SELECT NOW</a> -->
                                                    <button type="button" class="button btn-small full-width"
                                                            onclick="findSeatLayout(${bus.id})" id="id_check_avail">
                                                        Book Seat
                                                    </button>
                                                    <!-- <script>
												        window.busId = '${bus.id}';
                                                    </script> -->
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </article>

                                <div id="collapse_${bus.id}" class="collapse" style="background: white;">
                                    <div class="row">
                                        <div class="col-md-7">
                                            <div id="id_res_div"></div>
                                        </div>
                                                                                
	                                        
										<div class="col-md-4 form-group">
											<label>Boarding Point</label>
											<select name="bp" class="form-control">
												<option value="">Select Boarding Point</option>
												<option value="276024">(04:30 AM) Bypass, Rajgir more,Ram Chandrapur,Bypas...</option>
											</select> 
										</div>
																				                                            
                                        <div class="col-md-4 form-group">
											<label>Dropping Point</label>
	                                        <select name="dp" class="form-control">
												<option value="">Select Dropping Point</option>
												<option value="276024">(04:30 AM) Bypass, Rajgir more,Ram Chandrapur,Bypas...</option>
											</select> 
                                        </div>
                                        
                                        <div class="col-md-4 form-group">
											<label>Seat : 8A</label>	                                         
                                        </div>
                                        
                                        <div class="col-md-4 form-group">
											<label>Fare : passengers.fare</label>	                                         
                                        </div>
	                                        
                                        

                                    </div>

                                    <div id="submitFormId">

                                        <form:form action="${contextRoot}/pgredirect" method="POST" >
										<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
										<input type="hidden" title="TXN_AMOUNT" tabindex="10" type="text" name="TXN_AMOUNT" value="1">
                                        
                                          <div class="container-fluid">
                                                
											<div class="pasengerDetails col-md-12" style="margin:10px 0px 10px 0px; border:1px solid #c1c1c1; border-top: 2px solid #FF780C;">
                                                <hr>
                                                <div class="row">
                                                	<div class="col-md-6 form-group"> 
                                                		<!-- <input name="bp" type="text" class="form-control" placeholder="Boarding Point"/>   -->
														<select name="passengerContact.bp" class="form-control">
															<option value="0">Select Boarding Point</option>
															<option value="Espanade">(04:30 AM) Espanade</option>
														</select>
														                                                	
                                                	</div>
                                                	<div class="col-md-6 form-group">
                                                		<select name="passengerContact.dp" class="form-control">
															<option value="">Select Dropping Point</option>
															<option value="DighaPetrolPump">(08:30 AM) Digha Petrol Pump</option>
														</select> 
                                                	</div>
                                                </div>
                                                <hr>
												<div class="ssbsd-header-row" style="min-height: 25px;margin-bottom: 10px;">				    
												    
												    <div class="col-md-2 passengerInformation" style="text-align: inherit\9;">Gender</div>	
												    
												    <div class="col-md-3 passengerInformation" style="text-align: inherit\9;">Name</div>											                                                                
												                                                                
												    <div class="col-md-2 passengerInformation" style="text-align: inherit\9;">Age</div>
												                                                                 
												    <div class="col-md-2 passengerInformation" style="text-align: inherit\9;">Seat No</div>
												         .                                                       
												    <div class="col-md-2 passengerInformation" style="text-align: inherit\9;">Fare</div>												                                                                
													<hr>
													
													
                                                    <div id="passengersId"></div>
                                                    <div class="ssbsd-status col-md-12 form-group">
                                                        <div class="col-md-2">
                                                            <label style="font-weight:700;color:#666;">Total:&nbsp;</label>
                                                            <span class="curr"></span> <span style="font-weight: bold;font-size: 14px;"></span>
                                                        </div>
                                                    </div>
                                                </div>                                                                                              
                                               
                                                <div class="row">
                                               
                                                	<div class="col-md-4">
                                                		<input type="email" name="passengerContact.email" class="form-control" placeholder="Email" autocomplete="off"/>
                                                	</div>
                                                	<div class="col-md-4">
                                                		<input type=number name="passengerContact.mobile" class="form-control" placeholder="Mobile" autocomplete="off"/>
                                                	</div>
                                                	<div class="col-md-4">
                                                		<input type="text" name="passengerContact.idProof" class="form-control" placeholder="IdProof(Optional)" autocomplete="off"/>
                                                	</div>                                               	
                                                </div>
                                                 <hr>
                                                <!-- Not Needed  -->                                         
                                                <ul id="userinfo" style="display:none">
                                                	<li>
                                                		<input type="text" class="cus2-part1 mobile mobiHide" value="+91" disabled="disabled" style="color:#000;">
                                                		<input id="mobile" type="number" class="cus2-part2 mobile alowOnlyIntCopy" style="color:#000;" maxlength="10" placeholder="Mobile" value=""
                                                               oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);">
                                                    </li>
                                                    <li>
                                                        <input type="text" class="cus2-part1 mobile mobiHide" value="+91" disabled="disabled" style="color:#000;">      
                                                        <input id="emerPh" type="number" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"                         
                                                               maxlength="10" placeholder="Emergency" class="cus2-part2 mobile alowOnlyIntCopy" style="color:#000;">                           
                                                    </li>

                                                    <li style="line-height:6px;margin:8px 8px 2px 0px;">
                                                        <div class="selectStyleBox">
                                                        <select name="idProof" style="width: 198px;" class="idProof">                                                                                                                                                                                       
                                                            <option value="">Select ID Proof</option>
                                                            <option value="AADHAR">Aadhar Card</option>
                                                            <option value="VOTER_CARD">Voter ID Card</option>
                                                            <option value="DRIVING_LICENCE">Driving License</option>
                                                            <option value="PAN_CARD">PAN Card</option>
                                                            <option value="RATION_CARD">Ration Card</option>
                                                            <option value="PASSPORT">Passport</option>
                                                        </select>
                                                        
                                                        <span
                                                                class="selectStyleText">Select ID Proof</span><span
                                                                class="selectStyleArrow"></span></div>&nbsp;
                                                    </li>
                                                    <li class=" ">
                                                        <input id="idProofVal" type="text"
                                                               placeholder="ID Number"
                                                               maxlength="20" class="cus2-half">
                                                    </li>
                                                </ul>
                                                
                                                <ul class="ssb-error-box"></ul>
                                                
                                                <div class="ptpbtnbox" style="display:none">
                                                    <div style="float:right;width:180px;"><img
                                                            class="waiting waitImg"
                                                            src="ui/images/waitingSmall.gif"
                                                            alt=""><a
                                                            href="#" class="ptpbtn frht">Proceed to payment</a>
                                                    </div>
                                                </div>
                                                <!-- /Not Needed  -->
                                            	
                                            	
                                            	<div class="row mx-5 text-center">
		                                            <button type="submit" class="btn btn-secondary" onclick="getSelectedSeats();">Proceed</button>
		                                            <input id="seatsToBlock" name="seatsToBlock" type="hidden"/>
		                                        </div>
                                            </div>

                                        </div>

                                        
                                        
                                        </form:form>
                                    </div>

                                </div>
                            </c:forEach>


                        </c:if>

                    </div>
                    
                    <!-- IF Round Trip -->                    
                    <%-- <div class="flight-list listing-style3 flight">

                        <c:if test="${!empty listBus}">
                            <c:forEach items="${listBus}" var="bus">

                                <article class="box" data-toggle="collapse" data-target="#collapse_${bus.id}" id="#collapse_2">
                                    <figure class="col-xs-3 col-sm-2">                                        
                                        <span><img style="max-width:139px !important" alt="" src="${contextRoot}/resources/img/${bus.code}.jpg"></span>
                                    </figure>
                                    <div class="details col-xs-9 col-sm-10">
                                        <div class="details-wrapper">
                                            <div class="first-row">
                                                <div>
                                                    <a class="button btn-mini stop" style="font-size: 1.2em; height: 23px; line-height: 21px;">
                                                        ${bus.startPoint} to ${bus.endPoint}</a>
                                                    <div class="amenities">
                                                        <i class="soap-icon-wifi circle"></i>
                                                        <i class="soap-icon-entertainment circle"></i>
                                                        <i class="soap-icon-fork circle"></i>
                                                        <i class="soap-icon-suitcase circle"></i>
                                                    </div>
                                                </div>
                                                <div><span class="price"><small>FARE</small>${bus.fare}</span></div>
                                            </div>
                                            <div class="second-row">
                                                <div class="time">
                                                    <div class="take-off col-sm-4">
                                                        <div class="icon"><i class="soap-icon-plane-right yellow-color"></i></div>
                                                        <div><span class="skin-color">Boarding Time</span><br/>${bus.startTime}</div>
                                                    </div>
                                                    <div class="landing col-sm-4">
                                                        <div class="icon"><i class="soap-icon-plane-right yellow-color"></i></div>
                                                        <div><span class="skin-color">Arrival Time</span><br/>${bus.endTime}</div>
                                                    </div>
                                                    <div class="total-time col-sm-4">
                                                        <div class="icon"><i class="soap-icon-clock yellow-color"></i></div>
                                                        <div><span class="skin-color">total time</span><br/>13 Hour, 40 minutes</div>
                                                    </div>
                                                </div>
                                                <div class="action">
                                                    <button type="button" class="button btn-small full-width" onclick="findSeatLayout(${bus.id})" id="id_check_avail">
                                                        Book Seat</button>                                                
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </article>

                                <div id="collapse_2" class="collapse" style="background: white;">
                                    <div class="row">
                                        <div class="col-md-7">
                                            <div id="id_res_div"></div>
                                        </div>
                                                                                	                                        
										<div class="col-md-4 form-group">
											<label>Boarding Point</label>
											<select name="bp" class="form-control">
												<option value="">Select Boarding Point</option>
												<option value="Espanade">(04:30 AM) Espanade</option>
											</select> 
										</div>
																				                                            
                                        <div class="col-md-4 form-group">
											<label>Dropping Point</label>
	                                        <select name="dp" class="form-control">
												<option value="">Select Dropping Point</option>
												<option value="DighaPetrolPump">(08:30 AM) Digha Petrol Pump</option>
											</select> 
                                        </div>
                                        
                                        <div class="col-md-4 form-group">
											<label>Seat : 8A</label>	                                         
                                        </div>
                                        
                                        <div class="col-md-4 form-group">
											<label>Fare : passengers.fare</label>	                                         
                                        </div>

                                    </div>

                                    <div id="submitFormId">

                                        <form:form action="${contextRoot}/pgredirect" method="POST" >
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<input type="hidden" title="TXN_AMOUNT" tabindex="10" type="text" name="TXN_AMOUNT" value="1">
                                        
                                          <div class="container-fluid">
                                                
											<div class="pasengerDetails col-md-12" style="margin:10px 0px 10px 0px; border:1px solid #c1c1c1; border-top: 2px solid #FF780C;">
                                                <hr>
                                                <div class="row">
                                                	<div class="col-md-6 form-group"> 
                                                		<!-- <input name="bp" type="text" class="form-control" placeholder="Boarding Point"/>   -->
														<select name="passengerContact.bp" class="form-control">
															<option value="0">Select Boarding Point</option>
															<option value="Espanade">(04:30 AM) Espanade</option>
														</select>
														                                                	
                                                	</div>
                                                	<div class="col-md-6 form-group">
                                                		<select name="passengerContact.dp" class="form-control">
															<option value="">Select Dropping Point</option>
															<option value="DighaPetrolPump">(08:30 AM) Digha Petrol Pump</option>
														</select> 
                                                	</div>
                                                </div>
                                                <hr>
												<div class="ssbsd-header-row" style="min-height: 25px;margin-bottom: 10px;">				    
												    
												    <div class="col-md-2 passengerInformation" style="text-align: inherit\9;">Gender</div>	
												    
												    <div class="col-md-3 passengerInformation" style="text-align: inherit\9;">Name</div>											                                                                
												                                                                
												    <div class="col-md-2 passengerInformation" style="text-align: inherit\9;">Age</div>
												                                                                 
												    <div class="col-md-2 passengerInformation" style="text-align: inherit\9;">Seat No</div>
												         .                                                       
												    <div class="col-md-2 passengerInformation" style="text-align: inherit\9;">Fare</div>												                                                                
													<hr>
													
													
                                                    <div id="passengersId"></div>
                                                    <div class="ssbsd-status col-md-12 form-group">
                                                        <div class="col-md-2">
                                                            <label style="font-weight:700;color:#666;">Total:&nbsp;</label>
                                                            <span class="curr"></span> <span style="font-weight: bold;font-size: 14px;"></span>
                                                        </div>
                                                    </div>
                                                </div>                                                                                              
                                               
                                                <div class="row">
                                               
                                                	<div class="col-md-4">
                                                		<input type="email" name="passengerContact.email" class="form-control" placeholder="Email" autocomplete="off"/>
                                                	</div>
                                                	<div class="col-md-4">
                                                		<input type=number name="passengerContact.mobile" class="form-control" placeholder="Mobile" autocomplete="off"/>
                                                	</div>
                                                	<div class="col-md-4">
                                                		<input type="text" name="passengerContact.idProof" class="form-control" placeholder="IdProof(Optional)" autocomplete="off"/>
                                                	</div>                                               	
                                                </div>
                                                 <hr>                                            	
                                            	
                                            	<div class="row mx-5 text-center">
		                                            <button type="submit" class="btn btn-secondary" onclick="getSelectedSeats();">Proceed</button>
		                                            <input id="seatsToBlock" name="seatsToBlock" type="hidden"/>
		                                        </div>
                                            </div>

                                        </div>                                        
                                        
                                        </form:form>
                                    </div>

                                </div>
                            </c:forEach>

                        </c:if>

                    </div> --%>
                    <!-- IF Round Trip -->

                </div>
                <a class="button uppercase full-width btn-large">load more listings</a>
            </div>
        </div>
    </div>
    </div>
</section>

<script type="text/javascript">

$(document).ready(function() {

	$( "#bp" ).autocomplete({
		source: '${pageContext.request.contextPath}/findBoardPoint'
	});
	
	$( "#dropPoint" ).autocomplete({
		source: '${pageContext.request.contextPath}/findDropPoint'
	});
	
});

</script>
