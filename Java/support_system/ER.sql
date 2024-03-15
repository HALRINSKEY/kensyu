SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS repair_table;
DROP TABLE IF EXISTS user_table;




/* Create Tables */

CREATE TABLE repair_table
(
	id int NOT NULL AUTO_INCREMENT,
	order_id varchar(12) NOT NULL,
	serial_no varchar(12),
	product_code varchar(12) NOT NULL,
	product_name varchar(64) NOT NULL,
	repair_end varchar(12) NOT NULL,
	repair_order varchar(12) NOT NULL,
	out_state varchar(128),
	check_state varchar(160),
	repair_detail varchar(160),
	disorder_repair varchar(160),
	end_date date NOT NULL,
	order_date date NOT NULL,
	enabled int NOT NULL,
	entry_day timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	update_day timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (id),
	UNIQUE (id),
	UNIQUE (order_id)
);


CREATE TABLE user_table
(
	id int NOT NULL,
	user_id varchar(64) NOT NULL,
	password varchar(64) NOT NULL,
	class_code int NOT NULL,
	user_name varchar(64) NOT NULL,
	enabled int NOT NULL,
	entry_day timestamp NOT NULL,
	update_day timestamp NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id)
);



