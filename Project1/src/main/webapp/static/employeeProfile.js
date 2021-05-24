document.getElementById("profile-btn").addEventListener("click", profileRedirect);
document.getElementById("home-btn").addEventListener("click", homeRedirect);
document.getElementById("logout-btn").addEventListener("click", logout);
document.getElementById("request-btn").addEventListener("click", requestRedirect);
document.getElementById("pending-request-btn").addEventListener("click", pendingRequestRedirect);
document.getElementById("resolved-request-btn").addEventListener("click", resolvedRequestRedirect);

document.getElementById("update-btn").addEventListener("click", requestUpdate);

let apiURL = 'http://localhost:8080/Project1/profile/';

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

    let usernameSection = document.getElementById('username');
    let usernameInputSection = document.getElementById('usernameInput');
    usernameInputSection.value = response.username;
    usernameSection.innerHTML = response.username;

    let passwordSection = document.getElementById('password');
    let passwordInputSection = document.getElementById('passwordInput');
    passwordSection.innerHTML = "*******";
    passwordInputSection.value = response.password;

    let firstnameSection = document.getElementById('firstname');
    let firstnameInputSection = document.getElementById('firstnameInput');
    firstnameSection.innerHTML = response.firstName;
    firstnameInputSection.value = response.firstName;

    let lastnameSection = document.getElementById('lastname');
    let lastnameInputSection = document.getElementById('lastnameInput');
    lastnameSection.innerHTML = response.lastName;
    lastnameInputSection.value = response.lastName;

    let emailSection = document.getElementById('email');
    let emailInputSection = document.getElementById('emailInput');
    emailSection.innerHTML = response.email;
    emailInputSection.value = response.email;

    let roleSection = document.getElementById('role');
    roleSection.innerHTML = response.role.role;

}

function requestUpdate(){
	let user = document.getElementById("usernameInput").value;
	let pass = document.getElementById("passwordInput").value;
    let firstname = document.getElementById("firstnameInput").value;
    let lastname = document.getElementById("lastnameInput").value;
    let email = document.getElementById("emailInput").value;

    let xhr2 = new XMLHttpRequest();
	let url2 = "http://localhost:8080/Project1/employeeUpdate";
	xhr2.open("POST", url2);

    if (xhr2.readyState === 4) {
        if (xhr2.status >= 200 && xhr2.status < 300) {
          console.log("inside ready state")
        }
    }

    xhr2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	let requestBody = `userId=${userIDToken}&username=${user}&password=${pass}&firstname=${firstname}&lastname=${lastname}&email=${email}`;
	xhr2.send(requestBody);

    window.location.href="http://localhost:8080/Project1/static/employeeHome.html";

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