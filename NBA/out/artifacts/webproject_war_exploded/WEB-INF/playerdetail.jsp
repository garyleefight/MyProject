<%--
  Created by IntelliJ IDEA.
  User: lsr
  Date: 16/10/8
  Time: 下午2:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Player Detail Page</title>


    <link rel="stylesheet" href="css/normalize.css">


    <link rel="stylesheet" href="css/styledetail.css">





</head>

<body>

<div class="wrapper">

    <div class="table">

        <div class="row header">
            <div class="cell">
                Name
            </div>
            <div class="cell">
                Age
            </div>
            <div class="cell">
                Positon
            </div>
            <div class="cell">
                Team Number
            </div>
            <div class="cell">
                Height
            </div>
            <div class="cell">
                Weight
            </div>
            <div class="cell">
                Follow Him!
            </div>

        </div>

        <div class="row">
            <div class="cell">
                ${requestScope.get("player").getP_name()}
            </div>
            <div class="cell">
                ${requestScope.get("player").getAge()}
            </div>
            <div class="cell">
                ${requestScope.get("player").getPos()}
            </div>
            <div class="cell">
                ${requestScope.get("player").getNum()}
            </div>
            <div class="cell">
                ${requestScope.get("player").getHeight()}
            </div>
            <div class="cell">
                ${requestScope.get("player").getWeight()}
            </div>
            <div class="cell">
            <a target="_blank" href="${pageContext.request.contextPath}/userlike?id=${requestScope.get("player").getP_id()}"><i>♥</i></a>
            </div>
        </div>
        </div>

    <div class="table">

        <div class="row header green">
            <div class="cell">
                Season
            </div>
            <div class="cell">
                Team
            </div>
            <div class="cell">
                GP
            </div>
            <div class="cell">
                PTS
            </div>
            <div class="cell">
                REB
            </div>
            <div class="cell">
                AST
            </div>
            <div class="cell">
                BLK
            </div>
            <div class="cell">
                STL
            </div>
            <div class="cell">
                PF
            </div>
            <div class="cell">
                TOV
            </div>
            <div class="cell">
                REVISE
            </div>
        </div>

<c:forEach items="${requestScope.get('playerList')}" var="player" varStatus="status">
    <div class="row">
        <div class="cell">
                ${player.getSemester()}
        </div>
        <div class="cell">
            <form method="post" action="${pageContext.request.contextPath}/team?id=${player.getPlayerdata().getT_id()}">
                <input type="submit" value="${player.getTeam()}">
            </form>
        </div>
        <div class="cell">
                ${player.getGameplay()}
        </div>
        <div class="cell">
                ${player.getScore()}
        </div>
        <div class="cell">
                ${player.getRebound()}
        </div>
        <div class="cell">
                ${player.getAssist()}
        </div>
        <div class="cell">
                ${player.getBlock()}
        </div>
        <div class="cell">
                ${player.getSteal()}
        </div>
        <div class="cell">
                ${player.getFoul()}
        </div>
        <div class="cell">
            ${player.getTurnover()}
        </div>
        <div class="cell">
            <a target="_blank" href="${pageContext.request.contextPath}/playerdetail?psid=${player.getPlayerdata().getP_s_id()}">revise data</a>
        </div>
    </div>
</c:forEach>
        </div>
    </div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<div class="made-with-love">
    Thanks for using <i>NBA</i> DATABASE SYSTEM <br/>
    <a target="_blank" href="${pageContext.request.contextPath}/user"><i>Back Home</i></a>
    <a target="_blank" href="${pageContext.request.contextPath}/user?method=logout"><i>Log Out</i></a>

</div>



</body>
</html>
