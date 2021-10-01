<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Рекламодатели!</title>
</head>
<body>
<a href="/">Главная</a>
<div align="center">
    <h2>Customer Manager</h2>

    <h3><a href="/news/new">New Advertiser</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Advertiser_name</th>
            <th>Phone_number</th>
        </tr>
        <c:forEach items="${advertiserList}" var="advertiser">
        <tr>
            <td>${advertiser.id}</td>
            <td>${advertiser.advertiser_name}</td>
            <td>${advertiser.phone_number}</td>
            <td>    <a href="/news/edit?id=${advertiser.id}">Edit</a> </td>
            <td>    <a href="/news/delete?id=${advertiser.id}">Delete</a> </td>
            <td>    <a href="/news/campaigns/${advertiser.id}">Compaigns of advertiser</a> </td>
            <td>    <a href="/news/advercomp/${advertiser.id}">Advertising company</a> </td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>