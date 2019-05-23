use DB1;
select client_name 
	from employees join people on people.id = employees.person_id
	join employees_in_service  on employees_in_service.employee_id = employees.id
    join service_history on service_history.id = employees_in_service.service_id
    join clients on clients.id = service_history.client_id
    where person_name like 'Плющева'