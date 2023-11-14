function validateForm() {
	let username = document.getElementById("Username").value;
	let email = document.getElementById("E-mail").value;
	let password = document.getElementById("Password").value;
	let reenterPassword = document.getElementById("Re-enter-password").value;

	if (username === "" || email === "" || password === "" || reenterPassword === "") {
		alert("Hãy điền đủ các thông tin!");
		return false;
	}

	return true;
}