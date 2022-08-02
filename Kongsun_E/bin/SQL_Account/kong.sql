--리뷰 테이블 생성 
create table reviewbook(
r_no int primary key --번호 
,r_id varchar(50) default 0--계정ID
,r_store varchar2(200)  --가게이름
,r_point varchar2(50) --평점 (1,2,3,4,5)
,r_cont varchar2(200) -- 내용
,r_date date -- 등록 날짜 
);

drop table reviewbook;

--rno_seq라는 시퀀스명 생성 
create sequence rno_seq
start with 1
increment by 1 
nocache;

drop sequence rno_seq;

--시퀀스 번호값 확인 
select rno_seq.nextval as "시퀀스번호값" from dual; 

--확인
select * from reviewbook order by r_no desc;
select * from reviewbook order by r_date desc;

--리뷰 삭제 
delete from reviewbook where r_no=14;


--rno_seq라는 시퀀스명 생성 
create sequence pno_seq
start with 1
increment by 1 
nocache;

--시퀀스 번호값 확인 
select pno_seq.nextval as "시퀀스번호값" from dual; 

--확인
select * from pay_list;



INSERT INTO reviewbook VALUES(rno_seq.nextval, '닉네임', '훌리오 딜리버리','★★★★★','타코를 시켜서 먹었는데 정말 맛있었어요! 얼마나 맛있었냐면, 둘이 먹다가 하나 죽었는데 몰랐다니까요?', sysdate);
INSERT INTO reviewbook VALUES(rno_seq.nextval, '닉네임', '카레전문점','★★★★★','별로예요, 내 마음의 별로', sysdate);
INSERT INTO reviewbook VALUES(rno_seq.nextval, '닉네임', '훌리오 딜리버리','★★★★★','하하하, 또 시켜먹어야지~', sysdate);

INSERT INTO reviewbook VALUES(rno_seq.nextval, '불고기사랑해요', '별사랑 불고기','★★★★★','하하하, 또 시켜먹어야지~', sysdate);
INSERT INTO reviewbook VALUES(rno_seq.nextval, '내마음', '별사랑 불고기','★★★★★','정말 맛있었어요! 얼마나 맛있었냐면, 둘이 먹다가 하나 죽었는데 몰랐다니까요?', sysdate);
INSERT INTO reviewbook VALUES(rno_seq.nextval, '오예', '별사랑 불고기','★★★★★','별로예요, 내 마음의 별로', sysdate);
INSERT INTO reviewbook VALUES(rno_seq.nextval, '맛있어요', '별사랑 불고기','★★★★★','주말에 소주랑 함께 불고기 또 시켜먹을게요, 서비스 많이 주세요! ~', sysdate);





















