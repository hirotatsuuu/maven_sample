drop database if exists maven_sample;
create database if not exists maven_sample;
connect maven_sample;
drop table if exists fruits;
create table fruits(
id integer primary key,
name varchar(20),
price integer
);
insert into fruits(id, name, price) values (1, 'apple', 120);
insert into fruits(id, name, price) values (2, 'banana', 100);
insert into fruits(id, name, price) values (3, 'orange', 150);