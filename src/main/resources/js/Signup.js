

function signUp() {
    // Get form data
    var fullName = document.getElementById('full-name').value;
    var email = document.getElementById('email').value;
    var gender = document.querySelector('input[name="gender"]:checked').value;
    var nic = document.getElementById('nic').value;
    var birthday = document.getElementById('birthday').value;
    var healthHistory = document.getElementById('health-history').value;
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    // Create JSON object with form data
    var patientDTO = {
        fullName: fullName,
        email: email,
        gender: gender,
        nic: nic,
        birthday: birthday,
        healthHistory: healthHistory,
        username: username,
        password: password
    };

    // Send AJAX POST request to register patient
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8083/api/patients/register');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function() {
        if (xhr.status === 201) {
            // Registration successful
            alert('Patient registered successfully!');
            window.location.href = 'login.html';
        } else {
            // Registration failed
            alert('Failed to register patient. Please try again.');
        }
    };
    xhr.send(JSON.stringify(patientDTO));
}

