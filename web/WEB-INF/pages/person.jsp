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

    	<div>Данные</div>
    	
    	<form class = "changeform" METHOD="post">
   	 		<div>
				<div> Имя:
					<spring:bind path="newdata.name">
						<input type="text" name="name" value="${person.person_name}"/>
					</spring:bind>
				</div>
				
				<div> Фамилия:
					<spring:bind path="newdata.surname">
						<input type="text" name="surname" value="${person.person_surname}"/>
					</spring:bind>
				</div>
				
				<div> Отчество:
					<spring:bind path="newdata.patron">
						<input type="text" name="patron" value="${person.person_patronymic}"/>
					</spring:bind>
				</div>
				
			</div>
			<input type="submit" value="Изменить">
   	 	</form>
    	
    	${client.client_name} 
    	
    	<div>Контакты: <div>
    	<div> Телефоны</div>
    	
         <table class = "main_data">
			<c:forEach items="${phones}" var="phone">
			<tr class = "table_info">
			   ${phone}
			   <br />
				</td>
			</tr>
			</c:forEach>
			
			<div> Почта</div>
    	
         <table class = "main_data">
			<c:forEach items="${emails}" var="email">
			<tr class = "table_info">
			   ${email}
			   <br />
				</td>
			</tr>
			</c:forEach>
			
	</table> 
    
    <form class = "addform" METHOD="post">
   	 		<div>
				<div> Добавить телефон </div>
				<div> номер:
					<spring:bind path="newphone.name">
						<input type="text" name="name"/>
					</spring:bind>
				</div>
			</div>
			<input type="submit" value="Добавить">
   	 	</form>
    
    <form class = "addform" METHOD="post">
   	 		<div>
				<div> Добавить почту </div>
				<div> адрес:
					<spring:bind path="newemail.name1">
						<input type="text" name="name1"/>
					</spring:bind>
				</div>
			</div>
			<input type="submit" value="Добавить">
   	 	</form>
    
    </body>
</html>
