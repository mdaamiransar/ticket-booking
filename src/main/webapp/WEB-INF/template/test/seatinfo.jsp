<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Hello, world!</title>
    
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    
   
  </head>
  
  <body>

 <div class="container">
        <div class="col-md-12 col-sm-12 col-xs-12">
        
        	<ul class="nav nav-tabs">
    <li class="active"><a href="#tab1" data-toggle="tab">Shipping</a></li>
    <li><a href="#tab2" data-toggle="tab">Quantities</a></li>
    <li><a href="#tab3" data-toggle="tab">Summary</a></li>
</ul>
<div class="tab-content">
    <div class="tab-pane active" id="tab1">
    
    	<form action="/action_page.php">
		  <div class="form-group">
		    <label for="email">Email address:</label>
		    <input type="email" class="form-control" id="email">
		  </div>
		  <div class="form-group">
		    <label for="pwd">Password:</label>
		    <input type="password" class="form-control" id="pwd">
		  </div>
		 
		  <button type="submit" class="btn btn-default">Submit</button>
		</form>
        <a class="btn btn-primary btnNext" >Next</a>
    </div>
    <div class="tab-pane" id="tab2">
    	
    	<form action="/action_page.php">
		  <div class="row form-group">
		  
		  	<div class="col-xs-6">
		    <label for="email">Name:</label>
		    <input type="email" class="form-control" id="email">
		    </div>


		  <div class="col-xs-6">
		    <label for="pwd">Age:</label>
		    <input type="number" class="form-control" id="pwd">
		   </div>

		  <div class="col-xs-6">
			  <label for="sel1">Gender:</label>
			  <select class="form-control" id="sel1">
			    <option>Male</option>
			    <option>Female</option>
			  </select>
			  </div>

		</div>
		</form>
		
        <a class="btn btn-primary btnNext" >Next</a>
        <a class="btn btn-primary btnPrevious" >Previous</a>
    </div>
    <div class="tab-pane" id="tab3">
        <a class="btn btn-primary btnPrevious" >Previous</a>
    </div>
</div>
        </div>
 </div>
 
 <script type="text/javascript">
 $('.btnNext').click(function(){
	  $('.nav-tabs > .active').next('li').find('a').trigger('click');
	});

	  $('.btnPrevious').click(function(){
	  $('.nav-tabs > .active').prev('li').find('a').trigger('click');
	});
 </script>
            </body>
</html>


