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
                                            <input type="text" class="input-text full-width" placeholder="Leaving from" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="input-text full-width" placeholder="going to" value="" />
                                        </div>
                                        <div class="form-group">
                                            <div class="datepicker-wrap">
                                                <input type="text" name="date_from" class="input-text full-width" placeholder="Departure on (mm/dd/yy)" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="datepicker-wrap">
                                                <input type="text" name="date_to" class="input-text full-width" placeholder="Arrival on (mm/dd/yy)" />
                                            </div>
                                        </div>
                                        <br />
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
                                <a data-toggle="collapse" href="#departureTime-filter" class="collapsed">Departure Time</a>
                            </h4>
                            <div id="departureTime-filter" class="panel-collapse collapse">
                                <div class="panel-content">
                                    <ul class="check-square filters-option">
                                        <li><a href="#">6 am to 12 pm<small>(2)</small></a></li>
                                        <li><a href="#">12 pm to 6 pm<small>(2)</small></a></li>
                                        <li class="active"><a href="#">After 6 pm<small>(1)</small></a></li>
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
                                        <li><a href="#">6 am to 12 pm<small>(2)</small></a></li>
                                        <li><a href="#">12 pm to 6 pm<small>(2)</small></a></li>
                                        <li class="active"><a href="#">After 6 pm<small>(1)</small></a></li>
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
                                     <br />
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
                         
                         <!-- <ul class="swap-tiles clearfix block-sm">
                             <li class="swap-list active">
                                 <a href="flight-list-view.html"><i class="soap-icon-list"></i></a>
                             </li>
                             <li class="swap-grid">
                                 <a href="flight-grid-view.html"><i class="soap-icon-grid"></i></a>
                             </li>
                             <li class="swap-block">
                                 <a href="flight-block-view.html"><i class="soap-icon-block"></i></a>
                             </li>
                         </ul>
                     -->
                     </div>
                     
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
                         
                         <div id="collapse_${bus.id}" class="collapse">
                         
                         
							
							<script>
								window.busId = '${bus.id}';
							</script>
							
							<div class=" bg-success">
								<div class="row">
									<div class="col-md-5">
										<div id="subViewDiv"></div>
										
										<p id="test1">This is a paragraph.</p>
										<p id="test2">This is another paragraph.</p>
										
										<p>Input field: <input type="text" id="test3" value="Mickey Mouse"></p>

										<button id="btn1">Set Text</button>
										<button id="btn2">Set HTML</button>
										<button id="btn3">Set Value</button>
										
										
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
										<input type="button" value="GO!" onclick="doAjaxPost();" />
										<button type="button" name="refreshCart" class="btn btn-info btn-sm" value="Go"><span class="glyphicon glyphicon-refresh"></span></button>
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
								
								<!-- sss -->
								<div class="container" style="padding-bottom: 29px">
						 <div class="row text-center">
						 <div class="col-md-12">
					        <div ng-app="ngoptionsApp" ng-controller="ngoptionsCtrl">

							<select name="users" ng-options="user.boardingPoint for user in boardPointList" ng-model="userselected">
							<option value="">--Select Boarding Point--</option>
							</select><br /><br />
							<span>User Name: {{userselected.boardingPoint}}, UserId: {{userselected.bus}}</span>
							</div>
					     </div>
					   </div>
					    </div>
					    
					    <div ng-app="test" ng-controller="DemoCtrl" class="action">
					    <select ng-model="selectedTestAccount" ng-options="item.id as item.boardPoint for item in testAccounts">
						    <option value="">Select Account</option>
						</select>
						</div>
						 <!-- eee -->
						 
						
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


<script>
$(document).ready(function(){
    $("#btn1").click(function(){
        $("#test1").text("Hello world!");
    });
    $("#btn2").click(function(){
        $("#test2").html("<b>Hello world!</b>");
    });
    $("#btn3").click(function(){
        $("#test3").val("Dolly Duck");
    });
});
</script>

<script type="text/javascript">
angular.module('test', []).controller('DemoCtrl', function ($scope, $http) {
    $scope.selectedTestAccount = null;
    $scope.testAccounts = [];

    $http({
            method: 'GET',
            url: window.contextRoot + '/cp/all/boardPoint',
            data: { applicationId: 3 }
        }).success(function (result) {
        $scope.testAccounts = result;
    });
});
</script>
<script type="text/javascript">
        angular.module('drpdwnApp', []).controller('drpdwnCtrl', function ($scope, $http) {
            $scope.ProductList = null;
            //Declaring the function to load data from database
            $scope.fillProductList = function () {
                $http({
                    method: 'GET',
                    url: window.contextRoot +'/cp/all/boardingPoint'
                }).success(function (result) {
                    $scope.ProductList = result.d;
                });
            };
            //Calling the function to load the data on pageload
            $scope.fillProductList();
        });
    </script>
    
<script type="text/javascript">
        var app = angular.module('MyApp', [])
        app.controller('MyController', function ($scope, $http, $window) {
            $scope.DefaultLabel = "Loading.....";
            var post = $http({
                method: "GET",
                url: window.contextRoot + '/cp/all/boardPoint',
                dataType: 'json',
                //data: {},
                headers: { "Content-Type": "application/json" }
            });
 
            post.success(function (data, status) {
                $scope.DefaultLabel = "Please Select";
                $scope.Customers = data;
            });
 
            post.error(function (data, status) {
                $window.alert(data.Message);
            });
        });
    </script>
  
<script>
var app1 = angular.module('ngoptionsApp', []);
app1.controller('ngoptionsCtrl', function ($scope) {
$scope.boardPointList = 
	[
	{
		"bus": 1,
		"boardingPoint": "Babu Ghat"
	}, {
		"bus": 2,
		"boardingPoint": "Dharmtalla"
	}, {
		"bus": 3,
		"boardingPoint": "Ladies Park"
	}
	];
	});
</script>

<script type="text/javascript">    
        $(document).ready(function () {    
      
//----------------------------------------------------------- Insertion --------------------------------------------------------------
            $('#save').click(function () {    
            	
            	var idd = idd.id;  
            	
            data: "{'id':'" + idd + "'}"
            var stringData = JSON.stringify(data);    
            $.ajax({    
                type: "POST",    
                url: "category.aspx/insertion",    
                data: "{'id':'" + idd + "'}",   
                contentType: "application/json; charset=utf-8",    
                dataType: "json",    
                success: OnSucces,    
                error: OnError    
            });     
                function OnSucces(response) {    
                    if (response == 1) {    
                        alert('Category Added Successfully !!!');    
                        reset();    
                    }    
                    else {    
                        alert(response);    
                    }    
                }    
                function OnError(response) {    
                    alert(response);    
                                    }    
            });  
      });  
</script>  