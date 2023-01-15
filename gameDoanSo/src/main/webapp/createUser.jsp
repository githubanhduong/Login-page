<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dang ki</title>
    <style>
        body {
            background-image: url("images/game.png");
            background-size: cover;
            height: 100%;
            background-position: center;
            background-repeat: no-repeat;
            color: yellow;
        }
    </style>
    <script>
        function validateForm() {
            var x = document.forms["myForm"]["nameUser"].value;
            if (x == "" || x == null) {
                alert("Name must be filled out");
                return false;
            }
        }
    </script>
</head>
<body style="
    position: absolute;
    top: 50%;
    left: 35%;
    margin-top: -50px;
    height: 100px;
">

<div>
    <form name="myForm" action="http://localhost:8080/game" onsubmit="return validateForm()" method="get" required="">
        Name-Player: <input type="text" name="nameUser">
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
