use db_coursework;
create table g(S_No char(3) not null,S_name nvarchar(50) not null,transfer int not null,
                   attraction nvarchar(50) default null, PRIMARY KEY(S_name));

insert G values('G01','朱辛庄',1,null);
insert G values('G02','育知路',0,null);
insert G values('G03','平西府',0,null);
insert G values('G04','回龙观大街',0,null);
insert G values('G05','霍营',1,null);
insert G values('G06','育新',0,null);
insert G values('G07','西小口',0,null);
insert G values('G08','永泰庄',0,null);
insert G values('G09','林萃桥',0,null);
insert G values('G10','森林公园南门',0,NULL);
insert G values('G11','奥林匹克公园',1,'鸟巢');
insert G values('G12','奥体中心',0,null);
insert G values('G13','北土城',1,null);
insert G values('G14','安华桥',0,null);
insert G values('G15','安德里北街',0,'德胜门');
insert G values('G16','鼓楼大街',1,null);
insert G values('G17','什刹海',0,'什刹海');
insert G values('G18','南锣鼓巷',1,'南锣鼓巷');
