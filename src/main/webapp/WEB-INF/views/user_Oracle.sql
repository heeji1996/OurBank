--0: �Ϲ� ���� 1:����

create table tlb_user_board(
	id varchar2(50) not null,
 	passwd varchar2(50) not null,
 	user_name varchar2(50) not null,
 	user_birth varchar2(50) not null,
 	user_email varchar2(50) not null,
 	user_phone varchar2(50) not null,
 	user_address varchar2(1000) ,
	admin char(1) check(admin in('0','1')),
	primary key(id) enable
);

drop table tlb_user_board;
select count(*) from tlb_user_board where  id='js961223' and passwd='11121';
select * from tlb_user_board;
select id from tlb_user_board where user_name='����' and user_birth='2020-11-31' and user_phone='010-5068-7058';


drop table zipcode;

 select * from zipcode where rownum<10;
