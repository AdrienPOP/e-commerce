<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="css/style.css">
<title>Ap-Shop</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="bannerapp">
		<form:form servletRelativeAction="/addCategory"
			modelAttribute="category" acceptCharset="utf-8">
			<h2>Ajoutez une catégorie</h2>
			<p>
				<label>Name</label>
				<form:input path="name"></form:input>
			</p>
			<p>
				<label>Description</label>
				<form:input path="description"></form:input>
			</p>
			<button type="submit">Créer la catégorie</button>
		</form:form>
		<script type="text/javascript" src="js/script.js"></script>
</body>
</html>