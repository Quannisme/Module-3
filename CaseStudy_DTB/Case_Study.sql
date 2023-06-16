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
foreign key (Ma_nhan_vien) references Nhan_vien(Ma_nhan_vien),
foreign key(Ma_khach_hang) references Khach_hang(Ma_khach_hang),
foreign key(Ma_dich_vu) references Dich_vu(Ma_dich_vu)
);

create table Dich_vu_di_kem(
Ma_dich_vu_di_kem int auto_increment primary key,
Ten_dich_vu_di_kem varchar(50),
Gia_dich_vu_di_kem int,
don_vi_dich_vu_di_kem varchar(50),
Trang_thai_dich_vu_di_kem varchar(50)
);

create table Hop_dong_chi_tiet(
Ma_hop_dong_chi_tiet int auto_increment primary key,
Ma_hop_dong int ,
Ma_dich_vu_di_kem int ,
So_luong_nguoi int,
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
    ('Lê Văn Bình','1997-04-09','654231234',7000000,'0934212314','binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2),
	('Hồ Thị Yến','1995-12-12','999231723',14000000,'0412352315','thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2),
	('Võ Công Toản','1980-04-04','123231365',17000000,'0374443232','toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4),
	('Nguyễn Bỉnh Phát','1999-12-09','454363232',6000000,'0902341231','phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1),
	('Khúc Nguyễn An Nghi','2000-11-08','964542311',7000000,'0978653213','annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3),
	('Nguyễn Hữu Hà','1993-01-01','534323231',8000000,'0941234553','nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2),
	('Nguyễn Hà Đông','1989-09-03','234414123',9000000,'0642123111','donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4),
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
('Nguyễn Thị Hào','1970-11-07','0','643431213',0945423362,'thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',5),
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
-- Them du lieu vao dich vu

insert into Dich_vu(Ten_dich_vu,Dien_tich_su_dung_dich_vu,Chi_phi_thue_dich_vu,So_luong_nguoi_toi_da_dich_vu,Tieu_chuan_phong,Mo_ta_tien_nghi_khac,Dien_tich_ho_boi,So_tang_dich_vu,Ma_ten_kieu_thue,Ma_loai_dich_vu)
values 
('Villa Beach Front',25000,10000000,10,'vip','Có hồ bơi',500,4,3,1),
('House Princess 01',14000,5000000,7,'vip','Có thêm bếp nướng',null,3,2,2),
('Room Twin 01',5000,1000000,2,'normal','Có tivi',null,null,4,3),
('Villa No Beach Front',22000,9000000,8,'normal','Có hồ bơi',300,3,3,1),
('House Princess 02',10000,4000000,5,'normal','Có thêm bếp nướng',null,2,3,2),
('Room Twin 02',3000,900000,2,'normal','Có tivi',null,null,4,3);

-- them du lieu vao dich vu di kem
insert into Dich_vu_di_kem(Ten_dich_vu_di_kem,Gia_dich_vu_di_kem,don_vi_dich_vu_di_kem,Trang_thai_dich_vu_di_kem)
values
('Karaoke',10000,'giờ','tiện nghi, hiện tại'),
('Thuê xe máy',10000,'chiếc','hỏng 1 xe'),
('Thuê xe đạp',20000,'chiếc','tốt'),
('Buffet buổi sáng',15000,'suất','đầy đủ đồ ăn, tráng miệng'),
('Buffet buổi trưa',90000,'suất','đầy đủ đồ ăn, tráng miệng'),
('Buffet buổi tối',16000,'suất','đầy đủ đồ ăn, tráng miệng');

-- them du lieu vao hop dong
insert into Hop_dong(Ngay_lam_hop_dong,Ngay_ket_thuc_hop_dong,Tien_dat_coc_hop_dong,Ma_nhan_vien,Ma_khach_hang,Ma_dich_vu)
values
('2020-12-08','2020-12-08',0,3,1,3),
('2020-07-14','2020-07-21',200000,7,3,1),
('2021-03-15','2021-03-17',50000,3,4,2),
('2021-01-14','2021-01-18',100000,7,5,5),
('2021-07-14','2021-07-15',0,7,2,6),
('2021-06-01','2021-06-03',0,7,7,6),
('2021-09-02','2021-09-05',100000,7,4,4),
('2021-06-17','2021-06-18',150000,3,4,1),
('2020-11-19','2020-11-19',0,3,4,3),
('2021-04-12','2021-04-14',0,10,3,5),
('2021-04-25','2021-04-25',0,2,2,1),
('2021-05-25','2021-05-27',0,7,10,1);

-- them du lieu vao hop dong chi tiet
insert into Hop_dong_chi_tiet(So_luong_nguoi,Ma_hop_dong,Ma_dich_vu_di_kem)
values
(5,2,4),
(8,2,5),
(15,2,6),
(1,3,1),
(11,3,2),
(1,1,3),
(2,1,2),
(2,12,2);
-- bai 2 trong case
select * from Nhan_vien
where (trim(Ten_nhan_vien) like'H%') or trim(Ten_nhan_vien) like'T%' or trim(Ten_nhan_vien like'K%') And length(Ten_nhan_vien)<=15;

-- bai3
select * from Khach_hang
where(18<(year(now())-year(Ngay_sinh_khach_hang))<50) and(Dia_chi_khach_hang like'% Đà Nẵng' or Dia_chi_khach_hang like'% Quảng Trị');

-- bai4
select Kh.Ten_khach_hang,count(1)as solandat from 
Loai_khach lk join Khach_hang kh on lk.Ma_loai_khach=kh.Ma_loai_khach
join Hop_dong hd on kh.Ma_khach_hang=hd.Ma_khach_hang
where (Ten_loai_khach like 'Diamond')
group by kh.Ten_khach_hang
order by solandat;

-- bai5 bi null ten dich vu va tong tien
select kh.Ma_khach_hang,kh.Ten_khach_hang,lk.Ten_loai_khach,hd.Ma_hop_dong,hd.ma_dich_vu, dv.Ten_dich_vu,hd.Ngay_lam_hop_dong,hd.Ngay_ket_thuc_hop_dong,
(dv.Chi_phi_thue_dich_vu +hdct.So_luong_nguoi * dvdk.Gia_dich_vu_di_kem)as tongtien  from
Loai_khach lk join Khach_hang kh on lk.Ma_loai_khach=kh.Ma_loai_khach
join Hop_dong hd on kh.Ma_khach_hang=hd.Ma_khach_hang
join Dich_vu dv on hd.Ma_dich_vu=dv.Ma_dich_vu
join Hop_dong_chi_tiet hdct on hd.Ma_hop_dong=hdct.Ma_hop_dong
join Dich_vu_di_kem dvdk on hdct.Ma_dich_vu_di_kem=dvdk.Ma_dich_vu_di_kem;

-- bai 6
select dv.Ma_dich_vu,dv.Ten_dich_vu,dv.Dien_tich_su_dung_dich_vu,dv.Chi_phi_thue_dich_vu,ldv.Ten_loai_dich_vu from
Loai_dich_vu ldv join Dich_vu dv on ldv.Ma_loai_dich_vu=dv.Ma_loai_dich_vu
join Hop_dong hd on dv.Ma_dich_vu=hd.Ma_dich_vu
where  month(hd.Ngay_lam_hop_dong) not in (01,02,03) and dv.Ten_dich_vu not in (select dv.Ten_dich_vu from
Dich_vu dv join Hop_dong hd on dv.Ma_dich_vu = hd.Ma_dich_vu where month(hd.Ngay_lam_hop_dong) in (1,2,3))
group by dv.Ma_dich_vu;

-- bai7
