// Function to upload a file to S3 and return the file URL
async function uploadFileToS3(file, fileName) {
    const formData = new FormData();
    formData.append('file', file);
    formData.append('fileName', fileName);

    const response = await fetch('http://localhost:8080/api/upload', {
        method: 'POST',
        body: formData
    });

    const result = await response.json();
    return result.fileUrl; // AWS S3 URL for the uploaded file
}

// Function to handle form submission
async function submitForm() {
    const formData = new FormData();
    const curriculumFile = document.getElementById('curriculumFile').files[0];
    const supportingDoc = document.getElementById('supportingDoc').files[0];
    const institutionalData = document.getElementById('institutionalData').files[0];

    // Upload files to S3 and get URLs
    const curriculumFileUrl = await uploadFileToS3(curriculumFile, curriculumFile.name);
    const supportingDocUrl = await uploadFileToS3(supportingDoc, supportingDoc.name);
    const institutionalDataUrl = await uploadFileToS3(institutionalData, institutionalData.name);

    // Add form fields to FormData
    formData.append('curriculumDesc', document.getElementById('curriculumDesc').value);
    formData.append('curriculumFileUrl', curriculumFileUrl);
    formData.append('supportingDocUrl', supportingDocUrl);
    formData.append('institutionalDataUrl', institutionalDataUrl);
    formData.append('revisionPercentage', document.getElementById('revisionPercentage').value);
    formData.append('revisedPrograms', document.getElementById('revisedPrograms').value);
    formData.append('totalPrograms', document.getElementById('totalPrograms').value);

    // Log to verify the data before sending it
    console.log("Sending data to backend:", formData);

    // Submit the form data to the backend for PDF generation
    fetch('http://localhost:8080/api/ssr/generate', {
        method: 'POST',
        body: formData
    })
    .then(response => response.blob())
    .then(blob => {
        const link = document.createElement('a');
        link.href = URL.createObjectURL(blob);
        link.download = 'SelfStudyReport.pdf';
        link.click();
    })
    .catch(error => {
        console.error('Error generating PDF:', error);
        alert('An error occurred while generating the PDF.');
    });
}
