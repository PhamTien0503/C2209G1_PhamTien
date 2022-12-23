create database sale_management;
use sale_management;

create table customer(
  id_customer int auto_increment primary key, 
  name_customer varchar(50), 
  age_customer int
);

create table product(
  id_product int auto_increment primary key, 
  name_product varchar(50), 
  price_product int
);

create table `order`(
  id_order int auto_increment primary key, 
  id_customer int, 
  date_order date, 
  total_price_order int, 
  foreign key(id_customer) references customer(id_customer)
);

create table detail_order(
  id_product int, 
  id_order int, 
  quatity_order int, 
  primary key(id_product, id_order), 
  foreign key(id_product) references product(id_product), 
  foreign key(id_order) references `order`(id_order)
);

