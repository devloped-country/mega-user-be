create database megaTest;
use megaTest;

create table users_test (
	ID varchar(12) primary key,
    PASSWORD varchar(12) not null,
    name varchar(30) not null,
    role varchar(6) not null
);


insert into users_test values ('admin', '1234', '어드민', 'ADMIN');
insert into users_test values ('test01', '1234', '테스트01', 'USER');
insert into users_test values ('test02', '1234', '테스트02', 'USER');
insert into users_test values ('test03', '1234', '테스트03', 'USER');