function adminLogin() {
    // Get form data
    var username = document.getElementById('loginUsername').value;
    var password = document.getElementById('loginPassword').value;

    // Send AJAX POST request to login
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8083/adminLogin?username=' + username + '&password=' + password);
    xhr.onload = function() {
        if (xhr.status === 200) {
            // Login successful
            alert('Login successful!');
            window.location.href = 'patientpanel'; // Redirect to patient panel

        } else {
            // Login failed
            alert('Login failed. Please check your username and password.');
        }
    };
    xhr.send();
}