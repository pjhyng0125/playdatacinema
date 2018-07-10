--------------------------------------------------create table-----------------------------------------
create table member
(
id varchar2(20) primary key,
pass varchar2(20) not null,
gender varchar2(4),
name varchar2(15),
birth number(8),
phone varchar2(13),
addr varchar2(50),
mail varchar2(50),
point number,
cash number,
mem_grade number,
hint varchar2(30),
answer varchar2(30)
);

create table reserve
(
   id varchar2(20), --���̵�
   movie_name varchar2(20),
   run_date char(5), --������
   start_time char(5),
   seatnum char(2), --�¼���ȣ
   screen_code char(2), --�󿵰� ��ȣ
   person_cnt number,--�ο���
   primary key(id,seatnum),
   foreign key (id) references member(id)
);

create table movie
(
movie_name varchar2(20) primary key, --��ȭ�̸�
director varchar2(9), --������
actors varchar2(21), --�ֿ�����
summary varchar2(50), --�ٰŸ�
genre varchar2(10), --�帣
rate number , --������
avg_star number(1) default 0, --����
limit number, --���ѳ���
price number, --����
path varchar2(30),--�̹��� ���
start_date char(10), --��������
run_date char(10), --�� ����
run_time char(6), --��Ÿ��
onshow	number(1)-- 1�̸� ����
);

create table movie_comment
(
id varchar2(20),
movie_name varchar2(20),
no number, --com_seq
com_star number(1) not null,
content varchar2(100),
primary key(movie_name,no),
foreign key(movie_name) references movie(movie_name)
);

create table screen
(
screen_code number(1),
start_time char(4), -- ���ۻ󿵽ð�-���ð�
seatnum char(2) unique,
flag number(1) not null, --1�̸� ������
primary key(screen_code,start_time)
);


---����
create table admin
(
id varchar2(15) primary key,
pass varchar2(15) not null,
profit number
);
-------------------------------------------------------drop table--------------------------------------------------
drop table reserve;
drop table member;
drop table movie_comment;
drop table movie;
drop table screen;
drop table admin;
-------------------------------------------------------create sequence--------------------------------------------------
create sequence com_seq
      start with 1
      increment by 1
      nocycle
      nocache;
-------------------------------------------------------drop sequence-----------------------------------------------
drop sequence com_seq;

-------------------------------------------------------insert-----------------------------------------------
create table member
(
id varchar2(20) primary key,
pass varchar2(20) not null,
gender varchar2(6),
name varchar2(15),
birth number(8),
phone varchar2(13),
addr varchar2(50),
mail varchar2(50),
point number,
cash number,
mem_grade number,
hint varchar2(30),
answer varchar2(30)
);
	'�����ϴ�å��?'	'�¾����?'	'��� ������?'	'�����ϴ� ������?'
insert into member(id,pass,gender,name,birth,phone,addr,mail,point,cash,mem_grade,hint,answer)
         values ('encore1','1234','����','���ֿ�','19920121','01012341234','�츮��','encore1@naver.com',0,0,0,'�����ϴ�å��?','ȫ�浿��');
insert into member(id,pass,gender,name,birth,phone,addr,mail,point,cash,mem_grade,hint,answer)
         values ('encore8','1234','����','ȫ���','19920121','01012341234','�츮��2','encore1@naver.com','1000','17000','1','�����ϴ�å��?','ȫ�浿��');
insert into member(id,pass,gender,name,birth,phone,addr,mail,point,cash,mem_grade,hint,answer)
         values ('encore9','1234','����','�����','19920121','01012341234','�츮��3','encore1@naver.com','500','21000','2','�����ϴ�å��?','ȫ�浿��');
insert into member(id,pass,gender,name,birth,phone,addr,mail,point,cash,mem_grade,hint,answer)
         values ('encore4','1234','����','���ֿ�','19920121','01012341234','�츮��4','encore1@naver.com',0,0,0,'�����ϴ�å��?','ȫ�浿��');
insert into member(id,pass,gender,name,birth,phone,addr,mail,point,cash,mem_grade,hint,answer)
         values ('encore5','1234','����','������','19920121','01012341234','�츮��5','encore1@naver.com',0,0,0,'�����ϴ�å��?','ȫ�浿��');
insert into member(id,pass,gender,name,birth,phone,addr,mail,point,cash,mem_grade,hint,answer)
         values ('encore6','1234','����','���ֿ�','19920121','01012341234','�츮��6','encore1@naver.com',0,0,0,'�����ϴ�å��?','ȫ�浿��');
insert into member(id,pass,gender,name,birth,phone,addr,mail,point,cash,mem_grade,hint,answer)
         values ('encore7','1234','����','������','19920121','01012341234','�츮��7','encore1@naver.com',0,0,0,'�����ϴ�å��?','ȫ�浿��');
         				
         




insert into reserve (id,seatnum,movie_name)values ('encore1','A1','����');

drop table movie;
create table movie
(
movie_name varchar2(20) primary key, --��ȭ�̸�
director varchar2(9), --������
actors varchar2(21), --�ֿ�����
summary varchar2(50), --�ٰŸ�
genre varchar2(10), --�帣
rate number , --������
avg_star number(1) default 0, --����
limit number, --���ѳ���
price number, --����
path varchar2(30),--�̹��� ���
start_date char(10), --��������
run_date char(10), --�� ����
run_time char(6), --��Ÿ��
onshow	number(1)-- 1�̸� ����
);

insert into movie values ('����','������','��ٹ�,������','���డ ��Ÿ����!','�׼�',50,5,15,8000,'path','0628','0705',120,1);
insert into movie values ('����','��â��','��ٹ�,������','������ ��Ÿ����!','�׼�',25,4,15,8000,'path','0628','0705',120,2);
insert into movie values ('���׶�','�̺���','��ٹ�,������','���׶��� ��Ÿ����!','�׼�',20,2,15,8000,'path','0628','0705',120,3);
insert into movie values ('�ǹ̵�','������','��ٹ�,������','�ǹ̵��� ��Ÿ����!','�׼�',15,1,15,8000,'path','0628','0705',120,4);
insert into movie values ('����','��â��','��ٹ�,������','������ ��Ÿ����!','�׼�',0,0,15,8000,'path','0628','0705','07:00',120,0);
insert into movie values ('���׶�','�̺���','��ٹ�,������','���׶��� ��Ÿ����!','�׼�',0,0,15,8000,'path','0628','0705','07:00',120,0);
insert into movie values ('�ǹ̵�','������','��ٹ�,������','�ǹ̵��� ��Ÿ����!','�׼�',0,0,15,8000,'path','0628','0705','07:00',120,0);


------------------------------------------------------------------create trigger-----------------------------------------------------------
create or replace trigger reserve_trg
after insert on reserve
for each row
declare
cnt number;
allcnt number;
begin
    select count(*) into cnt from screen 
    where screen_code = :new.screen_code and flag='no';
   
    select count(*) into allcnt from screen
    where flag='no';
    
    update movie set rate = cnt*100/allcnt where movie_name = :new.movie_name;  
end;
/
---------------------------------------------------------------------------
create or replace trigger reserve_trg
after insert on reserve
for each row
declare
begin
    update screen set flag = 'no' 
    where screen_code = :new.screen_code and screen_time = :new.screen_time;  
end;
/

drop trigger screen_trg;
create or replace trigger screen_trg
after update on screen
for each row
declare
cnt number;
allcnt number;
begin
	 select count(*) into cnt from reserve 
    	 where screen_code = :new.screen_code;
   	 select count(*) into allcnt from reserve;
		update movie set rate = cnt*100/allcnt 
		where movie_name = (select distinct movie_name from reserve where screen_code = :new.screen_code );
end;
/
------------------------------------------------------------------------------


insert into screen (screen_code,screen_time,flag) values (1,'a','yes');
insert into screen (screen_code,screen_time,flag) values (1,'b','yes');
insert into screen (screen_code,screen_time,flag) values (1,'c','yes');
insert into screen (screen_code,screen_time,flag) values (1,'d','yes');
insert into screen (screen_code,screen_time,flag) values (1,'e','yes');
insert into screen (screen_code,screen_time,flag) values (2,'f','yes');
insert into screen (screen_code,screen_time,flag) values (3,'g','yes');
insert into screen (screen_code,screen_time,flag) values (1,'h','yes');
insert into screen (screen_code,screen_time,flag) values (4,'j','yes');

insert into reserve (id,seatnum,screen_code,screen_time,movie_name)values ('b1','A1',1,'a','h');
delete from screen;
delete from reserve;


insert into member(id,pass) values ('a1','1234');
insert into member(id,pass) values ('b1','1234');
insert into member(id,pass) values ('c1','1234');
insert into member(id,pass) values ('d1','1234');
insert into member(id,pass) values ('e1','1234');
insert into member(id,pass) values ('f1','1234');
insert into member(id,pass) values ('g1','1234');
insert into member(id,pass) values ('h1','1234');
insert into member(id,pass) values ('i1','1234');
insert into member(id,pass) values ('j1','1234');
insert into member(id,pass) values ('k1','1234');
insert into member(id,pass) values ('l1','1234');
insert into member(id,pass) values ('m1','1234');

insert into member (id,pass) values ('pppp', '1234');

select * from member;
select * from movie;
select * from screen;
select * from reserve;
