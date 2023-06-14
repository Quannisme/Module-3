create database MProducts;
use MProducts;

create table Products(
id int  primary key,
ProdcutCode varchar(52) ,
ProductName varchar(50),
ProductPrice int ,
ProductAmount int,
ProductDescription varchar(50),
ProductStatus varchar(50)
); 
insert into Products 
Values 
(1,'A0534','iPhone5',2000,10,'Hàng mới','còn hàng'),
(2,'A0Re4','iPhone6',3000,11,'Hàng cũ','còn hàng'),
(3,'A05f4','iPhone7',4000,12,'Hàng mới','còn hàng'),
(4,'A0cy4','iPhone8',5000,13,'Hàng cũ','còn hàng'),
(5,'B0534','iPhone9',6000,14,'Hàng mới','còn hàng'),
(6,'Uf534','iPhone10',7000,15,'Hàng cũ','còn hàng'),
(7,'E0534','iPhone11',8000,167,'Hàng mới','còn hàng'),
(8,'I0534','iPhone12',9000,17,'Hàng cũ','còn hàng');

-- dung index
create Unique index index_Products on Products(ProdcutCode);
explain select * from Products where ProdcutCode='E0534';

create index index_Composite on Products(ProductPrice , ProductAmount);
-- vi sao khong dung and duoc ma phai dung or ta
explain select * from Products where ProductPrice=30000 or ProductAmount=11;

-- dung view
create view view_Products as select ProdcutCode,ProductName,ProductPrice,ProductStatus 
from Products;

-- sua doi view
create or replace view view_Products as 
select ProdcutCode,ProductName,ProductPrice,ProductStatus,ProductDescription
from Products;

-- xoa view
drop view view_Products;

-- dung store procedure
-- lay tat ca thong tin cua cac san pham
DELIMITER // 
create Procedure show_Infor()
Begin
select * from Products;
End//
DELIMITER ;

Call show_Infor();

-- them mot san pham

DELIMITER // 
create Procedure Add_Product
( in id int,in ProdcutCode varchar(52) ,in ProductName varchar(50),in ProductPrice int ,in ProductAmount int,in ProductDescription varchar(50),in ProductStatus varchar(50))
Begin
insert into Products
values(id,ProdcutCode,ProductName,ProductPrice,ProductAmount,ProductDescription,ProductStatus);
End//
DELIMITER ;

call Add_Product(9,'A003','den',100,1,'tot','ton nhieu');

select * from Products;

-- sua thong tin san pham theo id
DELIMITER // 
create procedure fix_index
(in idx int,in ProdcutCode varchar(52) ,in ProductName varchar(50),in ProductPrice int ,in ProductAmount int,in ProductDescription varchar(50),in ProductStatus varchar(50))
Begin 
update Products set
ProdcutCode=ProdcutCode,
ProductName =ProductName,
ProductPrice =ProductPrice,
ProductAmount =ProductAmount,
ProductDescription=ProductDescription,
ProductStatus =ProductStatus
where id=idx;
End //
DELIMITER ;
call fix_index(9,'A123','hah',100,1,'khong tot','qua nhieu hang');
select * from Products;

-- xoa san pham theo id
DELIMITER // 
create procedure delete_Products(in idx int)
Begin
delete from Products 
where id=idx;
End //
DELIMITER ;