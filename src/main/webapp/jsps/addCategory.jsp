<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="tagLibs.jsp"%>
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
<title>Ap-Shop : Ajouter une catégorie</title>
</head>
<body>
	<%@ include file="header.jsp"%>
		<div id="bannerForm" class="col-8">
			<form:form servletRelativeAction="/addNewCategory"
				modelAttribute="category" acceptCharset="utf-8" class="col-8">
				<h2>Ajoutez une catégorie</h2>
				<div>
					<label for ="name" class="col-12">Name</label>
					<form:input path="name"></form:input>
				</div>
				<div>
					<label for="description" class="col-12">Description</label>
					<form:input path="description"></form:input>
				</div>
				<div id="btn_submit" class="col-12">
					<button class="col-6" type="submit">Ajouter une catégorie</button>
				</div>
			</form:form>
		</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>