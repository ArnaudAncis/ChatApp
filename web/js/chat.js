// var chatObject = new XMLHttpRequest();
//
//
// function messages(){
//     chatObject.open("GET", "Controller?action=GetChatMessages", true );
//     chatObject.onreadystatechange = getMessages;
//     chatObject.send(null);
// }
//
//
// function getMessages() {
//     if(chatObject.readyState == 4){
//         if(chatObject.status = 200){
//             var chat = document.getElementById('chat');
//             var serverResponse = JSON.parse(chatObject.responseText);
//             chat.innerHTML = "";
//
//             var p = document.createElement('p');
//             p.appendChild(serverResponse);
//             chat.appendChild(p);
//
//
//
//             setInterval(messages, 5000);
//
//
//
//         }
//     }
//
// }