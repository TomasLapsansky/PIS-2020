INSERT INTO role (id, name) values (1, 'superadmin');
INSERT INTO role (id, name) values (2, 'admin');
INSERT INTO role (id, name) values (3, 'employee');
INSERT INTO role (id, name) values (4, 'user');

INSERT INTO app_user (id, name, surname, email, password, role_id) values (1, 'Tomas', 'Lapsansky', 'xlapsa00@stud.fit.vutbr.cz', 'passwd', 1);