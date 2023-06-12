create database quan_ly_khu_nghi_duong_Furama;
use quan_ly_khu_nghi_duong_Furama;

create table Vi_tri(
Ma_vi_tri varchar(50) primary key,
Ten_vi_tri varchar(50)
);

create table Trinh_do(
Ma_trinh_do varchar(50) primary key,
Ten_trinh_do varchar(50)
);

create table Bo_Phan(
Ma_bo_phan varchar(50) primary key,
Ten_bo_phan varchar(50)
);

create table Nhan_vien(
Ma_nhan_vien varchar(50) primary key ,
Ten_nhan_vien char(50),
Ngay_sinh_nhan_vien date,
SoCMND_nhan_vien varchar(50),
Luong_nhan_vien int,
SoDTH varchar(50),
Email_nhan_vien varchar(50),
Dia_chi_nhan_vien varchar(50),
Ma_vi_tri varchar(50),
Ma_trinh_do varchar(50),
Ma_bo_phan varchar(50),
unique(Ma_vi_tri ,Ma_trinh_do, Ma_bo_phan),
foreign key(Ma_vi_tri) references Vi_tri(Ma_vi_tri),
foreign key (Ma_trinh_do) references Trinh_do(Ma_trinh_do),
foreign key(Ma_bo_phan) references Bo_phan(Ma_bo_phan)
);

create table Loai_khach(
Ma_loai_khach varchar(50) primary key,
Ten_loai_khach varchar(50)
);

create table Khach_hang(
Ma_khach_hang varchar(50) primary key,
Ma_loai_khach varchar(50),
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
Ma_loai_dich_vu varchar(50) primary key,
Ten_loai_dich_vu varchar(50)
);

create table Kieu_thue(
Ma_ten_kieu_thue varchar(50) primary key,
Ten_kieu_thue varchar(50)
);

create table Dich_vu(
Ma_dich_vu varchar(50) primary key,
Ten_dich_vu varchar(50) ,
Dien_tich_su_dung_dich_vu int,
Chi_phi_thue_dich_vu int,
So_luong_nguoi_toi_da_dich_vu int,
Ma_ten_kieu_thue varchar(50),
Ma_loai_dich_vu varchar(50),
Tieu_chuan_phong varchar(50),
Mo_ta_tien_nghi_khac varchar(50),
Dien_tich_ho_boi int,
So_tang_dich_vu int,
unique(Ma_dich_vu,Ma_ten_kieu_thue),
foreign key (Ma_loai_dich_vu) references Loai_dich_vu(Ma_loai_dich_vu),
foreign key (Ma_ten_kieu_thue) references Kieu_thue(Ma_ten_kieu_thue)
);

create table Hop_dong(
Ma_hop_dong varchar(50) primary key,
Ngay_lam_hop_dong date,
Ngay_ket_thuc_hop_dong date,
Tien_dat_coc_hop_dong int,
Ma_nhan_vien varchar(50),
Ma_khach_hang varchar(50) ,
Ma_dich_vu varchar(50),
unique(Ma_nhan_vien , Ma_khach_hang, Ma_dich_vu),
foreign key (Ma_nhan_vien) references Nhan_vien(Ma_nhan_vien),
foreign key(Ma_khach_hang) references Khach_hang(Ma_khach_hang),
foreign key(Ma_dich_vu) references Dich_vu(Ma_dich_vu)
);

create table Dich_vu_di_kem(
Ma_dich_vu_di_kem varchar(50) primary key,
Ten_dich_vu_di_kem varchar(50),
Gia_dich_vu_di_kem int,
don_vi_dich_vu_di_kem varchar(10),
Trang_thai_dich_vu_di_kem varchar(20)
);

create table Hop_dong_chi_tiet(
Ma_hop_dong_chi_tiet varchar(50) primary key,
Ma_hop_dong varchar(50),
Ma_dich_vu_di_kem varchar(50),
So_luong_nguoi int,
unique (Ma_hop_dong ,Ma_dich_vu_di_kem),
foreign key (Ma_hop_dong) references Hop_dong(Ma_hop_dong),
foreign key (Ma_dich_vu_di_kem) references Dich_vu_di_kem(Ma_dich_vu_di_kem)
);

insert into Nhan_vien
values (