<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Clients</title>
    </head>
    <body>
    	<div>Клиенты</div>
         <table class = "main_data">
			<tr> <td>Id</td> <td>Название</td></tr>
			<c:forEach items="${clients}" var="client">
				<tr class = "table_info">
				<td class = "clients_id"><a href="client?id=${client.id}">
				${client.id}
				</a>
				</td>
				<td class = "clients_client">
				${client.client_name}
				</td>
				<td class = "clients_name">
				</td>
			</tr>
			</c:forEach>
	</table> 
    </body>
</html>
