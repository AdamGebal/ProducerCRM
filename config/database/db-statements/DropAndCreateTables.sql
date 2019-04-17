drop table if exists producer_code;
drop table if exists producer;


create table producer (
	id int primary key identity(1,1),
	publicid varchar(55) not null unique,
	name varchar(55) not null,
	email varchar(55) not null
)

create table producer_code (
	id int primary key identity(1,1),
	publicid varchar(55) not null unique,
	code varchar(55) not null,
	producer_id int foreign key references producer(id) not null,
	parent_producer_code_id int foreign key references producer_code(id)
)