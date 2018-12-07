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
<div id ="statusDiv">
    <p id="status"></p>
    <p id="friend"></p>
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

    <Label>Change Status</Label>
    <input type="text" id="changeStatus" />
    <input type="button" id="changeStatus1" value="Change" />
    <div id="vriendenknop">
    <label class="addFriend">Add Friend</label>
    <input type="text" id="friendName" class="addFriend"/>
    <input type="button" id="addFriendButton" value="Add" class="addFriend" />
    </div>


    <div id="chat">
        <h1>Chat met </h1>

        <input type="text" id="chatText"/>
    </div>
    <input type="button" id="openChat" value="Open Chat">

    <!-- belangrijk dat script dan pas op het einde wordt geladen als je met event handlers werkt -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/status.js"></script>
    <script type="text/javascript" src="js/changeStatus.js"></script>
    <script type="text/javascript" src="js/friends.js"></script>
    <script type="text/javascript" src="js/addfriend.js"></script>
</div>




</body>
</html>
