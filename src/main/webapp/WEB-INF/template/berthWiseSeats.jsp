<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ taglib
	uri="http://www.springframework.org/tags" prefix="spring"%><%@ taglib
	uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url var="resources" value="/resources/seat" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<head>
<script>

function append(targetId, seatNo, fare, i){

	  console.log("seatNo:: "+seatNo);
		console.log("fare:: "+fare);
	$('#'+targetId).append(
			'<div class="ssbsd-selseat col-md-12">  <div class="col-md-2 seatgender" style="padding:0px 6px 14px;">  <input type="radio" name="passengers['+i+'].gender" value="male"/> M<br>  <input type="radio" name="passengers['+i+'].gender" value="female"/> F<br>  </div>  <div class="col-md-3" style="padding:0px 10px 0px 0px;"><input type="text" maxlength="25" placeholder="Name"  name="passengers['+i+'].name" class="form-control fName ui-autocomplete-input"  autocomplete="off"/><span role="status"  aria-live="polite"  class="ui-helper-hidden-accessible"></span>  </div> <div class="col-md-2" style="padding:0px 10px 0px 0px;"><input type="number"  value="0" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"  maxlength="2" placeholder="Age" name="passengers['+i+'].age" class="form-control age alowOnlyIntCopy"/></div>  <div style="display:none;" class="seatNo col-md-2"><span class="SeatNumbr">Seat:&nbsp;</span>A6</div><input name="passengers['+i+'].seat.number" type="hidden" value="'+seatNo+'"/>  <div class="seatNoView col-md-2"><span class="SeatNumbr" style="display:none;">Seat:&nbsp;</span>'+seatNo+'</div>  <div class="col-md-2 basefare"><span style="display:none;" class="BaseFare">Fare:&nbsp;</span><span  class="curr"></span>'+fare+'</div><input name="passengers['+i+'].seat.fare" type="hidden" value="'+fare+'"/>  </div>');
	console.log('dfhdfdskfdjsnf ***************');
}
    //seat====> 0 = seater
    //seat====> 1 = horizontal sleeper
    //seat====> 2 = vertical sleeper
 function findSeatData(elementId, src, seat, seatNo, fare)
 {
 	 $.ajax({
 		type: 'GET',
 		url: window.contextRoot + '/seatNo/'+ seatNo,
 		success: function(data) {
 			//Here availability has to be true.....
 			console.log('seat>>> '+seat +' , src >> '+src);

 			var selectedSeats = $('.selected-seat').length;
 			console.log('selectedSeats >>> '+selectedSeats);
 			if(selectedSeats <= 5 || src.indexOf('available') == -1){
  			switch(seat){
  			case 0:
  				if(src.indexOf('available') != -1){
  					$('#'+elementId).attr('src', '/resources/seat/seat-blockk.png');
  					$('#'+elementId).addClass('selected-seat');
  					append('passengersId', seatNo, fare, selectedSeats);
  					
  				} else{
  					$('#'+elementId).attr('src', '/resources/seat/seat-available.png');
  					$('#'+elementId).removeClass('selected-seat');
  					$('#max-seats-error').hide();
  					$("#passengersId").children().last().remove();
  				}
  				break;
  			case 1:
  				if(src.indexOf('available') != -1){
  					$('#'+elementId).attr('src', '/resources/seat/h-sleeper_block.png');
  					$('#'+elementId).addClass('selected-seat');
  					append('passengersId', seatNo, fare, selectedSeats);
  				} else{
  					$('#'+elementId).attr('src', '/resources/seat/available_sleeper.png');
  					$('#'+elementId).removeClass('selected-seat');
  					$('#max-seats-error').hide();
  					$("#passengersId").children().last().remove();
  				}
  				break;
  			case 2:
  				if(src.indexOf('available') != -1){
  					$('#'+elementId).attr('src', '/resources/seat/v-sleeper-block.png');
  					$('#'+elementId).addClass('selected-seat');
  					append('passengersId', seatNo, fare, selectedSeats);
  				} else{
  					$('#'+elementId).attr('src', '/resources/seat/v-sleeper-available.png');
  					$('#'+elementId).removeClass('selected-seat');
  					$('#max-seats-error').hide();
  					$("#passengersId").children().last().remove();

  				}
  				break;

  			}
  		} else{
$('#max-seats-error').show();
  		}
 		}
 	});
 	event.preventDefault();
  }
    
    
    </script>
</head>
<body>
	<div class="drvrow ksrtcsleeper">
		<img src="../resources/seat/steering.png" />
	</div>
	<div id="root-seats" class="passengers - seat">
		<div class="table-responsive">
			<div
				style="padding: 10px; border: solid 1px #ccc; margin-bottom: 10px;">
				<table class="tblparent ksrtcsleeper" border='0'>
					<c:if test="${berthSize == 2}">
						<tr>
							<td style="border-bottom: double;" colspan="2">Lower Berth</td>
						</tr>
					</c:if>
					<tr>
						<td>
							<div
								style="padding: 10px; border: solid 1px #ccc; margin-bottom: 10px;">
								<table border='0'>
									<tr>
										<td colspan=3></td>
									</tr>
									<tr>
										<td>
											<table>
												<c:forEach items="${lBerth}" var="row" varStatus="rowIndex">
													<tr>
														<c:forEach items="${row}" var="cell" varStatus="colIndex">
															<td><c:choose>
																	<c:when test="${cell.seatStatus == 'BOOKED'}">
																		<c:choose>
																			<c:when test="${cell.seat== 0}">
																				<image src="../resources/seat/seat-booked.png"
																					data-toggle="tooltip" data-placement="bottom"
																					title="seat: ${cell.name} | Fare: ${cell.fare} "
																					data-original-title="Tooltip on right" />
																			</c:when>
																		</c:choose>
																		<c:choose>
																			<c:when test="${cell.seat== 1}">
																				<image src="../resources/seat/booked_sleeper.png"
																					data-toggle="tooltip" data-placement="bottom"
																					title="seat: ${cell.name} | Fare: ${cell.fare} "
																					data-original-title="Tooltip on right" />
																			</c:when>
																		</c:choose>
																		<c:choose>
																			<c:when test="${cell.seat== 2}">
																				<image src="../resources/seat/v-sleeper-booked.png"
																					data-toggle="tooltip" data-placement="bottom"
																					title="seat: ${cell.name} | Fare: ${cell.fare} "
																					data-original-title="Tooltip on right" />
																			</c:when>
																		</c:choose>
																	</c:when>
																	<c:when test="${cell.seatStatus == 'AVAILABLE'}">
																		<c:choose>
																			<c:when test="${cell.seat== 0}">
																				<image
																					onclick="findSeatData(this.id, this.src, ${cell.seat}, '${cell.name}',${cell.fare});"
																					id="lcell_${rowIndex.index}_${colIndex.index}"
																					src="../resources/seat/seat-available.png"
																					data-toggle="tooltip" data-placement="bottom"
																					title="seat: ${cell.name} | Fare: ${cell.fare} "
																					data-original-title="Tooltip on right"></image>
																			</c:when>
																			<c:when test="${cell.seat ==  1}">
																				<image
																					onclick="findSeatData(this.id, this.src, ${cell.seat}, '${cell.name}',${cell.fare});"
																					id="lcell_${rowIndex.index}_${colIndex.index}"
																					src="../resources/seat/available_sleeper.png"
																					data-toggle="tooltip" data-placement="bottom"
																					title="seat: ${cell.name} | Fare: ${cell.fare} "
																					data-original-title="Tooltip on right"></image>
																			</c:when>
																			<c:when test="${cell.seat == 2}">
																				<image
																					onclick="findSeatData(this.id, this.src, ${cell.seat}, '${cell.name}',${cell.fare});"
																					id="lcell_${rowIndex.index}_${colIndex.index}"
																					src="../resources/seat/v-sleeper-available.png"
																					data-toggle="tooltip" data-placement="bottom"
																					title="seat: ${cell.name} | Fare: ${cell.fare} "
																					data-original-title="Tooltip on right"></image>
																			</c:when>
																		</c:choose>
																	</c:when>
																</c:choose></td>
														</c:forEach>
													</tr>
												</c:forEach>
											</table>
										</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
				</table>
			</div>
			<c:if test="${berthSize == 2}">
				<div
					style="padding: 10px; border: solid 1px #ccc; margin-bottom: 10px;">
					<table class="tblparent ksrtcsleeper" border='0'>
						<tr>
							<td style="border-bottom: double;" colspan="2">Upper Berth</td>
						</tr>
						<tr>
							<td>
								<table border='0'>
									<tr>
										<td colspan=3></td>
									</tr>
									<tr>
										<td>
											<table>
												<c:forEach items="${uBerth}" var="row" varStatus="rowIndex">
													<tr>
														<c:forEach items="${row}" var="cell" varStatus="colIndex">
															<td><c:choose>
																	<c:when test="${cell.seatStatus == 'BOOKED'}">
																		<c:choose>
																			<c:when test="${cell.seat== 0}">
																				<image
																					id="ucell_${rowIndex.index}_${colIndex.index}"
																					src="../resources/seat/seat-booked.png"
																					data-toggle="tooltip" data-placement="bottom"
																					title="seat: ${cell.name} | Fare: ${cell.fare} "
																					data-original-title="Tooltip on right" />
																			</c:when>
																		</c:choose>
																		<c:choose>
																			<c:when test="${cell.seat== 1}">
																				<image
																					id="ucell_${rowIndex.index}_${colIndex.index}"
																					src="../resources/seat/booked_sleeper.png"
																					data-toggle="tooltip" data-placement="bottom"
																					title="seat: ${cell.name} | Fare: ${cell.fare} "
																					data-original-title="Tooltip on right" />
																			</c:when>
																		</c:choose>
																		<c:choose>
																			<c:when test="${cell.seat== 2}">
																				<image
																					id="ucell_${rowIndex.index}_${colIndex.index}"
																					src="../resources/seat/v-sleeper-booked.png"
																					data-toggle="tooltip" data-placement="bottom"
																					title="seat: ${cell.name} | Fare: ${cell.fare} "
																					data-original-title="Tooltip on right" />
																			</c:when>
																		</c:choose>
																	</c:when>
																	<c:when test="${cell.seatStatus == 'AVAILABLE'}">
																		<c:choose>
																			<c:when test="${cell.seat== 0}">
																				<image
																					onclick="findSeatData(this.id, this.src, ${cell.seat}, '${cell.name}',${cell.fare});"
																					id="ucell_${rowIndex.index}_${colIndex.index}"
																					src="../resources/seat/seat-available.png"
																					data-toggle="tooltip" data-placement="bottom"
																					title="seat: ${cell.name} | Fare: ${cell.fare} "
																					data-original-title="Tooltip on right"></image>
																			</c:when>
																			<c:when test="${cell.seat ==  1}">
																				<image
																					onclick="findSeatData(this.id, this.src, ${cell.seat}, '${cell.name}',${cell.fare});"
																					id="ucell_${rowIndex.index}_${colIndex.index}"
																					src="../resources/seat/available_sleeper.png"
																					data-toggle="tooltip" data-placement="bottom"
																					title="seat: ${cell.name} | Fare: ${cell.fare} "
																					data-original-title="Tooltip on right"></image>
																			</c:when>
																			<c:when test="${cell.seat == 2}">
																				<image
																					onclick="findSeatData(this.id, this.src, ${cell.seat}, '${cell.name}',${cell.fare});"
																					id="ucell_${rowIndex.index}_${colIndex.index}"
																					src="../resources/seat/v-sleeper-available.png"
																					data-toggle="tooltip" data-placement="bottom"
																					title="seat: ${cell.name} | Fare: ${cell.fare} "
																					data-original-title="Tooltip on right"></image>
																			</c:when>
																		</c:choose>
																	</c:when>
																</c:choose></td>
														</c:forEach>
													</tr>
												</c:forEach>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
				<p id="max-seats-error" style="display: none;">
					<font size="3" color="red">maximum seats allowed to block is
						6!!!!!</font>
				</p>
			</c:if>
		</div>
	</div>
</body>