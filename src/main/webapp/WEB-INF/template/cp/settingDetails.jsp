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
					
				<c:url var="addAction" value="${contextRoot}/cp/settingDetails/add"></c:url>
				<form:form class="form-horizontal" modelAttribute="settingDetails" 
					action="${addAction}" 
					method="POST"
					enctype="multipart/form-data">
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Title</label> 
								<form:input type="text" path="title" id="title" class="form-control" placeholder="Enter Title"/>
							</div>
						</div>
					</div>

					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Smtp Username</label> 
								<form:input type="text" path="smtpUsername" id="smtpUsername" class="form-control" placeholder="Enter Smtp Username" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Smtp Host</label> 
								<form:input type="text" path="smtpHost" id="smtpHost" class="form-control" placeholder="Enter Smtp Host" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Smtp Password</label> 
								<form:input type="text" path="smtpPassword" id="smtpPassword" class="form-control" placeholder="Enter Smtp Password" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Sender Id</label> 
								<form:input type="text" path="senderId" id="senderId" class="form-control" placeholder="Enter Sender Id" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Sms Username</label> 
								<form:input type="text" path="smsUsername" id="smsUsername" class="form-control" placeholder="Enter Sms Username" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Sms Password</label> 
								<form:input type="text" path="smsPassword" id="smsPassword" class="form-control" placeholder="Enter Sms Password" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>App Key</label> 
								<form:input type="number" path="appKey" id="appKey" class="form-control" placeholder="Enter App Key" />
							</div>
						</div>
					</div>

					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Payment option</label> 
								<form:select path="paymentOption" class="selectpicker" style="width:100%;">
									<form:option value="0">Select </form:option>
									<form:option value="1">PayPal</form:option>
									<form:option value="2">Cash </form:option>
								</form:select>
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Upload Logo</label> 
								<form:input type="file" path="logo" id="logo" class="form-control" />
							</div>
						</div>
					</div>
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Upload Favicon</label> 
								<form:input type="file" path="favicon" id="favicon" class="form-control" />
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