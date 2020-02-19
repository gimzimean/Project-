```sql
create database project;


show variables like  'c%';

use project;
CREATE TABLE user(
 userId int auto_increment primary key,
 username varchar(20),
 password varchar(100),
 email varchar(30)
 ) engine=InnoDB default charset=utf8;
 
 select * from user;
 select * from band;
 
 SELECT * FROM user WHERE email='gimzimean@gmail.com' and password='123';
 select * from band Order by id DESC;
 
 create table band(
id int auto_increment primary key,
userId int, 
bandName varchar(100),
bandInfo text(100000),
boardTitle varchar(100),
boardContent text(100000),
eventTitle varchar(100),
eventContent text(100000),
foreign key (userId) references user(userId));

select b.id,b.userId, b.bandName, b.bandInfo,u.userId, u.username
from band b inner join user u on b.userId=u.userId
where b.id=2;

select b.id,b.userId, b.bandName, b.bandInfo,u.userId, u.username
from band b inner join user u on b.userId=u.userId
where u.userId=3
Order by id DESC;

alter table band add attachment text(100000000);

```sql
222222222222222222222222222222222222
 create table band(
bandId int auto_increment primary key,
userId int, 
bandName varchar(100),
bandInfo text(100000),
bandFile varchar(200),

foreign key (userId) references user(userId)
);

create table board(
boardId int auto_increment primary key,
bandId int, 
userId int,
boardName varchar(100),
boardContent text(100000),
foreign key (bandId) references band(bandId));


create table follow(
followId int auto_increment primary key,
fromId int, 
toId int,
createDate timestamp,
foreign key (toId) references user(userId)
);
drop table follow;



select *from follow order by followId desc;
 
select b.bandId,b.userId, b.bandName, b.bandInfo,u.userId,
		u.username
		from band b inner join user u on b.userId=u.userId
		Order by
		bandId DESC;
        
        select * from user;
        
        select * from follow f inner join user u on f.toId=u.userId where fromId=1;
        insert into follow (fromId, toId, createDate) values (2,3,now());
        
