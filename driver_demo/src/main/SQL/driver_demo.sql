drop database if exists driver_db ;
create database driver_db ;
use driver_db ;
drop table if exists driver ;
create table driver
(
    ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT ,
    driver_name VARCHAR(40) NOT NULL,
    driver_age INT NOT NULL
) ;
INSERT INTO driver ( driver_name, driver_age) VALUES ( 'JOE', 20 ), ( 'JANE', 40 ) ;