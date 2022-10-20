create table if not exists buyers(
    id bigserial primary key ,
    first_name varchar(50) not null ,
    last_name varchar(100) not null ,
    address varchar(1000) not null ,
    budget decimal not null
);