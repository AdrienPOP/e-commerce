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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Ap-Shop Register</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="bannerForm" class="col-8">
		<form:form servletRelativeAction="/registerUser" modelAttribute="user"
			acceptCharset="utf-8" class="col-8">
			<h2>Créer mon compte</h2>
			<div>
				<label for="username" class="col-12">Pseudo</label>
				<form:input path="username"/>
			</div>
			<div>
				<label for="password" class="col-12">Mot de passe</label>
				<form:input path="password" type="password"/>
			</div>
			<div>
				<label for="email" class="col-12">Email</label>
				<form:input path="email"></form:input>
			</div>

			<div id="btn_submit" class="col-12">
				<button class="col-6" type="submit">Créer mon compte</button>
			</div>
		</form:form>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>