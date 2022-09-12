create table score_card(  --���ھ�ī��
s_id varchar2(50),  --id, member���� �����ϴ� id���� ��.
s_location varchar2(50),  --����ģ ���
--�̸�, ������ �α����� �������� ������ ��(�ܷ�Ű or ����)
s_putting number(38),  --����Ƚ��
s_range number(38),  --��Ÿ�, ������ �����ɼ� ����
s_handicap number(38),  --�ڵ�ĸ
s_date varchar2(50)  --���ھ�ī�� ��ϵ� ��¥
);

create sequence s_no_seq
start with 1
increment by 1
nocache;

create sequence test_s_no_seq
start with 1
increment by 1
nocache;

select * from score_card;

delete from score_card;
drop table score_card;

select count(s_date) from score_card where s_id='id1' and s_date like '1��%';


insert into score_card values('id1','golf1',1,200,1,'1��1��');
insert into score_card values('id1','golf1',1,200,1,'1��2��');
insert into score_card values('id1','������2',1,220,1,'2��1��');
insert into score_card values('id1','������3',1,210,1,'3��1��');
insert into score_card values('id1','������4',1,230,1,'4��1��');
insert into score_card values('id1','������5',1,250,1,'5��1��');
insert into score_card values('id1','������6',1,240,1,'6��1��');
insert into score_card values('id1','������7',1,280,1,'7��1��');
insert into score_card values('id1','������8',1,260,1,'8��1��');

insert into score_card values('id2','������1',1,290,1,'1��1��');
insert into score_card values('id2','������2',1,220,1,'2��1��');
insert into score_card values('id2','������3',1,210,1,'3��1��');
insert into score_card values('id2','������4',1,230,1,'4��1��');
insert into score_card values('id2','������5',1,250,1,'5��1��');
insert into score_card values('id2','������6',1,240,1,'6��1��');
insert into score_card values('id2','������7',1,280,1,'7��1��');
insert into score_card values('id2','������8',1,260,1,'8��1��');

insert into score_card values('id3','������1',1,200,1,'1��1��');
insert into score_card values('id3','������2',1,220,1,'2��1��');
insert into score_card values('id3','������3',1,210,1,'3��1��');
insert into score_card values('id3','������4',1,230,1,'4��1��');
insert into score_card values('id3','������5',1,250,1,'5��1��');
insert into score_card values('id3','������6',1,240,1,'6��1��');
insert into score_card values('id3','������7',1,280,1,'7��1��');
insert into score_card values('id3','������8',1,260,1,'8��1��');

insert into score_card values('id4','������1',1,200,1,'1��1��');
insert into score_card values('id4','������2',1,220,1,'2��1��');
insert into score_card values('id4','������3',1,210,1,'3��1��');
insert into score_card values('id4','������4',1,230,1,'4��1��');
insert into score_card values('id4','������5',1,250,1,'5��1��');
insert into score_card values('id4','������6',1,240,1,'6��1��');
insert into score_card values('id4','������7',1,280,1,'7��1��');
insert into score_card values('id4','������8',1,260,1,'8��1��');

insert into score_card values('id5','������1',1,200,1,'1��1��');
insert into score_card values('id5','������2',1,220,1,'2��1��');
insert into score_card values('id5','������3',1,210,1,'3��1��');
insert into score_card values('id5','������4',1,230,1,'4��1��');
insert into score_card values('id5','������5',1,250,1,'5��1��');
insert into score_card values('id5','������6',1,240,1,'6��1��');
insert into score_card values('id5','������7',1,280,1,'7��1��');
insert into score_card values('id5','������8',1,260,1,'8��1��');

insert into score_card values('id6','������1',1,200,1,'1��1��');
insert into score_card values('id6','������2',1,220,1,'2��1��');
insert into score_card values('id6','������3',1,210,1,'3��1��');
insert into score_card values('id6','������4',1,230,1,'4��1��');
insert into score_card values('id6','������5',1,250,1,'5��1��');
insert into score_card values('id6','������6',1,240,1,'6��1��');
insert into score_card values('id6','������7',1,280,1,'7��1��');
insert into score_card values('id6','������8',1,260,1,'8��1��');

insert into score_card values('id7','������1',1,200,1,'1��1��');
insert into score_card values('id7','������2',1,220,1,'2��1��');
insert into score_card values('id7','������3',1,210,1,'3��1��');
insert into score_card values('id7','������4',1,230,1,'4��1��');
insert into score_card values('id7','������5',1,250,1,'5��1��');
insert into score_card values('id7','������6',1,240,1,'6��1��');
insert into score_card values('id7','������7',1,280,1,'7��1��');
insert into score_card values('id7','������8',1,260,1,'8��1��');

insert into score_card values('id8','������1',1,200,1,'1��1��');
insert into score_card values('id8','������2',1,220,1,'2��1��');
insert into score_card values('id8','������3',1,210,1,'3��1��');
insert into score_card values('id8','������4',1,230,1,'4��1��');
insert into score_card values('id8','������5',1,250,1,'5��1��');
insert into score_card values('id8','������6',1,240,1,'6��1��');
insert into score_card values('id8','������7',1,280,1,'7��1��');
insert into score_card values('id8','������8',1,260,1,'8��1��');



















