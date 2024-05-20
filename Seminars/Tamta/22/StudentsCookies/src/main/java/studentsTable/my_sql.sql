use test_db;

create table my_students
(
    id              int auto_increment,
    firstname       varchar(100) not null,
    lastname        varchar(100) not null,
    enrollment_year int          not null,
    constraint my_students_pk
        primary key (id)
);