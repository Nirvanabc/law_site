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
    	<a href = "clients"> Список клиентов</a>
    </div>
    <div>
    	<a href = "employees"> Список сотрудников</a>
    </div>
    <div>
    	<a href = "services"> Список услуг</a>
    </div>
     <div>
    	<a href = "positions"> Список вакансий</a>
    </div>
    	
    <form class = "addform" METHOD="post">
   	 		<div>
				<div> Добавить нового сотрудника </div>
				<div> ФИО, адрес, должность:
					<spring:bind path="newemp.name">
						<input type="text" name="name"/>
					</spring:bind>
					<spring:bind path="newemp.surname">
						<input type="text" name="surname"/>
					</spring:bind>
					<spring:bind path="newemp.patron">
						<input type="text" name="patron"/>
					</spring:bind>
					<spring:bind path="newemp.adress">
						<input type="text" name="adress"/>
					</spring:bind>
					<spring:bind path="newemp.position_id">
						<input type="text" name="position_id"/>
					</spring:bind>
				</div>
			</div>
			<input type="submit" value="Добавить">
   	 	</form>
    	
    	   <form class = "deleteform" METHOD="post">
   	 		<div>
				<div> Удалить сотрудника </div>
				<spring:bind path="idemp.clientid">
					<select name="clientid">
						<c:forEach items="${employees}" var="cur_emp">
						<option value = "${cur_emp.id}">${cur_emp.id}</option>
						</c:forEach>
					</select>
				</spring:bind>
			</div>
			<input type="submit" value="Удалить">
   	 	</form>
    	
    	<div>Сотрудники: <div>
    	<div> Id сотрудника, Id человека, ФИО, адрес,  ФИО</div>
    	
         <table class = "main_data">
			<c:forEach items="${employees}" var="contact">
			<tr class = "table_info">
			<td class = "id">
				${contact.id}
			   <td class = "person_id"><a href="person?id=${contact.person_id}">
			   ${contact.person_id}
				</a>
				</td>
				<td class = "name">
				${contact.person_name}
				<td class = "surname">
				${contact.person_surname}
				<td class = "pat">
				${contact.person_patronymic}
				<td class = "adress">
				${contact.adress}
				,
				<td class = "position_id"><a href="positions">
				${contact.position_id}
				</td>
			</tr>
			</c:forEach>
			
	</table> 
    
    </body>
</html>
