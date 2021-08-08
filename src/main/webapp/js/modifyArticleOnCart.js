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

function clickToModify(){
	let quantities = document.getElementsByClassName("quantity");
	
	
	for (let quantity of quantities){
		quantity.addEventListener("change", (e) => {
			console.log("test"); 
			sendRequest("GET", "modifyQuantity?idArticle=2&quantity=" )
		})
	}
};
clickToModify();