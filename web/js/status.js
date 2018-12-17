
var getNewStatusRequest = new XMLHttpRequest();


function getNewStatus(){
    getNewStatusRequest.open("GET", "Controller?action=Status", true);
    getNewStatusRequest.onreadystatechange = getData;
    getNewStatusRequest.send(null);
}


function getData(){
    if(getNewStatusRequest.readyState == 4){
        if(getNewStatusRequest.status == 200){
            var status = getNewStatusRequest.responseText;
            var p = document.getElementById("status");
            var textNode = document.createTextNode(status);
            p.appendChild(textNode);
        }
    }
}
