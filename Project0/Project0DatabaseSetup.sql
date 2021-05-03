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
	ite_estimated_val NUMERIC(10,2),
	ite_remaining_bal NUMERIC(10,2),
	ite_price NUMERIC(10,2),
	ite_remaining_payments INTEGER,
	cust_id INTEGER references customers(cust_id)
);

create table if not exists offers(
	off_id SERIAL primary key,
	off_price NUMERIC(10,2),
	ite_id INTEGER references items(ite_id),
	cust_id INTEGER references customers(cust_id)
);

insert into offers (off_price, ite_id, cust_id) values (500.60, 2, 1);