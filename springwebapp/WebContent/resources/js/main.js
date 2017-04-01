/**
 * 
 */
window.onload= function (){
	
	var confirms = document.querySelectorAll(".confirm");
	for(var i in confirms){
		if(confirms[i].addEventListener)
			confirms[i].addEventListener("click",clickConfirm);		
	}
}


function clickConfirm(e){
	 !confirm("ok ?") && e.preventDefault();
}