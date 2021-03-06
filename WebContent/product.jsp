<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Product details - Progetto SIW</title>
	<jsp:include page="import.jsp" />
</head>
<body>
<jsp:include page="header.jsp" />
<f:view>
	<div class="item">
		<div class="col-sm-12">
			<h1><span>product</span>details</h1>
		</div>
	</div> 
	<div class="col-sm-12">
		<div class="product-information"><!--/product-information-->
			<h2>${productController.product.name}</h2>
			<p>Code: ${productController.product.code}</p>
			<span>
				<span>${productController.product.price}&euro;</span>
				<c:if test="${customerController.customer!=null}">
				<c:if test="${orderController.currentOrder!=null}">
					<label>Quantity:</label>
					<h:form>
						<h:inputText value="#{orderController.quantity}" 
                    		 required="true"
                    		 requiredMessage="quantity is mandatory"
                  	 			id="quantity"/> <h:message for="quantity" />
            			<div class="btn btn-default add-to-cart">
            				<p>
            					<i class="fa fa-shopping-cart"></i>
            				 	<h:commandButton value="Add" action="#{orderController.addOrderLine}">
            						<f:param name="productCode" value="#{productController.product.code}" />
            					</h:commandButton>
            				</p>
            			</div>
            		</h:form>
				</c:if>
				</c:if>
				<p><b>Description:</b></p>
				<p>${productController.product.description}</p>
			</span>
		<h:form>
			<h:commandLink styleClass="btn btn-default" action="#{productController.listProducts}"
						value="Back to products list" />
		</h:form>
		</div><!--/product-information-->
	</div>
</f:view>
<jsp:include page="footer.jsp" />