<%--
  Created by IntelliJ IDEA.
  User: Arnaud
  Date: 14-11-2018
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>

<body onload="getNewStatus();friends();">
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Chat" />
</jsp:include>

<div id="changeStatusknop">
    <Label>Change Status</Label>
    <input type="text" id="changeStatus" />
    <input type="button" id="changeStatus1" value="Change" />
    <p id="status"></p>
    <div>
        <input type="button" id="changeStatusOnline" value="Online" onclick="change(this);" />
        <input type="button" id="changeStatusOffline" value="Offline" onclick="change(this);"  />
        <input type="button" id="changeStatusAway" value="Away"  onclick="change(this);" />
    </div>
</div>

<div id ="statusDiv">

<p>Welcome ${user.getFirstName()}!</p>
    <table>
        <thead>
            <tr>
                 <th>Naam</th>
                 <th>Status</th>
                <th></th>

            </tr>
        </thead>
    <tbody id="friendsDiv"></tbody>
    </table>
    <div id="popup">Click here to see all users</div>
    <span class="popuptext" id="myPopup"></span>

    <div id="vriendenknop">
    <label class="addFriend">Add Friend</label>
    <input type="text" id="friendName" class="addFriend"/>
    <input type="button" id="addFriendButton" value="Add" class="addFriend" />
    </div>

    <div id="chat" onload=""></div>

    <!-- belangrijk dat script dan pas op het einde wordt geladen als je met event handlers werkt -->


    <script type="text/javascript" src="js/status.js"></script>
    <script type="text/javascript" src="js/changeStatus.js"></script>
    <script type="text/javascript" src="js/friends.js"></script>
    <script type="text/javascript" src="js/addfriend.js"></script>
    <script src="js/jq.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>

    <script>
        function change(elem) {
            document.getElementById('changeStatus').value = elem.value;
            document.getElementById('changeStatus1').click();
            document.getElementById('changeStatus').value = "";

        }
    </script>
</div>





</body>
</html>
