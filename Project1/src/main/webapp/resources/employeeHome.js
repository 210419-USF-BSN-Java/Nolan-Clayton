document.getElementById("profile-btn").addEventListener("click", profileRedirect);
document.getElementById("logout-btn").addEventListener("click", logout);


function profileRedirect(){
    window.location.href="http://localhost:8080/Project1/static/employeeProfile.html"
}

function logout(){
    window.location.href="http://localhost:8080/Project1/"
}