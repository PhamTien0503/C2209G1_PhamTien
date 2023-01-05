create database users_management;
use users_management;

create table users (
  id int(3) not null auto_increment primary key, 
  name varchar(120) not null, 
  email varchar(220) not null, 
  country varchar(120)
);

insert into users (name, email, country) 
values 
  (
    'Minh', 'minh@codegym.vn', 'Viet Nam'
  );
  
insert into users (name, email, country) 
values 
  ('Kante', 'kante@che.uk', 'Kenia');
  
select 
  * 
from 
  users;
  
select 
  * 
from 
  users 
order by 
  name;
  
delimiter // create procedure add_user(
  id int(3), 
  name varchar(120), 
  email varchar(220), 
  country varchar(120)
) begin insert into users (id, name, email, country) 
values 
  (id, name, email, country);
end;
// delimiter ;

call add_user (
  10, 'Tien', 'tien@gmail.com', 'Viet Nam'
);

delimiter // create procedure select_all_user() begin 
select 
  * 
from 
  users;
end;
// delimiter ;

call select_all_user();
delimiter //
 create procedure update_user_by_id(
  id int(3), 
  name varchar(120), 
  email varchar(220), 
  country varchar(120)
) begin 
update 
  users u 
set 
  u.name = name, 
  u.email = email, 
  u.country = country 
where 
  u.id = id;
end;
// delimiter ;

call update_user_by_id(
  8, 'The Lan', 'laniuthe@gmail.com', 
  'VietNam'
);

delimiter // 
create procedure delete_user (id int) 
begin 
delete from 
  users u 
where 
  u.id = id;
end;
// delimiter ;

call delete_user(9);



 
 