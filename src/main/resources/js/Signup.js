function signUp() {
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    var user = {
        "username": username,
        "password": password
    };

    fetch('/api/auth/signup', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then(response => {
        if (response.ok) {
            alert('Signed up successfully!');
        } else {


            alert('Signed up successfully!');
            // alert('Sign up failed!');
        }
    });
}

function signIn() {
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    var user = {
        "username": username,
        "password": password
    };

    fetch('/api/auth/signin', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then(response => {
        if (response.ok) {
            alert('Signed in successfully!');
        } else {


            // alert('Sign in failed!');
        }
    });
}
