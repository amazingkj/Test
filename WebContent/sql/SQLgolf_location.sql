create table golf_location(  --������
l_no number(38),
l_category varchar2(50),  --�ʵ�/������ ����
l_name varchar2(50),  --�������
l_addr varchar2(50),  --�ּ�
l_phone varchar2(50),  --��ȭ��ȣ
l_email varchar2(50),  --�̸���
l_price varchar2(50)  --����
);

create sequence l_no_seq
start with 1
increment by 1
nocache;

insert into golf_location values();

select * from golf_location order by desc;





