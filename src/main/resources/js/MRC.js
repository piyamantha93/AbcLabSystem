
function Upload() {
    var patientId = $('#patientId').val();
    var reportDate = $('#reportDate').val();
    var formData = new FormData();
    formData.append('patientId', patientId);
    formData.append('reportDate', reportDate);
    formData.append('file', $('#fileInput')[0].files[0]); // Assuming you want to upload a single file

    $.ajax({
        method: "POST",
        url: 'http://localhost:8083/medicalReports/upload',
        processData: false,
        contentType: false,
        data: formData,
        success: function (data) {
            if (data) {
                alert("Upload successful!"); // Display success message
                // You can redirect or perform any further actions here
            } else {
                alert("Upload failed!"); // Display error message
            }
        },
        error: function (xhr, status, error) {
            console.log(xhr);
            console.log(status);
            console.log(error);
            alert("An error occurred");
        }
    });
}

