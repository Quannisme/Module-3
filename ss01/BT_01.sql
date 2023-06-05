create database student;
use  student;
create table student(
id int AUTO_INCREMENT primary key,
name char(50)
);
create table teacher(
id int AUTO_INCREMENT primary key,
name char(50),
age int,
country char(50)
);