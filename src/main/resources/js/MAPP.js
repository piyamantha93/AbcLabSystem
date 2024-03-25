// function saveAppointment(){
//     let patientId = $('#patientId').val();
//     let name = $('#name').val();
//     let email = $('#email').val();
//     let testType = $('#testType').val();
//     let date = $('#date').val();
//
//
//
//     $.ajax({
//         method: "post",
//         contentType: "application/json",
//         url: "http://localhost:8083/api/v1/appointment/saveAppointment",
//         async:true,
//         date:JSON.stringify({
//             "patientId": patientId,
//             "name": name,
//             "email": email,
//             "testType": testType,
//             "date": date
//         }),
//             success: function (data) {
//         if (data) {
//             alert("Upload successful!"); // Display success message
//             // You can redirect or perform any further actions here
//         } else {
//             alert("Upload failed!"); // Display error message
//         }
//     },
//     error: function (xhr, status, error) {
//         console.log(xhr);
//         console.log(status);
//         console.log(error);
//         alert("An error occurred");
//     }
//     });
// }
function saveAppointment() {
    let patientId = $('#patientId').val();
    let name = $('#name').val();
    let email = $('#email').val();
    let testType = $('#testType').val();
    let date = $('#date').val();

    $.ajax({
        method: "post",
        contentType: "application/json",
        url: "http://localhost:8083/api/v1/appointment/saveAppointment",
        async: true,
        data: JSON.stringify({
            "patientId": patientId,
            "name": name,
            "email": email,
            "testType": testType,
            "date": date
        }),
        success: function(data) {
            if (data) {
                alert("Upload successful!"); // Display success message
                // You can redirect or perform any further actions here
            } else {
                alert("Upload failed!"); // Display error message
            }
        },
        error: function(xhr, status, error) {
            console.log(xhr);
            console.log(status);
            console.log(error);
            alert("An error occurred");
        }
    });
}
