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
					
				<c:url var="addAction" value="${contextRoot}/cp/product/add"></c:url>
				<form:form class="form-horizontal" modelAttribute="product" 
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
								<label>Description</label> 
								<form:input type="text" path="description" id="description" class="form-control" placeholder="Enter Description" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>MRP</label> 
								<form:input type="number" path="mrp" id="mrp" class="form-control" placeholder="Enter MRP" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Quantity</label> 
								<form:input type="number" path="quantity" id="quantity" class="form-control" placeholder="Enter Quantity" />
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

					<!-- <div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-badge-check"></i></span>
							<div class="fg-line">
								<label>Status</label> 
								<select class="selectpicker" name="status" required>
									<option value="">Select Status</option>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>
								</select>
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
						<form:hidden path="supplierId" />
						<form:hidden path="categoryId" />
						<form:hidden path="gst" />
						<form:hidden path="status" />
						<form:hidden path="purchases" />
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
					${title} <small>It's just that simple. Turn your
						simple table into a sophisticated data table and offer your users
						a nice experience and great features without any effort. </small>
				</h2>
			</div>

			<div class="table-responsive">
				<table id="productListTable" class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Description</th>
							<th>Quantity</th>
							<th>MRP</th>
							<th>Image</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Description</th>
							<th>Quantity</th>
							<th>MRP</th>
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