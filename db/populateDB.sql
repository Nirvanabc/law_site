use DB1;

insert into people values (1, 'Илюшин', 'Григорий', 'Семёнович');
insert into people values (2, 'Илюшин', 'Александр', 'Семёнович');
insert into people values (3, 'Плющева', 'Ирина', 'Марковна');
insert into people values (4, 'Петров', 'Илья', 'Борисович');
insert into people values (5, 'Гусев', 'Борис', 'Николаевич');
insert into people values (6, 'Игнатьев', 'Евгений', 'Николаевич');
insert into people values (7, 'Григорьев', 'Валентин', 'Олегович');

insert into emails values (1, 1, 'ilushingreg@mail.ru');
insert into emails values (2, 2, 'ilushinalex@yandex.ru');
insert into emails values (3, 3, 'plushir@mail.ru');
insert into emails values (4, 4, 'petrovil@mail.ru');
insert into emails values (5, 5, 'gusevbor@rambler.ru');
insert into emails values (6, 6, 'ignatyev@yandex.ru');
insert into emails values (7, 1, 'ilushingreg2@mail.ru');
insert into emails values (8, 2, 'ilushinalex2@yandex.ru');

insert into phones values(1, 1, '89856751123');
insert into phones values(2, 2, '89856751448');
insert into phones values(3, 3, '89856751451');
insert into phones values(4, 5, '89856751669');
insert into phones values(6, 6, '89296734123');
insert into phones values(7, 1, '89656343129');
insert into phones values(8, 2, '89856751156');
insert into phones values(9, 3, '89891751178');
insert into phones values(10, 7, '89856751132');

insert into positions values(1, 'юрист-консультант', 30000);
insert into positions values(2, 'нотариус', 40000);
insert into positions values(3, 'адвокат', 60000);

insert into clients values(1, 'ООО меньше налогов');
insert into clients values(2, 'ОАО консультации юристов');
insert into clients values(3, 'ИП Игнатьев');

insert into client_contacts values(1, 1, 1, 'Первоапрельская 8');
insert into client_contacts values(2, 2, 2, 'Первоиюньская 8');
insert into client_contacts values(3, 3, 6, 'Первомайская 8');

insert into employees values(1, 2, 1, 'Гудкова 5');
insert into employees values(2, 4, 2, 'Лесная 5');
insert into employees values(3, 5, 3, 'Кирова 5');
insert into employees values(4, 7, 3, 'Малая 5');

insert into service_types values(1, 'создание документа', 1000);
insert into service_types values(2, 'восстановление документа', 500);
insert into service_types values(3, 'сопровождение документа', 1000);
insert into service_types values(4, 'банкротство', 700);
insert into service_types values(5, 'эмиссия акций', 1000);
insert into service_types values(6, 'сопровождение сделок', 1000);
insert into service_types values(7, 'судебное представительство', 5000);
insert into service_types values(8, 'консультация', 300);

insert into service_history values(1, 1, 1, '2018-01-01', '2018-10-01');
insert into service_history values(2, 2, 2, '2018-02-03', '2018-02-27');
insert into service_history values(3, 3, 2, '2018-04-13', '2018-08-13');
insert into service_history values(4, 7, 3, '2018-10-15', '2019-01-15');

insert into employees_in_service values(1, 1, 1);
insert into employees_in_service values(2, 1, 2);
insert into employees_in_service values(3, 2, 3);
insert into employees_in_service values(4, 3, 4);
insert into employees_in_service values(5, 4, 3);