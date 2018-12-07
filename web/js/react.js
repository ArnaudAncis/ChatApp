
var webSocket;
var number;

var div = document.getElementsByClassName("reactions");
var parent;



function openSocket(){
    webSocket = new WebSocket("ws://localhost:8080/blog");
    webSocket.onmessage = function(event){
        writeResponse(event.data);
    };

}

function sendMessage(elem){
    parent = elem.parentNode;
    //j = document.getElementsByClassName("reactions")[elem];
    var reaction = parent.getElementsByClassName("reaction")[0].value;
    var name = parent.getElementsByClassName("name")[0].value;
    var score = parent.getElementsByClassName("score")[0].value;

    //veranderen door JSON-Object
    var text2 = "<br/>" + name + ": " + reaction + " Score: " + score + "/10";
    webSocket.send(text2);
}

function closeSocket(){
    webSocket.close();
}

function writeResponse(text){
    //text wordt een jsonObject, informatie halen uit dat JSON-Object
    parent.innerHTML += text;
}
