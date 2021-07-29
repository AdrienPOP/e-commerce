<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Ap-Shop Login</title>
</head>
<body>
	<%@ include file="header.jsp"%>
		<div id="bannerForm" class="col-8">
			<form action="" method="POST" class="col-8">
				<div class="col-12">
					<label class="col-12" for="login">Identifiant</label> <input
						type="text" name="login" id="login" required>
				</div>
				<div class="col-12">
					<label class="col-12" for="password">Mot de passe</label> <input
						type="password" name="password" id="password" required>
				</div>

				<div id="btn_submit" class="col-12">
					<button class="col-6" type="submit">Se connecter</button>
				</div>
				<div class="col-8 mdp">
					<a id="newAccount"
						href=""
						class="col-6">Créer un compte</a>
					<a href="#" class="col-6">Mot de passe oublié</a>
				</div>
			</form>
		</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>