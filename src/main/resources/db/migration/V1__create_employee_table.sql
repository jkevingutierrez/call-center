create table EMPLOYEE (
    ID int8 not null primary key,
    NAME varchar(100) not null,
    TYPE varchar(15) not null,
    AVAILABLE boolean default true,
    BUSY boolean default false,
    EMAIL varchar(100)
);