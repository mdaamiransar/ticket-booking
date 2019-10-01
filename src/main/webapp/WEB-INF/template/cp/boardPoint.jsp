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
					
				<c:url var="addAction" value="${contextRoot}/cp/boardPoint/add"></c:url>
				<form:form class="form-horizontal" modelAttribute="boardPoint" 
					action="${addAction}" 
					method="POST">
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Bus Name</label> 
								<form:select path="bus" class="selectpicker" data-live-search="true" style="">
									<form:option value="0">Select </form:option>
									<form:options items="${buses}" itemValue="id" itemLabel="code" />
								</form:select>
							</div>
						</div>
					</div>

					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Route</label> 
								<form:select path="route" class="selectpicker" data-live-search="true" style="">
									<form:option value="0">Select </form:option>
									<form:options items="${routes}" itemValue="id" itemLabel="boardPoint" />
									<%-- <form:options items="${buses}" itemValue="id" itemLabel="startPoint" /> --%>
								</form:select>
								<%-- <form:input type="text" path="route" id="route" class="form-control" placeholder="Enter Route" /> --%>
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>New Boarding Point</label> 
								<form:input type="text" path="boardingPoint" id="boardingPoint" class="form-control" placeholder="Enter BoardingPoint" />
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
								<label>Landmark</label> 
								<form:input type="text" path="landmark" id="landmark" class="form-control" placeholder="Enter Landmark" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Address</label> 
								<form:input type="text" path="address" id="address" class="form-control" placeholder="Enter Address" />
							</div>
						</div>
					</div>
					
					<%-- 
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Upload File</label> 
								<form:input type="file" path="file" id="file" class="form-control" />
							</div>
						</div>
					</div>
					 --%>
					<div class="col-sm-12 form-group text-center">
						<button type="submit" class="btn btn-primary btn-sm"><i class="fa fa-save"></i>Save</button>
						<button type="reset" class="btn btn-primary btn-sm">Reset</button>
					</div>
					
					<!-- Hidden Fields -->
					<div>
						<form:hidden path="id" />
						<%-- <form:hidden path="image" /> --%>
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
					${title} <small>NewBoardingPoint. </small>
				</h2>
			</div>

			<div class="table-responsive">
				<table id="boardPointListTable" class="table table-striped">
					<thead>
						<tr>
							<th>Bus</th>
							<th>Route</th>
							<th>Boarding Point</th>
							<th>Start Time</th>
							<th>Landmark</th>
							<th>Address</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Bus</th>
							<th>Route</th>
							<th>Boarding Point</th>
							<th>Start Time</th>
							<th>Landmark</th>
							<th>Address</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</tfoot>
					
				</table>
			</div>
		</div>

	</div>
</section>
