use db_coursework;
create table h(S_No char(3) not null,S_name nvarchar(50) not null,transfer int not null,
                   attraction nvarchar(50) default null,PRIMARY KEY(S_name));

insert H values('H01','国家图书馆',1,'国家图书馆');
insert H values('H02','白石桥南',1,null);
insert H values('H03','白堆子',0,null);
insert H values('H04','军事博物馆',1,null);
insert H values('H05','北京西站',1,null);
insert H values('H06','六里桥东',0,null);
insert H values('H07','六里桥',1,null);
insert H values('H08','七里庄',1,null);
insert H values('H09','丰台东大街',0,null);
insert H values('H10','丰台南路',0,NULL);
insert H values('H11','科怡路',0,null);
insert H values('H12','丰台科技园',0,null);
insert H values('H13','郭公庄',1,null);

