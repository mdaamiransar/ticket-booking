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
					
				<c:url var="addAction" value="${contextRoot}/cp/city/add"></c:url>
				<form:form class="form-horizontal" modelAttribute="city" 
					action="${addAction}" 
					method="POST">
					
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>City</label> 
								<form:input type="text" path="name" id="name" class="form-control" placeholder="Enter City" />
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
					${title} <small>City</small>
				</h2>
			</div>

			<div class="table-responsive">
				<table id="cityListTable" class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Code</th>
							<th>City</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>ID</th>
							<th>Code</th>
							<th>City</th>
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
