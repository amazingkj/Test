create table ranking(
r_no number(38),
r_id varchar2(50), --ȸ�������� ���̵�� ����(�ܷ�Ű ���?)
r_sum number(38),
r_avg number(38),
r_putting number(38),
r_maxrange number(38),
r_avgrange number(38),
r_province varchar2(50)
);

alter table ranking add r_province varchar2(50);

drop table ranking;

create sequence r_no_seq
start with 1
increment by 1
nocache;

drop sequence r_no_seq;

insert into ranking values(r_no_seq.nextval,0,0,0,0,0,0,0,0);

select r_id from ranking order by r_sum asc;
select * from ranking order by r_sum asc;

select count(*) from ranking; --���̺� �� ���ڵ� ���� ��ȯ

create sequence test_r_no
start with 1
increment by 1
nocache;

drop sequence test_r_no;

insert into ranking values(test_r_no.nextval,'id1',0,0,1.5,100,100);
insert into ranking values(test_r_no.nextval,'id2',3,0,1.5,100,100);
insert into ranking values(test_r_no.nextval,'id3',-1,0,1.5,100,100);
insert into ranking values(test_r_no.nextval,'id4',-4,0,1.5,100,100);
insert into ranking values(test_r_no.nextval,'id5',4,0,1.5,100,100);
insert into ranking values(test_r_no.nextval,'id6',-3,0,1.5,100,100);
insert into ranking values(test_r_no.nextval,'id7',1,0,1.5,100,100);
insert into ranking values(test_r_no.nextval,'id8',2,0,1.5,100,100);

update ranking set r_sum=4 where r_id='id5';

update ranking set r_province='����' where r_id='id1';
update ranking set r_province='����' where r_id='id2';
update ranking set r_province='����' where r_id='id3';
update ranking set r_province='���' where r_id='id4';
update ranking set r_province='���' where r_id='id5';
update ranking set r_province='���' where r_id='id6';
update ranking set r_province='��õ' where r_id='id7';
update ranking set r_province='��õ' where r_id='id8';

select rownum,r_id from ranking order by r_sum asc;

delete from ranking;

