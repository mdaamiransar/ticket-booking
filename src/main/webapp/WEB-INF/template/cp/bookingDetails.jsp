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
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Bus Type</label> 
								<form:input type="number" path="type" id="type" class="form-control" placeholder="Enter BusType" />
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
								<form:input type="text" path="startPoint" id="startPoint" class="form-control" placeholder="Enter StartPoint" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>End Point</label> 
								<form:input type="text" path="endPoint" id="endPoint" class="form-control" placeholder="Enter EndPoint" />
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
								<form:input type="number" path="amenities" id="amenities" class="form-control" placeholder="Enter Amenities" />
							</div>
						</div>
					</div>

					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Image</label> 
								<form:input path="image" class="form-control" id="image" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Upload a file</label> 
								<form:input type="file" path="file" id="file" class="form-control" />
							</div>
						</div>
					</div>
					
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