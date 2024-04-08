function getAppointmentHistoryByPatient(patientId) {
    const url = `/api/v1/appointment/patient/${patientId}/history`;

    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            if (data.code === VarList.RSP_SUCCESS) {
                updateAppointmentTable(data.content); // Pass the appointment data
            } else {
                displayError(data.message);
            }
        })
        .catch(error => {
            console.error('Error fetching appointment history:', error);
            displayError('An error occurred while fetching appointments.');
        });
}

function updateAppointmentTable(appointments) {
    const tableBody = document.querySelector('table tbody');
    tableBody.innerHTML = ''; // Clear existing rows

    appointments.forEach(appointment => {
        const row = tableBody.insertRow();
        row.insertCell().textContent = appointment.patientId;
        row.insertCell().textContent = appointment.date;
        row.insertCell().textContent = appointment.testType;

        // Add status with appropriate styling (e.g., different colors)
        const statusCell = row.insertCell();
        statusCell.textContent = appointment.status;  // Assuming you have a 'status' field
        statusCell.classList.add(appointment.status.toLowerCase());
    });
}

function displayError(message) {
    // Implement error display logic (e.g., show an error message)
    console.error(message);
}

// Example usage - get history when needed
const patientId = 100;
getAppointmentHistoryByPatient(patientId);
