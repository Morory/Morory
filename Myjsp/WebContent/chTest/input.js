function writeSave() {
	let inputform = document.inputform;
	
	if(!inputform.code.value) {
		alert("코드를 입력하십시요.");
		inputform.code.focus();
		return false;
	}
	
	if(!inputform.name.value) {
		alert("성명을 입력하십시요.");
		inputform.name.focus();
		return false;
	}
	
	if(!inputform.score.value) {
		alert("점수를 입력하십시요.");
		inputform.score.focus();
		return false;
	}
}