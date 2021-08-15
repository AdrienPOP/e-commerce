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
<title>Ap-Shop : Mot de passe oublié</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="bannerForm" class="col-8">
		<form:form servletRelativeAction="/forgotPassword" modelAttribute="user"
			acceptCharset="utf-8" class="col-8">
			<h2>Mot de passe oublié</h2>
			<div>
				<label for="email" class="col-12">Email</label>
				<form:input path="email"></form:input>
			</div>
			<div id="btn_submit" class="col-12">
				<button class="col-6" type="submit">Changez le mot de passe</button>
			</div>
		</form:form>
	</div>
</body>
</html>