<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<section id="content">

	<div class="container">

		<div class="card">
			<div class="card-header">
				<h2>${title}</h2>
			</div>

			<div class="card-body card-padding">

				<div class="row">
				
				<!-- Alert -->
				<c:if test="${not empty message}">
					<div class="col-md-12 green">
						<div class="alert alert-sucess alert-dismissible">
							${message}
						</div>
					</div>
				</c:if>
				<!-- /Alert -->
					
				<c:url var="addAction" value="${contextRoot}/cp/seatLayout/add"></c:url>
				<form:form class="form-horizontal" modelAttribute="seatLayout" 
					action="${addAction}" 
					method="POST">
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Select Bus</label> 
								<form:select path="bus" class="chosen" data-placeholder="Select Bus...">
									<form:options items="${buses}" itemValue="id" itemLabel="code" />
								</form:select>
							</div>
						</div>
					</div>

					<%-- <div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Total Seats</label> 
								<form:input type="number" path="totalSeats" id="totalSeats" class="form-control" placeholder="Enter TotalSeats" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Select Seat Type</label> 
								<form:select path="seatType" class="selectpicker" data-live-search="true" style="">
									<form:option value="0">Select </form:option>
									<form:options items="${seatTypes}" itemValue="id" itemLabel="name" />
								</form:select>								
							</div>
						</div>
					</div>
			
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Select Layout Type</label> 
								<form:select path="layoutType" class="chosen" data-placeholder="Choose Layout Type...">
									<form:option value="0">Select </form:option>
									<form:options items="${layoutTypes}" itemValue="id" itemLabel="name" />
								</form:select>
							</div>
						</div>
					</div> --%>										
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Row</label> 
								<form:input type="number" path="row" id="row" class="form-control" placeholder="Row" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Column</label> 
								<form:input type="number" path="col" id="col" class="form-control" placeholder="Column" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Seat No</label> 
								<form:input type="text" path="name" id="name" class="form-control" placeholder="seatNo" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Length</label> 
								<form:input type="number" path="length" id="length" class="form-control" placeholder="length" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Width</label> 
								<form:input type="number" path="width" id="width" class="form-control" placeholder="width" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Deck</label> 
								<form:select path="zindex" class="chosen" data-placeholder="Choose Deck...">
									<form:option value = "2" label = "Select"/>
									<form:option value="0">LOWER </form:option>
									<form:option value="1">UPPER </form:option>
									<%-- <form:options items="${decks}" /> --%>
								</form:select>
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Base Fare</label> 
								<form:input type="number" path="baseFare" id="baseFare" class="form-control" placeholder="BaseFare" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Fare</label> 
								<form:input type="number" path="fare" id="fare" class="form-control" placeholder="Fare" />
							</div>
						</div>
					</div>										
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Seat Available</label> 
								<form:select path="available" class="chosen" data-placeholder="Choose Status...">
									<form:option value="TRUE">TRUE </form:option>
									<form:option value="FALSE">FALSE </form:option>
								</form:select>
							</div>
						</div>
					</div>												
										
					<div class="col-sm-12 form-group text-center">
						<button type="submit" class="btn btn-primary btn-sm"><i class="fa fa-save"></i>Save</button>
						<button type="reset" class="btn btn-primary btn-sm">Reset</button>
					</div>
					
					<!-- Hidden Fields -->
					<div>
						<form:hidden path="id" />
						<form:hidden path="status" />
						<form:hidden path="views" />
						<form:hidden path="createdBy" />
						<form:hidden path="createdDate" />
						<form:hidden path="modifiedBy" />
						<form:hidden path="modifiedDate" />
						<form:hidden path="lastRowSeats" />
						<form:hidden path="noOfSleeperSeats" />
						<form:hidden path="seatType" />
						<form:hidden path="layoutType" />
						<form:hidden path="deck" />
						<form:hidden path="ladiesSeat" />
						<form:hidden path="totalSeats" />
					</div>
				
				</form:form>
				</div>
				<br />

			</div>

			<br />
		</div>
	</div>

	<div class="container">

		<div class="card">
			<div class="card-header">
				<h2>
					${title} <small>Seat Layout</small>
				</h2>
			</div>

			<div class="table-responsive">
				<table id="seatLayoutListTable" class="table table-striped">
					<thead>
						<tr>
							<th>Bus</th>
							<th>Row</th>
							<th>Column</th>
							<th>Seat No</th>
							<th>Length</th>
							<th>Width</th>
							<th>Deck/Zindex</th>
							<th>Base Fare</th>
							<th>Fare</th>
							<th>Available</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Bus</th>
							<th>Row</th>
							<th>Column</th>
							<th>Seat No</th>
							<th>Length</th>
							<th>Width</th>
							<th>Deck/Zindex</th>
							<th>Base Fare</th>
							<th>Fare</th>
							<th>Available</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</tfoot>
					
				</table>
			</div>
		</div>

	</div>
</section>

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
      		<form action="${contextRoot}/passengerInfo" method="post"> 			
				
				<label>Seat</label>
				<select name="seat" class="selectpicker" multiple data-max-options="2" data-live-search="true">
				  <option data-tokens="1A">1A</option>
				  <option data-tokens="2A">2A</option>
				  <option data-tokens="1B">1B</option>
				</select>
				
			</form> 
      		</div>
      		
      	</div>
      
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <%-- <a href="${contextRoot}/passengerInfo" class="btn btn-primary" >Proceed</a> --%>
      </div>
    </div>
  </div>
</div>
