use db_coursework;
create table o(S_No char(3) not null,S_name nvarchar(50) not null,transfer int not null,
                   attraction nvarchar(50) default null,PRIMARY KEY(S_name));


insert LineJC values('Q01','东直门',1,null);
insert LineJC values('Q02','三元桥',1,null);
insert LineJC values('Q03','三号航站楼',0,'首都国际机场');
insert LineJC values('Q04','二号航站楼',0,null);
