create table laptops (
        id bigint not null auto_increment primary key,
        make varchar,
        model varchar,
        price bigint,
        order_id bigint,
        constraint anyconstraint foreign key (order_id) references orders(id)
);

create sequence laptops_seq start with 1 increment by 1;

insert into laptops(id, make, model, price, order_id)
    values (1, 'lenovo','xd', 1000, 1);
