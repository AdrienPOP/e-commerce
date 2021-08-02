"use strict";
let menuOpen = false;
function clickCategory(){
	let firstA = document.getElementsByClassName("firtA");
	let menuCat = document.getElementById("menuCategory")
	let body = document.querySelector("body");
	for (let a of firstA){
		a.addEventListener("click", (e) => {
			e.preventDefault();
			if(!menuOpen){
				menuCat.style.display="flex";
				a.innerHTML = "&#10007;"
				menuOpen = true;
			} else {
				menuCat.style.display="none";
				a.innerHTML = "&#x2630; Catégories";
				menuOpen = false;
			}
			console.log(menuOpen);
		});	
	}
}
clickCategory(); 