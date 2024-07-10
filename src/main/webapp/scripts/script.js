//login Form

const form = document.getElementById("form");
const username = document.getElementById("username");
const password = document.getElementById("password");

form.addEventListener('submit', e => {
	//    e.preventDefault();
	const isValid = validateInputs();
	if (!isValid) {
		e.preventDefault();
	}
});

const setError = (element, message) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = message;
    inputControl.classList.add('error');
    inputControl.classList.remove('success');
}

const setSuccess = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = '';
    inputControl.classList.add('success');
    inputControl.classList.remove('error');
}

const validateInputs = () => {
    const usernameValue = username.value.trim();
    const passwordValue = password.value.trim();
	let isValid = true;

    if(usernameValue === ''){
        setError(username, "Username required");
		isValid = false;
    } else{
        setSuccess(username);
    }

    if(passwordValue === ''){
        setError(password, "Password required");
		isValid = false;
    } else{
        setSuccess(password);
    }
	
	return isValid;
}