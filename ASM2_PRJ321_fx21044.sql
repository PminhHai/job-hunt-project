create database if not exists job_hunt_data;
drop database job_hunt_data;
use job_hunt_data;

create table `role`(
`id` int auto_increment primary key,
`role_name` varchar(255) default null
);

select * from role;

delete from `role` where id = 3;

INSERT INTO `role` (role_name)
VALUES 
('ROLE_EMPLOYEE'),('ROLE_RECRUITER');

create table company(
`id` int auto_increment primary key,
`name` varchar(255),
`address` varchar(255),
`description` text,
`email` varchar(255),
`phone_number` varchar(255));

select * from company;

insert into company (id, name, address, description, email, phone_number) values (1, 'Vidoo', '36268 Anhalt Drive', 'VERY BIG COPR with alot of seeder', 'tlenham0@bing.com', '705-158-6476'),
 (2, 'Youopia', '79217 Fieldstone Trail', 'Greedy company', 'skreuzer1@elegantthemes.com', '463-910-8499'),
 (3, 'Bubbletube', '1 Vernon Trail', 'Implemented with anti air cut in', 'kosgardby2@angelfire.com', '409-593-8331'),
 (4, 'Muxo', '01767 Sugar Alley', 'Empty company with big snake hid in beneath', 'lwattingham3@amazon.de', '939-846-7228'),
 (5, 'Twinder', '65380 Delaware Pass', 'Mostly handy man and some outlaw', 'sgowrie4@dmoz.org', '746-332-4863'),
 (6, 'Layo', '33911 Sachtjen Circle', 'Using cutting edge tech, but easily go bankrupt', 'ahoxey5@pbs.org', '864-760-3057'),
 (7, 'Youbridge', '60318 Quincy Way', 'Finding way to make human closer to god', 'kpietrusiak6@github.io', '766-218-7901');


create table `user`(
`id` int auto_increment,
`username` varchar(100) not null,
`password` varchar(100) not null,
`email` varchar(255) not null,
`description` varchar(255),
`full_name` varchar(255) not null,
`phone_number` varchar(255),
`image`  mediumblob,
`file_cv`  mediumblob,
`role_id` int,
`company_id` int,
primary key(id),
constraint fk_user_role foreign key(`role_id`) references `role`(id),
constraint FK_USER_COMPANY foreign key (`company_id`) references company(id));

select * from user;

insert into `user` (id, username, password, email, description, full_name, phone_number, image, role_id, company_id) values (1, 'lcoetzee0', '$2a$10$y8Uilwpfc6DIwQ6JXYkMb.blMSWzT8HEiKjXsHmF.Tr/uRiKnN6yW', 'lcoetzee0@reverbnation.com', 'test', 'Lacey Coetzee', '515 838 6098', 'http://dummyimage.com/237x100.png/cc0000/ffffff',1, null);
insert into `user` (id, username, password, email, description, full_name, phone_number, image, role_id, company_id) values (2, 'rivett1', '$2a$10$y8Uilwpfc6DIwQ6JXYkMb.blMSWzT8HEiKjXsHmF.Tr/uRiKnN6yW', 'rivett1@uol.com.br', 'test', 'Ruby Ivett', '764 421 1339', 'http://dummyimage.com/123x100.png/dddddd/000000',1, null);
insert into `user` (id, username, password, email, description, full_name, phone_number, image, role_id, company_id) values (3, 'mbrickhill2', '$2a$10$y8Uilwpfc6DIwQ6JXYkMb.blMSWzT8HEiKjXsHmF.Tr/uRiKnN6yW', 'mbrickhill2@google.com.au', 'test', 'Mayer Brickhill', '622 802 3896', 'http://dummyimage.com/208x100.png/cc0000/ffffff',1, null);
insert into `user` (id, username, password, email, description, full_name, phone_number, image, role_id, company_id) values (4, 'hkarp3', '$2a$10$y8Uilwpfc6DIwQ6JXYkMb.blMSWzT8HEiKjXsHmF.Tr/uRiKnN6yW', 'hkarp3@bbb.org', 'test', 'Henry Karp', '949 945 6941', 'http://dummyimage.com/167x100.png/cc0000/ffffff',2, 1);
insert into `user` (id, username, password, email, description, full_name, phone_number, image, role_id, company_id) values (5, 'jgeerling4', '$2a$10$y8Uilwpfc6DIwQ6JXYkMb.blMSWzT8HEiKjXsHmF.Tr/uRiKnN6yW', 'jgeerling4@google.nl', 'test', 'Joyan Geerling', '675 936 1490', 'http://dummyimage.com/161x100.png/dddddd/000000',2, 2);
insert into `user` (id, username, password, email, description, full_name, phone_number, image, role_id, company_id) values (6, 'odevita5', '$2a$10$y8Uilwpfc6DIwQ6JXYkMb.blMSWzT8HEiKjXsHmF.Tr/uRiKnN6yW', 'odevita5@booking.com', 'test', 'Oneida Devita', '318 118 9095', 'http://dummyimage.com/185x100.png/dddddd/000000',2, 3);
insert into `user` (id, username, password, email, description, full_name, phone_number, image, role_id, company_id) values (7, 'nkier6', '$2a$10$y8Uilwpfc6DIwQ6JXYkMb.blMSWzT8HEiKjXsHmF.Tr/uRiKnN6yW', 'nkier6@google.ru', 'test', 'Nikolas Kier', '833 181 6826', 'http://dummyimage.com/211x100.png/5fa2dd/ffffff',2, 4);
insert into `user` (id, username, password, email, description, full_name, phone_number, image, role_id, company_id) values (8, 'dfrankiss7', '$2a$10$y8Uilwpfc6DIwQ6JXYkMb.blMSWzT8HEiKjXsHmF.Tr/uRiKnN6yW', 'dfrankiss7@uiuc.edu', 'test', 'Drusie Frankiss', '811 462 6077', 'http://dummyimage.com/210x100.png/cc0000/ffffff',1, null);
insert into `user` (id, username, password, email, description, full_name, phone_number, image, role_id, company_id) values (9, 'cpaulet8', '$2a$10$y8Uilwpfc6DIwQ6JXYkMb.blMSWzT8HEiKjXsHmF.Tr/uRiKnN6yW', 'cpaulet8@quantcast.com', 'test', 'Colin Paulet', '347 110 1426', 'http://dummyimage.com/184x100.png/5fa2dd/ffffff',1, null);
insert into `user` (id, username, password, email, description, full_name, phone_number, image, role_id, company_id) values (10, 'pevershed9', '$2a$10$y8Uilwpfc6DIwQ6JXYkMb.blMSWzT8HEiKjXsHmF.Tr/uRiKnN6yW', 'pevershed9@etsy.com', 'test', 'Parke Evershed', '354 149 1639', 'http://dummyimage.com/136x100.png/dddddd/000000',1, null);

update `user` set `password` = '$2a$10$Ulkzfh.TFGWNMAgUcx.3COafhW9FAX1rEt8a2SDHtc.sKhQVGV/AC' where id > 0;
    
create table type_job(
	id int auto_increment,
    `name` varchar(255),
    createdDate datetime default now(),
    primary key(id));

drop table `type_job`;    

INSERT INTO  type_job
VALUES 
(1,'fulltime',curdate()),
(2,'parttime',curdate()),
(3,'freelancer',curdate());

select * from `type_job`;

create table category(
    id int auto_increment primary key,
    `name` varchar(255),
    createdDate datetime default now());
    
select * from category;   

INSERT INTO category
VALUES 
(1,'ect...',now()),
(2,'Java',now()),
(3,'.NET',now()),
(4,'#C',now()),
(5,'Android',now()),
(6,'Unreal Engine',now()),
(7,'NodeJS',now()),
(8,'PHP',now());
    
create table post(
	id int auto_increment primary key,
    title varchar(255),
    experience varchar(255),
    `description` varchar(255),
    number_of_recruit int,
    salary varchar(100),
    createdDate datetime default now(),
    expire_date datetime,
    location varchar(255),
    category_id int,
    user_id int,
    company_id int,
    job_type_id int,
    constraint fk_post_user foreign key (user_id) references `user` (id),
    constraint fk_post_category foreign key (category_id) references category (id),
    constraint fk_post_company foreign key (company_id) references company (id),
    constraint fk_post_job_type foreign key (job_type_id) references type_job (id));
    
    select * from post;
    
    SELECT * FROM post WHERE title LIKE '%.NET%' or description LIKE '%.NET%';
    
INSERT INTO post (id,title,experience,description,number_of_recruit,salary,category_id,expire_date,location,user_id,company_id,createdDate,job_type_id) 
VALUES 
(1,"Tuyển nhân viên .NET 1","không cần kinh nghiệm","mô tả",5,"Thỏa thuận",3,now(),"Hà Nội",4,1,now(),1),
(2,"Tuyển nhân viên .NET pro","1 năm kinh nghiệm","mô tả",10,"Thỏa thuận",3,now(),"Hà Nội",4,1,now(),1),
(3,"Tuyển nhân viên C# gấp","không cần kinh nghiệm","mô tả",5,"Thỏa thuận",4,now(),"Hà Nội",4,1,now(),2),
(4,"Tuyển nhân viên .NET 2","không cần kinh nghiệm","mô tả",5,"Thỏa thuận",3,now(),"Hà Nội",5,2,now(),1),
(5,"Tuyển nhân viên PHP nhanh","không cần kinh nghiệm","mô tả",5,"Thỏa thuận",8,now(),"Hà Nội",5,2,now(),3),
(6,"Tuyển nhân viên java","3 năm kinh nghiệm","mô tả",5,"Thỏa thuận",2,now(),"TP HCM",5,2,now(),3),
(7,"Tuyển nhân viên .NET 3","không cần kinh nghiệm","mô tả",5,"Thỏa thuận",3,now(),"TP HCM",6,3,now(),1),
(8,"Tuyển nhân viên C# gấp1","không cần kinh nghiệm","mô tả",5,"Thỏa thuận",4,now(),"TP HCM",4,1,now(),2),
(9,"Tuyển nhân viên C# gấp2","không cần kinh nghiệm","mô tả",5,"Thỏa thuận",4,now(),"TP HCM",4,1,now(),2),
(10,"Tuyển nhân viên C# gấp3","không cần kinh nghiệm","mô tả",5,"Thỏa thuận",4,now(),"TP HCM",4,1,now(),2);    
    
create table applypost(
	id int auto_increment primary key,
    createDate datetime default now(),
    post_id int,
    user_id int,
    file_cv mediumblob,
    `status` int,
    `text` varchar(255),
    constraint fk_apply_post foreign key (post_id) references post (id),
    constraint fk_apply_user foreign key (user_id) references `user` (id));
    
    select * from applypost;
    
    SELECT p.id, p.title, p.company_id, p.category_id, p.job_type_id, ap.status, ap.id as ap_id
	FROM applypost ap LEFT JOIN post p ON ap.post_id = p.id
	WHERE ap.user_id = 1;
    
INSERT INTO applypost(id,createDate,post_id,user_id,file_cv,status,text) VALUES
(1,curdate(),1,1,null,0,"somthing"),
(2,curdate(),2,1,null,0,"somthing"),
(3,curdate(),6,1,null,0,"somthing"),
(4,curdate(),4,2,null,0,"somthing"),
(5,curdate(),5,3,null,0,"somthing");
    
drop table applypost;