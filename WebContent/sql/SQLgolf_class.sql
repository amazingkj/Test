create table golf_class(  --����
c_no number(38),
c_name number(38),  --���¸�
c_phone number(38),  --��������ȣ
c_teacher number(38),  --�����
c_career01 number(38),  --����Ŀ����, ��� 02,03���� ����
c_gender number(38),  --���缺��
c_time number(38),  --1ȸ�� ���ǽð�
c_price number(38),  --���°���
c_schedule number(38),  --��������
c_addr number(38)  --�ֿ䰭������
);

create sequence c_no_seq
start with 1
increment by 1
nocache;

insert into golf_class values();

select * from golf_class order by desc;

