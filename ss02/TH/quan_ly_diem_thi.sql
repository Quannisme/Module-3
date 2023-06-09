create database  if not exists quanlidiemthi;
use quanlidiemthi;
create table hocsinh(
mahs varchar(20) primary key,
tenhs varchar(50),
ngaysinh datetime,
lop varchar(20),
gt varchar(20)
);

create table monhoc(
nanh varchar(20) primary key,
tenmh varchar(50)
);
create table bangdiem(
mahs varchar(20),
nanh varchar(20),
diemthi int,
ngaykt datetime,
primary key (mahs,nanh),
foreign key(mahs) references hocsinh(mahs),
foreign key(nanh) references monhoc(nanh)
);

create table giaovien(
magv varchar(20) primary key,
tengv varchar(20),
sdt int
);

alter table monhoc add magvv varchar(20);
alter table monhoc add constraint fk_magv1 foreign key (magvv) references giaovien(magv);
