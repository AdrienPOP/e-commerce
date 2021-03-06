<%@ include file="tagLibs.jsp"%>
<%@ page import="com.ap_commerce.engine.entities.Category"%>

<header class="col-12">
	<div id="navSticky" class="col-12">
		<ul class="col-12 col-lg-7">
			<li><a href="Cart">Mon panier</a></li>
			<sec:authorize access="isAuthenticated()"><li><a href="">Mon Compte</a></li></sec:authorize>
			<sec:authorize access="!isAuthenticated()"><li><a href="login">S'identifier</a></li></sec:authorize>
			<sec:authorize access="isAuthenticated()"><form:form servletRelativeAction="/logout"><button id="logout" type="submit">Se déconnecter</button></form:form></sec:authorize>
		</ul>
		<!-- <a href="logout">Se déconnecter</a></li> -->
	</div>
	<div id="banner" class="col-12">
		<div id="logo" class="col-12 col-lg-2">
			<h1>
				<a href="home">Ap-Shop</a>
			</h1>
			<h2>Vêtements & équipement outdoor</h2>
		</div>
		<form method>
			<label for="" hidden></label> <select>
				<option value="allCategory">Toutes les catégories</option>
				<c:forEach items="${categories}" var="cat">
					<option value="${cat.id }">${cat.name}</option>
				</c:forEach>
			</select>
			<div>
				<button type="submit">Cherchez</button>
			</div>
		</form>
	</div>
	</div>
	<div id="navBar" class="col-12">
		<nav class="col-12">
			<ul class="col-4">
				<li class="col-12"><a class="col-6 firtA" href="#">&#x2630;
						Catégories</a></li>
			</ul>
			<ul class="col-6">

				<li><a href="home">Accueil</a></li>
				<li><a href="">Produits</a></li>
				<li><a href="">Offre du moment</a></li>
				<li><a href="">Contactez-nous</a></li>
			</ul>
		</nav>
	</div>
	<div id="categoryBar">
		<div id="menuCategory" class="col-lg-12">
			<nav class="col-12">
				<ul>
					<c:forEach items="${categories}" var="cat">
						<li class="col-12"><a href="category?category=${cat.id}">${cat.name}</a></li>
					</c:forEach>
				</ul>
			</nav>
		</div>
	</div>

</header>

