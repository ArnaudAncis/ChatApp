// $(document).ready(function() {
//     $('#openChat').click(function(){
//         $('#chat').fadeToggle("slow");
//
//     })
// })
// var chatObject = new XMLHttpRequest();
// var chatObject2 = new XMLHttpRequest();

var naam;


$(document).on('click', '.startchatbutton', function(){
   // add_chat(this.parentNode.parentNode.childNodes[0].innerHTML);
    make_chat(this.parentNode.parentNode.childNodes[0].innerHTML);
    add_chat(this.parentNode.parentNode.childNodes[0].innerHTML);
    //getMessages(this.parentNode.parentNode.childNodes[0].innerHTML);
});

function make_chat(name){

    $.ajax({
        url: "Controller?action=MaakChat",
        type: "POST",
        data: "b=" + name,
        dataType: "json",
        success: function(json){

        },});
}

function add_chat(name) {
    //console.log("TEST" + name);
    if (!isErAlEenChatWindow()) {
        var chatDiv = document.getElementById('chat');
        var childDivs = document.getElementById('chat').getElementsByTagName('div');
        for (var i = 0; i < childDivs.length; i++) {
            if (childDivs[i].id == name) {
                $(document.getElementById(name)).fadeToggle("slow");
                return null;
            }
        }
        var nieuwechat = document.createElement('div');
        nieuwechat.id = name;
        nieuwechat.className = "nieuweChat";
        chatDiv.appendChild(nieuwechat);
        var h1 = document.createElement('h1');
        h1.innerHTML = name;
        nieuwechat.appendChild(h1);
        var input = document.createElement('input');
        input.type = "text";
        input.className = "inputField";

        var inputButton = document.createElement('input');
        inputButton.type = "button";
        inputButton.className = "inputButton";
        inputButton.value = "Send";
        var paraDiv = document.createElement('div');
        paraDiv.id= "chat" + name;
        inputButton.addEventListener("click", function () {
            sendMessage(inputButton, name);


        })


        nieuwechat.appendChild(paraDiv);
        nieuwechat.appendChild(input);
        nieuwechat.appendChild(inputButton);
        getMessages(name);

    }
}


function isErAlEenChatWindow(naam) {
    var chatWindows = document.getElementsByClassName("nieuweChat");
    for (var i = 0; i < chatWindows.length; i++) {
        if (chatWindows[i].getAttribute("id") === naam) {
            return true;
        }
    }
    return false;
}

function sendMessage(inputButton, namePartner) {
    var textVeld = inputButton.parentNode.getElementsByClassName("inputField")[0];
    var berichtText = textVeld.value;
    textVeld.value = "";
    var berichtObject = new Object;
    berichtObject.bericht = berichtText;
    berichtObject.ontvanger = namePartner;
    var berichtObjectJSON = JSON.stringify(berichtObject);
    console.log(berichtObjectJSON);

    $.ajax({
        url: "Controller?action=SendMessage",
        type: "POST",
        data: "b=" + berichtObjectJSON,
        dataType: "json",
        success: function (json) {
           //console.log(json);

        }
    });

}
function getMessages(name) {
    //console.log(naam);
        $.ajax({
            url: "Controller?action=GetChatMessages",
            type: "POST",
            data: "naam=" + name,
            dataType: "json",
            success: function (json) {
                console.log(json);
                //setTimeout(getMessages(name), 5000);
                addBerichtBijVenster(json, name);
        }

        });
    setTimeout(function (){getMessages(name)}, 3000);

}
   /* function addBerichtBijVenster(berichtObject, name ) {

        var bericht;
        var zender;
        var l = "chat" ;


        for (var i = 0; i < berichtObject.length; i++) {

            zender = berichtObject[i].ontvanger.firstName;
            bericht = zender + ": " + berichtObject[i].text;


            var berichtenRuimte = document.getElementById(l + berichtObject[i].sender.firstName);
            if(berichtenRuimte == null){
                berichtenRuimte = document.getElementById(l + berichtObject[i].ontvanger.firstName);
                console.log(berichtenRuimte.id);
            }
                berichtenRuimte.innerHTML = "";

            var node = document.createTextNode(bericht);
            var berichtDiv = document.createElement("div");
            if(berichtObject[i].sender.firstName ==  name){
                berichtDiv.className == "berichtVanMij";
            }
            else{
                berichtDiv.className = "berichtVanPartner";
            }
            berichtDiv.appendChild(node);
            berichtDiv.appendChild(document.createElement('br'));
            berichtenRuimte.appendChild(berichtDiv);
        }
    }*/

function addBerichtBijVenster(berichtObject, naamPartner) {
    console.log(berichtObject);
    var bericht;
    var zender;
    var berichtenRuimte = document.getElementById("chat" + naamPartner );
    berichtenRuimte.innerHTML = "";

    for (var i = 0; i < berichtObject.length; i++) {
        zender = berichtObject[i].ontvanger.firstName;
        bericht = berichtObject[i].text;

        var berichtDiv = document.createElement("div");
        if (zender === naamPartner) {
            berichtDiv.className = "berichtVanPartner";
        } else {
            berichtDiv.className = "berichtVanMij";
        }

        berichtDiv.appendChild(document.createElement('br'));
        berichtDiv.innerHTML = bericht;
        berichtenRuimte.appendChild(berichtDiv);

    }

}

    function closeButtonFunction(closeButton) {
        closeButton.addEventListener("click", function () {
            closeChat(closeButton);
        });
    }

    function closeChat(closeButton) {

        var partner = closeButton.parentNode.getElementsByClassName("partnerName")[0].innerHTML;
        console.log(partner);

        $.ajax({
            url: "Controller?action=DeleteChat",
            type: "POST",
            data: "u=" + partner,
            dataType: "json"
        });

        var parentParent = closeButton.parentNode.parentNode;
        parentParent.parentNode.removeChild(parentParent);

    }

