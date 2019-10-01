<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Websecure : About</title>

<script>

	window.contextRoot = '${contextRoot}'
	
</script>

<!-- Vendor CSS -->
<link href="resources/cp/vendors/bower_components/animate.css/animate.min.css"
	rel="stylesheet">
<link
	href="resources/cp/vendors/bower_components/sweetalert2/dist/sweetalert2.min.css"
	rel="stylesheet">
<link
	href="resources/cp/vendors/bower_components/material-design-iconic-font/dist/css/material-design-iconic-font.min.css"
	rel="stylesheet">
<link
	href="resources/cp/vendors/bower_components/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css"
	rel="stylesheet">
<link
	href="resources/cp/vendors/bower_components/bootstrap-select/dist/css/bootstrap-select.css"
	rel="stylesheet">
<link
	href="resources/cp/vendors/bower_components/nouislider/distribute/nouislider.min.css"
	rel="stylesheet">
<link
	href="resources/cp/vendors/bower_components/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link href="resources/cp/vendors/bower_components/dropzone/dist/min/dropzone.min.css"
	rel="stylesheet">
<link href="resources/cp/vendors/farbtastic/farbtastic.css" rel="stylesheet">
<link href="resources/cp/vendors/bower_components/chosen/chosen.css" rel="stylesheet">
<link href="resources/cp/vendors/summernote/dist/summernote.css" rel="stylesheet">
<link
	href="resources/cp/vendors/bower_components/datatables.net-dt/css/jquery.dataTables.min.css"
	rel="stylesheet">

<!-- CSS -->
<link href="resources/cp/css/app_1.min.css" rel="stylesheet">
<link href="resources/cp/css/app_2.min.css" rel="stylesheet">
</head>
<body>
	
	<%@include file="./shared/header.jsp"%>

	<section id="main">
		
		<%@include file="./shared/sidebar.jsp"%>
		
		<section id="content">
			<div class="container">
				<div class="block-header">
					<h2>Data Table</h2>

					<ul class="actions">
						<li><a href="#"> <i class="zmdi zmdi-trending-up"></i>
						</a></li>
						<li><a href="#"> <i class="zmdi zmdi-check-all"></i>
						</a></li>
						<li class="dropdown"><a href="#" data-toggle="dropdown">
								<i class="zmdi zmdi-more-vert"></i>
						</a>

							<ul class="dropdown-menu dropdown-menu-right">
								<li><a href="#">Refresh</a></li>
								<li><a href="#">Manage Widgets</a></li>
								<li><a href="#">Widgets Settings</a></li>
							</ul></li>
					</ul>
				</div>

				<div class="card">
					<div class="card-header">
						<div class="row">
							<div class="col-md-8">
								<h2>
									About Management <small>Here you can see all About, which
										is created by you.</small>
								</h2>
							</div><!-- href="#modalDefault" -->
							<div class="col-md-4 text-right">
								<button class="btn bgm-amber" data-toggle="modal" onclick="AddNewRecord(0)">
									<i class="zmdi zmdi-plus"></i> Add About
								</button>
							</div>
						</div>

					</div>

					<div class="table-responsive">
						<table id="aboutListTable" class="table table-striped">
							<thead>
								<tr>
									<th>Id</th>
									<th>Name</th>
									<th>Description</th>
									<th>Image</th>
									<th>Action</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>Id</th>
									<th>Name</th>
									<th>Description</th>
									<th>Image</th>
									<th>Action</th>
								</tr>
							</tfoot>
							<!-- <tbody>
								
							</tbody> -->
						</table>
					</div>
				</div>

			</div>
		
		</section>
	
	</section>

	<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>
	<!-- /Footer -->
	
	<!-- Page Loader -->
	<%@include file="./shared/page-loader.jsp"%>
	<!-- /Page Loader -->
	
	<!-- Javascript Libraries -->
	<script src="resources/cp/vendors/bower_components/jquery/dist/jquery.min.js"></script>
	<script
		src="resources/cp/vendors/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<script
		src="resources/cp/vendors/bower_components/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="resources/cp/vendors/bower_components/Waves/dist/waves.min.js"></script>
	<script src="resources/cp/vendors/bootstrap-growl/bootstrap-growl.min.js"></script>
	<script
		src="resources/cp/vendors/bower_components/sweetalert2/dist/sweetalert2.min.js"></script>

	<script src="resources/cp/vendors/bower_components/moment/min/moment.min.js"></script>
	<script
		src="resources/cp/vendors/bower_components/bootstrap-select/dist/js/bootstrap-select.js"></script>
	<script
		src="resources/cp/vendors/bower_components/nouislider/distribute/nouislider.min.js"></script>
	<script
		src="resources/cp/vendors/bower_components/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
	<script
		src="resources/cp/vendors/bower_components/typeahead.js/dist/typeahead.bundle.min.js"></script>
	<script src="resources/cp/vendors/summernote/dist/summernote-updated.min.js"></script>
	<script
		src="resources/cp/vendors/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>

	<!-- Placeholder for IE9 -->
	<!--[if IE 9 ]>
            <script src="resources/cp/vendors/bower_components/jquery-placeholder/jquery.placeholder.min.js"></script>
        <![endif]-->

	<script src="resources/cp/vendors/bower_components/chosen/chosen.jquery.js"></script>
	<script
		src="resources/cp/vendors/bower_components/jquery-mask-plugin/dist/jquery.mask.min.js"></script>
	<script src="resources/cp/vendors/fileinput/fileinput.min.js"></script>

	<script src="resources/cp/js/app.min.js"></script>

	<script type="text/javascript">
            $(document).ready(function() {
                $('#aboutListTable').DataTable();
            } );
        </script>

	<!-- Modal Popup For Add -->
	<div class="modal fade" id="modalDefault" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog" style="width: 60%;">
			<div class="modal-content">
			
					<div class="modal-header">
						<a href="#" class="close" data-dismiss="modal">&times;</a>
						<h4 class="modal-title">ADD ABOUT</h4>
						<hr>
					</div>
					
						<div class="modal-body">
							<form id ="form">
							<div class="row">
								<div class="col-sm-6">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="zmdi zmdi-sun"></i></span>
										<div class="fg-line">
											<label>Name</label> <input type="text" class="form-control"
												placeholder="Enter Name" name="name" required>
										</div>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="zmdi zmdi-store"></i></span>
										<div class="fg-line">
											<label>Description</label> <input type="text"
												class="form-control" placeholder="Enter Description"
												name="description" required>
										</div>
									</div>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="col-sm-6">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="zmdi zmdi-globe"></i></span>
										<div class="fg-line">
											<label>Image</label>
											<textarea type="text" class="form-control"
												placeholder="Enter Image" name="image1" required></textarea>
										</div>
									</div>
								</div>
								<!-- <div class="col-sm-6">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="zmdi zmdi-pin"></i></span>
										<div class="fg-line">
											<label>Image</label> 
											<input type="text"
												class="form-control" placeholder="Enter Image2" name="image2">
										</div>
									</div>
								</div> -->
							</div>
							<br />	
							<!-- <div class="row">
								<div class="col-sm-6">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="zmdi zmdi-badge-check"></i></span>
										<div class="fg-line">
											<label>Status</label> <select class="selectpicker"
												name="status" required>
												<option value="">Select Status</option>
												<option value="Active">Active</option>
												<option value="Inactive">Inactive</option>
											</select>
										</div>
									</div>
								</div>
							</div> 
							<br />-->
							</form>
						</div>
					

					<div class="modal-footer">
						<button type="submit" class="btn bgm-indigo" name="save" id="SaveAbout">Save</button>
						<button type="button" class="btn bgm-amber" data-dismiss="modal">Close</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Modal Popup For UPDATE -->
	<!--  
	<div class="modal fade" id="modalDefault<?php echo $i;?>" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-dialog" style="width: 60%;">

			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Update User Information</h4>
					<hr>
				</div>
				<input type="hidden" name="id" value="<?php echo $row['id'];?>" />
				<div class="modal-body">
					<div class="row">
						<div class="col-sm-6">
							<div class="input-group">
								<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
								<div class="fg-line">
									<label>Outlet</label> <input type="text" class="form-control"
										placeholder="Enter Outlet Name" name="outlet"
										id="outlet<?php echo $row['id'];?>"
										value="<?php echo $row[outlet];?>" required>
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="zmdi zmdi-store"></i></span>
								<div class="fg-line">
									<label>Outlet Name</label> <input type="text"
										class="form-control" placeholder="Enter Outlet Name"
										name="outlet_Name" id="outlet_Name<?php echo $row['id'];?>"
										value="<?php echo $row['outlet_Name'];?>" required>
								</div>
							</div>
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-sm-6">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="zmdi zmdi-globe"></i></span>
								<div class="fg-line">
									<label>Address</label>
									<textarea type="text" class="form-control"
										placeholder="Enter Address" name="address"
										id="address<?php echo $row['id'];?>" required><?php echo $row['address'];?></textarea>
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="input-group">
								<span class="input-group-addon"><i class="zmdi zmdi-pin"></i></span>
								<div class="fg-line">
									<label>Area(address)</label> <input type="text"
										class="form-control" placeholder="Enter Area" name="area"
										id="area<?php echo $row['id'];?>"
										value="<?php echo $row['area'];?>">
								</div>
							</div>
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-sm-6">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="zmdi zmdi-layers"></i></span>
								<div class="fg-line">
									<label>SGA Type</label> <input type="text" class="form-control"
										placeholder="Enter SGA Type"
										value="<?php echo $row['sga_Type'];?>" name="sga_Type"
										id="sga_Type<?php echo $row['id'];?>">
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="zmdi zmdi-pin-account"></i></span>
								<div class="fg-line">
									<label>Contact</label> <input type="text" class="form-control"
										placeholder="Enter Outlet Contact" name="contact"
										id="contact<?php echo $row['id'];?>"
										value="<?php echo $row['contact'];?>">
								</div>
							</div>
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-sm-6">
							<div class="input-group">
								<span class="input-group-addon"><i class="zmdi zmdi-toys"></i></span>
								<div class="fg-line">
									<label>Outlet Channel</label> <input type="text"
										class="form-control" placeholder="Enter Outlet Channel"
										name="outlet_Channel"
										id="outlet_Channel<?php echo $row['id'];?>"
										value="<?php echo $row['outlet_Channel'];?>" required>
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="zmdi zmdi-label-alt"></i></span>
								<div class="fg-line">
									<label>Category</label> <select class="form-control"
										name="category" id="category<?php echo $row['id'];?>">
										<option value="">Select Category</option>
										<option value="gold"<?php
											if($row['category']=="gold"){echo "selected";}?>>GOLD</option>
										<option value="silver"<?php
											if($row['category']=="silver"){echo "selected";}?>>SILVER</option>
										<option value="bronze"<?php
											if($row['category']=="bronze"){echo "selected";}?>>BRONZE</option>
									</select>
								</div>
							</div>
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-sm-6">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="zmdi zmdi-album"></i></span>
								<div class="fg-line">
									<label>Party</label> <input type="text" class="form-control"
										placeholder="Enter Outlet Party" name="outlet_Party"
										id="outlet_Party<?php echo $row['id'];?>"
										value="<?php echo $row[outlet_Party];?>">
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="zmdi zmdi-badge-check"></i></span>
								<div class="fg-line">
									<label>Status</label> <select class="form-control"
										name="status" id="status<?php echo $row['id'];?>" required>
										<option value="">Select Status</option>
										<option value="Active"<?php
											if($row['status']=="Active"){echo "selected";}?>>Active</option>
										<option value="Inactive"<?php
											if($row['status']=="Inactive"){echo "selected";}?>>Inactive</option>
									</select>
								</div>
							</div>
						</div>
					</div>
					<br />
				</div>
				<div class="modal-footer">
					<button type="button" class="btn bgm-indigo"
						onclick="editItem(<?php echo $row['id'];?>)" data-dismiss="modal">Save
						Changes</button>
					<button type="button" class="btn bgm-amber" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
	<?php $i++; }?>
	
	-->
	
	<!-- Script fo dataTable -->
	<script>
	// code for jquery dataTable
	var $table1 = $('#aboutListTable');

	// execute the below code only where we have this table
	if ($table1.length) {
		console.log('Inside the table!');

		var jsonUrl = '';
		jsonUrl = window.contextRoot + '/about-us';
		
		/* if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		} */

		$table1
			.DataTable({

				lengthMenu : [ [ 3, 5, 10, -1 ],
						[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
				pageLength : 5,
				ajax : {
					url : jsonUrl,
					dataSrc : ''
				},
				columns : 
					[
						{data : 'id'},
						{data : 'name'},
						{data : 'description'},
						{data : 'image',
							mRender: function(data,type,row) {
			           			return '<img src="' + window.contextRoot
								+ '/resources/img/' + data
								+ '.jpg" class="dataTableImg" style="height:50px; width:100px"/>';					           			
			           		}
						},
						{
							data : 'id',
						 	bSortable: false,
							mRender: function(data,type,row) {
			           			var str = "";
			           			str += '<a href="'
									+ window.contextRoot
									+ '/manage/'
									+ data
									+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
									
								/* var str1="";
								
								str +='<a href='#' class='btn-btn-warning' onclick='Edit()'><span class="glyphicon glyphicon-pencil"></span></a>';
	 */
							return str;
			           		}
						}

					]
			});
	}

	</script>
	
	<!-- Show the Popup Modal For Add New Record -->
	<script>
	
	function AddNewRecord(id)
	{
		$("#form")[0].reset();
		$("#modal-title").html("Add New record");
		$("#modalDefault").modal();
		
		
	}
	
	//Show The Popup Modal For Add New Student

    /* function AddNewStudent(id) {
        $("#form")[0].reset();
        $("#id").val(0);
        $("#DropDwn option:selected").text("--Select Dept--");
        $("#ModalTitle").html("Add New Student");
        $("#MyModal").modal();

    } */
	</script>
	
	<script>
	//Show The Popup Modal For Edit Student Record

    function EditStudentRecord(id) {
        //var url = "/Home/GetStudentById?StudentId=" + StudentId;
        var url = window.contextRoot + "/about/" + id;
        $("#modal-title").html("Update Student Record");
        $("#modalDefault").modal();
        $.ajax({
            type: "GET",
            url: url,
            success: function (data) {
                var obj = JSON.parse(data);
                $("#StuId").val(obj.id);
                $("#StuName").val(obj.StudentName);
                $("#Email").val(obj.Email);
                $("#DropDwn option:selected").text(obj.tblDepartment.DepartmentName);
                $("#DropDwn option:selected").val(obj.DepartmentId);

            }
        })
    }
	</script>
	
	


</body>



</html>