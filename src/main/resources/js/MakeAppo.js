function saveAppointment() {
    // Get form data
    var patientId = document.getElementById('patientId').value;
    var name = document.getElementById('name').value;
    var email = document.getElementById('email').value;
    var testType = document.getElementById('testType').value;
    var date = document.getElementById('date').value;

    // Create JSON object with form data
    var appointmentDTO = {
        patientId: patientId,
        name: name,
        email: email,
        testType: testType,
        date: date
    };

    // Send AJAX POST request to save appointment
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8083/api/v1/appointment/saveAppointment');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function() {
        if (xhr.status === 202) {
            // Appointment saved successfully
            alert('Appointment made successfully!');
            window.location.href = 'patientpanel.html';
            // Redirect or perform desired action
        } else if (xhr.status === 400) {
            // Appointment already exists
            alert('Appointment already exists. Please choose another date.');
        } else {
            // Error saving appointment
            alert('Failed to make appointment. Please try again.');
        }
    };
    xhr.send(JSON.stringify(appointmentDTO));
}
