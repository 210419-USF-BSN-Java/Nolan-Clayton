document.getElementById("profile-btn").addEventListener("click", profileRedirect);
document.getElementById("home-btn").addEventListener("click", homeRedirect);
document.getElementById("logout-btn").addEventListener("click", logout);
document.getElementById("request-btn").addEventListener("click", requestRedirect);
document.getElementById("pending-request-btn").addEventListener("click", pendingRequestRedirect);
document.getElementById("resolved-request-btn").addEventListener("click", resolvedRequestRedirect);

document.getElementById("submit-btn").addEventListener("click", submitRequest);


function submitRequest(){
    let token = sessionStorage.getItem("token");
    let tokenArr = token.split(":");


    let userId = tokenArr[0];
    let amo = document.getElementById("amount").value;
	let desc = document.getElementById("description").value;
    let typ = document.getElementById("type").value;

    let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/Project1/makeRequest";
	xhr.open("POST", url);
    xhr.onreadystatechange = sendData;

    function sendData() {

        if (xhr.readyState === 4) {
            console.log("ready state inside success")
        }
    }

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	let requestBody = `user=${userId}&amount=${amo}&description=${desc}&type=${typ}`;
	xhr.send(requestBody);

    document.getElementById('message').innerHTML='Request Submitted';
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