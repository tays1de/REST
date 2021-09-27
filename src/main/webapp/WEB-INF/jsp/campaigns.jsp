<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
<a href="/news">Назад</a>
<div align="center">
    <h2>Customer Manager</h2>
    <form method="get" action="search">
        <input type="text" name="keyword" />
        <input type="submit" value="Search" />
    </form>
    <h3><a href="/news/new_company">New Company</a></h3>
   <table border="1" cellpadding="5">
           <tr>
               <th>ID</th>
               <th>Campaigns name</th>
               <th>Link on photo</th>
               <th>Target countries</th>
               <th>Language</th>
               <th>Location</th>
               <th>Action</th>
           </tr>
           <c:forEach items="${plzDo}" var="plz">
           <tr>
               <td>${plz.id}</td>
               <td>${plz.campaigns_name}</td>
               <td>${plz.link_on_photo}</td>
               <th>${plz.target_countries}</th>
               <th>${plz.language}</th>
               <th>${plz.location}</th>
               <td>
                   <a href="/news/edit?id=${advertiser.id}">Edit</a>
                   <a href="/news/delete?id=${advertiser.id}">Delete</a>
               </td>
           </tr>
           </c:forEach>
       </table>
</div>
</body>
</html>