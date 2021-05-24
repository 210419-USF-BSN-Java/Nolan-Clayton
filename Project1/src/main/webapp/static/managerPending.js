document.getElementById("home-btn").addEventListener("click", homeRedirect);
document.getElementById("pending-btn").addEventListener("click", pendingRedirect);
document.getElementById("resolved-btn").addEventListener("click", resolvedRedirect);
document.getElementById("employees-btn").addEventListener("click", employeesRedirect);
document.getElementById("logout-btn").addEventListener("click", logout);


let token = sessionStorage.getItem("token");
let tokenArr = token.split(":");


let userId = tokenArr[0];


let apiURL = 'http://localhost:8080/Project1/managerPending';



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
        requestLi.innerHTML = `<b>Author:</b> ${request.author.username} <b>Name:</b> ${request.author.firstName} ${request.author.lastName} 
        <b>Amount:</b> ${request.amount} <b>Submitted:</b> ${request.submitted[1]}/${request.submitted[2]}/${request.submitted[0]} 
        <b>Description:</b> ${request.description} <b>Type:</b> ${request.reimbType.type} 
        <button type="button" id="approve-btn-${request.id}" class="btn btn-success">Approve</button>
        <button type="button" id="reject-btn-${request.id}" class="btn btn-danger">Reject</button>`;

        pendingList.appendChild(requestLi);
        
        document.getElementById(`approve-btn-${request.id}`).addEventListener("click", approve.bind(request.id));
        document.getElementById(`reject-btn-${request.id}`).addEventListener("click", reject.bind(request.id));
    }

}

function approve(requestId){
    let xhr2 = new XMLHttpRequest();
	let url2 = "http://localhost:8080/Project1/managerAccept";
	xhr2.open("POST", url2);
    xhr2.onreadystatechange = sendData;

    function sendData() {

        if (xhr2.readyState === 4) {
            console.log("ready state inside approve")
        }
    }

    console.log(this);

    xhr2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	let requestBody = `user=${userId}&requestId=${this}`;
	xhr2.send(requestBody);

    document.getElementById(`list-item-${this}`).remove();
}

function reject(requestId){
    let xhr3 = new XMLHttpRequest();
	let url3 = "http://localhost:8080/Project1/managerReject";
	xhr3.open("POST", url3);
    xhr3.onreadystatechange = sendData;

    function sendData() {

        if (xhr3.readyState === 4) {
            console.log("ready state inside reject")
        }
    }

    xhr3.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	let requestBody = `user=${userId}&requestId=${this}`;
	xhr3.send(requestBody);

    document.getElementById(`list-item-${this}`).remove();
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