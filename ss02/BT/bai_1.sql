create database thietke_csdl_1;
use thietke_csdl_1;
create table PHIEUXUAT(
SoPX int primary key,
NgayXuat date
);

create table VATTU(
MaVTU int primary key,
TenVTU varchar(50)
);

create table PHIEUNHAP(
SoPN int primary key,
NhapNgay date
);
create table DONDH(
SoDH int primary key,
NgayDH date
);

create table NHACC(
MaNCC int primary key,
TenNCC varchar(50),
DiaChi varchar(50),
SDT int 
);

create table Chi_tiet_phieu_xuat(
DGXuat int ,
SLXuat int, 
SoPX int ,
MaVTU int,
primary key (SoPX,MaVTU),
foreign key(SoPX) references PHIEUXUAT(SoPX),
foreign key(MaVTU) references VATTU(MaVTU)
);

create table Chi_tiet_phieu_nhap(
DGNhap int,
SLNhap int,
MaVTU int,
SoPN int,
primary key(MaVTU,SoPN),
foreign key(MaVTU) references VATTU(MaVTU),
foreign key(SoPN) references PHIEUNHAP(SoPN)
);

create table Chi_tiet_don_dat_hang(
MaVTU int,
SoDH int,
primary key(MaVTU,SoDH),
foreign key (MaVTU) references VATTU(MaVTU),
foreign key (SoDH) references DONDH(SoDH)
);

create table Cung_cap(
SoDH int,
MaNCC int ,
primary key(SoDH,MaNCC),
foreign key(SoDH) references DONDH(SoDH),
foreign key(MaNCC) references NHACC(MaNCC)
);