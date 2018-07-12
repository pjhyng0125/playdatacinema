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


create table reserve													--문제발생
(
   id varchar2(30), --아이디
   movie_name varchar2(60),
   run_date varchar2(20), --상영일자
   start_time varchar2(20),--영화 시작 시간
   seatnum varchar2(4), --좌석번호
   screen_code varchar2(2), --상영관 번호
   person_cnt number(4),--인원수
   primary key(movie_name,seatnum,start_time),
   foreign key (id) references member(id)
);


create table movie
(
movie_name varchar2(30) primary key, --영화이름
director varchar2(30), --감독명
actors varchar2(45), --주연배우들
summary varchar2(100), --줄거리
genre varchar2(30), --장르
rate number(15) , --예매율
avg_star number(2) default 0, --평점
limit number(4), --제한나이
price number(10), --가격
path varchar2(30),--이미지 경로
start_date varchar2(10), --개봉일자
run_date varchar2(10), --상영 일자
run_time varchar2(6), --런타임
onshow	number(2)-- 1이면 상영중
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

create table screen														-- 문제 발생
(
screen_code number(2),
start_time char(6), -- 시작상영시간-끝시간
seatnum char(4),
flag number(2) not null, --1이면 매진석
primary key(screen_code,start_time)
);


---보류
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

insert into member values ('encore1','1234','남자','김주원','19920121','010-1234-1234','서울','encore1@naver.com','2000',17000,0,'초등학교 이름은?','온곡');
insert into member values ('encore2','1234','여자','이주원','19920123','010-2341-2341','대전','encore2@naver.com',5000,20000,1,'좋아하는책은?','파수꾼');
insert into member values ('encore3','1234','남자','박주원','19920811','010-3412-3412','대구','encore3@naver.com',1000,15000,2,'태어난곳은?','여수');
insert into member values ('encore4','1234','여자','나주원','19920623','010-4123-4123','부산','encore4@naver.com',100,3000,0,'어릴적 별명은?','몰라');
insert into member values ('encore5','1234','남자','차주원','19920401','010-2345-2345','여수','encore5@naver.com',5000,18000,1,'좋아하는 게임은?','배그');
insert into member values ('encore6','1234','여자','길라임','19920520','010-3452-3452','제주도','encore6@naver.com',800,10000,0,'초등학교 이름은?','상계');
insert into member values ('encore7','1234','남자','나라임','19920529','010-4523-4523','강원도 강릉','encore7@naver.com',50,20000,0,'좋아하는책은??','종이약국');
insert into member values ('encore8','1234','여자','박라임','19920402','010-5234-5234','서울 마포','encore8@naver.com',780,5000,0,'태어난곳은?','노원');
insert into member values ('encore9','1234','남자','유시진','19921116','010-3456-3456','서울 서초','encore9@naver.com',700,2000,0,'어릴적 별명은?','남터');
insert into member values ('encore10','1234','여자','강모연','19920930','010-4563-4563','속초','encore10@naver.com',8000,900000,2,'초등학교 이름은?','계상');
insert into member values ('encore11','1234','남자','강동원','19920205','010-5634-5634','별내','encore11@naver.com',50,1000,0,'좋아하는 게임은?','메이플');
insert into member values ('encore12','1234','여자','한지민','19921104','010-6345-6345','전주','encore12@naver.com',0,5000,0,'좋아하는책은?','상실의시대');
insert into member values ('encore13','1234','남자','현빈','19920509','010-1112-2211','담양','encore13@naver.com',0,0,0,'태어난곳은?','제주도');


insert into movie values ('마녀','박찬욱','김다미,성동일','마녀가 나타났다!','액션',20,3,15,8000,'image/witch.png','6/28','7/05',120,1);
insert into movie values ('탐정','이언희','권상우,성동일','역대급 미제 사건을 해결한 추리 콤비','코미디,범죄',32,4,15,8000,'image/returns.png','6/28','7/05',120,1);
insert into movie values ('허스토리','민규동','김해숙,김희애','재판받는 이야기','드라마',12,3,7,8000,'image/her_story.png','6/28','7/05',120,1);
insert into movie values ('앤트맨과와스프','페이트 리드','폴러드,에반젤린 릴리','가장의 은둔히어로 스토리!','액션',37,4,12,8000,'image/antman.png','6/28','7/05',120,1);
insert into movie values ('독전','이창동','김다미,성동일','독전이 나타났다!','액션',25,4,15,8000,'image/antman.png','6/28','7/05',120,2);
insert into movie values ('베테랑','이병헌','김다미,성동일','베테랑이 나타났다!','액션',20,2,15,8000,'image/her_story.png','6/28','7/05',120,3);
insert into movie values ('실미도','박찬욱','김다미,성동일','실미도가 나타났다!','액션',15,1,15,8000,'image/returns.png','6/28','7/05',120,4);

insert into RESERVE values ('encore1','마녀','7/05','12:30','2',1,2);
insert into RESERVE values ('encore2','마녀','7/06','12:30','4',1,2);
insert into RESERVE values ('encore3','마녀','7/06','12:30','6',1,2);
insert into RESERVE values ('encore4','마녀','7/07','12:30','8',1,2);
insert into RESERVE values ('encore1','탐정','7/06','12:30','2',2,2);
insert into RESERVE values ('encore5','탐정','7/06','14:30','2',2,2);

insert into movie_comment values ('encore5','마녀',1,1,'노잼');
insert into movie_comment values ('encore6','마녀',2,2,'노잼');
insert into movie_comment values ('encore7','마녀',3,3,'보통');
insert into movie_comment values ('encore8','마녀',4,4,'잼');
insert into movie_comment values ('encore9','마녀',5,3,'보통');
insert into movie_comment values ('encore5','마녀',6,2,'노잼');

insert into movie_comment values ('encore5','탐정',1,1,'노잼');
insert into movie_comment values ('encore6','탐정',2,5,'유잼');
insert into movie_comment values ('encore7','탐정',3,4,'잼');
insert into movie_comment values ('encore8','탐정',4,3,'잼');
insert into movie_comment values ('encore9','탐정',5,2,'노잼');

insert into movie_comment values ('encore5','허스토리',1,1,'노잼');
insert into movie_comment values ('encore6','허스토리',2,2,'리뷰 몇글자 까지 가능한지 한번보자');
insert into movie_comment values ('encore7','허스토리',3,3,'');
insert into movie_comment values ('encore8','허스토리',4,4,'3번은 일부러 노댓글');
insert into movie_comment values ('encore9','허스토리',5,5,'노잼');
insert into movie_comment values ('encore10','허스토리',6,1,'노잼');
insert into movie_comment values ('encore11','허스토리',7,2,'노잼');
insert into movie_comment values ('encore12','허스토리',8,3,'노잼');
insert into movie_comment values ('encore13','허스토리',9,4,'노잼');

insert into movie_comment values ('encore5','앤트맨과와스프',1,1,'노잼');
insert into movie_comment values ('encore6','앤트맨과와스프',2,5,'노잼');
insert into movie_comment values ('encore7','앤트맨과와스프',3,5,'댓글세개');

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
