create table member(
m_no number(38),
m_name varchar2(50),
m_id varchar2(50),
m_pw varchar2(50),
m_phone varchar2(50),
m_addr varchar2(50),
m_email varchar2(50),
m_gender varchar2(50)

,m_profile varchar2(50)
);

create sequence m_no_seq
start with 1
increment by 1
nocache;

insert into member values();

select * from member order by desc;

--test�� insert
create sequence test_m_no
start with 1
increment by 1
nocache;

insert into member values(test_m_no.nextval,'������','a1','b1','010','home','c@d.e','male');
insert into member values(test_m_no.nextval,'������','a2','b2','010','home','c@d.e','male');

select count(*) from member;  --���̺� �� ����� ���ڵ� ���� ��ȯ










































