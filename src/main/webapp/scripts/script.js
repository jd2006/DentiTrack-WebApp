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

// Function to fetch doctor names
function fetchDoctors() {
	const url = "/DentiTrack-WebApp/GetDoctorsServlet";
	
	fetch(url)
	.then(response =>{
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
		
		doctorSelect.disabled = false; //Enable dropdown
	})
	.catch(error => console.error('Error fetching doctors:',error));
}

// Set the default date and restrict mindate and max date
// TODO: Need to recheck

document.addEventListener("DOMContentLoaded", function() {
	const dateInput = document.getElementById("date");

	// Set the minimum date to today
	const today = new Date().toISOString().split('T')[0];
	dateInput.min = today;

	// Set the maximum date to one month ahead
	const maxDate = new Date();
	maxDate.setMonth(maxDate.getMonth() + 1);
	dateInput.max = maxDate.toISOString().split('T')[0];
});

// Function to fetch available time slots
function fetchAvailableTimeSlots(){
	const selectedDate = document.getElementById('appointmentDate').value;
//	const url = `GetTimeSlotsServlet?date=${selectedDate}`;



//method2
//	const url = "GetTimeSlotsServlet?date=" + selectedDate;
const urlParams = new URLSearchParams({
  date: selectedDate
});

// Append the query string to the servlet URL
const baseUrl = "/DentiTrack-WebApp/GetTimeSlotsServlet";
const url = `${baseUrl}?${urlParams.toString()}`;

fetch(url)
  // ... rest of the fetch code
	

	//fetch(url)
	.then(response => {
	    if (!response.ok) {
	      throw new Error(`HTTP error! status: ${response.status}`);
	    }
	    return response.json();
	  })
		.then(data => {
			const timeSlotsContainer = document.getElementById('timeSlotsContainer');
			timeSlotsContainer.innerHTML = ''; //clear previous content
			
			data.forEach(slot => {
				// Create a container for each radio button and label
				const container = document.createElement('div');
				container.classList.add('time-slot-container');
				
				const radioBtn = document.createElement('input');
				radioBtn.type = 'radio';
				radioBtn.name = 'timeSlot';
				radioBtn.value = slot.time; 
				
				const label = document.createElement('label');
				label.textContent = slot.time; // Display the time slot
				
				timeSlotsContainer.appendChild(radioBtn);
				timeSlotsContainer.appendChild(label);
				timeSlotsContainer.appendChild(container);		
			});
			
			// Create a "Confirm Appointment" button
			const confirmButton = document.createElement('button');
			confirmButton.type = 'button';
			confirmButton.textContent = 'Confirm Appointment';
			confirmButton.addEventListener('click', confirmAppointment);

			// Append the button to the timeSlotsContainer
			timeSlotsContainer.appendChild(confirmButton);
			
		})
		.catch(error => console.error('Error fetching time slots:',error));
		
		
	
}

function testJSLoad() {
    alert('JavaScript is working!');
}

// Confirm Appointment
function confirmAppointment(){
	const selectedTimeSlot = document.querySelector('input[name="timeSlot"]:checked');
	            if (selectedTimeSlot) {
	                const selectedTime = selectedTimeSlot.value;
	                alert(`Appointment confirmed for ${selectedTime}`);
	                // Add logic here to proceed with appointment booking
	            } else {
	                alert('Please select a time slot to confirm your appointment.');
	            }
}


// to include a function to fetch doctor names when the page loads
document.addEventListener('DOMContentLoaded', ()=>{
	fetchDoctors();
});



