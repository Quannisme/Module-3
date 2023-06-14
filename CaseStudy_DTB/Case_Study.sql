create database quan_ly_khu_nghi_duong_Furama;
use quan_ly_khu_nghi_duong_Furama;

create table Vi_tri(
Ma_vi_tri int auto_increment primary key,
Ten_vi_tri varchar(50)
);

create table Trinh_do(
Ma_trinh_do int auto_increment primary key,
Ten_trinh_do varchar(50)
);

create table Bo_Phan(
Ma_bo_phan int auto_increment primary key,
Ten_bo_phan varchar(50)
);

create table Nhan_vien(
Ma_nhan_vien int auto_increment primary key ,
Ten_nhan_vien char(50),
Ngay_sinh_nhan_vien date,
SoCMND_nhan_vien varchar(50),
Luong_nhan_vien int,
SoDTH varchar(50),
Email_nhan_vien varchar(50),
Dia_chi_nhan_vien varchar(50),
Ma_vi_tri int,
Ma_trinh_do int,
Ma_bo_phan int,
unique(Ma_vi_tri ,Ma_trinh_do, Ma_bo_phan),
foreign key(Ma_vi_tri) references Vi_tri(Ma_vi_tri),
foreign key (Ma_trinh_do) references Trinh_do(Ma_trinh_do),
foreign key(Ma_bo_phan) references Bo_phan(Ma_bo_phan)
);

create table Loai_khach(
Ma_loai_khach int auto_increment primary key,
Ten_loai_khach varchar(50)
);

create table Khach_hang(
Ma_khach_hang int auto_increment primary key,
Ma_loai_khach int ,
Ten_khach_hang varchar(50),
Ngay_sinh_khach_hang date,
Gioi_tinh_khach_hang varchar(10),
SoCMND_khach_hang varchar(50),
SoDTH varchar(50),
Email_khach_hang varchar(50),
Dia_chi_khach_hang varchar(50),
foreign key (Ma_loai_khach) references Loai_khach(Ma_loai_khach)
);

create table Loai_dich_vu(
Ma_loai_dich_vu int auto_increment primary key,
Ten_loai_dich_vu varchar(50)
);

create table Kieu_thue(
Ma_ten_kieu_thue int auto_increment primary key,
Ten_kieu_thue varchar(50)
);

create table Dich_vu(
Ma_dich_vu int auto_increment primary key,
Ten_dich_vu varchar(50) ,
Dien_tich_su_dung_dich_vu int,
Chi_phi_thue_dich_vu int,
So_luong_nguoi_toi_da_dich_vu int,
Ma_ten_kieu_thue int ,
Ma_loai_dich_vu int ,
Tieu_chuan_phong varchar(50),
Mo_ta_tien_nghi_khac varchar(50),
Dien_tich_ho_boi int,
So_tang_dich_vu int,
unique(Ma_dich_vu,Ma_ten_kieu_thue),
foreign key (Ma_loai_dich_vu) references Loai_dich_vu(Ma_loai_dich_vu),
foreign key (Ma_ten_kieu_thue) references Kieu_thue(Ma_ten_kieu_thue)
);

create table Hop_dong(
Ma_hop_dong int auto_increment primary key,
Ngay_lam_hop_dong date,
Ngay_ket_thuc_hop_dong date,
Tien_dat_coc_hop_dong int,
Ma_nhan_vien int ,
Ma_khach_hang int  ,
Ma_dich_vu int ,
unique(Ma_nhan_vien , Ma_khach_hang, Ma_dich_vu),
foreign key (Ma_nhan_vien) references Nhan_vien(Ma_nhan_vien),
foreign key(Ma_khach_hang) references Khach_hang(Ma_khach_hang),
foreign key(Ma_dich_vu) references Dich_vu(Ma_dich_vu)
);

create table Dich_vu_di_kem(
Ma_dich_vu_di_kem int auto_increment primary key,
Ten_dich_vu_di_kem varchar(50),
Gia_dich_vu_di_kem int,
don_vi_dich_vu_di_kem varchar(10),
Trang_thai_dich_vu_di_kem varchar(20)
);

create table Hop_dong_chi_tiet(
Ma_hop_dong_chi_tiet int auto_increment primary key,
Ma_hop_dong int ,
Ma_dich_vu_di_kem int ,
So_luong_nguoi int,
unique (Ma_hop_dong ,Ma_dich_vu_di_kem),
foreign key (Ma_hop_dong) references Hop_dong(Ma_hop_dong),
foreign key (Ma_dich_vu_di_kem) references Dich_vu_di_kem(Ma_dich_vu_di_kem)
);
-- THem du lieu vao table vi_tri
insert into Vi_tri(Ten_vi_tri)
values
('Quản Lý'),
('Nhân Viên');

-- Them du lieu vao table Trinh_do
insert into Trinh_do(Ten_trinh_do)
values
	('Trung Cấp'),
	('Cao Đẳng'),
    ('Đại học'),
    ('Sau Đại học');
-- 	Them du lieu vao table bo phan
insert into Bo_Phan(Ten_bo_phan)
values
	('Sale-Marketing'),
	('Hành chính'),
	('Phục vụ'),
	('Quản lý');


-- them du lieu vao table nhan vien loi roi
insert into Nhan_vien
(Ten_nhan_vien,Ngay_sinh_nhan_vien,SoCMND_nhan_vien,Luong_nhan_vien,SoDTH,Email_nhan_vien,Dia_chi_nhan_vien,Ma_vi_tri,Ma_trinh_do,Ma_bo_phan)
values 
	('Nguyễn Văn An','1970-11-07','456231786',10000000,'0901234121','annguyen@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1),
    ('Lê Văn Bình',	'1997-04-09','654231234',7000000,'0934212314','binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2),
	('Hồ Thị Yến','1995-12-12','999231723',14000000,'0412352315','thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2),
	('Võ Công Toản','1980-04-04','123231365',17000000,'0374443232','toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',	1,4,4),
	('Nguyễn Bỉnh Phát','1999-12-09','454363232',6000000,'0902341231','phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,	1,1),
	('Khúc Nguyễn An Nghi','2000-11-08','964542311',7000000,'0978653213','annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3),
	('Nguyễn Hữu Hà','1993-01-01','	534323231',	8000000,'0941234553','nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',	2,3,2),
	('Nguyễn Hà Đông','	1989-09-03','234414123',9000000,'0642123111','donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4),
	('Tòng Hoang','1982-09-03','256781231',6000000,'0245144444','hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4),
	('Nguyễn Công Đạo','1994-01-08','755434343',8000000,'0988767111','nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2);


   --  them du lieu vao loai khach
	insert into Loai_khach(Ten_loai_khach)
    values
    ('Diamond'),
	('Platinium'),
	('Gold'),
	('Silver'),
	('Member');

-- Them du lieu vao khach hang van loi 
insert into Khach_hang(Ten_khach_hang,Ngay_sinh_khach_hang,Gioi_tinh_khach_hang,SoCMND_khach_hang,SoDTH,Email_khach_hang,Dia_chi_khach_hang,Ma_loai_khach)
values
('Nguyễn Thị Hào','	1970-11-07','0','643431213',0945423362,'thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',5),
('Phạm Xuân Diệu','1992-08-08','1','865342123','0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị',3),
('Trương Đình Nghệ','1990-02-27','1','488645199',0373213122,'nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',1),
('Dương Văn Quan','1981-07-08','1','543432111',0490039241,'duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng',1),
('Hoàng Trần Nhi Nhi','1995-12-09','0','795453345',0312345678,'nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai',4),
('Tôn Nữ Mộc Châu','2005-12-06','0','732434215',0988888844,'tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng',4),
('Nguyễn Mỹ Kim','1984-04-08','0','856453123',0912345698,'kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh',1),
('Nguyễn Thị Hào','1999-04-08','0','965656433',0763212345,'haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',3),
('Trần Đại Danh','1994-07-01','1','432341235',0643343433,'danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi',1),
('Nguyễn Tâm Đắc','1989-07-01','1','344343432',0987654321,'dactam@gmail.com','22 Ngô Quyền, Đà Nẵng',2);

-- Them du lieu vao kieu thue
insert into Kieu_thue(Ten_kieu_thue)
values 
	('year'),
	('month'),
	('day'),
	('hour');

-- Them du lieu vao loai dich vu
insert into Loai_dich_vu(Ten_loai_dich_vu)
values 
	('Villa'),
	('House'),
	('Room');
select * from Nhan_vien
where Ten_nhan_vien='H%' or Ten_nhan_vien='T%' or Ten_nhan_vien='K%' And length(Ten_nhan_vien)<15;