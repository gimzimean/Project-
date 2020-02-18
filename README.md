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