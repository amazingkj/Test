create table booking_loc(  --������ ����
bl_no number(38),
bl_people varchar2(50),  --�����ο�
bl_date varchar2(50) --���೯¥, date�� �ð��� �����ϴ°� ���ƺ���
);

create sequence bl_no_seq
start with 1
increment by 1
nocache;

insert into booking_loc values();

select * from booking_loc order by desc;
