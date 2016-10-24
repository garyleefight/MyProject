<%--
  Created by IntelliJ IDEA.
  User: lsr
  Date: 16/10/7
  Time: 上午10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>


    <link rel="stylesheet" href="css/reset.css">


    <link rel="stylesheet" href="css/styleuser.css">

    <script type="text/javascript">
        function contact() {
            alert("Copy All Right Arui and Lsr")
        }
    </script>



</head>

<body>

<h1> Welcome To The UserPage!
    <small>Howdy,${sessionScope.get("username")}!</small>
</h1>
<div class="grid-wrap">

    <a class="list-block demo-3" href="${pageContext.request.contextPath}/player?method=showall">
        <figure>
            <img src="${pageContext.request.contextPath}/images/wade.jpg" alt="" />
            <figcaption>
                <h2>Show All Players</h2>
                <p>Click To Search & View All Players!</p>
            </figcaption>
        </figure>
    </a>
    <a class="list-block demo-3" href="${pageContext.request.contextPath}/userlike?method=showfavor">
        <figure>
            <img src="${pageContext.request.contextPath}/images/wade1.jpg" alt="" />
            <figcaption>
                <h2>My Favorate Players</h2>
                <p>Click Here To Follow Your Stars!</p>
            </figcaption>
        </figure>
    </a>
    <a class="list-block demo-3" href="${pageContext.request.contextPath}/team?method=showteam">
        <figure>
            <img src="${pageContext.request.contextPath}/images/wade2.jpg" alt="" />
            <figcaption>
                <h2>Show All Teams</h2>
                <p>Click To Search & View All Teams</p>
            </figcaption>
        </figure>
    </a>
</div>


<!-- follow me template -->
<div class="made-with-love">
    Thanks for using <i>NBA</i> DATABASE SYSTEM <br/>
    <a onclick="contact()"><i>Contact Us</i></a>
    <a target="_blank" href="${pageContext.request.contextPath}/user?method=logout"><i>Log Out</i></a>
</div>




</body>
</html>

