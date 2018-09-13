drop table if exists USER_TBL;
drop table if exists CUSTOMER_TBL;
drop table if exists ACCOUNT_TBL;
drop table if exists AUTHORITY_TBL;
drop table if exists MOVEMENT_TBL;

create table USER_TBL(
	USER_ID integer auto_increment primary key,
	USERNAME varchar(100) not null,
	PASSWORD varchar(100) not null,
	ACCOUNT_NON_EXPIRED int(1) not null,
	ACCOUNT_NON_LOCKED int(1) not null,
	CREDENTIALS_NON_EXPIRED int(1) not null,
	ENABLED int(1) not null
);

create table CUSTOMER_TBL(
	CUSTOMER_ID integer auto_increment primary key,
	FK_USER_ID integer not null,
	NAME varchar(100) not null,
	LAST_NAME varchar(100) not null
);

create table ADMIN_TBL(
	ADMIN_ID integer auto_increment primary key,
	FK_USER_ID integer not null,
	NAME varchar(100) not null,
	LAST_NAME varchar(100) not null
);

create table ACCOUNT_TBL(
	ACCOUNT_ID integer auto_increment primary key,
	FK_CUSTOMER_ID integer not null,
	ACCOUNT_NUMBER varchar(16) unique not null,
	CREATED_DATE timestamp not null,
	BALANCE decimal(20,4) not null
);

create table AUTHORITY_TBL(
	AUTHORITY_ID integer auto_increment primary key,
	FK_USER_ID integer not null,
	AUTHORITY_NAME varchar(16) not null
);

create table MOVEMENT_TBL(
	MOVEMENT_ID integer auto_increment primary key,
	FK_ACCOUNT_ID integer not null,
	ORIGIN_ACCOUNT_NUMBER varchar(16) not null,
	DESTINATION_ACCOUNT_NUMBER varchar(16) not null,
	AMOUNT decimal(20,4) not null,
	MOVEMENT_TYPE varchar(15) not null,
	OPERATION_DATE timestamp not null,
	DESCRIPTION varchar(100) not null,
	REFERENCE_NUMBER varchar(100) not null
);