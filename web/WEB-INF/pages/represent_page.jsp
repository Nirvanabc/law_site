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
        <title>Представитель компании</title>
    </head>
    <body>
    	<div>
    	<a href = "clients"> К списку клиентов</a>
    	</div>

    	<div>Данные о представителе</div>
    	${client.client_name}
    	
    	<div>Представители: <div>
    	<div> Id,  адрес,  ФИО</div>
    	<body>
    	
         <table class = "main_data">
			<c:forEach items="${cc}" var="contact">
			<tr class = "table_info">
			   <td class = "contact_id"><a href="represent_page?id=${contact.client_represent_id}">
			   ${contact.client_represent_id}
				</a>
				</td>
				<td class = "lesson_id">
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
    
    </body>
</html>
