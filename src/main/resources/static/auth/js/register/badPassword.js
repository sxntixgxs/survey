function badPassword(){
    const passwordInput = document.getElementById('password');
    const confirmPasswordInput = document.getElementById('confirmPassword');

    passwordInput.classList.add('border-red-500');
    confirmPasswordInput.classList.add('border-red-500');

    
    if(!document.getElementById('errorMessage')){
        const errorMessage = document.createElement('span');
        errorMessage.id = 'errorMessage';
        errorMessage.classList.add('text-red-500');
        errorMessage.textContent = 'Passwords do not match!';
        confirmPasswordInput.parentElement.appendChild(errorMessage);
    }
}