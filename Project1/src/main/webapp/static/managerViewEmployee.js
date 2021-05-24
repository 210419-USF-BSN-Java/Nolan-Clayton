document.getElementById("home-btn").addEventListener("click", homeRedirect);
document.getElementById("pending-btn").addEventListener("click", pendingRedirect);
document.getElementById("resolved-btn").addEventListener("click", resolvedRedirect);
document.getElementById("employees-btn").addEventListener("click", employeesRedirect);
document.getElementById("logout-btn").addEventListener("click", logout);


let apiURL = 'http://localhost:8080/Project1/managerViewEmployee/';

let queryString = window.location.search;
let urlParams = new URLSearchParams(queryString);
let userId = urlParams.get('userId')

let xhr = new XMLHttpRequest();
xhr.onreadystatechange = receiveData;
xhr.open('GET', `${apiURL}${userId}`);
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
        <b>Description:</b> ${request.description} <b>Type:</b> ${request.reimbType.type} <b>Type:</b> ${request.reimbType.type}`;
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