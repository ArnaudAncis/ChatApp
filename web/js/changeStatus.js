var statusButton = document.getElementById('changeStatus1');
statusButton.onclick = changeStatus;

var newStatusRequest = new XMLHttpRequest();

function changeStatus () {
    var statusText = document.getElementById('changeStatus').value;
    var information = "status=" + encodeURIComponent(statusText);
    newStatusRequest.open("POST", "Controller?action=ChangeStatusHandler", true);
    newStatusRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    newStatusRequest.onreadystatechange = getData1;
    newStatusRequest.send(information);
}


function getData1(){
    if(newStatusRequest.status == 200){
        if(newStatusRequest.readyState == 4){
            var status = newStatusRequest.responseText;
             var p = document.getElementById("status");
             var textNode = document.createTextNode(status);
             p.removeChild(p.childNodes[0]);
             p.appendChild(textNode);
        }
    }
}