
var webSocket;
var number;

var div = document.getElementsByClassName("reactions");
var parent;



function openSocket(){
    webSocket = new WebSocket("ws://localhost:8080/blog");
    webSocket.onmessage = function(event){
        var object = JSON.parse(event.data);
        writeResponse(object);
    };

}

function sendMessage(elem){
    parent = elem.parentNode;
    var id = parent.id;
    //j = document.getElementsByClassName("reactions")[elem];
    var reaction = parent.getElementsByClassName("reaction")[0].value;
    var name = parent.getElementsByClassName("name")[0].value;
    var score = parent.getElementsByClassName("score")[0].value;

    var jsonComment = { "reactie":reaction, "name":name, "score":score, "id":id };


    //veranderen door JSON-Object
    //var text2 = "<br/>" + name + ": " + reaction + " Score: " + score + "/10";
    webSocket.send(JSON.stringify(jsonComment));
}

function closeSocket(){
    webSocket.close();
}

function writeResponse(text){
    //text wordt een jsonObject, informatie halen uit dat JSON-Object
    //parent.innerHTML += text;
    reactie = text.reactie;
    naam = text.name;
    score = text.score;
    id = text.id;
    var tekst =  naam + ": " + reactie + " " + score + "/10";
    var juist = document.getElementById(id);
    var p = document.createElement('p');

    var node = document.createTextNode(tekst);
    var re = juist.getElementsByClassName("reactions")[0];
    re.appendChild(node);
    re.appendChild(document.createElement("br"));
   // juist.appendChild(node);
   // juist.appendChild(document.createElement("br"));




}
