<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <title>lab6</title>
</head>
<body>
	<center>
        <h1>Countries</h1>
        <h2>
            <a href="${pageContext.request.contextPath}/CountryNew">Add New Country</a>
            &nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/CountryList">List All Countries</a>
             &nbsp;&nbsp;&nbsp;
            <a href="index.html">Back</a>
        </h2>
    </center>
    <div align="center">
        <c:if test="${country != null}">
            <form action="CountryUpdate" method="post">
        </c:if>
        <c:if test="${country == null}">
            <form action="CountryInsert" method="post">
        </c:if>
        <table border="1" cellpadding="5"  class="table">
            <caption>
                <h2>
                    <c:if test="${country != null}">
                        Edit Country
                    </c:if>
                    <c:if test="${country == null}">
                        Add New Country
                    </c:if>
                </h2>
            </caption>
                <c:if test="${country != null}">
                    <input type="hidden" name="id" value="<c:out value='${country.id}' />" />
                </c:if>           
            <tr>
                <th scope="col">Name: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${country.name}' />"
                        />
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input class="btn btn-primary" type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>