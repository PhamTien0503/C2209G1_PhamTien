create database if not exists material_management;
use material_management;

create table phieu_xuat(
  so_phieu_xuat int auto_increment primary key, 
  ngay_xuat date
);

create table phieu_nhap(
  so_phieu_nhap int auto_increment primary key, 
  ngay_nhap date
);

create table vat_tu(
  ma_vat_tu int primary key auto_increment, 
  ten_vat_tu varchar(50)
);

create table chi_tiet_phieu_xuat(
  so_phieu_xuat int not null, 
  ma_vat_tu int, 
  don_gia_xuat int, 
  so_luong_xuat int, 
  primary key(so_phieu_xuat, ma_vat_tu), 
  foreign key(so_phieu_xuat) references phieu_xuat(so_phieu_xuat), 
  foreign key(ma_vat_tu) references vat_tu(ma_vat_tu)
);

create table chi_tiet_phieu_nhap(
  so_phieu_nhap int, 
  ma_vat_tu int, 
  don_gia_nhap int, 
  so_luong_nhap int, 
  primary key(so_phieu_nhap, ma_vat_tu), 
  foreign key(so_phieu_nhap) references phieu_nhap(so_phieu_nhap), 
  foreign key(ma_vat_tu) references vat_tu(ma_vat_tu)
);

create table nha_cung_cap(
  ma_nha_cung_cap int auto_increment primary key, 
  ten_nha_cung_cap varchar(50), 
  dia_chi varchar(50)
);

create table so_dien_thoai(
  ma_so_dien_thoai int auto_increment primary key, 
  so_dien_thoai varchar(12), 
  ma_nha_cung_cap int, 
  foreign key(ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);

create table don_dat_hang(
  so_don_hang int auto_increment primary key, 
  ngay_hop_dong date, 
  ma_nha_cung_cap int, 
  foreign key(ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);

create table chi_tiet_don_dat_hang(
  ma_vat_tu int, 
  so_don_hang int, 
  primary key(ma_vat_tu, so_don_hang), 
  foreign key(ma_vat_tu) references vat_tu(ma_vat_tu), 
  foreign key(so_don_hang) references don_dat_hang(so_don_hang)
);





