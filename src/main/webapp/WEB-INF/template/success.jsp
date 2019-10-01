<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.9/angular.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.9/angular-cookies.js"></script>

<div class="page-title-container">
    <div class="container">
        <div class="page-title pull-left">
            <h2 class="entry-title">Bus Booking</h2>
        </div>
        <ul class="breadcrumbs pull-right">
            <li><a href="#">HOME</a></li>
            <li class="active">BUS Booking</li>
        </ul>
    </div>
</div>
<section id="content" class="gray-area">
    <div class="container" ng-app="MyApp" ng-controller="MyController">
        <div class="row">
            <div id="main" class="col-sms-6 col-sm-8 col-md-9">
                <div class="booking-section travelo-box">
                    
                    <form class="booking-form" method="post" action="http://www.soaptheme.net/html/travelo/booking-handler.php">
                        <div class="person-information">
                            <h2>Success !!</h2>
                            <%int i=1; %>
                            <div class="row">
                            	
                            	<c:forEach items="${listSeat}" var="seat">
                            	<div class="col-md-12 col-sm-12 col-xs-12">

								<div class="panel-group">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" href="#collapse_<%=i%>">Passenger <%=i%>| Seat : ${seat} </a>
											</h4>
										</div>
										<div id="collapse_<%=i++%>" class="panel-collapse collapse">
											<div class="panel-body">
												<div class="col-sm-6 form-group">
													<label>Name</label> <input type="text" ng-model="user.name" class="form-control"
														placeholder="Enter Name" name="name" required>
												</div>
				
												<div class="col-sm-6 form-group">
													<label>Age</label> <input type="text" ng-model="user.age" class="form-control"
														placeholder="Enter Age" name="age" required>
												</div>
				
												<div class="col-sm-6 form-group">
													<label>Gender</label> <input type="text" ng-model="user.gender" class="form-control"
														placeholder="Enter Gender" name="gender" required>
												</div>
												
												<div class="col-sm-6 form-group">
													<label>Seat</label> <input type="text" class="form-control"
														placeholder="Enter Seat" name="seat" required>
												</div>
												
												
												
				
											</div>
				
										</div>
									</div>
				
								</div>
				
							</div>
                            	</c:forEach>
                            	
                            </div>
                                                      
                            
                           
                        </div>
                        <hr />
                        <div class="card-information">
                            <h2 style="text-decoration: underline;">Order Details</h2>
                            <div class="form-group row">
                                <div class="col-sm-6 col-md-5">
                                    <label>Order Id : ${orderId}</label>
	                            </div>
                                <div class="col-sm-6 col-md-5">
                                    <label>Email : ${passengerContact.email}</label>
                                </div>
                                <div class="col-sm-6 col-md-5">
                                    <label>Phone : ${passengerContact.mobile}</label>
                                </div>
                                <div class="col-sm-6 col-md-5">
                                    <label>Amount : ${totalFare}</label>
                                </div>
                            </div>
                           
                        </div>
                        <hr />
                        
                        
                    </form>
                    <div class="card-information">                       
                            <div class="form-group row">
                                <div class="col-sm-12 col-md-11 text-center">
                                    <label><a href="http://localhost:8080">Go Back for Another Booking</a></label>
	                            </div>
                                
                            </div>
                           
                        </div>
                </div>
            </div>
            <div class="sidebar col-sms-6 col-sm-4 col-md-3">
                <div class="booking-details travelo-box">
                    <h4>Booking Details</h4>
                    <article class="flight-booking-details">
                        <figure class="clearfix">
                            <!-- <a title="" href="flight-detailed.html" class="middle-block">
                            <img class="middle-item" alt="" src="images/flight/thumbnail/1.png"></a> -->
                            <div class="text-left">
                                <h5 class="box-title">Kolkata to Digha</h5>
                            </div>
                        </figure><hr style="margin:0 0 0 0;">
                    
                    </article>
                    
                    <h4>Other Details</h4>
                    <dl class="other-details">
                        <dt class="feature">Bus:</dt><dd class="value">Delta</dd>
                        <dt class="feature">Bus type:</dt><dd class="value">Economy</dd>
                        <dt class="feature">base fare:</dt><dd class="value">Rs. 320</dd>
                        <dt class="feature">taxes and fees:</dt><dd class="value">Rs. 300</dd>
                        <dt class="total-price">Total Price</dt><dd class="total-price-value">Rs. 620</dd>
                    </dl>
                </div>
                
                <div class="travelo-box contact-box">
                    <h4>Need BusUncle Help?</h4>
                    <p>We would be more than happy to help you. Our team advisor are 24/7 at your service to help you.</p>
                    <address class="contact-details">
                        <span class="contact-phone"><i class="soap-icon-phone"></i> 1-800-123-HELLO</span>
                        <br>
                        <a class="contact-email" href="#">help@.com</a>
                    </address>
                </div>
            </div>
        </div>
    </div>
</section>