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
        <title>Услуги</title>
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
				<div> Добавить новую услугу </div>
				<div> Название:
					<spring:bind path="newpos.name">
						<input type="text" name="name"/>
					</spring:bind>
					
					<spring:bind path="newpos.salary">
						<input type="text" name="salary"/>
					</spring:bind>
				</div>
			</div>
			<input type="submit" value="Добавить">
   	 	</form>
    
    <form class = "deleteform" METHOD="post">
   	 		<div>
				<div> Удалить позицию </div>
				<spring:bind path="idpos.clientid">
					<select name="clientid">
						<c:forEach items="${services}" var="cur_pos">
						<option value = "${cur_pos.id}">${cur_pos.id}</option>
						</c:forEach>
					</select>
				</spring:bind>
			</div>
			<input type="submit" value="Удалить">
   	 	</form>
    
    	<div>Услуги</div>
         <table class = "main_data">
			<tr> <td>Id</td> <td>Название</td><td>Стоимость</td></tr>
			<c:forEach items="${services}" var="position">
				<tr class = "table_info">
				<td class = "position_id">
				${position.id}
				</a>
				</td>
				<td class = "service_name">
				${position.service_name}
				</td>
				<td class = "salary">
				${position.cost}
				</td>
			</tr>
			</c:forEach>
	</table> 
    </body>
</html>
