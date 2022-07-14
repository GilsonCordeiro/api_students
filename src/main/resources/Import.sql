INSERT INTO tb_institution(name, telephone) VALUES ('Católica', '321-0877');
INSERT INTO tb_institution(name, telephone) VALUES ('UNB', '3144-0890');

INSERT INTO tb_courses(course, monthly, id_instituion) VALUES ('Sistema da Informação', 879.45 , 2);
INSERT INTO tb_courses(course, monthly, id_instituion) VALUES ('Engenheiro Civil', 1.345 , 1);

INSERT INTO tb_students(course_id, name, email, password) VALUES (1, 'Catya Nadys', 'catyanadys@yahoo.com', '1e3Ac32');
INSERT INTO tb_students(course_id, name, email, password) VALUES (2, 'Pietro Green', 'pietrogreen@yahoo.com', '4e3Ac54');
INSERT INTO tb_students(course_id, name, email, password) VALUES (1, 'Nathália Pink', 'nathaliapink@yahoo.com', '2eGNc12');