--------------------------------------------------create table-----------------------------------------
drop table member;

create table member
(
id varchar2(20) primary key,
pass varchar2(20) not null,
gender varchar2(6),
name varchar2(15),
birth number(8),
phone varchar2(13),
addr varchar2(50),
email varchar2(50),
point number,
cash number,
mem_grade number,
hint varchar2(30),
answer varchar2(30)
);

select * from member;


create table reserve													--�����߻�
(
   id varchar2(30), --���̵�
   movie_name varchar2(60),
   run_date varchar2(20), --������
   start_time varchar2(20),--��ȭ ���� �ð�
   seatnum varchar2(4), --�¼���ȣ
   screen_code varchar2(2), --�󿵰� ��ȣ
   person_cnt number(4),--�ο���
   primary key(movie_name,seatnum,start_time),
   foreign key (id) references member(id)
);


create table movie
(
movie_name varchar2(30) primary key, --��ȭ�̸�
director varchar2(30), --������
actors varchar2(45), --�ֿ�����
summary varchar2(100), --�ٰŸ�
genre varchar2(30), --�帣
rate number(15) , --������
avg_star number(2) default 0, --����
limit number(4), --���ѳ���
price number(10), --����
path varchar2(30),--�̹��� ���
start_date varchar2(10), --��������
run_date varchar2(10), --�� ����
run_time varchar2(6), --��Ÿ��
onshow	number(2)-- 1�̸� ����
);



create table movie_comment
(
id varchar2(20),
movie_name varchar2(30),
no number, --com_seq
com_star number(2) not null,
content varchar2(100),
primary key(movie_name,no),
foreign key(movie_name) references movie(movie_name)
);

create table screen														-- ���� �߻�
(
screen_code number(2),
start_time char(6), -- ���ۻ󿵽ð�-���ð�
seatnum char(4),
flag number(2) not null, --1�̸� ������
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
delete from member;

insert into member values ('encore1','1234','����','���ֿ�','19920121','010-1234-1234','����','encore1@naver.com','2000',17000,0,'�ʵ��б� �̸���?','�°�');
insert into member values ('encore2','1234','����','���ֿ�','19920123','010-2341-2341','����','encore2@naver.com',5000,20000,1,'�����ϴ�å��?','�ļ���');
insert into member values ('encore3','1234','����','���ֿ�','19920811','010-3412-3412','�뱸','encore3@naver.com',1000,15000,2,'�¾����?','����');
insert into member values ('encore4','1234','����','���ֿ�','19920623','010-4123-4123','�λ�','encore4@naver.com',100,3000,0,'��� ������?','����');
insert into member values ('encore5','1234','����','���ֿ�','19920401','010-2345-2345','����','encore5@naver.com',5000,18000,1,'�����ϴ� ������?','���');
insert into member values ('encore6','1234','����','�����','19920520','010-3452-3452','���ֵ�','encore6@naver.com',800,10000,0,'�ʵ��б� �̸���?','���');
insert into member values ('encore7','1234','����','������','19920529','010-4523-4523','������ ����','encore7@naver.com',50,20000,0,'�����ϴ�å��??','���̾౹');
insert into member values ('encore8','1234','����','�ڶ���','19920402','010-5234-5234','���� ����','encore8@naver.com',780,5000,0,'�¾����?','���');
insert into member values ('encore9','1234','����','������','19921116','010-3456-3456','���� ����','encore9@naver.com',700,2000,0,'��� ������?','����');
insert into member values ('encore10','1234','����','����','19920930','010-4563-4563','����','encore10@naver.com',8000,900000,2,'�ʵ��б� �̸���?','���');
insert into member values ('encore11','1234','����','������','19920205','010-5634-5634','����','encore11@naver.com',50,1000,0,'�����ϴ� ������?','������');
insert into member values ('encore12','1234','����','������','19921104','010-6345-6345','����','encore12@naver.com',0,5000,0,'�����ϴ�å��?','����ǽô�');
insert into member values ('encore13','1234','����','����','19920509','010-1112-2211','���','encore13@naver.com',0,0,0,'�¾����?','���ֵ�');


insert into movie values ('����','������','��ٹ�,������','���డ ��Ÿ����!','�׼�',20,3,15,8000,'image/witch.png','6/28','7/05',120,1);
insert into movie values ('Ž��','�̾���','�ǻ��,������','����� ���� ����� �ذ��� �߸� �޺�','�ڹ̵�,����',32,4,15,8000,'image/returns.png','6/28','7/05',120,1);
insert into movie values ('�㽺�丮','�αԵ�','���ؼ�,�����','���ǹ޴� �̾߱�','���',12,3,7,8000,'image/her_story.png','6/28','7/05',120,1);
insert into movie values ('��Ʈ�ǰ��ͽ���','����Ʈ ����','������,�������� ����','������ ��������� ���丮!','�׼�',37,4,12,8000,'image/antman.png','6/28','7/05',120,1);
insert into movie values ('����','��â��','��ٹ�,������','������ ��Ÿ����!','�׼�',25,4,15,8000,'image/antman.png','6/28','7/05',120,2);
insert into movie values ('���׶�','�̺���','��ٹ�,������','���׶��� ��Ÿ����!','�׼�',20,2,15,8000,'image/her_story.png','6/28','7/05',120,3);
insert into movie values ('�ǹ̵�','������','��ٹ�,������','�ǹ̵��� ��Ÿ����!','�׼�',15,1,15,8000,'image/returns.png','6/28','7/05',120,4);

insert into RESERVE values ('encore1','����','7/05','12:30','2',1,2);
insert into RESERVE values ('encore2','����','7/06','12:30','4',1,2);
insert into RESERVE values ('encore3','����','7/06','12:30','6',1,2);
insert into RESERVE values ('encore4','����','7/07','12:30','8',1,2);
insert into RESERVE values ('encore1','Ž��','7/06','12:30','2',2,2);
insert into RESERVE values ('encore5','Ž��','7/06','14:30','2',2,2);

insert into movie_comment values ('encore5','����',1,1,'����');
insert into movie_comment values ('encore6','����',2,2,'����');
insert into movie_comment values ('encore7','����',3,3,'����');
insert into movie_comment values ('encore8','����',4,4,'��');
insert into movie_comment values ('encore9','����',5,3,'����');
insert into movie_comment values ('encore5','����',6,2,'����');

insert into movie_comment values ('encore5','Ž��',1,1,'����');
insert into movie_comment values ('encore6','Ž��',2,5,'����');
insert into movie_comment values ('encore7','Ž��',3,4,'��');
insert into movie_comment values ('encore8','Ž��',4,3,'��');
insert into movie_comment values ('encore9','Ž��',5,2,'����');

insert into movie_comment values ('encore5','�㽺�丮',1,1,'����');
insert into movie_comment values ('encore6','�㽺�丮',2,2,'���� ����� ���� �������� �ѹ�����');
insert into movie_comment values ('encore7','�㽺�丮',3,3,'');
insert into movie_comment values ('encore8','�㽺�丮',4,4,'3���� �Ϻη� ����');
insert into movie_comment values ('encore9','�㽺�丮',5,5,'����');
insert into movie_comment values ('encore10','�㽺�丮',6,1,'����');
insert into movie_comment values ('encore11','�㽺�丮',7,2,'����');
insert into movie_comment values ('encore12','�㽺�丮',8,3,'����');
insert into movie_comment values ('encore13','�㽺�丮',9,4,'����');

insert into movie_comment values ('encore5','��Ʈ�ǰ��ͽ���',1,1,'����');
insert into movie_comment values ('encore6','��Ʈ�ǰ��ͽ���',2,5,'����');
insert into movie_comment values ('encore7','��Ʈ�ǰ��ͽ���',3,5,'��ۼ���');

insert into screen values (1,'09:30',5,0);
insert into screen values (2,'09:30',10,0);
insert into screen values (3,'09:30',10,0);
insert into screen values (4,'09:30',10,0);


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
