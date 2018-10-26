
window.onload = init;

function init() {
    var button = document.getElementById("addButton");
    button.onclick = handleButtonClick;
}

function handleButtonClick(e) {
    var textInput = document.getElementById("taskInput");
    var task = textInput.value;
    //alert("Adding " + task);

    if (task == "") {
        alert("Please enter a task");
    }
    else {
        //alert("Adding " + task);
        var li = document.createElement("li");
        li.innerHTML = task;
        var ul = document.getElementById("todolist");
        ul.appendChild(li);
    }
}

