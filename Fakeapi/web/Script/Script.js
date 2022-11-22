function validateForm() {
    let id = document.forms["form1"]["ID"].value;
    let fname = document.forms["form1"]["Fname"].value;
    let lname = document.forms["form1"]["Lname"].value;
    let about = document.forms["form1"]["About"].value;
    let age = document.forms["form1"]["AGE"].value;
    if (id === "") {
        alert("id must be filled out");
        return false;
    } else if (fname === "") {
        alert("fname must be filled out");
        return false;
    } else if (lname === "") {
        alert("lname must be filled out");
        return false;
    } else if (about === "") {
        alert("about must be filled out");
        return false;
    } else if (age === "") {
        alert("age must be filled out");
        return false;
    }
}