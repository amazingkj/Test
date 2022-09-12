--스코어카드 업로드 게시판 테이블 생성
create table scboard(
sc_no number(38)
,sc_name varchar2(50)
,sc_title varchar2(50)
,sc_pwd varchar2(50)
,sc_cont varchar2(4000)
,sc_file varchar2(100)
,sc_hit number(38) default 0
,sc_date date
);

create sequence test_scboard_seq
start with 1
increment by 1
nocache;

insert into scboard(sc_no,sc_name,sc_title,sc_pwd,sc_cont,sc_file,sc_date) values(test_scboard_seq,?,?,?,?,?,sysdate);


