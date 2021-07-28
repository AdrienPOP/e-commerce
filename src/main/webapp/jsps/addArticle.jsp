<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<form:form servletRelativeAction="/addArticle"
			modelAttribute="article" acceptCharset="utf-8">
			<h2>Ajoutez un article</h2>
			<p>
				<label>Name</label>
				<form:input path="name"></form:input>
			</p>
			<p>
				<label>Description</label>
				<form:input path="description"></form:input>
			</p>
			<p>
				<label>Formation</label>
				<form:select path="category">
					<form:option value="" label="--Selectionnez votre catégorie--"></form:option>
					<form:options items="${categories}" itemValue="id" itemLabel="name"></form:options>
				</form:select>
			</p>

			<button type="submit">Créer l'article</button>
		</form:form>
	</div>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>