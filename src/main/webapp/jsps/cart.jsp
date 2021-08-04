<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ap_commerce.engine.entities.Article"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Ap-Shop Mon panier</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="bannerapp" class="col-12">
		<div id="cart" class="col-6">
			<table>
				<thead>
					<tr>
						<th colspan="4">Votre panier</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Nom de l'article</td>
						<td>Quantité</td>
						<td>Prix unitaire</td>
						<td>Prix total</td>
					</tr>
					<c:forEach items="${articles}" var="article">
						<tr>
							<td>${article.name}</td>
							<td>${article.quantity}</td>
							<td>${article.price}</td>
							<td>${article.price *article.quantity}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="3">Total à payer</td>
						<td></td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/script.js"></script>
</html>