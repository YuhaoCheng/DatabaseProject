use db_coursework;
create table b(S_No char(3) not null,S_name nvarchar(50) not null,transfer int not null,
                   attraction nvarchar(50) default null, PRIMARY KEY(S_name));
insert b values('B01','西直门',0,null);
insert b values('B02','积水潭',0,'北邮本部');
insert b values('B03','鼓楼大街',1,null);
insert b values('B04','安定门',0,null);
insert b values('B05','雍和宫',1,'雍和宫');
insert b values('B06','东直门',1,null);
insert b values('B07','东四十条',0,null);
insert b values('B08','朝阳门',1,null);
insert b values('B09','建国门',1,null);
insert b values('B10','北京站',0,null);
insert b values('B11','崇文门',1,null);
insert b values('B12','前门',0,null);
insert b values('B13','和平门',0,null);
insert b values('B14','宣武门',1,null);
insert b values('B15','长椿街',0,null);
insert b values('B16','复兴门',1,null);
insert b values('B17','阜成门',0,null);
insert b values('B18','车公庄',1,null);

