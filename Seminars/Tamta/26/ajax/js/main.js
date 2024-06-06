var ourRequest = new XMLHttpRequest();
var button = document.getElementById("btn");
var animalInfo = document.getElementById("animal-info");
var pageNum = 1;

button.addEventListener("click", handleButtonClick)

function handleButtonClick(){
    ourRequest.open("GET", "https://learnwebcode.github.io/json-example/animals-" + pageNum + ".json");

    ourRequest.onload = function() {
        if (ourRequest.status >= 200 && ourRequest.status < 400){
            var ourData = JSON.parse(ourRequest.responseText);
            addHtmlContent(ourData)
        } else {
            alert("Incorrect data provided");
        }
    }

    ourRequest.onerror = function() {
        alert("Couldn't fetch response");
    }
    
    ourRequest.send();
    pageNum++;
    if (pageNum > 3) {
        button.classList.add("on-hide");
    }
}

function addHtmlContent(data){
    var resultStr = "";

    for (let i = 0; i < data.length; i++) {
        resultStr += "<p>";
        resultStr += "Cat's name is " + data[i].name;
        resultStr += "</p>";
    }


    animalInfo.insertAdjacentHTML("beforeend", resultStr);
}



