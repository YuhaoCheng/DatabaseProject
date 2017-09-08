use db_coursework;
create table m(S_No char(3) not null,S_name nvarchar(50) not null,transfer int not null,
                   attraction nvarchar(50) default null,PRIMARY KEY(S_name));

insert LineCP values('N01','昌平西山口',0,null);
insert LineCP values('N02','十三陵景区',0,null);
insert LineCP values('N03','昌平',0,null);
insert LineCP values('N04','昌平东关',0,null);
insert LineCP values('N05','北邵洼',0,null);
insert LineCP values('N06','南邵',0,null);
insert LineCP values('N07','沙河高教园',0,null);
insert LineCP values('N08','沙河',0,null);
insert LineCP values('N09','巩华城',0,null);
insert LineCP values('N10','朱辛庄',1,null);
insert LineCP values('N11','生命科学园',0,null);
insert LineCP values('N12','西二旗',1,null);
