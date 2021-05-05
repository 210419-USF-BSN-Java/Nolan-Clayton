create table if not exists employees(
	empl_id SERIAL,
	empl_name VARCHAR(100),
	empl_user_name VARCHAR(100) primary key,
	empl_user_pass VARCHAR(100),
	empl_is_manager boolean
);

create table if not exists customers(
	cust_id SERIAL unique,
	cust_name VARCHAR(100),
	cust_user_name VARCHAR(100) primary key,
	cust_user_pass VARCHAR(100)
);

create table if not exists items(
	ite_id SERIAL primary key,
	ite_name VARCHAR(100),
	ite_description VARCHAR(600),
	ite_estimated_val NUMERIC(15,2),
	ite_weekly_pay NUMERIC(15,2),
	ite_price NUMERIC(15,2),
	ite_remaining_payments INTEGER,
	cust_id INTEGER references customers(cust_id) on delete set null
);

create table if not exists offers(
	off_id SERIAL primary key,
	off_price NUMERIC(15,2),
	off_num_weekly_payments INTEGER,
	ite_id INTEGER references items(ite_id) on delete set null,
	cust_id INTEGER references customers(cust_id) on delete set null
);

create table if not exists payments(
	pay_id SERIAL primary key,
	pay_time_stamp TIMESTAMP,
	pay_value NUMERIC(15,2),
	ite_id INTEGER references items(ite_id) on delete set null
);

insert into employees (empl_name, empl_user_name, empl_user_pass, empl_is_manager) values (Admin, admin, admin, TRUE);