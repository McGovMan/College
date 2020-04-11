function validateForm() {
    
    var email = document.getElementById("email").value;
    var html = "";

    if (document.getElementById("questionID").options[questionID.selectedIndex].value == 0) html += "Enter an option. ";
    if (document.getElementById("questionText").value == '') html += "Enter a question. ";
    if (document.getElementById("name").value == '') html += "Enter your name. ";
    if (email.indexOf("@") <= 0 || email.indexOf(".") <= 0) html += "Enter your email with a @ and ."
    
    if (html != '') alert(html);
}