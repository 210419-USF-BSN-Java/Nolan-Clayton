document.getElementById("profile-btn").addEventListener("click", profileRedirect);
document.getElementById("home-btn").addEventListener("click", homeRedirect);
document.getElementById("logout-btn").addEventListener("click", logout);
document.getElementById("request-btn").addEventListener("click", requestRedirect);
document.getElementById("pending-request-btn").addEventListener("click", pendingRequestRedirect);
document.getElementById("resolved-request-btn").addEventListener("click", resolvedRequestRedirect);



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