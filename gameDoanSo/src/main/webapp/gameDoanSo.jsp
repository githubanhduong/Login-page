<%@ page import="model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>


<html>
<head>
    <title>Game Doan So</title>
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

        #wrapper {
            width: 100%;
            height: 400px;
            border: none;
            display: flex;
            align-items: center;
            justify-content: center;
            flex-direction: column;
        }

        button {
            margin-top: 10px;
            height: 20px;
            width: 100px;
        }
        h1 {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Moi ban nhap tu 1 den 100</h1>
    <div style="text-align: center;">
        <h3><c:out value="${user.getName()}"/></h3>
        <br>
        <c:out value= "Luot choi thu "/>
        <c:out value="${user.getCountTurn()}"/>
    </div>

    <div id="wrapper">
        <c:if test="${result != 0}">
            <form action="http://localhost:8080/game" method="post" style="text-align: center;">
                <input type="text" name="soDuDoan" placeholder="napSo" value="${number}"/>
                <input type="hidden" name="numberTurn" value="${user.getCountTurn()}"/>
                <br>
                <button>Doan so</button>
            </form>
        </c:if>
        <c:choose>
            <c:when test = "${result == 1}">
               <h1>
                   <c:out value="Ban doan lon hon so cua game"></c:out>
               </h1>
            </c:when>
            <c:when test = "${result == -1}">
                <h1>
                    <c:out value="Ban doan nho hon so cua game"></c:out>
                </h1>
            </c:when>
            <c:when test = "${result == 0}">
                <h1>
                    <c:out value="CHUC MUNG BAN DA DOAN CHINH XAC"></c:out>
                </h1>
                <a href="http://localhost:8080/rank">
                    <button style="height: auto">Xem bang xep hang</button>
                </a>
            </c:when>
        </c:choose>
    </div>

</body>
</html>
