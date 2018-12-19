var addFriendButton = document.getElementById('addFriendButton');
addFriendButton.onclick = addFriend;

var addFriendsObject = new XMLHttpRequest();

function addFriend() {
    var friendName = document.getElementById('friendName').value;
    var information = "friend=" + encodeURIComponent(friendName);
    addFriendsObject.open("POST", "Controller?action=AddFriendsHandler", true);
    addFriendsObject.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    addFriendsObject.onreadystatechange = getData2;
    addFriendsObject.send(information);
}

function getData2(){
    if(addFriendsObject.readyState == 4){
        if(addFriendsObject.status == 200){

           var serverResponse = addFriendsObject.responseText;
           if(serverResponse == "nope"){
               alert("This person doesn't exist, or is already a friend.");
           }
           else if(serverResponse == "nope2"){
               alert('You can not add yourself.');
           }

            else {
               var div = document.getElementById('friendsDiv');
               var text = document.createTextNode(serverResponse);
               var row = div.insertRow();
               var cell1 = row.insertCell(0);
               var cell2 = row.insertCell(1);
               var cell3 = row.insertCell(2);
               var button = document.createElement('button');

               button.className = "startchatbutton";
               button.innerHTML = "Open/Close&nbsp;Chat";

               cell1.innerHTML = serverResponse;
               cell2.innerHTML = 'Online';
               cell3.appendChild(button);


           }




        }

    }

}