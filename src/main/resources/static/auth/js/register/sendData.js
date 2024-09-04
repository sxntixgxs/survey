function sendData(data){
    fetch('http://localhost:8080/auth/register',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: data
    })
    .then(response => response.json())
    .then(data=> console.log('perfect ', data))
    .catch(error=> console.log('error ',error))
}