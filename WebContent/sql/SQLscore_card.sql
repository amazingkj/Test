create table score_card(  --스코어카드
s_id varchar2(50),  --id, member내에 존재하는 id여야 함.
s_location varchar2(50),  --골프친 장소
--이름, 성별은 로그인한 정보에서 가져올 것(외래키 or 세션)
s_putting number(38),  --퍼팅횟수
s_range number(38),  --비거리, 없으면 삭제될수 있음
s_handicap number(38),  --핸디캡
s_date varchar2(50)  --스코어카드 기록된 날짜
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

select count(s_date) from score_card where s_id='id1' and s_date like '1월%';


insert into score_card values('id1','golf1',1,200,1,'1월1일');
insert into score_card values('id1','golf1',1,200,1,'1월2일');
insert into score_card values('id1','골프장2',1,220,1,'2월1일');
insert into score_card values('id1','골프장3',1,210,1,'3월1일');
insert into score_card values('id1','골프장4',1,230,1,'4월1일');
insert into score_card values('id1','골프장5',1,250,1,'5월1일');
insert into score_card values('id1','골프장6',1,240,1,'6월1일');
insert into score_card values('id1','골프장7',1,280,1,'7월1일');
insert into score_card values('id1','골프장8',1,260,1,'8월1일');

insert into score_card values('id2','골프장1',1,290,1,'1월1일');
insert into score_card values('id2','골프장2',1,220,1,'2월1일');
insert into score_card values('id2','골프장3',1,210,1,'3월1일');
insert into score_card values('id2','골프장4',1,230,1,'4월1일');
insert into score_card values('id2','골프장5',1,250,1,'5월1일');
insert into score_card values('id2','골프장6',1,240,1,'6월1일');
insert into score_card values('id2','골프장7',1,280,1,'7월1일');
insert into score_card values('id2','골프장8',1,260,1,'8월1일');

insert into score_card values('id3','골프장1',1,200,1,'1월1일');
insert into score_card values('id3','골프장2',1,220,1,'2월1일');
insert into score_card values('id3','골프장3',1,210,1,'3월1일');
insert into score_card values('id3','골프장4',1,230,1,'4월1일');
insert into score_card values('id3','골프장5',1,250,1,'5월1일');
insert into score_card values('id3','골프장6',1,240,1,'6월1일');
insert into score_card values('id3','골프장7',1,280,1,'7월1일');
insert into score_card values('id3','골프장8',1,260,1,'8월1일');

insert into score_card values('id4','골프장1',1,200,1,'1월1일');
insert into score_card values('id4','골프장2',1,220,1,'2월1일');
insert into score_card values('id4','골프장3',1,210,1,'3월1일');
insert into score_card values('id4','골프장4',1,230,1,'4월1일');
insert into score_card values('id4','골프장5',1,250,1,'5월1일');
insert into score_card values('id4','골프장6',1,240,1,'6월1일');
insert into score_card values('id4','골프장7',1,280,1,'7월1일');
insert into score_card values('id4','골프장8',1,260,1,'8월1일');

insert into score_card values('id5','골프장1',1,200,1,'1월1일');
insert into score_card values('id5','골프장2',1,220,1,'2월1일');
insert into score_card values('id5','골프장3',1,210,1,'3월1일');
insert into score_card values('id5','골프장4',1,230,1,'4월1일');
insert into score_card values('id5','골프장5',1,250,1,'5월1일');
insert into score_card values('id5','골프장6',1,240,1,'6월1일');
insert into score_card values('id5','골프장7',1,280,1,'7월1일');
insert into score_card values('id5','골프장8',1,260,1,'8월1일');

insert into score_card values('id6','골프장1',1,200,1,'1월1일');
insert into score_card values('id6','골프장2',1,220,1,'2월1일');
insert into score_card values('id6','골프장3',1,210,1,'3월1일');
insert into score_card values('id6','골프장4',1,230,1,'4월1일');
insert into score_card values('id6','골프장5',1,250,1,'5월1일');
insert into score_card values('id6','골프장6',1,240,1,'6월1일');
insert into score_card values('id6','골프장7',1,280,1,'7월1일');
insert into score_card values('id6','골프장8',1,260,1,'8월1일');

insert into score_card values('id7','골프장1',1,200,1,'1월1일');
insert into score_card values('id7','골프장2',1,220,1,'2월1일');
insert into score_card values('id7','골프장3',1,210,1,'3월1일');
insert into score_card values('id7','골프장4',1,230,1,'4월1일');
insert into score_card values('id7','골프장5',1,250,1,'5월1일');
insert into score_card values('id7','골프장6',1,240,1,'6월1일');
insert into score_card values('id7','골프장7',1,280,1,'7월1일');
insert into score_card values('id7','골프장8',1,260,1,'8월1일');

insert into score_card values('id8','골프장1',1,200,1,'1월1일');
insert into score_card values('id8','골프장2',1,220,1,'2월1일');
insert into score_card values('id8','골프장3',1,210,1,'3월1일');
insert into score_card values('id8','골프장4',1,230,1,'4월1일');
insert into score_card values('id8','골프장5',1,250,1,'5월1일');
insert into score_card values('id8','골프장6',1,240,1,'6월1일');
insert into score_card values('id8','골프장7',1,280,1,'7월1일');
insert into score_card values('id8','골프장8',1,260,1,'8월1일');



















