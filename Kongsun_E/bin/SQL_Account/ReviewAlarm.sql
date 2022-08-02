create table ReviewAlarm(
point int
,m_id varchar2(50)
);

insert into ReviewAlarm values (0,null);

select * from ReviewAlarm;

drop table ReviewAlarm;

delete from reviewalarm;

update reviewalarm set point=1, m_id='asd';
update reviewalarm set point=0, m_id=null;


