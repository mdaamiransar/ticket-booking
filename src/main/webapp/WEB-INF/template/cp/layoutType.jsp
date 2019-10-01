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
					
				<c:url var="addAction" value="${contextRoot}/cp/layoutType/add"></c:url>
				<form:form class="form-horizontal" modelAttribute="layoutType" 
					action="${addAction}" 
					method="POST">
					
					<div class="col-sm-6 form-group">
						<div class="input-group">
							<span class="input-group-addon"><i class="zmdi zmdi-sun"></i></span>
							<div class="fg-line">
								<label>Name</label> 
								<form:input type="text" path="name" id="name" class="form-control" placeholder="Enter Name"/>
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
					${title} <small>LayoutType Management </small>
				</h2>
			</div>

			<div class="table-responsive">
				<table id="layoutTypeListTable" class="table table-striped">
					<thead>
						<tr>
							<th>Code</th>
							<th>Name</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Code</th>
							<th>Name</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</tfoot>
					
				</table>
			</div>
		</div>

	</div>
</section>

<!-- <script>
//list of all seatType for admin
var $layoutTypeListTable = $('#layoutTypeListTable');


if($layoutTypeListTable.length) {
	
	var jsonUrl = window.contextRoot + '/cp/all/layoutType';
	console.log(jsonUrl);
	
	$layoutTypeListTable.DataTable({
				lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
				pageLength : 10,
				ajax : {
					url : jsonUrl,
					dataSrc : ''
				},
				columns : [		
				           	{data: 'id'},
				           	{data : 'name'},
							{
								data : 'status',
								bSortable : false,
								mRender : function(data, type, row) {
									
									var str = '';
									
									if(data) {											
										str += '<label class="switch"> <input type="checkbox" value="'+row.id+'" checked="checked">  <div class="slider round"> </div></label>';
										
									}else {
										str += '<label class="switch"> <input type="checkbox" value="'+row.id+'">  <div class="slider round"> </div></label>';
									}
																			
									return str;
								}
							},
							
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/cp/layoutType/'
											+ data
											+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
									
									str += '<a href="'
										+ window.contextRoot
										+ '/cp/layoutType/delete/'
										+ data
										+ '" class="btn btn-danger"><span class="zmdi zmdi-delete"></span></a> &#160;';

									return str;
								}
							}					           	
				],
				
				initComplete: function () {
					var api = this.api();
					api.$('.switch input[type="checkbox"]').on('change' , function() {							
						var dText = (this.checked)? 'You want to activate the layoutType Row?': 'You want to de-activate the layoutType?';
						var checked = this.checked;
						var checkbox = $(this);
						debugger;
					    bootbox.confirm({
					    	size: 'medium',
					    	title: 'layoutType Activation/Deactivation',
					    	message: dText,
					    	callback: function (confirmed) {
						        if (confirmed) {
						            $.ajax({							            	
						            	type: 'GET',
						            	url: window.contextRoot + '/cp/layoutType/'+checkbox.prop('value')+'/activation',
						        		timeout : 100000,
						        		success : function(data) {
						        			bootbox.alert(data);							        										        			
						        		},
						        		error : function(e) {
						        			bootbox.alert('ERROR: '+ e);
						        			//display(e);
						        		}						            	
						            });
						        }
						        else {							        	
						        	checkbox.prop('checked', !checked);
						        }
					    	}
					    });		
						
						/*Sweet Alert 2*/
						/*swal({   
		                    title: "Are you sure?",   
		                    text: "You will not be able to recover this imaginary file!",   
		                    type: "warning",   
		                    showCancelButton: true,   
		                    confirmButtonText: "Yes, delete it!",
		                    cancelButtonText: "No, cancel plx!",   
		                }).then(function(isConfirm){
		                    if (isConfirm) {     
		                        swal("Deleted!", "Your imaginary file has been deleted.", "success");   
		                    } else {     
		                        swal("Cancelled", "Your imaginary file is safe :)", "error");   
		                    } 
		                });*/
						
						
					});
						
				}
				
				

			});
}
</script> -->