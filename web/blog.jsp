<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>

<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Blog" />
</jsp:include>
<body onload="openSocket();">
<div id="blogDiv">

    <div class="blog" id="1">
        <h2> Blog 1</h2>
        <p>Was het een interessante projectweek?</p>
        <h2>Reacties</h2>


    <div class="reactions"></div>
                <label > Naam </label>
                <input type="text" class="name" name="name">
        <br>
                <label > Reactie </label>
                <input type="text" class="reaction" name="reactie">
        <br>
                <label >Score</label>
                <input type="number" class="score" name="score" min="1" max="10" value="10">
        <button type="button" onclick="sendMessage(this);"> React</button>


    </div>
    <div class="blog" id="2">
        <h2> Blog 2</h2>
        <p>Wat ben je van plan te doen vandaag?</p>
        <h2>Reacties</h2>

        <div class="reactions"></div>
        <label > Naam </label>
        <input type="text" class="name" name="name">
        <br>
        <label > Reactie </label>
        <input type="text" class="reaction" name="reactie">
        <br>
        <label >Score</label>
        <input type="number" class="score" name="score" min="1" max="10" value="10">
        <button type="button" onclick="sendMessage(this);"> React</button>


    </div>

    <div class="blog" id="3">
        <h2> Blog 3</h2>
        <p>Naar welke muziek ben je momenteel aan het luisteren?</p>
        <h2>Reactions</h2>

        <div class="reactions"></div>
        <label > Naam </label>
        <input type="text" class="name" name="name">
        <br>
        <label > Reactie </label>
        <input type="text" class="reaction" name="reactie">
        <br>
        <label >Score</label>
        <input type="number" class="score" name="score" min="1" max="10" value="10">
        <button type="button" onclick="sendMessage(this);"> React</button>
    </div>

    <div class="blog" id="4">
        <h2> Blog 4</h2>
        <p>Wat zijn de examenvragen voor het vak Web4?</p>
        <h2>Reactions</h2>

        <div class="reactions"></div>
        <label > Naam </label>
        <input type="text" class="name" name="name">
        <br>
        <label > Reactie </label>
        <input type="text" class="reaction" name="reactie">
        <br>
        <label >Score</label>
        <input type="number" class="score" name="score" min="1" max="10" value="10">
        <button type="button" onclick="sendMessage(this);"> React</button>
    </div>
    <div class="blog" id="5">
        <h2> Blog 5</h2>
        <h2>Reactions</h2>

        <div class="reactions"></div>
        <label > Naam </label>
        <input type="text" class="name" name="name">
        <br>
        <label > Reactie </label>
        <input type="text" class="reaction" name="reactie">
        <br>
        <label >Score</label>
        <input type="number" class="score" name="score" min="1" max="10" value="10">
        <button type="button" onclick="sendMessage(this);"> React</button>
    </div>


    <script type="text/javascript" src="js/react.js"></script>
</div>



</body>
</html>
