// Global variables to store login status
let loggedIn = false;
let userType = null;

document.addEventListener('DOMContentLoaded', function() {
    // Initial login status check
    checkLoginStatus().then(() => {
        if (loggedIn) {
            console.log('Logged In');
        } else {
            console.log('Not Logged In');
        }
    }).catch(error =>{
		console.error('Error during initial login status check:', error);
	});
    // Fetch doctors when the page loads
    fetchDoctors();
});

// Check login status and set global variables
function checkLoginStatus() {
    return fetch('/DentiTrack-WebApp/CheckLoginStatusServlet', {
        method: 'GET',
        credentials: 'include'
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        if (data.loggedIn) {
            loggedIn = true;
            userType = data.userType;
        } else {
            loggedIn = false;
            userType = null;
        }
    })
    .catch(error => console.error('Error checking login status:', error));
}

// Form validation for login
const form = document.getElementById("form");
const username = document.getElementById("username");
const password = document.getElementById("password");

form.addEventListener('submit', e => {
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

    if (usernameValue === '') {
        setError(username, "Username required");
        isValid = false;
    } else {
        setSuccess(username);
    }

    if (passwordValue === '') {
        setError(password, "Password required");
        isValid = false;
    } else {
        setSuccess(password);
    }

    return isValid;
}

// Fetch doctor names
function fetchDoctors() {
    const url = "/DentiTrack-WebApp/GetDoctorsServlet";
    fetch(url)
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        const doctorSelect = document.getElementById('doctorname');
        doctorSelect.innerHTML = ''; // Clear previous options
        data.forEach(doctor => {
            const option = document.createElement('option');
            option.value = doctor.userId;
            option.textContent = `${doctor.firstName} ${doctor.lastName}`;
            doctorSelect.appendChild(option);
        });
        doctorSelect.disabled = false; // Enable dropdown
    })
    .catch(error => console.error('Error fetching doctors:', error));
}

// Fetch available time slots
function fetchAvailableTimeSlots() {
    const selectedDate = document.getElementById('appointmentDate').value;
    const urlParams = new URLSearchParams({ date: selectedDate });
    const baseUrl = "/DentiTrack-WebApp/GetTimeSlotsServlet";
    const url = `${baseUrl}?${urlParams.toString()}`;

    fetch(url)
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        const timeSlotsContainer = document.getElementById('timeSlotsContainer');
        timeSlotsContainer.innerHTML = ''; // Clear previous content

        data.forEach(slot => {
            const container = document.createElement('div');
            container.classList.add('time-slot-container');

            const radioBtn = document.createElement('input');
            radioBtn.type = 'radio';
            radioBtn.name = 'timeSlot';
            radioBtn.value = slot.time;

            const label = document.createElement('label');
            label.textContent = slot.time; // Display the time slot

            container.appendChild(radioBtn);
            container.appendChild(label);
            timeSlotsContainer.appendChild(container);
        });

        // Create a "Confirm Appointment" button
        const confirmButton = document.createElement('button');
        confirmButton.type = 'button';
        confirmButton.textContent = 'Confirm Appointment';
        confirmButton.addEventListener('click', function() {
            confirmAppointment();
        });
        timeSlotsContainer.appendChild(confirmButton);
    })
    .catch(error => console.error('Error fetching time slots:', error));
}

// Confirm appointment
function confirmAppointment() {
    if (!loggedIn) {
        alert("You need to be signed in to confirm an appointment. Please sign in or sign up.");
        window.location.href = "/DentiTrack-WebApp/login.html";
    } else {
        alert("Appointment confirmed!");
        // Proceed with appointment confirmation logic here
    }
}

// Calculate age from date of birth
const dobInput = document.getElementById('dob');
const ageInput = document.getElementById('age');

dobInput.addEventListener('change', () => {
    const dob = new Date(dobInput.value);
    const today = new Date();
    let age = today.getFullYear() - dob.getFullYear();
    const monthDiff = today.getMonth() - dob.getMonth();
    const dayDiff = today.getDate() - dob.getDate();

    if (monthDiff < 0 || (monthDiff === 0 && dayDiff < 0)) {
        age--;
    }
    ageInput.value = age;
});

// Test JavaScript load
function testJSLoad() {
    alert('JavaScript is working!');
}
