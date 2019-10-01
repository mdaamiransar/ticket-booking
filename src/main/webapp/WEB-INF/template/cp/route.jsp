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
					
				<c:url var="addAction" value="${contextRoot}/cp/route/add"></c:url>
				<form:form class="form-horizontal" modelAttribute="route" 
					action="${addAction}" 
					method="POST">
					
					<div class="col-sm-6 form-group">
						<div class="input-group" style="float: none;">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Select Bus</label> 
																
								<form:select path="bus" class="selectpicker" data-live-search="true" style="">
									<form:option value="0">Select </form:option>
									<form:options items="${buses}" itemValue="id" itemLabel="name" />
								</form:select>
								

								</div>
						</div>
					</div>

					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Fare</label> 
								<form:input type="number" path="fare" id="fare" class="form-control" placeholder="Enter Fare" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Board Point</label> 
								<form:input type="text" path="boardPoint" id="boardPoint" class="form-control" placeholder="Enter boardPoint" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Drop Point</label> 
								<form:input type="text" path="dropPoint" id="dropPoint" class="form-control" placeholder="Enter DropPoint" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Start Time</label> 
								<form:input type="text" path="startTime" id="startTime" class="form-control" placeholder="Enter startTime" />
							</div>
						</div>
					</div>

					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Arrival Time</label> 
								<form:input type="text" path="arrivalTime" id="arrivalTime" class="form-control" placeholder="Enter arrivalTime" />
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
						<form:hidden path="status" />
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
					${title} <small>Route Management. </small>
				</h2>
			</div>

			<div class="table-responsive">
				<table id="routeListTable" class="table table-striped">
					<thead>
						<tr>
							<!-- <th>ID</th> -->
							<th>Bus</th>
							<th>Board Point</th>
							<th>Start Time</th>
							<th>Drop Point</th>
							<th>Arrival Time</th>
							<th>Fare</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<!-- <th>ID</th> -->
							<th>Bus</th>
							<th>Board Point</th>
							<th>Start Time</th>
							<th>Drop Point</th>
							<th>Arrival Time</th>
							<th>Fare</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</tfoot>
					
				</table>
			</div>
		</div>

	</div>
</section>

