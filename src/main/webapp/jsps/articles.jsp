<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.ap_commerce.engine.entities.Category" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<title>Ap-Shop Articles</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="bannerapp" class="col-12">
		<div id="bannerArt">
			<c:forEach items="${articles}" var="article">
				<div class="art col-3">
					<h3>${article.name}</h3>
					<img alt="" src="https://via.placeholder.com/300x200">
					<div class="btn_art col-12">
						<a class="col-4 addArtOnCarts" href="?${article.id}">Ajouter au panier</a>
						<a class="col-4">Voir le produit</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/addCart.js"></script>
</body>
</html>