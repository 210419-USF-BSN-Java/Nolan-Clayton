document.getElementById("home-btn").addEventListener("click", homeRedirect);
document.getElementById("pending-btn").addEventListener("click", pendingRedirect);
document.getElementById("resolved-btn").addEventListener("click", resolvedRedirect);
document.getElementById("employees-btn").addEventListener("click", employeesRedirect);
document.getElementById("logout-btn").addEventListener("click", logout);


let apiURL = 'http://localhost:8080/Project1/managerResolved';

let xhr = new XMLHttpRequest();
xhr.onreadystatechange = receiveData;
xhr.open('GET', apiURL);
xhr.send();

function receiveData() {

    if (xhr.readyState === 4) {
        if (xhr.status >= 200 && xhr.status < 300) {
            let response = xhr.responseText;
            response = JSON.parse(response);
            populateData(response);
        }
    }
}

function populateData(response){

    let pendingList = document.getElementById('request-list');

    for (var i = 0; i < response.length; i++) {
        var request = response[i];
        let requestLi = document.createElement('li');

        requestLi.className = "list-group-item";
        requestLi.id = `list-item-${request.id}`;
        requestLi.innerHTML = `<b>Resolver Username:</b> ${request.resolver.username} <b>Author:</b> ${request.author.username}  
        <b>Name:</b> ${request.author.firstName} ${request.author.lastName} 
        <b>Amount:</b> ${request.amount} <b>Submitted:</b> ${request.submitted[1]}/${request.submitted[2]}/${request.submitted[0]} 
        <b>Resolved:</b> ${request.resolved[1]}/${request.resolved[2]}/${request.resolved[0]} 
        <b>Description:</b> ${request.description} <b>Type:</b> ${request.reimbType.type} <b>Status:</b> ${request.reimbStatus.status}`;

        pendingList.appendChild(requestLi);
        
    }

}


function homeRedirect(){
    window.location.href="http://localhost:8080/Project1/static/managerHome.html"
}

function pendingRedirect(){
    window.location.href="http://localhost:8080/Project1/static/managerPending.html"
}

function resolvedRedirect(){
    window.location.href="http://localhost:8080/Project1/static/managerResolved.html"
}

function employeesRedirect(){
    window.location.href="http://localhost:8080/Project1/static/managerEmployees.html"
}

function logout(){
    sessionStorage.removeItem('token');
    window.location.href="http://localhost:8080/Project1/"
}