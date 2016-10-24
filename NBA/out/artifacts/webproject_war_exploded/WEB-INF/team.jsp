<%--
  Created by IntelliJ IDEA.
  User: lsr
  Date: 16/10/8
  Time: 下午5:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>NBA Team System</title>


    <link rel="stylesheet" href="css/reset.css">


    <link rel="stylesheet" href="css/styletable.css">





</head>

<body>

<section> <!--for demo wrap-->
    <h1>NBA Player System</h1>
    <div  class="tbl-header">
        <table cellpadding="0" cellspacing="0" border="0">
            <thead>
            <tr>
                <th>id</th>
                <th>TeamName</th>
                <th>Part</th>
                <th>Section</th>
            </tr>
            </thead>
        </table>
    </div>
    <div  class="tbl-content">
        <table cellpadding="0" cellspacing="0" border="0">
            <tbody>
            <c:forEach items="${requestScope.get('showall')}" var="team">
                <tr>
                    <td>${team.getT_id()}</td>
                    <td><form method="post" action="${pageContext.request.contextPath}/team?id=${team.getT_id()}">
                        <input type="submit" value="${team.getT_name()}">
                    </form> </td>
                    <td>${team.getT_loc()}</td>
                    <td>${team.getT_div()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script src="js/index.js"></script>
<div class="made-with-love">
    Thanks for using <i>NBA</i> DATABASE SYSTEM <br/>
    <a target="_blank" href="${pageContext.request.contextPath}/user"><i>Back Home</i></a>
    <a target="_blank" href="${pageContext.request.contextPath}/user?method=logout"><i>Log Out</i></a>

</div>


</body>
</html>
