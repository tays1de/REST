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
            <th>
                <a href="/news/${currentPage}/?sortField=id&sortDir=${reverseSortDir}">
                ID</a></th>
            <th>
                <a href="/news/${currentPage}/?sortField=advertiserName&sortDir=${reverseSortDir}">

                    Advertiser_name</a></th>
            <th>
                <a href="/news/${currentPage}/?sortField=phoneNumber&sortDir=${reverseSortDir}">
                    Phone_number</a></th>
        </tr>
        <c:forEach items="${listAdvertiser}" var="advertiser">
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

    <%--For displaying Previous link except for the 1st page --%>
    <c:if test="${currentPage != 1}">
        <td><a href="/news/${currentPage - 1}/?sortField=id&sortDir=${sortDirection}">Previous</a></td>
    </c:if>
    <%--For displaying Page numbers.
     The when condition does not display a link for the current page--%>
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${totalPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="/news/${i}/?sortField=id&sortDir=${sortDirection}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
    <%--For displaying Next link --%>
    <c:if test="${currentPage lt totalPages}">
        <td><a href="/news/${currentPage + 1}/?sortField=id&sortDir=${sortDirection}">Next</a></td>
    </c:if>


</div>
</body>
</html>