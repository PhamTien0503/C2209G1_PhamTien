create database furama_management_2;
use furama_management_2;

create table position (
id int primary key auto_increment,
name varchar(45)
);

create table education_degree (
id int primary key auto_increment,
name varchar(45)
);

create table division (
id int primary key auto_increment,
name varchar(45)
);

create table employee (
id int primary key auto_increment,
name varchar(45),
date_of_birth date,
id_card varchar(45),
salary double,
phone_number varchar(45),
email varchar(45),
address varchar(45),
position_id int,
foreign key (position_id) references position (id) on delete set null,
education_degree_id int,
foreign key (education_degree_id) references education_degree(id),
division_id int,
foreign key (division_id) references division (id)
);

create table customer_type (
id int primary key auto_increment,
name varchar(45)
);

create table customer (
id int primary key auto_increment,
customer_type_id int,
foreign key (customer_type_id) references customer_type (id),
name varchar(45),
date_of_birth date,
gender bit(1),
id_card varchar(45),
phone_number varchar(45),
email varchar(45),
address varchar(45)
);

create table facility_type (
id int primary key auto_increment,
name varchar(45)
);

create table rent_type (
id int primary key auto_increment,
name varchar(45)
);

create table facility (
id int primary key auto_increment,
name varchar(45),
area int,
cost double,
max_people int,
rent_type_id int,
facility_type_id int,
foreign key (rent_type_id) references rent_type(id),
foreign key (facility_type_id) references facility_type(id),
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int,
facility_free text
);

create table contract (
id int primary key auto_increment,
start_date datetime,
end_date datetime,
deposit double,
employee_id int,
customer_id int,
facility_id int,
foreign key (employee_id) references employee(id),
foreign key (customer_id) references customer(id),
foreign key (facility_id) references facility(id)
);

create table attach_facility (
id int primary key auto_increment,
name varchar(45),
cost double,
unit varchar(10),
status varchar(45)
);

create table contract_detail (
id int primary key auto_increment,
contract_id int,
attach_facility_id int,
foreign key (contract_id) references contract(id),
foreign key (attach_facility_id) references attach_facility(id),
quantity int
);

select * from customer_type;
select * from customer;

select c.*, ct.id as customer_type_id, ct.name from customer c
join customer_type ct on c.customer_type_id=ct.id;

insert into customer ( customer_type_id,name ,date_of_birth ,gender ,id_card ,phone_number ,email ,address)
values (1,'Sy', '1994-01-01',1,'02222334445','0383561453','phatien@gmail.com','Da nang');

select * from customer c;


update customer c set c.customer_type_id=2, c.name='The', c.date_of_birth='1994-02-01', c.gender=1, c.id_card='03203023', c.phone_number='123123213',c.email='12321312',c.address='fasfadfsdaf'where c.id=2;

delete from customer where id=11;

select * from customer where id=2 and name like '%The%';

select * from facility_type;

insert into facility (name ,area ,cost,max_people ,standard_room ,
description_other_convenience ,pool_area ,number_of_floors ,facility_free ,rent_type_id ,facility_type_id)
values 
  (
    'Villa Beach Front', 25000, 1000000, 
    10, 'vip', 'Có hồ bơi', 500, 4, 
    null, 3, 1
  ), 
  (
    'House Princess 01', 14000, 5000000, 
    7, 'vip', 'Có thêm bếp nướng', 
    null, 3, null, 2, 2
  ), 
  (
    'Room Twin 01', 5000, 1000000, 2, 
    'normal', 'Có tivi', null, null, 
    '1 Xe máy, 1 Xe đạp', 4, 3
  ), 
  (
   'Villa No Beach Front', 22000, 
    9000000, 8, 'normal', 'Có hồ bơi', 
    300, 3, null, 3, 1
  ), 
  (
    'House Princess 02', 10000, 4000000, 
    5, 'normal', 'Có thêm bếp nướng', 
    null, 2, null, 3, 2
  ), 
  (
    'Room Twin 02', 3000, 900000, 2, 
    'normal', 'Có tivi', null, null, 
    '1 Xe máy', 4, 3
  );

select * from rent_type;

select * from facility;





