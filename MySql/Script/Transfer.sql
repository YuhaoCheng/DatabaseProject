use db_coursework;
create table q(T_name nvarchar(50) not null, T_line1 char(2) not null, T_line2 char(2) not null,
                      PRIMARY KEY(T_name, T_line1, T_line2));

insert Transfer values('公主坟','A','I');
insert Transfer values('军事博物馆','A','H');
insert Transfer values('复兴门','A','B');
insert Transfer values('西单','A','C');
insert Transfer values('东单','A','D');
insert Transfer values('建国门','A','B');
insert Transfer values('国贸','A','I');
insert Transfer values('西直门','B','C');
insert Transfer values('西直门','B','J');
insert Transfer values('车公庄','B','E');
insert Transfer values('宣武门','B','C');
insert Transfer values('崇文门','B','D');
insert Transfer values('朝阳门','B','E');
insert Transfer values('东直门','B','Q');
insert Transfer values('东直门','B','J');
insert Transfer values('鼓楼大街','B','G');
insert Transfer values('海淀黄庄','C','I');
insert Transfer values('国家图书馆','C','H');
insert Transfer values('平安里','C','E');
insert Transfer values('角门西','C','I');
insert Transfer values('立水桥','D','J');
insert Transfer values('惠新西街南口','D','I');
insert Transfer values('雍和宫','D','B');
insert Transfer values('雍和宫','D','J');
insert Transfer values('宋家庄','D','I');
insert Transfer values('宋家庄','D','O');
insert Transfer values('慈寿寺','E','I');
insert Transfer values('白石桥南','E','H');
insert Transfer values('东四','A','E');
insert Transfer values('南锣鼓巷','E','G');
insert Transfer values('呼家楼','E','I');
insert Transfer values('双井','F','I');
insert Transfer values('磁器口','F','D');
insert Transfer values('菜市口','F','C');
insert Transfer values('北京西站','F','H');
insert Transfer values('知春路','I','J');
insert Transfer values('北土城','I','G');
insert Transfer values('芍药居','I','J');
insert Transfer values('六里桥','I','H');
insert Transfer values('西直门','J','B');
insert Transfer values('西直门','J','C');
insert Transfer values('知春路','J','I');
insert Transfer values('西二旗','J','N');
insert Transfer values('霍营','J','G');
insert Transfer values('望京西','J','L');
insert Transfer values('东直门','J','B');
insert Transfer values('东直门','J','Q');
insert Transfer values('西局','K','I');
insert Transfer values('七里庄','K','H');
insert Transfer values('望京','K','L');
insert Transfer values('金台路','K','E');
insert Transfer values('望京','L','K');
insert Transfer values('望京西','L','J');
insert Transfer values('大屯路东','L','D');
insert Transfer values('奥林匹克公园','L','G');
insert Transfer values('朱辛庄','N','G');
insert Transfer values('郭公庄','P','H');
insert Transfer values('三元桥','Q','I');
insert Transfer values('北京南站','C','K');
insert Transfer values('蒲黄榆','D','K');
insert Transfer values('大望路','A','K');
insert Transfer values('九龙山','F','K');
insert Transfer values('十里河','I','K');