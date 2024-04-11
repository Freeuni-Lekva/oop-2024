create database test_db;

use test_db;

CREATE TABLE students (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          idnumber CHAR(11) NOT NULL,
                          firstname VARCHAR(100) NOT NULL,
                          lastname VARCHAR(100) NOT NULL,
                          register_date DATETIME NOT NULL DEFAULT NOW(),
                          CONSTRAINT students_uk2 UNIQUE (idnumber)
);

insert into students (idnumber, firstname, lastname)
values
    ('11111111111', 'john', 'doe'),
    ('11111111112', 'giorgi', 'pirveli'),
    ('11111111113', 'giorgi', 'meore');

CREATE TABLE courses(
                        id int primary key auto_increment,
                        course_name varchar(255) not null,
                        course_credit INT NOT NULL DEFAULT 0,
                        course_type VARCHAR(255)
);

INSERT INTO courses
(course_name, course_credit, course_type)
VALUES
    ('Linear Algebra', 4, 'MATH'),
    ('Programming Paradigms', 6, 'CS'),
    ('Calculus I', 6, 'MATH'),
    ('OOP', 6, 'CS'),
    ('Quantum Algorithms', 7, 'CS'),
    ('Nand To Tetris', 6, 'CS');

CREATE TABLE student_courses (
     id INT PRIMARY KEY AUTO_INCREMENT,
     course_id INT NOT NULL,
     student_id INT NOT NULL,
     CONSTRAINT student_courses_uk1 UNIQUE (course_id, student_id),
     CONSTRAINT student_courses_fk1 FOREIGN KEY (course_id)
         REFERENCES courses (id),
     CONSTRAINT student_courses_fk2 FOREIGN KEY (student_id)
         REFERENCES students (id)
);

insert into student_courses (student_id, course_id)
select s.id, c.id from students s inner join courses c
where (s.firstname = 'john' and c.course_credit = 7) or (s.firstname = 'john' and c.course_credit = 4);


