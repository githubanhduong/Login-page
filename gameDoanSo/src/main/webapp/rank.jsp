<%@ page import="model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>


<html>
<head>
    <title>Xep hang</title>
    <link rel = "icon" href =
            "https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200X200.png"
          type = "image/x-icon">
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
</head>
<body style="text-align: -webkit-center;" >
    <h1>Rank</h1>
    <p>*</p><p>*</p><p>*</p><p>*</p>
    <table>
        <tr>
            <th>Name player</th>
            <th>Achievement</th>
        </tr>
        <c:forEach var="player" items="${playerRank}">
            <tr>
                <c:set var="achievement" scope="session" value="${player.getAchievement()}"/>
                <c:if test="${achievement != 0}">
                    <td>${player.getName()}</td>
                    <td>${player.getAchievement()}</td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
    <a href="http://localhost:8080/game">TAO NGUOI CHOI MOI</a>

</body>
</html>
