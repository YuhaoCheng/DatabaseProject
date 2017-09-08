use db_coursework;
create table p(S_No char(3) not null,S_name nvarchar(50) not null,transfer int not null,
                   attraction nvarchar(50) default null,PRIMARY KEY(S_name));

insert LineYZ values('O01','宋家庄',1,null);
insert LineYZ values('O02','肖村',0,null);
insert LineYZ values('O03','小红门',0,null);
insert LineYZ values('O04','旧宫',0,null);
insert LineYZ values('O05','亦庄桥',0,null);
insert LineYZ values('O06','亦庄文化园',0,null);
insert LineYZ values('O07','万源街',0,null);
insert LineYZ values('O08','荣京东街',0,null);
insert LineYZ values('O09','荣昌东街',0,null);
insert LineYZ values('O10','同济南路',0,null);
insert LineYZ values('O11','经海路',0,null);
insert LineYZ values('O12','次渠南',0,null);
insert LineYZ values('O13','次渠',0,null);
insert LineYZ values('O14','亦庄火车站',0,null);
