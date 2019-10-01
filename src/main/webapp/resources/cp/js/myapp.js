$(function() {
	
	// for adding a loader
	$(window).load(function(){
		setTimeout(function() {
			$(".se-pre-con").fadeOut("slow");
		}, 500);			
	});	
	
	
	// for handling CSRF token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if((token!=undefined && header !=undefined) && (token.length > 0 && header.length > 0)) {		
		// set the token header for the ajax request
		$(document).ajaxSend(function(e, xhr, options) {			
			xhr.setRequestHeader(header,token);			
		});				
	}
	
	
	// solving the active menu problem

	

	// jQuery Validation Code

	//methods required for validation
	
	function errorPlacement(error, element) {
		// Add the 'help-block' class to the error element
		error.addClass("help-block");
		
		// add the error label after the input element
		error.insertAfter(element);
		
		
		// add the has-feedback class to the
		// parent div.validate in order to add icons to inputs
		element.parents(".validate").addClass("has-feedback");	

	}	
	
	
	/*validating the loginform*/
	
	// fetch the form element
	$loginForm = $('#loginForm');
	
	if($loginForm.length) {
		
		$loginForm.validate({			
				rules: {
					username: {
						required: true,
						email: true
						
					},
					password: {
						required: true
					}				
				},
				messages: {					
					username: {
						required: 'Please enter your email!',
						email: 'Please enter a valid email address!'
					},
					password: {
						required: 'Please enter your password!'
					}					
				},
				errorElement : "em",
				errorPlacement : function(error, element) {
					// Add the 'help-block' class to the error element
					error.addClass("help-block");
					
					// add the error label after the input element
					error.insertAfter(element);
				}				
			}
		
		);
		
	}
	
	
	// list of all products for admin
	var $productsTable = $('#data-table-basic');
	
	
	if($productsTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/category';
		console.log(jsonUrl);
		
		$productsTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [		
					           	{data: 'id'},
					           	{
									data : 'name'
								},
								{
									data : 'description'
								},
								{data: 'image',
						           	 bSortable: false,
						           		mRender: function(data,type,row) {
						           			return '<img src="' + window.contextRoot
											+ '/resources/img/' + data
											+ '.jpg" class="dataTableImg" style="height:70px; width:120px;"/>';					           			
						           		}
						           	},
								{
									data : 'status'
								},
								
								{
									data : 'id',
									bSortable : false,
									mRender : function(data, type, row) {

										var str = '';
										str += '<a href="'
												+ window.contextRoot
												+ '/cp/category/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';

										return str;
									}
								}					           	
					]
					
					

				});
	}
	
	
	// list of all products for admin
	var $testTable = $('#data-table-basic1');
	
	
	if($testTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/category';
		console.log(jsonUrl);
		
		$testTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [		
					           	{data: 'id'},
					           	{
									data : 'name'
								},
								{
									data : 'description'
								},
								{data: 'image',
						           	 bSortable: false,
						           		mRender: function(data,type,row) {
						           			return '<img src="' + window.contextRoot
											+ '/resources/img/' + data
											+ '.jpg" class="dataTableImg" style="height:70px; width:120px;"/>';					           			
						           		}
						           	},
								{
									data : 'status'
								},
								
								{
									data : 'id',
									bSortable : false,
									mRender : function(data, type, row) {

										var str = '';
										str += '<a href="'
												+ window.contextRoot
												+ '/cp/category/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';

										return str;
									}
								}					           	
					]
					
					

				});
	}
	
	
	// list of all products for admin
	var $productListTable = $('#productListTable');
	
	
	if($productListTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/product';
		console.log(jsonUrl);
		
		$productListTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [		
					           	{data: 'id'},
					           	{data : 'name'},
					           	{data : 'description'},					           	
					           	{data : 'quantity'},
					           	{data : 'mrp'},
								{data: 'code',
						           	 bSortable: false,
						           		mRender: function(data,type,row) {
						           			return '<img src="' 
						           			+ window.contextRoot
											+ '/resources/img/' + data
											+ '.jpg" class="dataTableImg" style="height:70px; width:120px;"/>';					           			
						           		}
						           	},
								{
									data : 'status',
									bSortable : false,
									mRender : function(data, type, row) {
										
										var str = '';
										
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
												+ '/cp/product/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';

										return str;
									}
								}					           	
					],
					
					initComplete: function () {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the Product?': 'You want to de-activate the Product?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'Product Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/cp/product/'+checkbox.prop('value')+'/activation',
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
	
	
	// list of all about for admin
	var $aboutListTable = $('#aboutListTable');
	
	
	if($aboutListTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/about';
		console.log(jsonUrl);
		
		$aboutListTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [		
					           	{data: 'id'},
					           	{data : 'name'},
					           	{data : 'shortDescription'},					           	
					           	{data : 'description'},
								{data: 'receiptImgFilename',
						           	 bSortable: false,
						           		mRender: function(data,type,row) {
						           			return '<img src="' 
						           			+ window.contextRoot
											+ '/resources/img/' + data
											+ '.jpg" class="dataTableImg" style="height:70px; width:120px;"/>';					           			
						           		}
						           	},
								{
									data : 'status',
									bSortable : false,
									mRender : function(data, type, row) {
										
										var str = '';
										
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
												+ '/cp/about/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
										
										str += '<a href="'
											+ window.contextRoot
											+ '/cp/about/delete/'
											+ data
											+ '" class="btn btn-danger"><span class="zmdi zmdi-delete"></span></a> &#160;';

										return str;
									}
								}					           	
					],
					
					initComplete: function () {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the About Row?': 'You want to de-activate the About?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'About Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/cp/about/'+checkbox.prop('value')+'/activation',
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
	
	
	// list of all helpAndSupportListTable for admin
	var $helpAndSupportListTable = $('#helpAndSupportListTable');
	
	
	if($helpAndSupportListTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/helpAndSupport';
		console.log(jsonUrl);
		
		$helpAndSupportListTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [		
					           	{data: 'id'},
					           	{data : 'name'},
					           	{data : 'shortDescription'},					           	
					           	{data : 'description'},
								{data: 'image',
						           	 bSortable: false,
						           		mRender: function(data,type,row) {
						           			return '<img src="' 
						           			+ window.contextRoot
											+ '/resources/img/' + data
											+ '.jpg" class="dataTableImg" style="height:70px; width:120px;"/>';					           			
						           		}
						           	},
								{
									data : 'status',
									bSortable : false,
									mRender : function(data, type, row) {
										
										var str = '';
										
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
												+ '/cp/helpAndSupport/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
										
										str += '<a href="'
											+ window.contextRoot
											+ '/cp//helpAndSupport/delete/'
											+ data
											+ '" class="btn btn-danger"><span class="zmdi zmdi-delete"></span></a> &#160;';

										return str;
									}
								}					           	
					],
					
					initComplete: function () {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the helpAndSupport ?': 'You want to de-activate the About?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'helpAndSupport Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/cp/helpAndSupport/'+checkbox.prop('value')+'/activation',
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
	
		
	// list of all contact for adminpartnerProgramListTable
	var $contactListTable = $('#contactListTable');
	
	
	if($contactListTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/contact';
		console.log(jsonUrl);
		
		$contactListTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [		
					           	{data: 'id'},
					           	{data : 'name'},
					           	{data : 'shortDescription'},					           	
					           	{data : 'description'},
								{data: 'image',
						           	 bSortable: false,
						           		mRender: function(data,type,row) {
						           			return '<img src="' 
						           			+ window.contextRoot
											+ '/resources/img/' + data
											+ '.jpg" class="dataTableImg" style="height:70px; width:120px;"/>';					           			
						           		}
						           	},
								{
									data : 'status',
									bSortable : false,
									mRender : function(data, type, row) {
										
										var str = '';
										
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
												+ '/cp/contact/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
										
										str += '<a href="'
											+ window.contextRoot
											+ '/cp/about/delete/'
											+ data
											+ '" class="btn btn-danger"><span class="zmdi zmdi-delete"></span></a> &#160;';

										return str;
									}
								}					           	
					],
					
					initComplete: function () {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the About Row?': 'You want to de-activate the About?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'Contact Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/cp/contact/'+checkbox.prop('value')+'/activation',
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
	
	
	// list of all partnerProgram for admin
	var $partnerProgramListTable = $('#partnerProgramListTable');
	
	
	if($partnerProgramListTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/partnerProgram';
		console.log(jsonUrl);
		
		$partnerProgramListTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [		
					           	{data: 'id'},
					           	{data : 'name'},
					           	{data : 'shortDescription'},					           	
					           	{data : 'description'},
								{data: 'image',
						           	 bSortable: false,
						           		mRender: function(data,type,row) {
						           			return '<img src="' 
						           			+ window.contextRoot
											+ '/resources/img/' + data
											+ '.jpg" class="dataTableImg" style="height:70px; width:120px;"/>';					           			
						           		}
						           	},
								{
									data : 'status',
									bSortable : false,
									mRender : function(data, type, row) {
										
										var str = '';
										
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
												+ '/cp/partnerProgram/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
										
										str += '<a href="'
											+ window.contextRoot
											+ '/cp/partnerProgram/delete/'
											+ data
											+ '" class="btn btn-danger"><span class="zmdi zmdi-delete"></span></a> &#160;';

										return str;
									}
								}					           	
					],
					
					initComplete: function () {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the PartnerProgram ?': 'You want to de-activate the PartnerProgram?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'PartnerProgram Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/cp/partnerProgram/'+checkbox.prop('value')+'/activation',
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
	
	// list of all testimonial for admin $testimonialListTable
	var $testimonialListTable = $('#testimonialListTable');
	
	
	if($testimonialListTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/testimonial';
		console.log(jsonUrl);
		
		$testimonialListTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [		
					           	{data: 'id'},
					           	{data : 'name'},
					           	{data : 'shortDescription'},					           	
					           	{data : 'description'},
								{data: 'image',
						           	 bSortable: false,
						           		mRender: function(data,type,row) {
						           			return '<img src="' 
						           			+ window.contextRoot
											+ '/resources/img/' + data
											+ '.jpg" class="dataTableImg" style="height:70px; width:120px;"/>';					           			
						           		}
						           	},
								{
									data : 'status',
									bSortable : false,
									mRender : function(data, type, row) {
										
										var str = '';
										
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
												+ '/cp/testimonial/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
										
										str += '<a href="'
											+ window.contextRoot
											+ '/cp/testimonial/delete/'
											+ data
											+ '" class="btn btn-danger"><span class="zmdi zmdi-delete"></span></a> &#160;';

										return str;
									}
								}					           	
					],
					
					initComplete: function () {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the testimonial Row?': 'You want to de-activate the testimonial?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'Testimonial Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/cp/testimonial/'+checkbox.prop('value')+'/activation',
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
	
	
	// list of all news for admin $newsListTable
	var $newsListTable = $('#newsListTable');
	
	
	if($newsListTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/news';
		console.log(jsonUrl);
		
		$newsListTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [		
					           	{data: 'id'},
					           	{data : 'name'},
					           	{data : 'shortDescription'},					           	
					           	{data : 'description'},
								{data: 'image',
						           	 bSortable: false,
						           		mRender: function(data,type,row) {
						           			return '<img src="' 
						           			+ window.contextRoot
											+ '/resources/img/' + data
											+ '.jpg" class="dataTableImg" style="height:70px; width:120px;"/>';					           			
						           		}
						           	},
								{
									data : 'status',
									bSortable : false,
									mRender : function(data, type, row) {
										
										var str = '';
										
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
												+ '/cp/news/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
										
										str += '<a href="'
											+ window.contextRoot
											+ '/cp/news/delete/'
											+ data
											+ '" class="btn btn-danger"><span class="zmdi zmdi-delete"></span></a> &#160;';

										return str;
									}
								}					           	
					],
					
					initComplete: function () {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the testimonial Row?': 'You want to de-activate the testimonial?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'News Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/cp/news/'+checkbox.prop('value')+'/activation',
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
	
	
	// list of all bus for admin
	var $busListTable = $('#busListTable');
	
	
	if($busListTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/bus';
		console.log(jsonUrl);
		
		$busListTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [		
//					           	{data: 'id'},
					           	{data : 'name'},
					           	{data : 'code'},
//					           	{data : 'regiNumber'},					           	
					           	{data : 'type'},
					           	{data : 'maximumSeats'},
					           	{data : 'startPoint'},
					           	{data : 'endPoint'},
					           	{data : 'startTime'},
					           	{data : 'endTime'},
//					           	{data : 'amenities'},
								{data: 'code',
						           	 bSortable: false,
						           		mRender: function(data,type,row) {
						           			return '<img src="' 
						           			+ window.contextRoot
											+ '/resources/img/' + data
											+ '.jpg" class="dataTableImg" style="height:70px; width:120px;"/>';					           			
						           		}
						           	},
								{
									data : 'status',
									bSortable : false,
									mRender : function(data, type, row) {
										
										var str = '';
										
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
												+ '/cp/bus/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
										
										str += '<a href="'
											+ window.contextRoot
											+ '/cp/bus/delete/'
											+ data
											+ '" class="btn btn-danger"><span class="zmdi zmdi-delete"></span></a> &#160;';

										return str;
									}
								}					           	
					],
					
					initComplete: function () {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the Bus?': 'You want to de-activate the Bus?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'Bus Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/cp/bus/'+checkbox.prop('value')+'/activation',
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
	
	
	// list of all route for admin
	var $routeListTable = $('#routeListTable');
	
	
	if($routeListTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/route';
		console.log(jsonUrl);
		
		$routeListTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [		
//					           	{data: 'id'},
					           	{data : 'bus'},					           	
					           	{data : 'boardPoint'},
					           	{data : 'startTime'},
					           	{data : 'dropPoint'},
					           	{data : 'arrivalTime'},
					           	{data : 'fare'},
								{
									data : 'status',
									bSortable : false,
									mRender : function(data, type, row) {
										
										var str = '';
										
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
												+ '/cp/route/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
										
										str += '<a href="'
											+ window.contextRoot
											+ '/cp/route/delete/'
											+ data
											+ '" class="btn btn-danger"><span class="zmdi zmdi-delete"></span></a> &#160;';

										return str;
									}
								}					           	
					],
					
					initComplete: function () {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the Route?': 'You want to de-activate the Route?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'Bus Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/cp/route/'+checkbox.prop('value')+'/activation',
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
	
	
	// list of all news for admin $newsListTable
	var $boardPointListTable = $('#boardPointListTable');
	
	
	if($boardPointListTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/boardPoint';
		console.log(jsonUrl);
		
		$boardPointListTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [		
					           	{data : 'bus'},
					           	{data : 'route'},					           	
					           	{data : 'boardingPoint'},
					           	{data : 'startTime'},
					           	{data : 'landmark'},
					           	{data : 'address'},
								{
									data : 'status',
									bSortable : false,
									mRender : function(data, type, row) {
										
										var str = '';
										
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
												+ '/cp/boardPoint/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
										
										str += '<a href="'
											+ window.contextRoot
											+ '/cp/boardPoint/delete/'
											+ data
											+ '" class="btn btn-danger"><span class="zmdi zmdi-delete"></span></a> &#160;';

										return str;
									}
								}					           	
					],
					
					initComplete: function () {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the Boarding Point Row?': 'You want to de-activate the Boarding Point?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'News Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/cp/boardPoint/'+checkbox.prop('value')+'/activation',
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
	
	
	// list of all news for admin $dropPointListTable
	var $dropPointListTable = $('#dropPointListTable');
	
	if($dropPointListTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/dropPoint';
		console.log(jsonUrl);
		
		$dropPointListTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [		
					           	/*{data: 'id'},*/
					           	{data : 'bus'},
					           	{data : 'route'},					           	
					           	{data : 'droppingPoint'},
					           	{data : 'dropTime'},
					           	{data : 'landmark'},
					           	{data : 'address'},
								{
									data : 'status',
									bSortable : false,
									mRender : function(data, type, row) {
										
										var str = '';
										
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
												+ '/cp/dropPoint/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
										
										str += '<a href="'
											+ window.contextRoot
											+ '/cp/dropPoint/delete/'
											+ data
											+ '" class="btn btn-danger"><span class="zmdi zmdi-delete"></span></a> &#160;';

										return str;
									}
								}					           	
					],
					
					initComplete: function () {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the Dropping Point Row?': 'You want to de-activate the Dropping Point?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'Drop Point Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/cp/dropPoint/'+checkbox.prop('value')+'/activation',
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
	
	
	// list of all news for admin $promoListTable
	var $promoListTable = $('#promoListTable');
	
	if($promoListTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/promo';
		console.log(jsonUrl);
		
		$promoListTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [		
					           	/*{data: 'id'},*/
					           	{data : 'code'},					           	
					           	{data : 'amount'},
					           	{data : 'expiryDate'},
								{
									data : 'status',
									bSortable : false,
									mRender : function(data, type, row) {
										
										var str = '';
										
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
												+ '/cp/promo/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
										
										str += '<a href="'
											+ window.contextRoot
											+ '/cp/promo/delete/'
											+ data
											+ '" class="btn btn-danger"><span class="zmdi zmdi-delete"></span></a> &#160;';

										return str;
									}
								}					           	
					],
					
					initComplete: function () {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the Promo Row?': 'You want to de-activate the Promo ?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'Promo Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/cp/promo/'+checkbox.prop('value')+'/activation',
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
	
	
	// list of all news for admin $customerListTable
	var $customerListTable = $('#customerListTable');
	
	if($customerListTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/customer';
		console.log(jsonUrl);
		
		$customerListTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [		
					           	/*{data: 'id'},*/
					           	{data : 'id'},
					           	{data : 'name'},					           	
					           	{data : 'email'},
					           	{data : 'mobile'},
								{
									data : 'status',
									bSortable : false,
									mRender : function(data, type, row) {
										
										var str = '';
										
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
												+ '/cp/customer/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
										
										str += '<a href="'
											+ window.contextRoot
											+ '/cp/customer/delete/'
											+ data
											+ '" class="btn btn-danger"><span class="zmdi zmdi-delete"></span></a> &#160;';

										return str;
									}
								}					           	
					],
					
					initComplete: function () {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the Customer Row?': 'You want to de-activate the Customer ?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'Customer Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/cp/customer/'+checkbox.prop('value')+'/activation',
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
	
	
	// list of all news for admin $seatLayoutListTable
	var $seatLayoutListTable = $('#seatLayoutListTable');
	
	if($seatLayoutListTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/seatLayout';
		console.log(jsonUrl);
		
		$seatLayoutListTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [		
					           	/*{data: 'id'},*/
					           	{data : 'bus'},
					           	{data : 'row'},
					           	{data : 'col'},
					           	{data : 'name'},
					           	{data : 'length'},
					           	{data : 'width'},
					           	{data : 'zindex'},
					           	{data : 'baseFare'},					           	
					           	{data : 'fare'},
					           	{data : 'available'},
								{
									data : 'status',
									bSortable : false,
									mRender : function(data, type, row) {
										
										var str = '';
										
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
												+ '/cp/seatLayout/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
										
										str += '<a href="'
											+ window.contextRoot
											+ '/cp/seatLayout/delete/'
											+ data
											+ '" class="btn btn-danger"><span class="zmdi zmdi-delete"></span></a> &#160;';

										return str;
									}
								}					           	
					],
					
					initComplete: function () {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the SeatLayout Row?': 'You want to de-activate the SeatLayout ?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'SeatLayout Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/cp/seatLayout/'+checkbox.prop('value')+'/activation',
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
	
	
	//list of all busType for admin
	var $busTypeListTable = $('#busTypeListTable');


	if($busTypeListTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/busType';
		console.log(jsonUrl);
		
		$busTypeListTable.DataTable({
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
												+ '/cp/busType/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
										
										str += '<a href="'
											+ window.contextRoot
											+ '/cp/busType/delete/'
											+ data
											+ '" class="btn btn-danger"><span class="zmdi zmdi-delete"></span></a> &#160;';

										return str;
									}
								}					           	
					],
					
					initComplete: function () {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the busType Row?': 'You want to de-activate the busType?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'busType Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/cp/busType/'+checkbox.prop('value')+'/activation',
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

	//list of all seatType for admin
	var $seatTypeListTable = $('#seatTypeListTable');


	if($seatTypeListTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/seatType';
		console.log(jsonUrl);
		
		$seatTypeListTable.DataTable({
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
												+ '/cp/seatType/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
										
										str += '<a href="'
											+ window.contextRoot
											+ '/cp/seatType/delete/'
											+ data
											+ '" class="btn btn-danger"><span class="zmdi zmdi-delete"></span></a> &#160;';

										return str;
									}
								}					           	
					],
					
					initComplete: function () {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the SeatType Row?': 'You want to de-activate the SeatType?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'SeatType Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/cp/seatType/'+checkbox.prop('value')+'/activation',
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
	

	// list of all bus for amenities
	var $amenitiesListTable = $('#amenitiesListTable');
	
	
	if($amenitiesListTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/amenities';
		console.log(jsonUrl);
		
		$amenitiesListTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [		
					           	{data: 'id'},
					           	{data : 'name'},
								{data: 'code',
						           	 bSortable: false,
						           		mRender: function(data,type,row) {
						           			return '<img src="' 
						           			+ window.contextRoot
											+ '/resources/img/' + data
											+ '.jpg" class="dataTableImg" style="height:70px; width:120px;"/>';					           			
						           		}
						           	},
								{
									data : 'status',
									bSortable : false,
									mRender : function(data, type, row) {
										
										var str = '';
										
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
												+ '/cp/amenities/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
										
										str += '<a href="'
											+ window.contextRoot
											+ '/cp/amenities/delete/'
											+ data
											+ '" class="btn btn-danger"><span class="zmdi zmdi-delete"></span></a> &#160;';

										return str;
									}
								}					           	
					],
					
					initComplete: function () {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the Amenities?': 'You want to de-activate the Amenities?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'Amenities Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/cp/amenities/'+checkbox.prop('value')+'/activation',
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
	
	
	
	// list of all bus for amenities
	var $cityListTable = $('#cityListTable');
	
	
	if($cityListTable.length) {
		
		var jsonUrl = window.contextRoot + '/cp/all/city';
		console.log(jsonUrl);
		
		$cityListTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [		
					           	{data: 'id'},					           	
								{data: 'code'},
								{data : 'name'},
								{
									data : 'status',
									bSortable : false,
									mRender : function(data, type, row) {
										
										var str = '';
										
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
												+ '/cp/city/'
												+ data
												+ '" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
										
										str += '<a href="'
											+ window.contextRoot
											+ '/cp/city/delete/'
											+ data
											+ '" class="btn btn-danger"><span class="zmdi zmdi-delete"></span></a> &#160;';

										return str;
									}
								}					           	
					],
					
					initComplete: function () {
						var api = this.api();
						api.$('.switch input[type="checkbox"]').on('change' , function() {							
							var dText = (this.checked)? 'You want to activate the City?': 'You want to de-activate the City?';
							var checked = this.checked;
							var checkbox = $(this);
							debugger;
						    bootbox.confirm({
						    	size: 'medium',
						    	title: 'City Activation/Deactivation',
						    	message: dText,
						    	callback: function (confirmed) {
							        if (confirmed) {
							            $.ajax({							            	
							            	type: 'GET',
							            	url: window.contextRoot + '/cp/city/'+checkbox.prop('value')+'/activation',
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
	
	
	/*------*/
	/* for fading out the alert message after 3 seconds */
	$alert = $('.alert');
	if($alert.length) {
		setTimeout(function() {
	    	$alert.fadeOut('slow');
		   }, 3000
		);		
	}
	
	
	/*------*/
	/* handle refresh cart*/	
	/*$('button[name="refreshCart"]').click(function(){*/
	$("#refreshCart").on("click","button[name=refreshCart]",function(){
		var cartLineId = $(this).attr('value');
		var countField = $('#count_' + cartLineId);
		var originalCount = countField.attr('value');
		// do the checking only the count has changed
		if(countField.val() != originalCount) 
		{	
			// check if the quantity is within the specified range
			if(countField.val() < 1 || countField.val() > 3) {
				// set the field back to the original field
				countField.val(originalCount);
				bootbox.alert({
					size: 'medium',
			    	title: 'Error',
			    	message: 'Product Count should be minimum 1 and maximum 3!'
				});
			}
			else {
				// use the window.location.href property to send the request to the server
				var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count=' + countField.val();
				window.location.href = updateUrl;
			}
		}
	});
	
	
	
	//-----start-----
	$('button[name="refreshCart"]').click(function(){
	

	    $.ajax({
	        type: "GET",
	        url: window.contextRoot + '/bus/' + window.busId +'/seatLayout',
	        success: function(response) {
	            $("#subViewDiv").html( response );
	        }
	    });
	
	});
	//-----end-----
	
			
});