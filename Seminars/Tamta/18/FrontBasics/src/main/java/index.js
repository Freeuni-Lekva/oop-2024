window.onload = start;

function start(){
    const button = document.getElementById("add-student");
    button.addEventListener('click', addStudent);
}

function addStudent(){
    const firstName = document.getElementById("first-name").value;
    const lastName = document.getElementById("last-name").value;
    const year = document.getElementById("year").value;

    if (firstName == "" || lastName === "" || year === "") {
        alert("No empty fields!!!")
        return;
    }

    const table = document.getElementsByTagName("table").item(0);
    const row = table.insertRow(table.rows.length);
    const nameCell = row.insertCell(0);
    nameCell.innerHTML = firstName;
    const lastNameCell = row.insertCell(1);
    lastNameCell.innerHTML = lastName;
    const yearCell = row.insertCell(2);
    yearCell.innerHTML = year;

    document.getElementById("first-name").value = "";
    document.getElementById("last-name").value = "";
    document.getElementById("year").value = "";

}
