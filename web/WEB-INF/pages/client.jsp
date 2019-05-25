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
        <title>Клиент</title>
    </head>
    <body>
    	<div>
    	<a href = "clients"> К списку клиентов</a>
    	</div>
    	
    	     <form class = "addform" METHOD="post">
   	 		<div>
				<div> Добавить нового представителя </div>
				<div> ФИО, адрес:
					<spring:bind path="newrepr.name">
						<input type="text" name="name"/>
					</spring:bind>
					<spring:bind path="newrepr.surname">
						<input type="text" name="surname"/>
					</spring:bind>
					<spring:bind path="newrepr.patron">
						<input type="text" name="patron"/>
					</spring:bind>
					<spring:bind path="newrepr.adress">
						<input type="text" name="adress"/>
					</spring:bind>
				</div>
			</div>
			<input type="submit" value="Добавить">
   	 	</form>    	

    	<div>Данные о клиенте</div>
    	
    	<form class = "changeform" METHOD="post">
   	 		<div>
				<div> Название:
					<spring:bind path="newclientname.name">
						<input type="text" name="name" value="${client.client_name}"/>
					</spring:bind>
				</div>
			</div>
			<input type="submit" value="Изменить">
   	 	</form>
    	
    	${client.client_name}
    	
    	<div>Представители: <div>
    	<div> Id,  адрес,  ФИО</div>
    	
         <table class = "main_data">
			<c:forEach items="${cc}" var="contact">
			<tr class = "table_info">
			   <td class = "contact_id"><a href="represent_page?id=${contact.client_represent_id}">
			   ${contact.client_represent_id}
				</a>
				</td>
				<td class = "client_id">
				${contact.client_work_adress}
				,
				${contact.client_represent_name}
				${contact.client_represent_surname}
				${contact.client_represent_patronymic}
				</td>
			</tr>
			</c:forEach>
			
	</table> 
    
    </body>
</html>
