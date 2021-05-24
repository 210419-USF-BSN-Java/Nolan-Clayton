document.getElementById("profile-btn").addEventListener("click", profileRedirect);
document.getElementById("home-btn").addEventListener("click", homeRedirect);
document.getElementById("logout-btn").addEventListener("click", logout);
document.getElementById("request-btn").addEventListener("click", requestRedirect);
document.getElementById("pending-request-btn").addEventListener("click", pendingRequestRedirect);
document.getElementById("resolved-request-btn").addEventListener("click", resolvedRequestRedirect);



let apiURL = 'http://localhost:8080/Project1/employeePending/';

let token = sessionStorage.getItem("token");
let tokenArr = token.split(":");

let userIDToken = tokenArr[0];

let xhr = new XMLHttpRequest();
xhr.onreadystatechange = receiveData;
xhr.open('GET', `${apiURL}${userIDToken}`);
xhr.send();

function receiveData() {

    if (xhr.readyState === 4) {
        // Status code is in the 200s, meaning successful
        if (xhr.status >= 200 && xhr.status < 300) {
            let response = xhr.responseText;
            // Converting JSON to JS object
            response = JSON.parse(response);
            // Data processing behavior
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
        requestLi.innerHTML = `<b>Amount:</b> ${request.amount} 
        <b>Submitted:</b> ${request.submitted[1]}/${request.submitted[2]}/${request.submitted[0]} 
        <b>Description:</b> ${request.description} <b>Type:</b> ${request.reimbType.type}`;
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