function addTechnician() {
    // Get form data

        var name = document.getElementById('name').value;
        var username = document.getElementById('username').value;
        var password = document.getElementById('password').value;

        // Create an object to send to the server
        var technicianData = {
            name: name,
            username: username,
            password: password
        };

        // Make a POST request to the server
        fetch('http://localhost:8083/technicians', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(technicianData)
        })
            .then(response => {
                if (response.ok) {
                    // Registration successful, handle response
                    alert('Technician registered successfully!');
                } else {
                    // Registration failed, handle error
                    alert('Technician registered successfully!');
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }

