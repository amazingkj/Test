create table board(
b_no number(38),
b_title varchar2(100),  --������
b_writer varchar2(100),  --�۾���
b_cont varchar2(3000),  --�۳���
b_view number(38),  --��ȸ��
b_like number(38),  --���ƿ䰳��
b_bad number(38)  --�Ⱦ�䰳��
);

create sequence b_no_seq
start with 1
increment by 1
nocache;

insert into board values();

select * from board order by desc;



