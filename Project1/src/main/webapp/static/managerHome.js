document.getElementById("home-btn").addEventListener("click", homeRedirect);
document.getElementById("pending-btn").addEventListener("click", pendingRedirect);
document.getElementById("resolved-btn").addEventListener("click", resolvedRedirect);
document.getElementById("employees-btn").addEventListener("click", employeesRedirect);
document.getElementById("logout-btn").addEventListener("click", logout);




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