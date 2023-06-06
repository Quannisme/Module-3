create database QuanLyBanHang;
use QuanLyBanHang;
drop table Customer;
create table Customer(
CID int  primary key,
CName varchar(50),
CAge int
);

create table Orrder(
OID int auto_increment primary key,
CID int  ,
ODate date,
OTotalPrice int,
constraint fk_Customer_CID
foreign key(CID) references Customer(CID)
);

create table orderDetail(
OID int ,
PID int primary key,
OdQTY int,
constraint fk_Orrder_OID
foreign key(OID) references Orrder(OID)
);

create table Product(
PID int,
PName varchar(50),
PPrice int,
constraint fk_orderDetail_PID
foreign key (PID) references orderDetail(PID)
);
