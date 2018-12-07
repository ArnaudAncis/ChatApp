<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
<main>

    <c:if test="${errors.size()>0 }">
        <div class="danger">
            <ul>
                <c:forEach var="error" items="${errors }">
                    <li>${error }</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>

        <form method="post" action="Controller?action=SignUp">
            <p>
                <label for="firstName">First Name </label>
                <input type="text" id="firstName" name="firstName" value="">
            </p>
            <p>
                <label for="lastName">Last Name</label>
                <input type="text" id="lastName" name="lastName" value="">
            </p>
            <p>
                <label for="email">Email</label>
                <input type="text" id="email" name="email" value="">
            </p>
            <p>
                <label for="sex">Sex</label>
                <input type="text" id="sex" name="sex" value="">
            </p>

            <p>
                <label for="password">Password</label>
                <input type="text" id="password" name="password" value="">
            </p>
            <p>
                <label for="password2">Password Verification</label>
                <input type="text" id="password2" name="password2" value="">
            </p>
            <p>
                <input type="submit" id="signupbutton" value="Sign Up">
            </p>
        </form>
    </main>

<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>


</body>
</html>