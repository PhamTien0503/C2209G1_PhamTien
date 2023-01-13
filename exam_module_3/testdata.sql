create database exam_module_3;
use exam_module_3;

create table position (
id int primary key auto_increment,
name varchar(45)
);

create table employee (
id int primary key auto_increment,
name varchar(45),
date_of_birth date,
gender bit(1),
position_id int,
foreign key (position_id) references position (id) on delete set null
);

insert into position 
values 
  (1, 'Quản Lý'), 
  (2, 'Nhân Viên');
  
insert into employee (name,date_of_birth,gender,position_id)
values('Nguyễn Văn An', '1970-11-07',0,1),
  (
    'Nguyễn Văn Ba', '1970-11-07',0,1
  );
  
  select * from position;
  
  select * from employee;
  
  delete from employee where id =3;
  
  select * from employee where name like '%%' and position_id like '%%';
  
  update employee set name='Pham Tien', date_of_birth='1994-11-07',gender=1,position_id=2 where id=2;