create table customers (
    id bigint not null auto_increment primary key,
    first_name varchar,
    last_name varchar);

create sequence customers_seq start with 1 increment by 1;

insert into customers(id, first_name, last_name)
values (next value for customers_seq, 'Jan', 'Kowalski');
insert into customers(id, first_name, last_name)
values (next value for customers_seq, 'Mateusz', 'Morawiecki');
insert into customers(id, first_name, last_name)
values (next value for customers_seq, 'Andrzej', 'Duda');