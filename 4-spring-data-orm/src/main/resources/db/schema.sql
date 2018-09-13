drop table if exists SPRING_DATA_USER_TBL;
drop table if exists SPRING_DATA_CUSTOMER_TBL;
drop table if exists SPRING_DATA_ACCOUNT_TBL;

create table SPRING_DATA_USER_TBL(
	USER_ID integer auto_increment primary key,
	FK_CUSTOMER_ID integer not null,
	USERNAME varchar(100) not null,
	PASSWORD varchar(100) not null
);

create table SPRING_DATA_CUSTOMER_TBL(
	CUSTOMER_ID integer auto_increment primary key,
	NAME varchar(100) not null,
	LAST_NAME varchar(100) not null
);

create table SPRING_DATA_ACCOUNT_TBL(
	ACCOUNT_ID integer auto_increment primary key,
	FK_CUSTOMER_ID integer not null,
	ACCOUNT_NUMBER varchar(16) not null,
	CREATED_DATE timestamp not null,
	BALANCE decimal(20,4) not null
);