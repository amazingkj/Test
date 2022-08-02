create table emp3(
 g_no int primary key --식당번호
 ,g_sr varchar2(200) not null --식당
);	

select * from emp3 order by g_no desc;

select g_no from emp3 where g_sr=?;

select * from emp3;

delete  emp1;

insert into emp3 values(1,'별사랑 불고기');
insert into emp3 values(2,'죽도령');
insert into emp3 values(3,'영웅 갈비찜');
insert into emp3 values(4,'운봉');
insert into emp3 values(5,'일품각');
insert into emp3 values(6,'해피판다');
insert into emp3 values(7,'미카코카레');
insert into emp3 values(8,'우동마이루식');
insert into emp3 values(9,'카츠반 프리미엄');
insert into emp3 values(10,'에그드랍');
insert into emp3 values(11,'홀리오');
insert into emp3 values(12,'제비 파스타&리조또');

update emp3 set g_sr='별사랑 불고기' where g_no=1;


