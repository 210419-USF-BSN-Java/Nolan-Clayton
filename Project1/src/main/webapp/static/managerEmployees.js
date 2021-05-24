document.getElementById("home-btn").addEventListener("click", homeRedirect);
document.getElementById("pending-btn").addEventListener("click", pendingRedirect);
document.getElementById("resolved-btn").addEventListener("click", resolvedRedirect);
document.getElementById("employees-btn").addEventListener("click", employeesRedirect);
document.getElementById("logout-btn").addEventListener("click", logout);


let apiURL = 'http://localhost:8080/Project1/managerEmployees';

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

    let pendingList = document.getElementById('employee-list');

    for (var i = 0; i < response.length; i++) {
        var request = response[i];
        let requestLi = document.createElement('li');

        requestLi.className = "list-group-item";
        requestLi.id = `list-item-${request.id}`;
        requestLi.innerHTML = `<b>Username:</b> ${request.username} <b>Name:</b> ${request.firstName} ${request.lastName}
        <b>Email:</b> ${request.email} <b>Role:</b> ${request.role.role} 
        <button type="button" id="employee-btn-${request.id}" class="btn btn-primary">View Requests</button>`;

        pendingList.appendChild(requestLi);

        document.getElementById(`employee-btn-${request.id}`).addEventListener("click", viewEmployee.bind(request.id));
        
    }

}

function viewEmployee(requestId){
    window.location.href=`http://localhost:8080/Project1/static/managerViewEmployee.html?userId=${this}`
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