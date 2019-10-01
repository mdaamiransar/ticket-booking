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
					<div class="col-md-12">
						<div class="alert alert-sucess alert-dismissible">
							${message}
						</div>
					</div>
				</c:if>
				<!-- /Alert -->
					
				<c:url var="addAction" value="${contextRoot}/cp/bus/add"></c:url>
				<form:form class="form-horizontal" modelAttribute="bus" 
					action="${addAction}" 
					method="POST"
					enctype="multipart/form-data">
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Name</label> 
								<!-- <input type="text" class="form-control" placeholder="Enter Name" name="name" required> -->
								<form:input type="text" path="name" id="name" class="form-control" placeholder="Enter Name"/>
							</div>
						</div>
					</div>

					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Regi Number</label> 
								<form:input type="text" path="regiNumber" id="regiNumber" class="form-control" placeholder="Enter RegiNumber" />
							</div>
						</div>
					</div>
					
					<!-- Only this dropdown using class="selectpicker" others using class="chosen" -->
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Select Bus Type</label> 
								<form:select path="type" class="selectpicker">
									<form:option value="0">Select </form:option>									
									<form:options items="${busTypes}" itemValue="id" itemLabel="name" />
								</form:select>
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Maximum Seats</label> 
								<form:input type="number" path="maximumSeats" id="maximumSeats" class="form-control" placeholder="Enter MaximumSeats" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Start Point</label>
								<form:select path="startPoint" class="chosen" data-placeholder="Choose Layout Type...">
									<form:option value="0">Select </form:option>
									<form:options items="${cities}" itemValue="name" itemLabel="name" />
								</form:select> 
								<%-- <form:input type="text" path="startPoint" id="startPoint" class="form-control" placeholder="Enter StartPoint" /> --%>
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>End Point</label> 
								<form:select path="endPoint" class="chosen" data-placeholder="Choose Layout Type...">
									<form:option value="0">Select </form:option>
									<form:options items="${cities}" itemValue="name" itemLabel="name" />
								</form:select>
								<%-- <form:input type="text" path="endPoint" id="endPoint" class="form-control" placeholder="Enter EndPoint" /> --%>
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Start Time</label> 
								<form:input type="text" path="startTime" id="startTime" class="form-control" placeholder="Enter StartTime" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>End Time</label> 
								<form:input type="text" path="endTime" id="endTime" class="form-control" placeholder="Enter EndtTime" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Amenities</label> 
								<form:select path="amenities" class="chosen" data-placeholder="Choose Amenities...">
									<form:option value="0">Select </form:option>
									<form:options items="${amenities}" itemValue="id" itemLabel="name" />
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
								<form:select path="seatType" class="chosen" data-placeholder="Choose Seat Type...">
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
								<label>No. of Last Row Seats</label> 
								<form:input type="number" path="totalLastRowSeats" id="totalLastRowSeats" class="form-control" placeholder="Enter Total Last Row Seats" />
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
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>No of Decks</label> 
								<form:select path="deck" class="chosen" data-placeholder="Choose Deck...">
									<form:option value = "0" label = "Select"/>
									<form:option value="1">LOWER </form:option>
									<form:option value="2">UPPER </form:option>
									<form:options items="${decks}" />
								</form:select>
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>No of Rows</label> 
								<form:input type="number" path="totalRows" id="totalRows" class="form-control" placeholder="No. Of Rows(if any)" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>No of Columns</label> 
								<form:input type="number" path="totalCols" id="totalCols" class="form-control" placeholder="No. Of Columns(if any)" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>No of Sleeper Seats</label> 
								<form:input type="number" path="totalSleeperSeats" id="totalSleeperSeats" class="form-control" placeholder="No. Of SleeperSeats(if any)" />
							</div>
						</div>
					</div> --%>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Upload a file</label> 
								<form:input type="file" path="file" id="file" class="form-control" />
							</div>
						</div>
					</div>
					
					<%-- <div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Image</label> 
								<form:input path="image" class="form-control" id="image" />
							</div>
						</div>
					</div> --%>

					<!-- <div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label></label> 
								Button trigger modal
								<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
								  View Layout
								</button>								
							</div>
						</div>
					</div> -->
					
					<div class="col-sm-12 form-group text-center">
						<!-- <input type="submit" name="submit" value="Save" class="btn btn-primary"/> -->
						<button type="submit" class="btn btn-primary btn-sm"><i class="fa fa-save"></i>Save</button>
						<button type="reset" class="btn btn-primary btn-sm">Reset</button>
					</div>
					
					<!-- Hidden Fields -->
					<div>
						<form:hidden path="id" />
						<form:hidden path="code" />
						<form:hidden path="status" />
						<form:hidden path="views" />
						<form:hidden path="createdBy" />
						<form:hidden path="createdDate" />
						<form:hidden path="modifiedBy" />
						<form:hidden path="modifiedDate" />
						<form:hidden path="image" />
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
					${title} <small>Bus Management. </small>
				</h2>
			</div>

			<div class="table-responsive">
				<table id="busListTable" class="table table-striped">
					<thead>
						<tr>
							<!-- <th>ID</th> -->
							<th>Bus</th>
							<th>Code</th>
							<!-- <th>Bus RegiNumber</th> -->
							<th>Type</th>
							<th>Maximum Seats</th>
							<th>Start Point</th>
							<th>End Point</th>
							<th>Start Time</th>
							<th>End Time</th>
							<!-- <th>Amenities</th> -->
							<th>Image</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<!-- <th>ID</th> -->
							<th>Bus</th>
							<th>Code</th>
							<!-- <th>Bus RegiNumber</th> -->
							<th>Type</th>
							<th>Maximum Seats</th>
							<th>Start Point</th>
							<th>End Point</th>
							<th>Start Time</th>
							<th>End Time</th>
							<!-- <th>Amenities</th> -->
							<th>Image</th>
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

<!-- <script type="text/javascript">

$(document).ready(function() {

	$( "#startPoint" ).autocomplete({
		source: '${pageContext.request.contextPath}/cp/findCity'
	});
	
	$( "#endPoint" ).autocomplete({
		source: '${pageContext.request.contextPath}/cp/findCity'
	});
	
});

</script> -->
