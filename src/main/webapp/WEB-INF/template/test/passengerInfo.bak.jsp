<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Hello, world!</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


</head>

<body>

	<div class="container">

		<div class="row">
			
			<%int i=1; %>
			<c:forEach items="${listSeat}" var="seat">
			<div class="col-md-12 col-sm-12 col-xs-12">

				<div class="panel-group">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" href="#collapse_<%=i%>">Passenger <%=i%>| Seat : ${seat} </a>
							</h4>
						</div>
						<div id="collapse_<%=i++%>" class="panel-collapse collapse">
							<div class="panel-body">
								<div class="col-sm-6 form-group">
									<label>Name</label> <input type="text" class="form-control"
										placeholder="Enter Name" name="name" required>
								</div>

								<div class="col-sm-6 form-group">
									<label>Age</label> <input type="text" class="form-control"
										placeholder="Enter Age" name="age" required>
								</div>

								<div class="col-sm-6 form-group">
									<label>Gender</label> <input type="text" class="form-control"
										placeholder="Enter Gender" name="gender" required>
								</div>
								
								<div class="col-sm-6 form-group">
									<label>Seat</label> <input type="text" class="form-control"
										placeholder="Enter Seat" name="seat" required>
								</div>

							</div>

						</div>
					</div>

				</div>

			</div>
			
			</c:forEach>
		</div>
	</div>

	<div class="container">

		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">

				<div class="panel-group">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" href="#collapse2">Contact Details</a>
							</h4>
						</div>
						<div id="collapse2" class="panel-collapse collapse">
							<div class="panel-body">
								<div class="col-sm-6 form-group">
									<label>Email</label> <input type="text" class="form-control"
										placeholder="Enter Name" name="name" required>
								</div>

								<div class="col-sm-6 form-group">
									<label>Phone</label> <input type="text" class="form-control"
										placeholder="Enter Age" name="age" required>
								</div>

								<div class="col-sm-6 form-group">
									<a class="btn btn-primary" >Proceed</a>
								</div>

							</div>
							
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>

</body>
</html>


