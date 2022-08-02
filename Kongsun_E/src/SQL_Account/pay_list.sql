--결제내역 테이블 생성
CREATE TABLE PAY_LIST2(
p_no number(20), --주문번호
cus_no varchar2(50), --고객번호
p_date timestamp, --주문일시
d_way varchar2(20), --픽업방법
p_with varchar2(50), --결제수단
p_total varchar2(50), --총 주문 금액
d_tip varchar2(50), --배달팁
p_sum varchar2(50), --총 결제금액(총 주문 금액+배달팁)
addr varchar2(200), -- 배달 주소
req varchar2(1000), -- 요청사항(일회용품 여부)
restaurant varchar2(50),  --상호명
menu varchar2(50),  --음식
statement varchar2(50)  --배달상태(완료여부)
);

CREATE TABLE PAY_LIST3(
p_no number(20), --주문번호
cus_no varchar2(50), --고객번호
p_date timestamp, --주문일시
d_way varchar2(20), --픽업방법
p_with varchar2(50), --결제수단
p_total varchar2(50), --총 주문 금액
d_tip varchar2(50), --배달팁
p_sum varchar2(50), --총 결제금액(총 주문 금액+배달팁)
addr varchar2(200), -- 배달 주소
req varchar2(1000), -- 요청사항(일회용품 여부)
restaurant varchar2(50),  --상호명
menu varchar2(50),  --음식
statement varchar2(50)  --배달상태(완료여부)
);

SELECT * FROM PAY_LIST2;

delete from PAY_LIST2;
delete from PAY_LIST4;

--pno_seq라는 시퀀스명 생성
create sequence payno_seq
start with 1000
increment by 1
nocache;

drop sequence pno_seq;

--시퀀스 번호값 확인
select payno_seq.nextval as "시퀀스번호값" from dual;

select * from PAY_LIST2 order by p_no desc;

alter table pay_list2 modify cus_no varchar2(50);
alter table pay_list2 modify d_tip varchar2(50);
alter table pay_list2 modify p_total varchar2(50);
alter table pay_list2 modify p_sum varchar2(50);
alter table pay_list2 modify p_date timestamp;

alter table pay_list2 add img varchar2(50);
alter table pay_list4 add img varchar2(50);

INSERT INTO pay_list2 VALUES(pno_seq.nextval,1,sysdate,'배달','카드',25000,3000,28000,'서울시','없음','내사랑 불고기','불고기 비빔밥','배달 완료');
INSERT INTO pay_list2 VALUES(pno_seq.nextval,2,sysdate,'배달','카드',5000,3000,8000,'서울시','없음','에그 드랍','갈릭 베이컨 치즈 샌드위치','배달 완료');
INSERT INTO pay_list2 VALUES(pno_seq.nextval,2,sysdate,'배달','만나서 결제(카드/현금 가능)',20000,3000,23000,'서울시 강남구','일회용품 필요해요','영웅갈비찜','갈비찜','배달 완료');

--시간까지 나오도록 해봤지만 안됨.
INSERT INTO pay_list2 VALUES(pno_seq.nextval,2,to_date(sysdate,'YYYY-MM-DD HH24:mi'),'배달','카드',5000,2000,7000,'서울시','없음','내사랑 불고기','불고기 비빔밥','배달 완료');

select p_date,restaurant,menu from (select p_date,restaurant,menu,rownum as rn 
from (select p_date,restaurant,menu from pay_list2 p 
inner join member_login m on p.restaurant=m.m_bn 
where m.m_id = 'ceo1'
order by p_no desc)) where rn = 3;
