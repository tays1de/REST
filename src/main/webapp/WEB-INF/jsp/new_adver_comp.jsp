<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>New advertiser company</title>
</head>
<body>
<a href="/news">Назад</a>
<div align="center">
    <h2>New advertiser company</h2>
    <form:form action="save" method="post" modelAttribute="adverComp">
        <table border="0" cellpadding="5">
            <tr>
                <td>Link for presentation:</td>
                <td><form:input path="link_for_presentation"/></td>
            </tr>
            <tr>
                <td>Advertiser id</td>
                <td>${company.advertisers.getId()}
                    <form:hidden path="advertisers"/>
                </td>

            </tr>

            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>