use DB1;
select * from clients;
select * from education;
select * from people;
select * from emails;
select * from positions;
select * from employees;
select email from emails;

select client_name
	from people inner join employees on people.id = employees.person_id
    inner join employees_in_service on employees.id = employees_in_service.employee_id
    inner join service_history on service_history.id = employees_in_service.service_id
    inner join clients on clients.id = service_history.client_id
    where people.person_surname like 'Илюшин';

select phones.phone, emails.email
	from phones inner join people on people.id = phones.person_id
    inner join emails on emails.person_id = people.id
    where people.person_surname like "Илюшин";
    
select adress, person_name, person_surname, person_patronymic, email, phone
    from people left join phones on phones.person_id = people.id
    left join emails on emails.person_id = people.id
    left join employees on employees.person_id = people.id
	where people.id = 1;
    
select client_name, service_name, from_time, to_time
	from clients inner join service_history on clients.id = service_history.client_id
    inner join service_types on service_types.id = service_history.service_type
    where '2018-02-01' between from_time and to_time and  '2018-02-01' between from_time and to_time;
    
select client_name, service_name, from_time, to_time 
				from clients inner join service_history on clients.id = service_history.client_id
			    inner join service_types on service_types.id = service_history.service_type
			    where client_name like 'ООО меньше налогов';
                
select distinct client_name
	from clients inner join service_history on clients.id = service_history.client_id
    inner join service_types on service_types.id = service_history.service_type
	where service_name like 'создание документа';
      
    
