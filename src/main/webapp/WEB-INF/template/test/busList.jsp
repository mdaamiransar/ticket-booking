<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">
	
	
	<div class="row">
		
		<!-- Display the product description -->	
		<div class="col-md-12">
		
			<div class="table-responsive" style="margin-top:100px;">
			<c:if test="${!empty listBus}">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr class="info">
							<th width="80">Bus</th>
							<th width="120">BoardPoint</th>
							<th width="60">Start Time</th>
							<th width="60">Drop Point</th>
							<th width="60">Arrival Time</th>
							<th width="60">Fare</th>
							<th width="60">Book</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listBus}" var="bank">
							<tr class="primary">
								<td>${bank.bus}</td>
								<td>${bank.boardPoint}</td>
								<td>${bank.startTime}</td>
								<td>${bank.dropPoint}</td>
								<td>${bank.arrivalTime}</td>
								<td>${bank.fare}</td>
								<td class="center">
								<%-- <a href="<c:url value='${contextRoot}/passengerInfo?id=${bank.id}' />"><i class="fa fa-edit "></i></a> --%>
								
								<!-- Button trigger modal -->
								<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
								  Book Seat
								</button>
								</td>
								<%-- <td class="center">
								<a href="<c:url value='/bank/delete/${bank.id}' />"><i class="fa fa-trash-o"></i></a></td> --%>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</c:if>
		</div>
					
		</div>
	
	</div>

</div>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Select Seat</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      <div class="modal-body">
      	
      	<div class="row">
      		<div class="col-md-12 form-group">    
      		<form action="${contextRoot}/passengerInfo" method="GET"> 			
				
				<label>Seat</label>
				<select name="seat" class="selectpicker" multiple data-max-options="2" data-live-search="true">
				  <option data-tokens="1A">1A</option>
				  <option data-tokens="2A">2A</option>
				  <option data-tokens="1B">1B</option>
				</select>
				<button type="submit" class="btn btn-secondary">Proceed</button>
			</form> 
      		</div>
      		
      		<%-- <div class="col-md-6 form-group" data-ng-app="mooApp"  data-ng-controller="boo">    
      		<form action="${contextRoot}/passengerInfo" method="post">

				<h2>Book Your Seat</h2>
				<!-- <div class="row col-md-4 col-md-offset-3">
					<p>No of Quantity:</p>
					<select ng-model="selectedVal"
						ng-options="i for i in quantities"></select>
				</div> -->
				<div>
					<div>
						<div class="table-responsive">
							<table class="table">
								<tbody class="table">
									<tr ng-repeat="row in rows">
										<span>{{rowLetter[$index]}}</span>
										<td ng-repeat="item in row"><a class="available"
											ng-disabled="isDisabled"
											ng-class="{'selected': item.check == true,'available': item.check == false, 'blocked': item.seat == true}"
											ng-click="clickSeat(item)">{{item.val}}</a></td>
									</tr>
								</tbody>
							</table>
							{{rows | json}}
							<p>total Seats you can select = {{selectedVal}}</p>
							<p>whether the selection of seats should be disabled or
								not = {{isDisabled}}</p>
							<p>Seats selected: {{selectedSeatCount}}</p>
						</div>
					</div>
				</div>
			</form> 
      		</div> --%>
      		
      	</div>
      
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <%-- <a href="${contextRoot}/passengerInfo" class="btn btn-primary" >Proceed</a> --%>
      </div>
    </div>
  </div>
</div>

<script>
	var mooApp = angular.module('mooApp', []);

	mooApp.controller('boo', [ '$scope', 'rowCalc', function($scope, rowCalc) {
		$scope.quantities = [ 1, 2, 3 ];

		$scope.obj = [ [ {
			val : 1,
			letter : 'a',
			check : false,
			seat : false
		}, {
			val : 2,
			letter : 'a',
			check : false,
			seat : false
		}, {
			val : 3,
			letter : 'a',
			check : false,
			seat : false
		} ], [ {
			val : 1,
			letter : 'b',
			check : false,
			seat : false
		}, {
			val : 2,
			letter : 'b',
			check : false,
			seat : true
		}, {
			val : 3,
			letter : 'b',
			check : false,
			seat : false
		} ] ];

		$scope.isDisabled = false;
		$scope.rows = $scope.obj;
		$scope.rowLetter = rowCalc.rowStack($scope.obj);
		$scope.selectedSeatCount = 0;

		$scope.clickSeat = function(seat) {
			if (!seat.seat && !$scope.isDisabled) {
				if (seat.check) {
					seat.check = false;
					$scope.selectedSeatCount--;
				} else if ($scope.selectedSeatCount < $scope.selectedVal) {
					seat.check = true;
					$scope.selectedSeatCount++;
				}
			}
		}
	} ])

	.service('rowCalc', function() {
		var rowLetter = [];

		this.rowStack = function(obj) {
			for (var i = 0, j = 65; i < obj.length; i++, j++) {
				rowLetter.push(String.fromCharCode(j));
			}
			return rowLetter;
		}

	});
</script>


