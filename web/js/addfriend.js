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
               alert('Deze persoon bestaat niet of is al een vriend');
           }

            else {
               var div = document.getElementById('friendsDiv');
               var tr = document.createElement('tr');
               var text = document.createTextNode(serverResponse);
               var text2 = document.createTextNode('Online');
               var td = document.createElement('td');
               var td2 = document.createElement('td');
               td.appendChild(text);
               td2.appendChild(text2);
               tr.appendChild(td);
               tr.appendChild(td2);
               div.appendChild(tr);
           }




        }

    }

}