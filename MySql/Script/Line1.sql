use db_coursework;
create table a(S_No char(3) not null,S_name nvarchar(50) not null,transfer int not null,
                   attraction nvarchar(50) default null, PRIMARY KEY(S_name) );

insert a values('A01','苹果园',0,null);
insert a values('A02','古城',0,null);
insert a values('A03','八角游乐园',0,null);
insert a values('A04','八宝山',0,null);
insert a values('A05','玉泉路',0,null);
insert a values('A06','五棵松',0,null);
insert a values('A07','万寿路',0,null);
insert a values('A08','公主坟',1,'中央电视台');
insert a values('A09','军事博物馆',1,null);
insert a values('A10','木樨地',0,null);
insert a values('A11','南礼士路',0,null);
insert a values('A12','复兴门',1,null);
insert a values('A13','西单',1,null);
insert a values('A14','天安门西',0,'故宫');
insert a values('A15','天安门东',0,'天安门');
insert a values('A16','王府井',0,'王府井');
insert a values('A17','东单',1,null);
insert a values('A18','建国门',1,null);
insert a values('A19','永安里',0,null);
insert a values('A20','国贸',1,null);
insert a values('A21','大望路',1,null);
insert a values('A22','四惠',0,null);
insert a values('A23','四惠东',0,null);
insert a values('A24','高碑店',0,null);
insert a values('A25','传媒大学',0,null);
insert a values('A26','双桥',0,null);
insert a values('A27','管庄',0,null);
insert a values('A28','八里桥',0,null);
insert a values('A29','通州北苑',0,null);
insert a values('A30','果园',0,null);
insert a values('A31','九棵树',0,null);
insert a values('A32','梨园',0,null);
insert a values('A33','临河里',0,null);
insert a values('A34','土桥',0,null);
