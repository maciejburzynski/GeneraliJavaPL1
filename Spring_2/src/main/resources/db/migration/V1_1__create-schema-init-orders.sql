create table orders (
        id bigint not null auto_increment primary key,
        customer_id bigint,
        price bigint,
        foreign key (customer_id) references customers(id)
);

create sequence orders_seq start with 1 increment by 1;

insert into orders(id, customer_id, price)
    values (1, 1, 1000);
