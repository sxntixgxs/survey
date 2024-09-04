

document.getElementById('registerFormButton').addEventListener('click', function(e){
    e.preventDefault();

    const data = getFormData();
    if(data!=null){
        sendData(data);
    }
});