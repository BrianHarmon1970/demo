
drop database if exists inventory_db ;
create database inventory_db ;
use inventory_db ;
drop table if exists contact ;
create table contact
(
    ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT ,
    name VARCHAR(128) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(128) NOT NULL
) ;

drop table if exists customer ;
create table customer
(
    ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT ,
    name VARCHAR(128) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(128) NOT NULL
) ;

drop table if exists vendor ;
create table vendor
(
    ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT ,
    name VARCHAR(128) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(128) NOT NULL
) ;

drop table if exists vendor_contact ;
create table vendor_contact
(
    #ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT ,
    vendor_id BIGINT(20) REFERENCES vendor(ID),
    contact_id BIGINT(20) REFERENCES contact(ID)
) ;

drop table if exists customer_contact ;
create table customer_contact
(
    #ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT ,
    customer_id BIGINT(20) REFERENCES customer(ID),
    contact_id BIGINT(20) REFERENCES contact(ID)
) ;


drop table if exists part_item ;
create table part_item
(
    ID			BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT ,
    list_price 	FIXED(8,2) ,
    brand 		VARCHAR(128),
    part_number	VARCHAR(128),
    description	VARCHAR(256)
) ;

drop table if exists purchase_order ;
create table purchase_order
(
    ID			BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT ,
    part_id		BIGINT(20) REFERENCES part_item(ID),
    vendor_id	BIGINT(20) REFERENCES vendor(ID),
    order_date		DATE NOT NULL,
    price 	FIXED(8,2) ,
    quantity	INTEGER NOT NULL
) ;

drop table if exists customer_quote ;
create table customer_quote
(
    ID			BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT ,
    part_id		BIGINT(20) REFERENCES part_item(ID),
    customer_id	BIGINT(20) REFERENCES customer(ID),
    vendor_id	BIGINT(20) REFERENCES vendor(ID),
    quote_date	DATE NOT NULL,
    price 		FIXED(8,2) ,
    quantity	INTEGER NOT NULL
) ;
