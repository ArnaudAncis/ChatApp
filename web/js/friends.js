var friendsObject = new XMLHttpRequest();


function friends(){
    friendsObject.open("GET", "Controller?action=Friends", true );
    friendsObject.onreadystatechange = getFriends;
    friendsObject.send(null);
}


function getFriends() {
    if(friendsObject.readyState == 4){
        if(friendsObject.status = 200){
            var friendsz = document.getElementById('friendsDiv');
            var serverResponse = JSON.parse(friendsObject.responseText);
            friendsz.innerHTML = "";


            for (var i = 0; i!= serverResponse.length; i++) {

                //naam vriend
                var friend = serverResponse[i]["firstName"];
                // Status van vriend
                var statusFriend = serverResponse[i]["status"];
                var row = friendsz.insertRow(i);
                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);
                var cell3 = row.insertCell(2);
                var button = document.createElement('button');
               // button.type = "button";
                button.className = "startchatbutton";
                button.innerHTML = "Start&nbsp;Chat";

                cell1.innerHTML = friend;
                cell2.innerHTML = statusFriend;
                cell3.appendChild(button);
            }

           setInterval(friends, 20000);



        }
    }

}

