<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Рекламные компании!</title>
</head>
<body>
<a href="/">Главная</a>
<a href="/news">Назад</a>
<div align="center">
    <h2>Customer Manager</h2>
    <h3><a href="/news/advercomp/new/${advertiser_id}">New advertiser company</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Link for presentation</th>
        </tr>
        <c:forEach items="${adverComp}" var="adver">
            <tr>
                <td>${adver.id}</td>
                <td>${adver.link_for_presentation}</td>

                <td><a href="/news/advercomp/edit/${adver.id}">Edit</a></td>
                <td><a href="/news/advercomp/delete/${adver.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>