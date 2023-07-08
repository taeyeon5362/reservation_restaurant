function open_win(url, name) {

	window.open(url, name, "width=500, height=230");

}   //url로 가서 창만들어라



function passCheck() {

	if (document.frm.pass.value.length == 0) {

		alert("비밀번호를 입력하세요.");

		return false;

	}

	return true;

}
