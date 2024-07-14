document.addEventListener('DOMContentLoaded', function() {
    const logoutLink = document.getElementById('logoutLink');

    logoutLink.addEventListener('click', function(event) {
        event.preventDefault(); // Prevent the default link behavior

        // Send a request to the LogoutServlet
        fetch('/DentiTrack-WebApp/LogoutServlet', {
            method: 'GET',
            credentials: 'include'
        })
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            // Clear any client-side session storage if used
            sessionStorage.clear();
            localStorage.clear();
            // Redirect to the login page
            window.location.href = '/DentiTrack-WebApp/login.html';
        })
        .catch(error => console.error('Error during logout:', error));
    });
});
