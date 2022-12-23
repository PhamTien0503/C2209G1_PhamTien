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
  id_order int, 
  id_product int, 
  quatity_order int, 
  primary key(id_product, id_order), 
  foreign key(id_product) references product(id_product), 
  foreign key(id_order) references `order` (id_order)
);

insert customer
values  (1,"Minh Quan",10),
		(2,"Ngoc Oanh",20),
        (3,"Hong Ha",50);
        
insert `order`
values   (1,1,'2006-03-21', null),
         (2,2,'2006-03-23', null),
         (3,1,'2006-03-16', null);
         
insert product
values  (1,"May Giat",3),
		(2,"Tu Lanh",5),
		(3,"Dieu Hoa",7),
		(4,"Quat",1),
		(5,"Bep Dien",2);
        
insert detail_order
values 	
		(1,1,3),
		(1,3,7),
		(1,4,2),
		(2,1,1),
		(3,1,8),
		(2,5,4),
		(2,3,3);
	
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select  id_order, date_order, total_price_order from `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select name_customer, name_product
from customer
	join `order` on customer.id_customer =`order`.id_customer 
	join detail_order on `order`.id_order = detail_order.id_order
	join product on product.id_product = detail_order.id_product;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select id_customer, name_customer from customer 
where id_customer not in (select id_customer from `order`);

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- Giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.
-- Giá bán của từng loại được tính = odQTY*pPrice.
    
select `order` .id_order, `order` .date_order, (sum(quatity_order*price_product)) as total_price
from `order` 
	join detail_order on `order`.id_order = detail_order.id_order
	join product on product.id_product = detail_order.id_product
group by id_order;





     
        
