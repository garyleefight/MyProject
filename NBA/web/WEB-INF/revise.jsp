<%--
  Created by IntelliJ IDEA.
  User: lsr
  Date: 16/10/8
  Time: 下午11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basic Form Styling</title>




    <link rel="stylesheet" href="css/stylerevise.css">





</head>

<body>

<div class="container">
    <h1>Revise Form</h1>

    <form action="${pageContext.request.contextPath}/playerdetail?pid=${requestScope.get("player").getPlayerdata().getP_s_id()}&plid=${requestScope.get("player").getP_id()}" method="post">
        <div>
            <p>
                <label>
                    PlayerName<br>
                    <input type="text" name="name" disabled="disabled" placeholder="${requestScope.get("player").getP_name()}" value="${requestScope.get("player").getP_name()}">
                </label>
            </p>
            <p>
                <label>
                    Season<br>
                    <input type="text" name="season" disabled="disabled" placeholder="${requestScope.get("player").getSemester()}" value="${requestScope.get("player").getSemester()}">
                </label>
            </p>
            <p>
                <label>
                    Team<br>
                    <input type="text" name="team" disabled="disabled" placeholder="${requestScope.get("player").getTeam()}" value="${requestScope.get("player").getTeam()}">
                </label>
            </p>
            <p>
                <label>
                    GamePlay<br>
                    <input type="text" name="gp" placeholder="${requestScope.get("player").getGameplay()}" value="${requestScope.get("player").getGameplay()}" runat="server" class="easyui-numberbox" precision="1">
                </label>
            </p>
            <p>
                <label>
                    Points<br>
                    <input type="text" name="point" placeholder="${requestScope.get("player").getScore()}" value="${requestScope.get("player").getScore()}" runat="server" class="easyui-numberbox" precision="1">
                </label>
            </p>
            <p>
                <label>
                    Rebound<br>
                    <input type="text" name="rebound" placeholder="${requestScope.get("player").getRebound()}" value="${requestScope.get("player").getRebound()}" runat="server" class="easyui-numberbox" precision="1">
                </label>
            </p>
            <p>
                <label>
                    Assist<br>
                    <input type="text"  name="assist" placeholder="${requestScope.get("player").getAssist()}" value="${requestScope.get("player").getAssist()}" runat="server" class="easyui-numberbox" precision="1">
                </label>
            </p>
            <p>
                <label>
                    Block<br>
                    <input type="text"  name="block" placeholder="${requestScope.get("player").getBlock()}" value="${requestScope.get("player").getBlock()}" runat="server" class="easyui-numberbox" precision="1">
                </label>
            </p>
            <p>
                <label>
                    Steal<br>
                    <input type="text"  name="steal" placeholder="${requestScope.get("player").getSteal()}" value="${requestScope.get("player").getSteal()}" runat="server" class="easyui-numberbox" precision="1">
                </label>
            </p>
            <p>
                <label>
                    Foul<br>
                    <input type="text"  name="foul" placeholder="${requestScope.get("player").getFoul()}" value="${requestScope.get("player").getFoul()}"runat="server" class="easyui-numberbox" precision="1">
                </label>
            </p>
            <p>
                <label>
                    Turnover<br>
                    <input type="text" name="turnover" placeholder="${requestScope.get("player").getTurnover() }" value="${requestScope.get("player").getTurnover()}" runat="server" class="easyui-numberbox" precision="1">
                </label>
            </p>
            <p>
                <input type="submit" value="submit">
            </p>
            </div>
    </form>
</div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script src="js/index1.js"></script>



</body>
</html>