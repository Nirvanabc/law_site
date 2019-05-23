use DB1;

create table clients (
	id SMALLINT not null auto_increment primary key,
    client_name VARCHAR (30) not null
);

create table client_contacts (
	id SMALLINT not null auto_increment primary key,
    client_id SMALLINT not null,
    person_id SMALLINT not null,
    adress VARCHAR (30)
);

create table employees (
	id SMALLINT not null auto_increment primary key,
    person_id SMALLINT not null,
    education VARCHAR (30) not null,
    position_id SMALLINT not null,
    adress VARCHAR (30)
);
   
create table positions (
	id SMALLINT not null auto_increment primary key,
    position_name VARCHAR (30) not null,
    salary INT
);

create table employees_in_service (
	id SMALLINT not null auto_increment primary key,
    service_id SMALLINT not null,
	employee_id SMALLINT
);

create table service_history (
	id SMALLINT not null auto_increment primary key,
    service_type SMALLINT,
    client_id SMALLINT,
    from_time DATETIME,
    to_time DATETIME
);

create table service_types (
	id SMALLINT not null auto_increment primary key,
    service_name VARCHAR (30),
    cost SMALLINT
);

create table phones (
	id SMALLINT not null auto_increment primary key,
	person_id SMALLINT not null,
    phone VARCHAR (15)
);

create table emails (
	id SMALLINT not null auto_increment primary key,
	person_id SMALLINT not null,
    email VARCHAR (30) not null
);

create table people (
	id SMALLINT not null auto_increment primary key,
    person_surname VARCHAR (30) not null,
    person_name VARCHAR (30) not null,
    person_patronymic VARCHAR (30)
);

create table education (
	id SMALLINT not null auto_increment primary key,
    education_name VARCHAR (30) not null
);

alter table employees add
	foreign key (person_id)
    references people (id)
    on delete cascade;
    
alter table client_contacts add
	foreign key (client_id)
    references clients (id)
    on delete cascade;

alter table client_contacts add
    foreign key (person_id)
    references people (id)
    on delete cascade;

alter table emails add
	foreign key (person_id)
    references people (id)
    on delete cascade;

alter table phones add
	foreign key (person_id)
    references people (id)
    on delete cascade;

alter table employees add
	foreign key (position_id)
    references positions (id)
    on delete cascade;
    
alter table employees add
	foreign key (position_id)
    references education (id)
    on delete cascade;

alter table service_history add
	foreign key (client_id)
    references clients (id)
    on delete cascade;
    
alter table service_history add
	foreign key (service_type)
    references service_types (id)
    on delete cascade;
    
alter table employees_in_service add
	foreign key (service_id)
    references service_history (id)
    on delete cascade;

alter table employees_in_service add
	foreign key (employee_id)
    references employees (id)
    on delete cascade;
