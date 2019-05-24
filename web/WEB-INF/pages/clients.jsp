﻿<?xml version="1.0" encoding="UTF-8" ?>
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
    
    <div>
    	<a href = "clients"> Список клиентов</a>
    	</div>
    	<div>
    	<a href = "employees"> Список сотрудников</a>
    	</div>
    	<div>
    	<a href = "services"> Список услуг</a>
    
     <form class = "addform" METHOD="post">
   	 		<div>
				<div> Добавить нового клиента </div>
				<div> Название:
					<spring:bind path="newclient.name">
						<input type="text" name="name"/>
					</spring:bind>
				</div>
			</div>
			<input type="submit" value="Добавить">
   	 	</form>
    
    <form class = "deleteform" METHOD="post">
   	 		<div>
				<div> Удалить клиента </div>
				<spring:bind path="clientid.clientid">
					<select name="clientid">
						<c:forEach items="${clients}" var="client">
						<option value = "${client.id}">${client.id}</option>
						</c:forEach>
					</select>
				</spring:bind>
			</div>
			<input type="submit" value="Удалить">
   	 	</form>
    
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
