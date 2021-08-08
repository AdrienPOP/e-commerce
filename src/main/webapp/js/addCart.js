"use strict"

function getRequest() {
	var request;
	if (window.XMLHttpRequest) {
		request = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
	} else {
		request = false;
	}
	return request;
};

function sendRequest(method, url, action, parameter = "") {
	let request = getRequest();
	request.overrideMimeType("test/json");

	request.open(method, url);
	request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	request.send(parameter);

	request.onreadystatechange = () => {

		if (request.readyState == 4 && request.status == 200) {
			action(request.responseText);
		}
	};
};

let openModalWindowSuccess = (jsonString) => {
	let article = JSON.parse(jsonString);
	console.log(article);
	let html = "";
	html += "<h3>" + article.name + "</h3>" + '<img alt="" src="https://via.placeholder.com/300x200">' + '<div class="col-12"><a id="btnClose" href="#">&#10007</a></div>';
	
	document.getElementById("modalWindowSucess").style.display="flex";
	document.getElementById("articleAddInCart").innerHTML = html;
	closeModalWindowSuccess();
};

function closeModalWindowSuccess(){
	let btnClose = document.getElementById("btnClose");
	btnClose.addEventListener("click", (e) => {
		document.getElementById("modalWindowSucess").style.display="none";
	});
};

function clickToCart(){
	let arts = document.getElementsByClassName("addArtOnCarts");
	
	for (let art of arts){
		art.addEventListener("click", (e) => {
			e.preventDefault();
			sendRequest("GET", "addArticleOnCart?idArticle=" + art.search.substring(1), openModalWindowSuccess);  
		})
	}
};

clickToCart();

