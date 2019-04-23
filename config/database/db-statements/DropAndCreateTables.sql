drop table if exists charge_pattern_commission_rate;
drop table if exists individual_commission_plan;
drop table if exists producer_code;
drop table if exists producer;


create table producer (
	id int primary key identity(1,1),
	publicid varchar(55) not null unique,
	name varchar(55) not null,
	email varchar(55) 
)

create table producer_code (
	id int primary key identity(1,1),
	publicid varchar(55) not null unique,
	code varchar(55) not null,
	producer_id int foreign key references producer(id) not null,
	parent_producer_code_id int foreign key references producer_code(id)
)

create table individual_commission_plan (
	id int primary key identity(1,1),
	producer_code_id int unique foreign key references producer_code(id)
)

create table charge_pattern_commission_rate (
	id int primary key identity(1,1),
	individual_commission_plan_id int foreign key references individual_commission_plan(id),
	charge_pattern varchar(55) not null,
	commission_rate decimal(5,2) not null,
	CONSTRAINT UC_CPCR UNIQUE (individual_commission_plan_id, charge_pattern)
)