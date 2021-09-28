<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Company </title>
</head>
<body>
    <div align="center">
        <h2>Edit Company</h2>
        <form:form action="save_edit" method="post" modelAttribute="campaign">
            <table border="0" cellpadding="5">
                <tr>
                    <td>ID: </td>
                    <td>${campaign.id}
                        <form:hidden path="id"/>
                    </td>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td><form:input path="campaigns_name" /></td>
                </tr>
                <tr>
                    <td>Link on photo: </td>
                    <td><form:input path="link_on_photo" /></td>
                </tr>
                <tr>
                    <td>Target countries: </td>
                    <td><form:input path="target_countries" /></td>
                </tr>
                <tr>
                    <td>Language: </td>
                    <td><form:input path="language" /></td>
                </tr>
                <tr>
                    <td>Location: </td>
                    <td><form:input path="location" /></td>
                </tr>
                <tr>
                    <td>Advertiser id</td>
                    <td> <form:input path="advertisers"  /></td>
                </tr>


                <tr>
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>