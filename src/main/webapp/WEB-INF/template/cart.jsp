<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="availableCount" value="${userModel.cart.cartLines}" />

<!-- Breadcromb Area Start -->
<section class="bleezy-breadcromb-area">
	<div class="breadcromb-top section_50">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="breadcromb-top-text">
						<h2>cart page</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="breadcromb-bottom">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="breadcromb-bottom-text">
						<ul>
							<li><a href="index.html">home</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-long-arrow-right"></span></a></li>
							<li><a href="#">shop</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-long-arrow-right"></span></a></li>
							<li>cart page</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Breadcromb Area End -->

<!-- Cart Page Area Start -->

<div class="container">
	
	<c:choose>
		
		<c:when test="${not empty cartLines}">
		
		<table id="cart" class="table table-hover table-condensed">
			<thead>
				<tr>
					<th style="width:50%">Product</th>
					<th style="width:10%">Price</th>
					<th style="width:8%">Quantity</th>
					<th style="width:22%" class="text-center">Subtotal</th>
					<th style="width:10%"></th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach items="${cartLines}" var="cartLine">
				
				<c:if test="${cartLine.available == false}">
						<c:set var="availableCount" value="${availableCount - 1}"/>
				</c:if>
				
				<tr>
					<td data-th="Product">
						<div class="row">
							<div class="col-sm-2 hidden-xs"><img src="/resources/img/${cartLine.product.code}.jpg" alt="${cartLine.product.name}" class="img-responsive" style="width:150px; height:70px;"/></div>
							<div class="col-sm-10">
								<h4 class="nomargin">${cartLine.product.name}
									<c:if test="${cartLine.available == false}">
										<strong class="unavailable">(Not Available)</strong>
									</c:if>
								</h4>
								<p>${cartLine.product.description}</p>
							</div>
						</div>
					</td>
					<td data-th="Price">${cartLine.buyingPrice}</td>
					<td data-th="Quantity">
						<input type="number" id="count_${cartLine.id}" class="form-control text-center" value="${cartLine.productCount}" min="1" max="3" />
					</td>
					<td data-th="Subtotal" class="text-center">&#8377; ${cartLine.total}/-</td>
					<td class="actions" data-th="">
						<c:if test="${cartLine.available == true}">
							<button type="button" name="refreshCart" class="btn btn-info btn-sm" value="${cartLine.id}"><span class="glyphicon glyphicon-refresh"></span></button>
						</c:if>		
						<a href="${contextRoot}/cart/${cartLine.id}/delete" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span></a>													
					</td>
				</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr class="visible-xs">
					<td class="text-center"><strong>Total ${userModel.cart.grandTotal}</strong></td>
				</tr>
				<tr>
					<td><a href="#" class="btn btn-warning"><span class="glyphicon glyphicon-chevron-left"></span> Continue Shopping</a></td>
					<td colspan="2" class="hidden-xs"></td>
					<td class="hidden-xs text-center"><strong>Total ${userModel.cart.grandTotal}</strong></td>
					<td><a href="#" class="btn btn-success btn-block">Checkout <span class="glyphicon glyphicon-chevron-right"></span></a></td>
				</tr>
			</tfoot>
		</table>

		</c:when>
		
		<c:otherwise>
			<div class="jumbotron">
				<div class="text-center">
					<h1> Your cart is empty ! </h1>
				</div>
			</div>
		
		</c:otherwise>
	</c:choose>
	</div>

<!-- Cart Page Area End -->

<!-- <script type="text/javascript">

function myFunction() 
{
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
}

</script> -->

<!-- <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

 -->