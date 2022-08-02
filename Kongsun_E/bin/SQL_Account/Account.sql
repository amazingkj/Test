create table member(   --총 14종류, 공통 7종, 개인회원 +3종, 사업자 +3종, 회원구분(1:관리자, 2:사업자, 3:개인회원) 1종
m_no int primary key  --회원번호
,m_id varchar2(100) not null  --아이디
,m_pw varchar2(100) not null  --비번
,m_name varchar2(100) not null  --이름
,m_addr varchar2(100) not null  --주소
,m_phone varchar2(100) not null  --폰번

,m_joindate date  --가입일

,m_email varchar2(100)  --이메일
,m_gender varchar2(100)  --성별
,m_birth varchar2(100)  --생일

,m_crn varchar2(100)   --사업자등록번호
,m_bn varchar2(100)   --상호명
,m_food varchar2(100)  --음식종류
,m_menu_1 varchar2(100)  --세부메뉴1
,m_menu_2 varchar2(100)  --세부메뉴2
,m_menu_3 varchar2(100)  --세부메뉴3
,m_cost_1 varchar2(100)  --상품가격1
,m_cost_2 varchar2(100)  --상품가격2
,m_cost_3 varchar2(100)  --상품가격3
,m_tip varchar2(100)  --배달팁

,m_lv int --관리자,사업자,손님 구분
);

create sequence m_no_seq  --1부터 1씩 증가하는 시퀀스 생성
start with 1
increment by 1
nocache --임시장소 사용하지 않음

alter user kong quota 150M on member;  --용량설정?

insert into member values(m_no_seq.nextval,'admin','admin','관리자','KGITBANK',
'010-1111-1111',sysdate,'admin@admin.admin','남자','1111년11월11일','111-11-11111','kgitbank','한식',1)  --관리자용 계정 생성(쓸모없을듯)

select * from member order by m_no asc;  --member 테이블 검색

create table member_login as select * from member where 1=0; --테이블 컬럼만 복사로 로그인 정보 테이블 생성

delete from member_login; --테이블 내 레코드 전부삭제
delete from member;

insert into member (m_no, m_id, m_pw, m_name, m_addr, m_phone, m_joindate, m_crn, m_bn, m_food, m_menu_1, m_menu_2, m_menu_3, m_cost_1, m_cost_2, m_cost_3, m_tip, m_lv)
values (m_no_seq.nextval, 'ceo1', '11', '김사업', '서울 강남구', '010-1212-1212', sysdate, '111-22-33445', '별사랑 불고기', '한식', '1인 불고기세트'
		,'2인 불고기세트', '3~4인 불고기세트', '12900', '23400', '37400', '2500', 2);

insert into member (m_no, m_id, m_pw, m_name, m_addr, m_phone, m_joindate, m_crn, m_bn, m_food, m_menu_1, m_menu_2, m_menu_3, m_cost_1, m_cost_2, m_cost_3, m_tip, m_lv)
values (m_no_seq.nextval, 'ceo2', '11', '김사업', '서울 강남구', '010-1212-1212', sysdate, '111-22-33445', '죽도령', '한식', '꼬끼오~영양닭죽', '음메~한우소고기'
		, '예뻐지는호박죽', '9500', '9500', '9900', '2500', 2);

insert into member (m_no, m_id, m_pw, m_name, m_addr, m_phone, m_joindate, m_crn, m_bn, m_food, m_menu_1, m_menu_2, m_menu_3, m_cost_1, m_cost_2, m_cost_3, m_tip, m_lv)
values (m_no_seq.nextval, 'ceo3', '11', '김사업', '서울 강남구', '010-1212-1212', sysdate, '111-22-33445', '영웅갈비찜', '한식', '소갈비찜', '소갈비찜 중'
		, '소갈비찜 대', '9500', '9500', '9900', '2500', 2);

insert into member (m_no, m_id, m_pw, m_name, m_addr, m_phone, m_joindate, m_crn, m_bn, m_food, m_menu_1, m_menu_2, m_menu_3, m_cost_1, m_cost_2, m_cost_3, m_tip, m_lv)
values (m_no_seq.nextval, 'ceo4', '11', '김사업', '서울 강남구', '010-1212-1212', sysdate, '111-22-33445', '운봉', '중식', '짬짜면', '차돌박이짬뽕'
		, '고추잡채', '9500', '9500', '9900', '2500', 2);

insert into member (m_no, m_id, m_pw, m_name, m_addr, m_phone, m_joindate, m_crn, m_bn, m_food, m_menu_1, m_menu_2, m_menu_3, m_cost_1, m_cost_2, m_cost_3, m_tip, m_lv)
values (m_no_seq.nextval, 'ceo5', '11', '김사업', '서울 강남구', '010-1212-1212', sysdate, '111-22-33445', '일품각', '중식', '짬뽕', '꿔바로우'
		, '라즈기', '9500', '9500', '9900', '2500', 2);

insert into member (m_no, m_id, m_pw, m_name, m_addr, m_phone, m_joindate, m_crn, m_bn, m_food, m_menu_1, m_menu_2, m_menu_3, m_cost_1, m_cost_2, m_cost_3, m_tip, m_lv)
values (m_no_seq.nextval, 'ceo6', '11', '김사업', '서울 강남구', '010-1212-1212', sysdate, '111-22-33445', '해피판다', '중식', '굴짬뽕', '삼선짬뽕'
		, '탕수육', '9500', '9500', '9900', '2500', 2);

insert into member (m_no, m_id, m_pw, m_name, m_addr, m_phone, m_joindate, m_crn, m_bn, m_food, m_menu_1, m_menu_2, m_menu_3, m_cost_1, m_cost_2, m_cost_3, m_tip, m_lv)
values (m_no_seq.nextval, 'ceo7', '11', '김사업', '서울 강남구', '010-1212-1212', sysdate, '111-22-33445', '미카코카레', '일식', '곱창카레도시락', '소떡소떡카레도시락'
		, '용가리치킨카레도시락', '9500', '9500', '9900', '2500', 2);

insert into member (m_no, m_id, m_pw, m_name, m_addr, m_phone, m_joindate, m_crn, m_bn, m_food, m_menu_1, m_menu_2, m_menu_3, m_cost_1, m_cost_2, m_cost_3, m_tip, m_lv)
values (m_no_seq.nextval, 'ceo8', '11', '김사업', '서울 강남구', '010-1212-1212', sysdate, '111-22-33445', '우동마이루식', '일식', '우동+돈까스+샐러드', '냉소바+돈까스+샐러드'
		, '냉소바+김치햄볶음밥', '9500', '9500', '9900', '2500', 2);

insert into member (m_no, m_id, m_pw, m_name, m_addr, m_phone, m_joindate, m_crn, m_bn, m_food, m_menu_1, m_menu_2, m_menu_3, m_cost_1, m_cost_2, m_cost_3, m_tip, m_lv)
values (m_no_seq.nextval, 'ceo9', '11', '김사업', '서울 강남구', '010-1212-1212', sysdate, '111-22-33445', '카츠반프리미엄', '일식', '등심카츠', '프리미엄안심'
		, '골든치즈', '9500', '9500', '9900', '2500', 2);

insert into member (m_no, m_id, m_pw, m_name, m_addr, m_phone, m_joindate, m_crn, m_bn, m_food, m_menu_1, m_menu_2, m_menu_3, m_cost_1, m_cost_2, m_cost_3, m_tip, m_lv)
values (m_no_seq.nextval, 'ceo10', '11', '김사업', '서울 강남구', '010-1212-1212', sysdate, '111-22-33445', '제비파스타리조또', '양식', '베이컨알리오파스타', '베이컨매콤로제파스타'
		, '베이컨버섯크림파스타', '9500', '9500', '9900', '2500', 2);

insert into member (m_no, m_id, m_pw, m_name, m_addr, m_phone, m_joindate, m_crn, m_bn, m_food, m_menu_1, m_menu_2, m_menu_3, m_cost_1, m_cost_2, m_cost_3, m_tip, m_lv)
values (m_no_seq.nextval, 'ceo11', '11', '김사업', '서울 강남구', '010-1212-1212', sysdate, '111-22-33445', '홀리오', '양식', '오리지널엔칠라다', '캘리포니아부리또'
		, '타코', '9500', '9500', '9900', '2500', 2);

insert into member (m_no, m_id, m_pw, m_name, m_addr, m_phone, m_joindate, m_crn, m_bn, m_food, m_menu_1, m_menu_2, m_menu_3, m_cost_1, m_cost_2, m_cost_3, m_tip, m_lv)
values (m_no_seq.nextval, 'ceo11', '11', '김사업', '서울 강남구', '010-1212-1212', sysdate, '111-22-33445', '에그드랍', '양식', '아메리칸햄치즈샌드위치', '갈릭베이컨치즈샌드위치'
		, '아메리카노', '9500', '9500', '9900', '2500', 2);



update member set m_bn='별사랑 불고기' where m_id='ceo1';



