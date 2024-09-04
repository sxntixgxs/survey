function getFormData(){
    const username = document.getElementById("username").value;
    const prePassword = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirmPassword").value;
    let password = "";
    if (prePassword === confirmPassword) {
        password = confirmPassword;
        const formData = {
            "username": username,
            "password": password,
            "role":"USER"
        }
        return JSON.stringify(formData); // le agregué esto
    }else{
        badPassword();
        return null;
    }
}