create database QuanLyBanHang;
use QuanLyBanHang;

create table Customer(
CID int auto_increment primary key,
Name varchar(25),
CAge tinyint  
);

create table Orderr(
OID int auto_increment primary key,
CID int ,
ODate date,
OTotalPrice int,
foreign key (CID) references Customer(CID)
);

create table Product(
PID int auto_increment primary key,
PName varchar(25),
PPrice int
);

create table OrderDetail(
OID int ,
PID int ,
ODQTY int,
unique key(OID,PID),
foreign key (OID) references Orderr(OID),
foreign key(PID) references Product(PID)
);

insert into Customer(Name ,CAge)
values('Minh Quan',10),
	  ('Ngoc Oanh',20),
      ('Hong Ha',50);
      
insert into Orderr(CID,ODate,OTotalPrice)
values(1,'2006-03-21',null),
	  (2,'2006-03-23',null),
      (1,'2003-03-16',null);
      
insert into Product(PName , PPrice)
values('May Giat',3),
      ('Tu Lanh',5),
      ('Dieu hoa',7),
      ('Quat',1),
      ('Bep Dien',2);
      
insert into OrderDetail(OID,PID,ODQTY)
values(1,1,3),
      (1,3,7),
      (1,4,2),
      (2,1,1),
      (3,1,8),
      (2,5,4),
      (2,3,3);
      
select OID,ODate,OTotalPrice from Orderr;

-- Hien thi danh sach cac khach hang da mua hang va danh sach san pham da mua

select C.Name , P.PName from 
Customer C join Orderr O on C.CID=O.OID
join OrderDetail Od on O.OID=Od.OID
join Product P on Od.PID=P.PID;

select * from Customer C
where not exists(select * from Orderr where C.CID = CID);

-- hien thi ma hoa don , ngay ban , gia tien cua tung hoa don 
select O.OID,O.ODate,(Od.ODQTY*P.PPrice) as TongTien from 
Orderr O join OrderDetail Od on O.OID=Od.OID
join Product P on Od.PID=P.PID;