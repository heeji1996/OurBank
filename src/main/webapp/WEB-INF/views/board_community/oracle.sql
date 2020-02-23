/* best�Խù� ������*/
create sequence best_seq_idx minvalue 1 maxvalue 9999999999 increment by 1 start with 1 ;
drop sequence best_seq_idx;

/*���� �Խ���*/
create sequence review_seq minvalue 1 maxvalue 9999999999 increment by 1 start with 1 ;
create table review_board (
	category varchar2(20) default '����',
    category_num number(10,0) default 1,
    best_idx number(10,0) not null,
 	id_x number(10,0) not null,
 	id varchar2(20) not null,
 	subject varchar2(100),
 	content varchar2(200),
 	created_date date,
 	hits number(10,0),
 	filename varchar2(50) default null,
 	filesize number default null,
 	step number(10,0) default null,
 	ref number(10,0) default null,
 	depth number(10,0) default null,
 	review_case char(20) default '���ݸ���' check (review_case in ('���ݸ���', '���ݸ���', '��Ÿ����')),
 	satisfaction char(30) default '�ڡڡڡڡ�  �ſ츸��' check (satisfaction 
 		in ('�ڡڡڡڡ�  �ſ츸��', '�ڡڡڡ�  ����', '�ڡڡ�  ����', '�ڡ�  �Ҹ���', '��  �ſ�Ҹ���')),
 	banks varchar2(30) ,
 	re_productname varchar2(50) ,
primary key (id_x) enable
 ) ;
 
 select review_case, satisfaction, banks, re_productname from review_board where ref = 29;
 
 drop sequence review_seq;
 select * from review_board;
 drop table review_board;
 
 
/* �����Խ��� */
create sequence free_seq_idnum minvalue 1 maxvalue 9999999999 increment by 1 start with 1 ;
 create table tlb_free_board (
    category varchar2(20) default '����',
    category_num number(10,0) default 2,
 	best_idx number(10,0) not null,
 	id varchar2(20) not null,
 	idx_num number(10,0) not null,
 	subject varchar2(100),
 	content varchar2(200),
 	created_date date,
 	hits number(10,0),
 	filename varchar2(50) default null,
 	filesize number default null,
 	step number(10,0) default null,
 	ref number(10,0) default null,
 	depth number(10,0) default null,
primary key (idx_num) enable
 ) ;

 drop table tlb_free_board;
 select * from tlb_free_board;
 drop sequence free_seq_idnum;
 insert into tlb_free_board (id, idx_num) values ('ex_id', 1);

 
 /*���� �Խ���*/
 create sequence meeting_seq_idnum minvalue 1 maxvalue 9999999999 increment by 1 start with 1 ;
 create table tlb_meeting_board (
 	category varchar2(20) default '����',
 	category_num number(10,0) default 3,
 	best_idx number(10,0) not null,
 	id varchar2(20) not null,
 	idx_num number(10,0) not null,
 	subject varchar2(100),
 	content varchar2(200),
 	created_date date,
 	hits number(10,0),
 	filename varchar2(50) default null,
 	filesize number default null,
 	step number(10,0) default null,
 	ref number(10,0) default null,
 	depth number(10,0) default null,
primary key (idx_num) enable
 ) ;
  select * from tlb_meeting_board;
   drop table tlb_meeting_board;
    drop sequence meeting_seq_idnum;
  
    
   /*��� �Խ���*/
 create sequence debate_seq_idnum minvalue 1 maxvalue 9999999999 increment by 1 start with 1 ;
 create table tlb_debate_board (
 	category varchar2(20) default '���',
 	category_num number(10,0) default 4,
 	best_idx number(10,0) not null,
 	id varchar2(20) not null,
 	idx_num number(10,0) not null,
 	subject varchar2(100),
 	content varchar2(200),
 	created_date date,
 	hits number(10,0),
 	filename varchar2(50) default null,
 	filesize number default null,
 	step number(10,0) default null,
 	ref number(10,0) default null,
 	depth number(10,0) default null,
primary key (idx_num) enable
 ) ;
  select * from tlb_debate_board;
   drop table tlb_debate_board;
   drop sequence debate_seq_idnum;
    
   
 /*����ũ ���Ͽ� �Խ���*/
  create sequence invest_seq minvalue 1 maxvalue 9999999999 increment by 1 start with 1 ;
  create table invest_board (
 	category varchar2(20) default '����ũ���Ͽ�',
 	category_num number(10,0) default 5,
 	best_idx number(10,0) not null,
 	id_x number(10,0) not null,
 	id varchar2(20) not null,
 	subject varchar2(100),
 	content varchar2(200),
 	created_date date,
 	hits number(10,0),
 	invest_case char(30) default '�������' check (invest_case in ('�������','���л��', '��Ÿ')),
 	filename varchar2(50) default null,
 	filesize number default null,
 	step number(10,0) default null,
 	ref number(10,0) default null,
 	depth number(10,0) default null,
primary key (id_x) enable
 ) ;
 
drop table invest_board;
 drop sequence invest_seq;
 select * from invest_board;
 select invest_case from invest_board where ref = 1;
 
 delete invest_board 
 
 update invest_board set invest_case = #{'�������', jdbc
 
 
 
 /***************************************/
 

 select * from (
	(select id from review_board) 
union 
	(select id from tlb_free_board)
union
	(select id from tlb_meeting_board)
union
	(select id from tlb_debate_board)
union
	(select id from invest_board)
union
	(select id from tlb_user_board));

select category, category_num, best_idx, id, subject, content, created_date, hits, filename	

select * from (select category, category_num, best_idx, id, subject, content, created_date, hits, depth,
				filename, ceil(rownum / 10) as page from 
				((select category, category_num, best_idx, id, subject, content, created_date, hits, filename, depth from review_board) union 
				(select category, category_num, best_idx, id, subject, content, created_date, hits, filename, depth from tlb_free_board) union
				(select category, category_num, best_idx, id, subject, content, created_date, hits, filename, depth from tlb_meeting_board) union 
				(select category, category_num, best_idx, id, subject, content, created_date, hits, filename, depth from tlb_debate_board) union 
				(select category, category_num, best_idx, id, subject, content, created_date, hits, filename, depth from invest_board)) 
			where rownum <=10 and hits is not null and depth=0 order by hits desc) 
			where page=1;
					union 
					(select * from tlb_debate_board)) where rownum <=10 and hits is not null  order by hits desc) 
					where page=1;
					
select * from (
					(select category, category_num, best_idx, id, subject, content, created_date, hits, filename from review_board) union
					(select category, category_num, best_idx, id, subject, content, created_date, hits, filename from TLB_free_BOARD) union 
					(select category, category_num, best_idx, id, subject, content, created_date, hits, filename from tlb_meeting_board) union 
					(select category, category_num, best_idx, id, subject, content, created_date, hits, filename from tlb_debate_board) union
					(select category, category_num, best_idx, id, subject, content, created_date, hits, filename from invest_board)) 
					where best_idx=43;
					

	


