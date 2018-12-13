// $(document).ready(function() {
//     $('#openChat').click(function(){
//         $('#chat').fadeToggle("slow");
//
//     })
// })
// var chatObject = new XMLHttpRequest();
// var chatObject2 = new XMLHttpRequest();

$(document).on('click', '.startchatbutton', function(){
   // add_chat(this.parentNode.parentNode.childNodes[0].innerHTML);
   make_chat(this.parentNode.parentNode.childNodes[0].innerHTML);
    add_chat(this.parentNode.parentNode.childNodes[0].innerHTML);

});

function make_chat(name){

    $.ajax({
        url: "Controller?action=MaakChat",
        type: "POST",
        data: "b=" + name,
        dataType: "json",
        success: function(json){
            //add_chat(name);



        },});
}

function add_chat(name) {
    if (!isErAlEenChatWindow()) {
        var chatDiv = document.getElementById('chat');
        var childDivs = document.getElementById('chat').getElementsByTagName('div');
        for (var i = 0; i < childDivs.length; i++) {
            if (childDivs[i].id == name) {
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
        nieuwechat.appendChild(input);
        var inputButton = document.createElement('button');
        inputButton.className = "inputButton";
        inputButton.innerHTML = "Send&nbsp;Message";
        var paraDiv = document.createElement('div');
        paraDiv.id= "chat" + name;
        inputButton.addEventListener("click", function () {
            sendMessage(inputButton, name)
        })

        nieuwechat.appendChild(inputButton);
        nieuwechat.appendChild(paraDiv);

    }
}


// function openChat(partner) {
//     if (!isErAlEenChatWindow(partner)) {
//
//         var chatWindow = document.createElement("div");
//         chatWindow.className = "chatWindow";
//         chatWindow.setAttribute("id", partner + "Chat");
//
//         var navBar = document.createElement("div");
//         navBar.className = "chatWindowNavBar";
//         chatWindow.appendChild(navBar);
//
//         var partnerName = document.createElement("span");
//         partnerName.className = "partnerName";
//         partnerName.innerHTML = partner;
//         navBar.appendChild(partnerName);
//
//         var closeButton = document.createElement("div");
//         closeButton.className = "closeButton";
//         closeButton.innerHTML = "X";
//         closeButtonFunction(closeButton);
//         navBar.appendChild(closeButton);
//
//         var messages = document.createElement("div");
//         messages.className = "messages";
//         chatWindow.appendChild(messages);
//
//         var inputDiv = document.createElement("div");
//         inputDiv.className = "inputDiv";
//         chatWindow.appendChild(inputDiv);
//
//         var inputField = document.createElement("textarea");
//         inputField.className = "inputField";
//         inputDiv.appendChild(inputField);
//
//         var sendButton = document.createElement("button");
//         sendButton.className = "sendButton";
//         sendButton.innerHTML = "Send";
//         sendButton.addEventListener("click", function () {
//             zendBericht(sendButton, partner);
//         });
//
//         inputDiv.appendChild(sendButton);
//
//
//
//         var br = document.createElement("br");
//         chatWindow.appendChild(br);
//         $("#chatWindowDiv").append(chatWindow);
//
//     }
// }

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
    });
}
    function getMessages() {
        $.ajax({
            url: "Controller?action=GetChatMessages",
            type: "GET",
            dataType: "json",
            success: function (json) {
               console.log(json);
               console.log(json.berichten);
               addBerichtBijVenster(json);

        }
        });
        //setInterval(getMessages(), 5000);
}
    function addBerichtBijVenster(berichtObject) {
        var bericht;
        var zender;
        var l = "chat" ;
        var berichtDiv = document.createElement("div");
        //bericht = berichtObject.bericht;

        for (var i = 0; i < berichtObject.length; i++) {
            bericht = berichtObject[i].text;
            zender = berichtObject[i].person.firstName;
            console.log(zender);


            // if (zender === naamPartner) {
            //     berichtDiv.className = "berichtVanPartner";
            // } else {
            //     berichtDiv.className = "berichtVanMij";
            // }
            var berichtenRuimte = document.getElementById(l + zender);
            berichtenRuimte.innerHTML = "";

            berichtDiv.appendChild(bericht);
            berichtenRuimte.appendChild(berichtDiv);

        }

        //    // var berichtDiv = document.createElement("div");
        //     if (zender === naamPartner) {
        //         berichtDiv.className = "berichtVanPartner";
        //     } else {
        //         berichtDiv.className = "berichtVanMij";
        // }
        //     var t = document.createTextNode(bericht);
        //     console.log(t);
        //
        //     berichtenRuimte.appendChild(t);
        //     berichtenRuimte.appendChild(document.createElement('br'));




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

