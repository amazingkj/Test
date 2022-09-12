--메뉴,음식점 img ,가격, 수량 
create table CeoMenu(
meimg_2 varchar2(100) ,--메뉴이미지 좌표
count_2 int ,--수량 
price_2 varchar2(100) ,--가격
once_2 varchar2(100)  --일회용품 체크박스
);

create table Menu_2(
meimg_2 varchar2(100) ,--메뉴이미지 좌표
count_2 int ,--수량 
price_2 varchar2(100) ,--가격
once_2 varchar2(100)  --일회용품 체크박스
);

select*from CeoMenu;

delete from CeoMenu;
delete from Menu_2;

alter table Menu_2 modify count_2 int;
alter table CeoMenu modify count_2 int;

alter table Menu_2 add cusname varchar2(50);
alter table CeoMenu add cusname varchar2(50);
alter table Menu_2 add addr varchar2(50);
alter table CeoMenu add addr varchar2(50);
alter table Menu_2 add menu varchar2(50);
alter table CeoMenu add menu varchar2(50);
alter table Menu_2 add tip varchar2(50);
alter table CeoMenu add tip varchar2(50);
alter table Menu_2 add rest varchar2(50);
alter table CeoMenu add rest varchar2(50);

create table finish(
ordertime date
,menu varchar2(50)
,counting int
,price varchar2(50)
);
