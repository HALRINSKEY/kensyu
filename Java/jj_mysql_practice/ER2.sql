SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS member_master;
DROP TABLE IF EXISTS division_master;




/* Create Tables */

CREATE TABLE division_master
(
	division_id char(3) NOT NULL,
	name char(20) NOT NULL,
	PRIMARY KEY (division_id)
);


CREATE TABLE member_master
(
	id char(4) NOT NULL,
	name varchar(10) NOT NULL,
	enter_date date NOT NULL,
	retire_flg boolean NOT NULL,
	division_id char(3) NOT NULL,
	password varchar(255) NOT NULL,
	-- 0:root,user:1
	attribute boolean NOT NULL COMMENT '0:root,user:1',
	PRIMARY KEY (id)
);



/* Create Foreign Keys */

ALTER TABLE member_master
	ADD FOREIGN KEY (division_id)
	REFERENCES division_master (division_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

/* Insert member_master Data */
insert into member_master values('0000','root','1970/01/01',0,'000','root',0);
insert into member_master values('0001','佐藤','2015/04/01',0,'100','pass1',1);
insert into member_master values('0002','小林','2016/04/01',0,'200','pass2',1);
insert into member_master values('0003','高橋','2018/06/01',1,'100','pass3',1);
insert into member_master values('0004','吉田','2019/04/01',0,'100','pass4',1);
insert into member_master values('0005','元木','2020/04/01',0,'200','pass5',1);

/* Insert division_master Data */
insert into division_master values('000','管理者');
insert into division_master values('100','技術');
insert into division_master values('200','営業');
