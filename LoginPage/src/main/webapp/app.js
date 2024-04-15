let eye = document.querySelector(".fa-eye-slash");
let password = document.querySelector(".passwordss");

eye.addEventListener("click", () => {
    if (password.type === "password") {
        password.type = "text";
eye.classList.toggle("fa-eye")
    } else {
        password.type = "password";
       eye.classList.toggle("fa-eye")
    }
});
document.getElementById("signupForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent form submission if validation fails
    
    let inputs = document.querySelectorAll("input");
    let isValid = true;
    
    // Check each input field for validity
    inputs.forEach(input => {
        if (!input.checkValidity()) {
            isValid = false;
            alert(input.validationMessage);
        }
    });
    
    // If all fields are valid, you can submit the form here
    if (isValid) {
        console.log("Form submitted successfully");
        // Uncomment the line below if you want to submit the form programmatically
        // event.target.submit();
    }
});