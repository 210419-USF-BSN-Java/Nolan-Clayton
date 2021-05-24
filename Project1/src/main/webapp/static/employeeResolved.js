document.getElementById("profile-btn").addEventListener("click", profileRedirect);
document.getElementById("home-btn").addEventListener("click", homeRedirect);
document.getElementById("logout-btn").addEventListener("click", logout);
document.getElementById("request-btn").addEventListener("click", requestRedirect);
document.getElementById("pending-request-btn").addEventListener("click", pendingRequestRedirect);
document.getElementById("resolved-request-btn").addEventListener("click", resolvedRequestRedirect);

let apiURL = 'http://localhost:8080/Project1/employeeResolved/'

let token = sessionStorage.getItem("token");
let tokenArr = token.split(":");

let userIDToken = tokenArr[0];

let xhr = new XMLHttpRequest();
xhr.onreadystatechange = receiveData;
xhr.open('GET', `${apiURL}${userIDToken}`);
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
        requestLi.className = "list-group-item"
        requestLi.innerHTML = `<b>Resolver Username:</b> ${request.resolver.username} <b>Author:</b> ${request.author.username}  
        <b>Name:</b> ${request.author.firstName} ${request.author.lastName} 
        <b>Amount:</b> ${request.amount} <b>Submitted:</b> ${request.submitted[1]}/${request.submitted[2]}/${request.submitted[0]} 
        <b>Resolved:</b> ${request.resolved[1]}/${request.resolved[2]}/${request.resolved[0]} 
        <b>Description:</b> ${request.description} <b>Type:</b> ${request.reimbType.type} <b>Status:</b> ${request.reimbStatus.status}`;
        pendingList.appendChild(requestLi);
    }

}



function profileRedirect(){
    window.location.href="http://localhost:8080/Project1/static/employeeProfile.html"
}

function requestRedirect(){
    window.location.href="http://localhost:8080/Project1/static/employeeMakeRequest.html"
}

function pendingRequestRedirect(){
    window.location.href="http://localhost:8080/Project1/static/employeePending.html"
}

function resolvedRequestRedirect(){
    window.location.href="http://localhost:8080/Project1/static/employeeResolved.html"
}

function homeRedirect(){
    window.location.href="http://localhost:8080/Project1/static/employeeHome.html"
}

function logout(){
    sessionStorage.removeItem('token');
    window.location.href="http://localhost:8080/Project1/"
}