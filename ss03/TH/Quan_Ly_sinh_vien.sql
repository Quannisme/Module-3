create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table Class(
ClassID int Not null auto_increment primary key,
ClassName varchar(60) not null,
StarDate datetime not null,
Statuc bit
);

create table Student(
StudentID int not null auto_increment primary key ,
StudentName varchar(30) not null,
Address varchar(50),
Phone varchar(20),
Status bit,
ClassID int not null,
foreign key (ClassID) references Class(ClassID)
);

create table Subject(
SubID int not null primary key auto_increment,
SubName varchar(30) not null,
Credit tinyint not null default 1 check(Credit>=1),
Status bit default 1 
);

create table Mark(
MarkID int not null primary key auto_increment,
SubID int not null ,
StudentID int not null,
Mark float default 0 check(0<Mark<100),
ExamTimes tinyint default 1,
unique (SubID,StudentID),
foreign key(SubID) references Subject(SubID),
foreign key(StudentID) references Student(StudentID)
);

insert into Class
values(1,'A1','2008-12-20',1);
insert into class
values(2,'A2','2008-12-22',1);
insert into Class
values(3,'B3',current_date(),0);

insert into Student(StudentID,StudentName,Address,Phone,Status,ClassID)
values(1,'Hung','Ha Noi',0912113113,1,1);
insert into Student(StudentID,StudentName,Address,Status,ClassID)
values(2,'Hoa','Hai Phong',1,1);
insert into Student(StudentID,StudentName,Address,Phone,Status,ClassID)
values(3,'Manh','HCM',0123123123,0,2);

insert into Subject(SubID,SubName,Credit,Status)
values(1,'CF',5,1);
insert into Subject(SubID,SubName,Credit,Status)
values(2,'C',6,1);
insert into Subject(SubID,SubName,Credit,Status)
values(3,'HDJ',5,1);
insert into Subject(SubID,SubName,Credit,Status)
values(4,'RDBMS',10,1);

insert into Mark(SubID,StudentID,Mark,ExamTimes)
values(1,1,8,1),
	   (1,2,10,2),
       (2,1,12,1);
       
select * from Student;

select *from Student 
where status=true;

select * from Subject
where status <10;

select *from Class
where ClassName='A1';

select S.StudentID,S.StudentName,C.ClassName
from Student S join Class C on S.ClassID=C.ClassID
where C.ClassName='A1';

select S.StudentID,S.StudentName,Sub.SubName,M.Mark
From student S join Mark M on S.StudentID=M.StudentID join Subject Sub on M.SubID=Sub.SubID
where Sub.SubName='CF';

Select StudentName from Student
where StudentName like 'h%';

select StarDate from Class
where date_format(StarDate,'%m')='12';

select * from Subject
where 3<Credit<5;

update Student 
set ClassID =2
where StudentName='Hung';

select S.StudentName, Sub.SubName,M.Mark
from Student S join Mark M on S.StudentID=M.StudentID 
join Subject Sub on M.SubID=Sub.SubID
order by Mark DESC, StudentName ASC;

-- ss04_Thuc Hanh
select Address , count(StudentID) as 'So luong hoc vien'
from Student
group by Address;

select S.StudentID,S.StudentName ,avg(Mark) from 
Student S join Mark M on S.StudentID=M.StudentID
group by StudentID,StudentName
having avg(Mark)>15;


select S.StudentID,S.StudentName ,avg(Mark) from 
Student S join Mark M on S.StudentID=M.StudentID
group by StudentID,StudentName
having avg(Mark)>=all(select avg(Mark) from Mark group by Mark.StudentID);

-- Bai tap SS04


-- hien thi tat ca cac thong tin mon hoc co credit lon nhat
select  *
from Subject
where Credit=(select max(Credit) from Subject);

-- Hien thi thong tin mon hoc co diem thi cao nhat
select Sub.SubID,Sub.SubName,Sub.Credit,Sub.Status , M.Mark from 
Subject Sub join Mark M on 
Sub.SubID=M.SubID
where Mark=(select max(Mark) from Mark);


-- Hien thi thong tin cua sinh vien  va diem trung binh cua moi sinh vien , xep hang theo thu tu giam dan
SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName